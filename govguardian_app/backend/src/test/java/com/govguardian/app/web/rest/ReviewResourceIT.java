package com.govguardian.app.web.rest;

import static com.govguardian.app.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import com.govguardian.app.IntegrationTest;
import com.govguardian.app.domain.Review;
import com.govguardian.app.repository.EntityManager;
import com.govguardian.app.repository.ReviewRepository;
import com.govguardian.app.service.dto.ReviewDTO;
import com.govguardian.app.service.mapper.ReviewMapper;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * Integration tests for the {@link ReviewResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class ReviewResourceIT {

    private static final String DEFAULT_CONTENT = "AAAAAAAAAA";
    private static final String UPDATED_CONTENT = "BBBBBBBBBB";

    private static final Integer DEFAULT_RATING = 1;
    private static final Integer UPDATED_RATING = 2;
    private static final Integer SMALLER_RATING = 1 - 1;

    private static final String DEFAULT_FEEDBACK = "AAAAAAAAAA";
    private static final String UPDATED_FEEDBACK = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_TIMESTAMP = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_TIMESTAMP = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
    private static final ZonedDateTime SMALLER_TIMESTAMP = ZonedDateTime.ofInstant(Instant.ofEpochMilli(-1L), ZoneOffset.UTC);

    private static final String ENTITY_API_URL = "/api/reviews";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private Review review;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Review createEntity(EntityManager em) {
        Review review = new Review()
            .content(DEFAULT_CONTENT)
            .rating(DEFAULT_RATING)
            .feedback(DEFAULT_FEEDBACK)
            .timestamp(DEFAULT_TIMESTAMP);
        return review;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Review createUpdatedEntity(EntityManager em) {
        Review review = new Review()
            .content(UPDATED_CONTENT)
            .rating(UPDATED_RATING)
            .feedback(UPDATED_FEEDBACK)
            .timestamp(UPDATED_TIMESTAMP);
        return review;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(Review.class).block();
        } catch (Exception e) {
            // It can fail, if other entities are still referring this - it will be removed later.
        }
    }

    @AfterEach
    public void cleanup() {
        deleteEntities(em);
    }

    @BeforeEach
    public void initTest() {
        deleteEntities(em);
        review = createEntity(em);
    }

    @Test
    void createReview() throws Exception {
        int databaseSizeBeforeCreate = reviewRepository.findAll().collectList().block().size();
        // Create the Review
        ReviewDTO reviewDTO = reviewMapper.toDto(review);
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(reviewDTO))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the Review in the database
        List<Review> reviewList = reviewRepository.findAll().collectList().block();
        assertThat(reviewList).hasSize(databaseSizeBeforeCreate + 1);
        Review testReview = reviewList.get(reviewList.size() - 1);
        assertThat(testReview.getContent()).isEqualTo(DEFAULT_CONTENT);
        assertThat(testReview.getRating()).isEqualTo(DEFAULT_RATING);
        assertThat(testReview.getFeedback()).isEqualTo(DEFAULT_FEEDBACK);
        assertThat(testReview.getTimestamp()).isEqualTo(DEFAULT_TIMESTAMP);
    }

    @Test
    void createReviewWithExistingId() throws Exception {
        // Create the Review with an existing ID
        review.setId(1L);
        ReviewDTO reviewDTO = reviewMapper.toDto(review);

        int databaseSizeBeforeCreate = reviewRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(reviewDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Review in the database
        List<Review> reviewList = reviewRepository.findAll().collectList().block();
        assertThat(reviewList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllReviews() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList
        webTestClient
            .get()
            .uri(ENTITY_API_URL + "?sort=id,desc")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.[*].id")
            .value(hasItem(review.getId().intValue()))
            .jsonPath("$.[*].content")
            .value(hasItem(DEFAULT_CONTENT))
            .jsonPath("$.[*].rating")
            .value(hasItem(DEFAULT_RATING))
            .jsonPath("$.[*].feedback")
            .value(hasItem(DEFAULT_FEEDBACK))
            .jsonPath("$.[*].timestamp")
            .value(hasItem(sameInstant(DEFAULT_TIMESTAMP)));
    }

    @Test
    void getReview() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get the review
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, review.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(review.getId().intValue()))
            .jsonPath("$.content")
            .value(is(DEFAULT_CONTENT))
            .jsonPath("$.rating")
            .value(is(DEFAULT_RATING))
            .jsonPath("$.feedback")
            .value(is(DEFAULT_FEEDBACK))
            .jsonPath("$.timestamp")
            .value(is(sameInstant(DEFAULT_TIMESTAMP)));
    }

    @Test
    void getReviewsByIdFiltering() {
        // Initialize the database
        reviewRepository.save(review).block();

        Long id = review.getId();

        defaultReviewShouldBeFound("id.equals=" + id);
        defaultReviewShouldNotBeFound("id.notEquals=" + id);

        defaultReviewShouldBeFound("id.greaterThanOrEqual=" + id);
        defaultReviewShouldNotBeFound("id.greaterThan=" + id);

        defaultReviewShouldBeFound("id.lessThanOrEqual=" + id);
        defaultReviewShouldNotBeFound("id.lessThan=" + id);
    }

    @Test
    void getAllReviewsByContentIsEqualToSomething() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where content equals to DEFAULT_CONTENT
        defaultReviewShouldBeFound("content.equals=" + DEFAULT_CONTENT);

        // Get all the reviewList where content equals to UPDATED_CONTENT
        defaultReviewShouldNotBeFound("content.equals=" + UPDATED_CONTENT);
    }

    @Test
    void getAllReviewsByContentIsInShouldWork() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where content in DEFAULT_CONTENT or UPDATED_CONTENT
        defaultReviewShouldBeFound("content.in=" + DEFAULT_CONTENT + "," + UPDATED_CONTENT);

        // Get all the reviewList where content equals to UPDATED_CONTENT
        defaultReviewShouldNotBeFound("content.in=" + UPDATED_CONTENT);
    }

    @Test
    void getAllReviewsByContentIsNullOrNotNull() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where content is not null
        defaultReviewShouldBeFound("content.specified=true");

        // Get all the reviewList where content is null
        defaultReviewShouldNotBeFound("content.specified=false");
    }

    @Test
    void getAllReviewsByContentContainsSomething() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where content contains DEFAULT_CONTENT
        defaultReviewShouldBeFound("content.contains=" + DEFAULT_CONTENT);

        // Get all the reviewList where content contains UPDATED_CONTENT
        defaultReviewShouldNotBeFound("content.contains=" + UPDATED_CONTENT);
    }

    @Test
    void getAllReviewsByContentNotContainsSomething() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where content does not contain DEFAULT_CONTENT
        defaultReviewShouldNotBeFound("content.doesNotContain=" + DEFAULT_CONTENT);

        // Get all the reviewList where content does not contain UPDATED_CONTENT
        defaultReviewShouldBeFound("content.doesNotContain=" + UPDATED_CONTENT);
    }

    @Test
    void getAllReviewsByRatingIsEqualToSomething() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where rating equals to DEFAULT_RATING
        defaultReviewShouldBeFound("rating.equals=" + DEFAULT_RATING);

        // Get all the reviewList where rating equals to UPDATED_RATING
        defaultReviewShouldNotBeFound("rating.equals=" + UPDATED_RATING);
    }

    @Test
    void getAllReviewsByRatingIsInShouldWork() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where rating in DEFAULT_RATING or UPDATED_RATING
        defaultReviewShouldBeFound("rating.in=" + DEFAULT_RATING + "," + UPDATED_RATING);

        // Get all the reviewList where rating equals to UPDATED_RATING
        defaultReviewShouldNotBeFound("rating.in=" + UPDATED_RATING);
    }

    @Test
    void getAllReviewsByRatingIsNullOrNotNull() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where rating is not null
        defaultReviewShouldBeFound("rating.specified=true");

        // Get all the reviewList where rating is null
        defaultReviewShouldNotBeFound("rating.specified=false");
    }

    @Test
    void getAllReviewsByRatingIsGreaterThanOrEqualToSomething() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where rating is greater than or equal to DEFAULT_RATING
        defaultReviewShouldBeFound("rating.greaterThanOrEqual=" + DEFAULT_RATING);

        // Get all the reviewList where rating is greater than or equal to UPDATED_RATING
        defaultReviewShouldNotBeFound("rating.greaterThanOrEqual=" + UPDATED_RATING);
    }

    @Test
    void getAllReviewsByRatingIsLessThanOrEqualToSomething() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where rating is less than or equal to DEFAULT_RATING
        defaultReviewShouldBeFound("rating.lessThanOrEqual=" + DEFAULT_RATING);

        // Get all the reviewList where rating is less than or equal to SMALLER_RATING
        defaultReviewShouldNotBeFound("rating.lessThanOrEqual=" + SMALLER_RATING);
    }

    @Test
    void getAllReviewsByRatingIsLessThanSomething() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where rating is less than DEFAULT_RATING
        defaultReviewShouldNotBeFound("rating.lessThan=" + DEFAULT_RATING);

        // Get all the reviewList where rating is less than UPDATED_RATING
        defaultReviewShouldBeFound("rating.lessThan=" + UPDATED_RATING);
    }

    @Test
    void getAllReviewsByRatingIsGreaterThanSomething() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where rating is greater than DEFAULT_RATING
        defaultReviewShouldNotBeFound("rating.greaterThan=" + DEFAULT_RATING);

        // Get all the reviewList where rating is greater than SMALLER_RATING
        defaultReviewShouldBeFound("rating.greaterThan=" + SMALLER_RATING);
    }

    @Test
    void getAllReviewsByFeedbackIsEqualToSomething() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where feedback equals to DEFAULT_FEEDBACK
        defaultReviewShouldBeFound("feedback.equals=" + DEFAULT_FEEDBACK);

        // Get all the reviewList where feedback equals to UPDATED_FEEDBACK
        defaultReviewShouldNotBeFound("feedback.equals=" + UPDATED_FEEDBACK);
    }

    @Test
    void getAllReviewsByFeedbackIsInShouldWork() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where feedback in DEFAULT_FEEDBACK or UPDATED_FEEDBACK
        defaultReviewShouldBeFound("feedback.in=" + DEFAULT_FEEDBACK + "," + UPDATED_FEEDBACK);

        // Get all the reviewList where feedback equals to UPDATED_FEEDBACK
        defaultReviewShouldNotBeFound("feedback.in=" + UPDATED_FEEDBACK);
    }

    @Test
    void getAllReviewsByFeedbackIsNullOrNotNull() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where feedback is not null
        defaultReviewShouldBeFound("feedback.specified=true");

        // Get all the reviewList where feedback is null
        defaultReviewShouldNotBeFound("feedback.specified=false");
    }

    @Test
    void getAllReviewsByFeedbackContainsSomething() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where feedback contains DEFAULT_FEEDBACK
        defaultReviewShouldBeFound("feedback.contains=" + DEFAULT_FEEDBACK);

        // Get all the reviewList where feedback contains UPDATED_FEEDBACK
        defaultReviewShouldNotBeFound("feedback.contains=" + UPDATED_FEEDBACK);
    }

    @Test
    void getAllReviewsByFeedbackNotContainsSomething() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where feedback does not contain DEFAULT_FEEDBACK
        defaultReviewShouldNotBeFound("feedback.doesNotContain=" + DEFAULT_FEEDBACK);

        // Get all the reviewList where feedback does not contain UPDATED_FEEDBACK
        defaultReviewShouldBeFound("feedback.doesNotContain=" + UPDATED_FEEDBACK);
    }

    @Test
    void getAllReviewsByTimestampIsEqualToSomething() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where timestamp equals to DEFAULT_TIMESTAMP
        defaultReviewShouldBeFound("timestamp.equals=" + DEFAULT_TIMESTAMP);

        // Get all the reviewList where timestamp equals to UPDATED_TIMESTAMP
        defaultReviewShouldNotBeFound("timestamp.equals=" + UPDATED_TIMESTAMP);
    }

    @Test
    void getAllReviewsByTimestampIsInShouldWork() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where timestamp in DEFAULT_TIMESTAMP or UPDATED_TIMESTAMP
        defaultReviewShouldBeFound("timestamp.in=" + DEFAULT_TIMESTAMP + "," + UPDATED_TIMESTAMP);

        // Get all the reviewList where timestamp equals to UPDATED_TIMESTAMP
        defaultReviewShouldNotBeFound("timestamp.in=" + UPDATED_TIMESTAMP);
    }

    @Test
    void getAllReviewsByTimestampIsNullOrNotNull() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where timestamp is not null
        defaultReviewShouldBeFound("timestamp.specified=true");

        // Get all the reviewList where timestamp is null
        defaultReviewShouldNotBeFound("timestamp.specified=false");
    }

    @Test
    void getAllReviewsByTimestampIsGreaterThanOrEqualToSomething() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where timestamp is greater than or equal to DEFAULT_TIMESTAMP
        defaultReviewShouldBeFound("timestamp.greaterThanOrEqual=" + DEFAULT_TIMESTAMP);

        // Get all the reviewList where timestamp is greater than or equal to UPDATED_TIMESTAMP
        defaultReviewShouldNotBeFound("timestamp.greaterThanOrEqual=" + UPDATED_TIMESTAMP);
    }

    @Test
    void getAllReviewsByTimestampIsLessThanOrEqualToSomething() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where timestamp is less than or equal to DEFAULT_TIMESTAMP
        defaultReviewShouldBeFound("timestamp.lessThanOrEqual=" + DEFAULT_TIMESTAMP);

        // Get all the reviewList where timestamp is less than or equal to SMALLER_TIMESTAMP
        defaultReviewShouldNotBeFound("timestamp.lessThanOrEqual=" + SMALLER_TIMESTAMP);
    }

    @Test
    void getAllReviewsByTimestampIsLessThanSomething() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where timestamp is less than DEFAULT_TIMESTAMP
        defaultReviewShouldNotBeFound("timestamp.lessThan=" + DEFAULT_TIMESTAMP);

        // Get all the reviewList where timestamp is less than UPDATED_TIMESTAMP
        defaultReviewShouldBeFound("timestamp.lessThan=" + UPDATED_TIMESTAMP);
    }

    @Test
    void getAllReviewsByTimestampIsGreaterThanSomething() {
        // Initialize the database
        reviewRepository.save(review).block();

        // Get all the reviewList where timestamp is greater than DEFAULT_TIMESTAMP
        defaultReviewShouldNotBeFound("timestamp.greaterThan=" + DEFAULT_TIMESTAMP);

        // Get all the reviewList where timestamp is greater than SMALLER_TIMESTAMP
        defaultReviewShouldBeFound("timestamp.greaterThan=" + SMALLER_TIMESTAMP);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultReviewShouldBeFound(String filter) {
        webTestClient
            .get()
            .uri(ENTITY_API_URL + "?sort=id,desc&" + filter)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.[*].id")
            .value(hasItem(review.getId().intValue()))
            .jsonPath("$.[*].content")
            .value(hasItem(DEFAULT_CONTENT))
            .jsonPath("$.[*].rating")
            .value(hasItem(DEFAULT_RATING))
            .jsonPath("$.[*].feedback")
            .value(hasItem(DEFAULT_FEEDBACK))
            .jsonPath("$.[*].timestamp")
            .value(hasItem(sameInstant(DEFAULT_TIMESTAMP)));

        // Check, that the count call also returns 1
        webTestClient
            .get()
            .uri(ENTITY_API_URL + "/count?sort=id,desc&" + filter)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$")
            .value(is(1));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultReviewShouldNotBeFound(String filter) {
        webTestClient
            .get()
            .uri(ENTITY_API_URL + "?sort=id,desc&" + filter)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$")
            .isArray()
            .jsonPath("$")
            .isEmpty();

        // Check, that the count call also returns 0
        webTestClient
            .get()
            .uri(ENTITY_API_URL + "/count?sort=id,desc&" + filter)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$")
            .value(is(0));
    }

    @Test
    void getNonExistingReview() {
        // Get the review
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_PROBLEM_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putExistingReview() throws Exception {
        // Initialize the database
        reviewRepository.save(review).block();

        int databaseSizeBeforeUpdate = reviewRepository.findAll().collectList().block().size();

        // Update the review
        Review updatedReview = reviewRepository.findById(review.getId()).block();
        updatedReview.content(UPDATED_CONTENT).rating(UPDATED_RATING).feedback(UPDATED_FEEDBACK).timestamp(UPDATED_TIMESTAMP);
        ReviewDTO reviewDTO = reviewMapper.toDto(updatedReview);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, reviewDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(reviewDTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Review in the database
        List<Review> reviewList = reviewRepository.findAll().collectList().block();
        assertThat(reviewList).hasSize(databaseSizeBeforeUpdate);
        Review testReview = reviewList.get(reviewList.size() - 1);
        assertThat(testReview.getContent()).isEqualTo(UPDATED_CONTENT);
        assertThat(testReview.getRating()).isEqualTo(UPDATED_RATING);
        assertThat(testReview.getFeedback()).isEqualTo(UPDATED_FEEDBACK);
        assertThat(testReview.getTimestamp()).isEqualTo(UPDATED_TIMESTAMP);
    }

    @Test
    void putNonExistingReview() throws Exception {
        int databaseSizeBeforeUpdate = reviewRepository.findAll().collectList().block().size();
        review.setId(longCount.incrementAndGet());

        // Create the Review
        ReviewDTO reviewDTO = reviewMapper.toDto(review);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, reviewDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(reviewDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Review in the database
        List<Review> reviewList = reviewRepository.findAll().collectList().block();
        assertThat(reviewList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchReview() throws Exception {
        int databaseSizeBeforeUpdate = reviewRepository.findAll().collectList().block().size();
        review.setId(longCount.incrementAndGet());

        // Create the Review
        ReviewDTO reviewDTO = reviewMapper.toDto(review);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, longCount.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(reviewDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Review in the database
        List<Review> reviewList = reviewRepository.findAll().collectList().block();
        assertThat(reviewList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamReview() throws Exception {
        int databaseSizeBeforeUpdate = reviewRepository.findAll().collectList().block().size();
        review.setId(longCount.incrementAndGet());

        // Create the Review
        ReviewDTO reviewDTO = reviewMapper.toDto(review);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(reviewDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the Review in the database
        List<Review> reviewList = reviewRepository.findAll().collectList().block();
        assertThat(reviewList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateReviewWithPatch() throws Exception {
        // Initialize the database
        reviewRepository.save(review).block();

        int databaseSizeBeforeUpdate = reviewRepository.findAll().collectList().block().size();

        // Update the review using partial update
        Review partialUpdatedReview = new Review();
        partialUpdatedReview.setId(review.getId());

        partialUpdatedReview.content(UPDATED_CONTENT);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedReview.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedReview))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Review in the database
        List<Review> reviewList = reviewRepository.findAll().collectList().block();
        assertThat(reviewList).hasSize(databaseSizeBeforeUpdate);
        Review testReview = reviewList.get(reviewList.size() - 1);
        assertThat(testReview.getContent()).isEqualTo(UPDATED_CONTENT);
        assertThat(testReview.getRating()).isEqualTo(DEFAULT_RATING);
        assertThat(testReview.getFeedback()).isEqualTo(DEFAULT_FEEDBACK);
        assertThat(testReview.getTimestamp()).isEqualTo(DEFAULT_TIMESTAMP);
    }

    @Test
    void fullUpdateReviewWithPatch() throws Exception {
        // Initialize the database
        reviewRepository.save(review).block();

        int databaseSizeBeforeUpdate = reviewRepository.findAll().collectList().block().size();

        // Update the review using partial update
        Review partialUpdatedReview = new Review();
        partialUpdatedReview.setId(review.getId());

        partialUpdatedReview.content(UPDATED_CONTENT).rating(UPDATED_RATING).feedback(UPDATED_FEEDBACK).timestamp(UPDATED_TIMESTAMP);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedReview.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedReview))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Review in the database
        List<Review> reviewList = reviewRepository.findAll().collectList().block();
        assertThat(reviewList).hasSize(databaseSizeBeforeUpdate);
        Review testReview = reviewList.get(reviewList.size() - 1);
        assertThat(testReview.getContent()).isEqualTo(UPDATED_CONTENT);
        assertThat(testReview.getRating()).isEqualTo(UPDATED_RATING);
        assertThat(testReview.getFeedback()).isEqualTo(UPDATED_FEEDBACK);
        assertThat(testReview.getTimestamp()).isEqualTo(UPDATED_TIMESTAMP);
    }

    @Test
    void patchNonExistingReview() throws Exception {
        int databaseSizeBeforeUpdate = reviewRepository.findAll().collectList().block().size();
        review.setId(longCount.incrementAndGet());

        // Create the Review
        ReviewDTO reviewDTO = reviewMapper.toDto(review);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, reviewDTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(reviewDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Review in the database
        List<Review> reviewList = reviewRepository.findAll().collectList().block();
        assertThat(reviewList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchReview() throws Exception {
        int databaseSizeBeforeUpdate = reviewRepository.findAll().collectList().block().size();
        review.setId(longCount.incrementAndGet());

        // Create the Review
        ReviewDTO reviewDTO = reviewMapper.toDto(review);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, longCount.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(reviewDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Review in the database
        List<Review> reviewList = reviewRepository.findAll().collectList().block();
        assertThat(reviewList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamReview() throws Exception {
        int databaseSizeBeforeUpdate = reviewRepository.findAll().collectList().block().size();
        review.setId(longCount.incrementAndGet());

        // Create the Review
        ReviewDTO reviewDTO = reviewMapper.toDto(review);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(reviewDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the Review in the database
        List<Review> reviewList = reviewRepository.findAll().collectList().block();
        assertThat(reviewList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteReview() {
        // Initialize the database
        reviewRepository.save(review).block();

        int databaseSizeBeforeDelete = reviewRepository.findAll().collectList().block().size();

        // Delete the review
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, review.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<Review> reviewList = reviewRepository.findAll().collectList().block();
        assertThat(reviewList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
