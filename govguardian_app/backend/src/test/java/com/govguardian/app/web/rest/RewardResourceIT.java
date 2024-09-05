package com.govguardian.app.web.rest;

import static com.govguardian.app.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import com.govguardian.app.IntegrationTest;
import com.govguardian.app.domain.Reward;
import com.govguardian.app.repository.EntityManager;
import com.govguardian.app.repository.RewardRepository;
import com.govguardian.app.service.dto.RewardDTO;
import com.govguardian.app.service.mapper.RewardMapper;
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
 * Integration tests for the {@link RewardResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class RewardResourceIT {

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final Integer DEFAULT_POINTS = 1;
    private static final Integer UPDATED_POINTS = 2;
    private static final Integer SMALLER_POINTS = 1 - 1;

    private static final ZonedDateTime DEFAULT_TIMESTAMP = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_TIMESTAMP = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
    private static final ZonedDateTime SMALLER_TIMESTAMP = ZonedDateTime.ofInstant(Instant.ofEpochMilli(-1L), ZoneOffset.UTC);

    private static final String ENTITY_API_URL = "/api/rewards";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private RewardRepository rewardRepository;

    @Autowired
    private RewardMapper rewardMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private Reward reward;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Reward createEntity(EntityManager em) {
        Reward reward = new Reward().description(DEFAULT_DESCRIPTION).points(DEFAULT_POINTS).timestamp(DEFAULT_TIMESTAMP);
        return reward;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Reward createUpdatedEntity(EntityManager em) {
        Reward reward = new Reward().description(UPDATED_DESCRIPTION).points(UPDATED_POINTS).timestamp(UPDATED_TIMESTAMP);
        return reward;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(Reward.class).block();
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
        reward = createEntity(em);
    }

    @Test
    void createReward() throws Exception {
        int databaseSizeBeforeCreate = rewardRepository.findAll().collectList().block().size();
        // Create the Reward
        RewardDTO rewardDTO = rewardMapper.toDto(reward);
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(rewardDTO))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the Reward in the database
        List<Reward> rewardList = rewardRepository.findAll().collectList().block();
        assertThat(rewardList).hasSize(databaseSizeBeforeCreate + 1);
        Reward testReward = rewardList.get(rewardList.size() - 1);
        assertThat(testReward.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testReward.getPoints()).isEqualTo(DEFAULT_POINTS);
        assertThat(testReward.getTimestamp()).isEqualTo(DEFAULT_TIMESTAMP);
    }

    @Test
    void createRewardWithExistingId() throws Exception {
        // Create the Reward with an existing ID
        reward.setId(1L);
        RewardDTO rewardDTO = rewardMapper.toDto(reward);

        int databaseSizeBeforeCreate = rewardRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(rewardDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Reward in the database
        List<Reward> rewardList = rewardRepository.findAll().collectList().block();
        assertThat(rewardList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllRewards() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList
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
            .value(hasItem(reward.getId().intValue()))
            .jsonPath("$.[*].description")
            .value(hasItem(DEFAULT_DESCRIPTION))
            .jsonPath("$.[*].points")
            .value(hasItem(DEFAULT_POINTS))
            .jsonPath("$.[*].timestamp")
            .value(hasItem(sameInstant(DEFAULT_TIMESTAMP)));
    }

    @Test
    void getReward() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get the reward
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, reward.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(reward.getId().intValue()))
            .jsonPath("$.description")
            .value(is(DEFAULT_DESCRIPTION))
            .jsonPath("$.points")
            .value(is(DEFAULT_POINTS))
            .jsonPath("$.timestamp")
            .value(is(sameInstant(DEFAULT_TIMESTAMP)));
    }

    @Test
    void getRewardsByIdFiltering() {
        // Initialize the database
        rewardRepository.save(reward).block();

        Long id = reward.getId();

        defaultRewardShouldBeFound("id.equals=" + id);
        defaultRewardShouldNotBeFound("id.notEquals=" + id);

        defaultRewardShouldBeFound("id.greaterThanOrEqual=" + id);
        defaultRewardShouldNotBeFound("id.greaterThan=" + id);

        defaultRewardShouldBeFound("id.lessThanOrEqual=" + id);
        defaultRewardShouldNotBeFound("id.lessThan=" + id);
    }

    @Test
    void getAllRewardsByDescriptionIsEqualToSomething() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where description equals to DEFAULT_DESCRIPTION
        defaultRewardShouldBeFound("description.equals=" + DEFAULT_DESCRIPTION);

        // Get all the rewardList where description equals to UPDATED_DESCRIPTION
        defaultRewardShouldNotBeFound("description.equals=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllRewardsByDescriptionIsInShouldWork() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where description in DEFAULT_DESCRIPTION or UPDATED_DESCRIPTION
        defaultRewardShouldBeFound("description.in=" + DEFAULT_DESCRIPTION + "," + UPDATED_DESCRIPTION);

        // Get all the rewardList where description equals to UPDATED_DESCRIPTION
        defaultRewardShouldNotBeFound("description.in=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllRewardsByDescriptionIsNullOrNotNull() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where description is not null
        defaultRewardShouldBeFound("description.specified=true");

        // Get all the rewardList where description is null
        defaultRewardShouldNotBeFound("description.specified=false");
    }

    @Test
    void getAllRewardsByDescriptionContainsSomething() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where description contains DEFAULT_DESCRIPTION
        defaultRewardShouldBeFound("description.contains=" + DEFAULT_DESCRIPTION);

        // Get all the rewardList where description contains UPDATED_DESCRIPTION
        defaultRewardShouldNotBeFound("description.contains=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllRewardsByDescriptionNotContainsSomething() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where description does not contain DEFAULT_DESCRIPTION
        defaultRewardShouldNotBeFound("description.doesNotContain=" + DEFAULT_DESCRIPTION);

        // Get all the rewardList where description does not contain UPDATED_DESCRIPTION
        defaultRewardShouldBeFound("description.doesNotContain=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllRewardsByPointsIsEqualToSomething() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where points equals to DEFAULT_POINTS
        defaultRewardShouldBeFound("points.equals=" + DEFAULT_POINTS);

        // Get all the rewardList where points equals to UPDATED_POINTS
        defaultRewardShouldNotBeFound("points.equals=" + UPDATED_POINTS);
    }

    @Test
    void getAllRewardsByPointsIsInShouldWork() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where points in DEFAULT_POINTS or UPDATED_POINTS
        defaultRewardShouldBeFound("points.in=" + DEFAULT_POINTS + "," + UPDATED_POINTS);

        // Get all the rewardList where points equals to UPDATED_POINTS
        defaultRewardShouldNotBeFound("points.in=" + UPDATED_POINTS);
    }

    @Test
    void getAllRewardsByPointsIsNullOrNotNull() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where points is not null
        defaultRewardShouldBeFound("points.specified=true");

        // Get all the rewardList where points is null
        defaultRewardShouldNotBeFound("points.specified=false");
    }

    @Test
    void getAllRewardsByPointsIsGreaterThanOrEqualToSomething() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where points is greater than or equal to DEFAULT_POINTS
        defaultRewardShouldBeFound("points.greaterThanOrEqual=" + DEFAULT_POINTS);

        // Get all the rewardList where points is greater than or equal to UPDATED_POINTS
        defaultRewardShouldNotBeFound("points.greaterThanOrEqual=" + UPDATED_POINTS);
    }

    @Test
    void getAllRewardsByPointsIsLessThanOrEqualToSomething() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where points is less than or equal to DEFAULT_POINTS
        defaultRewardShouldBeFound("points.lessThanOrEqual=" + DEFAULT_POINTS);

        // Get all the rewardList where points is less than or equal to SMALLER_POINTS
        defaultRewardShouldNotBeFound("points.lessThanOrEqual=" + SMALLER_POINTS);
    }

    @Test
    void getAllRewardsByPointsIsLessThanSomething() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where points is less than DEFAULT_POINTS
        defaultRewardShouldNotBeFound("points.lessThan=" + DEFAULT_POINTS);

        // Get all the rewardList where points is less than UPDATED_POINTS
        defaultRewardShouldBeFound("points.lessThan=" + UPDATED_POINTS);
    }

    @Test
    void getAllRewardsByPointsIsGreaterThanSomething() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where points is greater than DEFAULT_POINTS
        defaultRewardShouldNotBeFound("points.greaterThan=" + DEFAULT_POINTS);

        // Get all the rewardList where points is greater than SMALLER_POINTS
        defaultRewardShouldBeFound("points.greaterThan=" + SMALLER_POINTS);
    }

    @Test
    void getAllRewardsByTimestampIsEqualToSomething() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where timestamp equals to DEFAULT_TIMESTAMP
        defaultRewardShouldBeFound("timestamp.equals=" + DEFAULT_TIMESTAMP);

        // Get all the rewardList where timestamp equals to UPDATED_TIMESTAMP
        defaultRewardShouldNotBeFound("timestamp.equals=" + UPDATED_TIMESTAMP);
    }

    @Test
    void getAllRewardsByTimestampIsInShouldWork() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where timestamp in DEFAULT_TIMESTAMP or UPDATED_TIMESTAMP
        defaultRewardShouldBeFound("timestamp.in=" + DEFAULT_TIMESTAMP + "," + UPDATED_TIMESTAMP);

        // Get all the rewardList where timestamp equals to UPDATED_TIMESTAMP
        defaultRewardShouldNotBeFound("timestamp.in=" + UPDATED_TIMESTAMP);
    }

    @Test
    void getAllRewardsByTimestampIsNullOrNotNull() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where timestamp is not null
        defaultRewardShouldBeFound("timestamp.specified=true");

        // Get all the rewardList where timestamp is null
        defaultRewardShouldNotBeFound("timestamp.specified=false");
    }

    @Test
    void getAllRewardsByTimestampIsGreaterThanOrEqualToSomething() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where timestamp is greater than or equal to DEFAULT_TIMESTAMP
        defaultRewardShouldBeFound("timestamp.greaterThanOrEqual=" + DEFAULT_TIMESTAMP);

        // Get all the rewardList where timestamp is greater than or equal to UPDATED_TIMESTAMP
        defaultRewardShouldNotBeFound("timestamp.greaterThanOrEqual=" + UPDATED_TIMESTAMP);
    }

    @Test
    void getAllRewardsByTimestampIsLessThanOrEqualToSomething() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where timestamp is less than or equal to DEFAULT_TIMESTAMP
        defaultRewardShouldBeFound("timestamp.lessThanOrEqual=" + DEFAULT_TIMESTAMP);

        // Get all the rewardList where timestamp is less than or equal to SMALLER_TIMESTAMP
        defaultRewardShouldNotBeFound("timestamp.lessThanOrEqual=" + SMALLER_TIMESTAMP);
    }

    @Test
    void getAllRewardsByTimestampIsLessThanSomething() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where timestamp is less than DEFAULT_TIMESTAMP
        defaultRewardShouldNotBeFound("timestamp.lessThan=" + DEFAULT_TIMESTAMP);

        // Get all the rewardList where timestamp is less than UPDATED_TIMESTAMP
        defaultRewardShouldBeFound("timestamp.lessThan=" + UPDATED_TIMESTAMP);
    }

    @Test
    void getAllRewardsByTimestampIsGreaterThanSomething() {
        // Initialize the database
        rewardRepository.save(reward).block();

        // Get all the rewardList where timestamp is greater than DEFAULT_TIMESTAMP
        defaultRewardShouldNotBeFound("timestamp.greaterThan=" + DEFAULT_TIMESTAMP);

        // Get all the rewardList where timestamp is greater than SMALLER_TIMESTAMP
        defaultRewardShouldBeFound("timestamp.greaterThan=" + SMALLER_TIMESTAMP);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultRewardShouldBeFound(String filter) {
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
            .value(hasItem(reward.getId().intValue()))
            .jsonPath("$.[*].description")
            .value(hasItem(DEFAULT_DESCRIPTION))
            .jsonPath("$.[*].points")
            .value(hasItem(DEFAULT_POINTS))
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
    private void defaultRewardShouldNotBeFound(String filter) {
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
    void getNonExistingReward() {
        // Get the reward
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_PROBLEM_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putExistingReward() throws Exception {
        // Initialize the database
        rewardRepository.save(reward).block();

        int databaseSizeBeforeUpdate = rewardRepository.findAll().collectList().block().size();

        // Update the reward
        Reward updatedReward = rewardRepository.findById(reward.getId()).block();
        updatedReward.description(UPDATED_DESCRIPTION).points(UPDATED_POINTS).timestamp(UPDATED_TIMESTAMP);
        RewardDTO rewardDTO = rewardMapper.toDto(updatedReward);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, rewardDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(rewardDTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Reward in the database
        List<Reward> rewardList = rewardRepository.findAll().collectList().block();
        assertThat(rewardList).hasSize(databaseSizeBeforeUpdate);
        Reward testReward = rewardList.get(rewardList.size() - 1);
        assertThat(testReward.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testReward.getPoints()).isEqualTo(UPDATED_POINTS);
        assertThat(testReward.getTimestamp()).isEqualTo(UPDATED_TIMESTAMP);
    }

    @Test
    void putNonExistingReward() throws Exception {
        int databaseSizeBeforeUpdate = rewardRepository.findAll().collectList().block().size();
        reward.setId(longCount.incrementAndGet());

        // Create the Reward
        RewardDTO rewardDTO = rewardMapper.toDto(reward);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, rewardDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(rewardDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Reward in the database
        List<Reward> rewardList = rewardRepository.findAll().collectList().block();
        assertThat(rewardList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchReward() throws Exception {
        int databaseSizeBeforeUpdate = rewardRepository.findAll().collectList().block().size();
        reward.setId(longCount.incrementAndGet());

        // Create the Reward
        RewardDTO rewardDTO = rewardMapper.toDto(reward);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, longCount.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(rewardDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Reward in the database
        List<Reward> rewardList = rewardRepository.findAll().collectList().block();
        assertThat(rewardList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamReward() throws Exception {
        int databaseSizeBeforeUpdate = rewardRepository.findAll().collectList().block().size();
        reward.setId(longCount.incrementAndGet());

        // Create the Reward
        RewardDTO rewardDTO = rewardMapper.toDto(reward);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(rewardDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the Reward in the database
        List<Reward> rewardList = rewardRepository.findAll().collectList().block();
        assertThat(rewardList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateRewardWithPatch() throws Exception {
        // Initialize the database
        rewardRepository.save(reward).block();

        int databaseSizeBeforeUpdate = rewardRepository.findAll().collectList().block().size();

        // Update the reward using partial update
        Reward partialUpdatedReward = new Reward();
        partialUpdatedReward.setId(reward.getId());

        partialUpdatedReward.description(UPDATED_DESCRIPTION).points(UPDATED_POINTS);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedReward.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedReward))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Reward in the database
        List<Reward> rewardList = rewardRepository.findAll().collectList().block();
        assertThat(rewardList).hasSize(databaseSizeBeforeUpdate);
        Reward testReward = rewardList.get(rewardList.size() - 1);
        assertThat(testReward.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testReward.getPoints()).isEqualTo(UPDATED_POINTS);
        assertThat(testReward.getTimestamp()).isEqualTo(DEFAULT_TIMESTAMP);
    }

    @Test
    void fullUpdateRewardWithPatch() throws Exception {
        // Initialize the database
        rewardRepository.save(reward).block();

        int databaseSizeBeforeUpdate = rewardRepository.findAll().collectList().block().size();

        // Update the reward using partial update
        Reward partialUpdatedReward = new Reward();
        partialUpdatedReward.setId(reward.getId());

        partialUpdatedReward.description(UPDATED_DESCRIPTION).points(UPDATED_POINTS).timestamp(UPDATED_TIMESTAMP);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedReward.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedReward))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Reward in the database
        List<Reward> rewardList = rewardRepository.findAll().collectList().block();
        assertThat(rewardList).hasSize(databaseSizeBeforeUpdate);
        Reward testReward = rewardList.get(rewardList.size() - 1);
        assertThat(testReward.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testReward.getPoints()).isEqualTo(UPDATED_POINTS);
        assertThat(testReward.getTimestamp()).isEqualTo(UPDATED_TIMESTAMP);
    }

    @Test
    void patchNonExistingReward() throws Exception {
        int databaseSizeBeforeUpdate = rewardRepository.findAll().collectList().block().size();
        reward.setId(longCount.incrementAndGet());

        // Create the Reward
        RewardDTO rewardDTO = rewardMapper.toDto(reward);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, rewardDTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(rewardDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Reward in the database
        List<Reward> rewardList = rewardRepository.findAll().collectList().block();
        assertThat(rewardList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchReward() throws Exception {
        int databaseSizeBeforeUpdate = rewardRepository.findAll().collectList().block().size();
        reward.setId(longCount.incrementAndGet());

        // Create the Reward
        RewardDTO rewardDTO = rewardMapper.toDto(reward);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, longCount.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(rewardDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Reward in the database
        List<Reward> rewardList = rewardRepository.findAll().collectList().block();
        assertThat(rewardList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamReward() throws Exception {
        int databaseSizeBeforeUpdate = rewardRepository.findAll().collectList().block().size();
        reward.setId(longCount.incrementAndGet());

        // Create the Reward
        RewardDTO rewardDTO = rewardMapper.toDto(reward);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(rewardDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the Reward in the database
        List<Reward> rewardList = rewardRepository.findAll().collectList().block();
        assertThat(rewardList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteReward() {
        // Initialize the database
        rewardRepository.save(reward).block();

        int databaseSizeBeforeDelete = rewardRepository.findAll().collectList().block().size();

        // Delete the reward
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, reward.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<Reward> rewardList = rewardRepository.findAll().collectList().block();
        assertThat(rewardList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
