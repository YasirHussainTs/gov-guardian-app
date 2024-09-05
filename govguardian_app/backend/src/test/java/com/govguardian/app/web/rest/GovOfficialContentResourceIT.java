package com.govguardian.app.web.rest;

import static com.govguardian.app.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import com.govguardian.app.IntegrationTest;
import com.govguardian.app.domain.GovOfficialContent;
import com.govguardian.app.repository.EntityManager;
import com.govguardian.app.repository.GovOfficialContentRepository;
import com.govguardian.app.service.dto.GovOfficialContentDTO;
import com.govguardian.app.service.mapper.GovOfficialContentMapper;
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
 * Integration tests for the {@link GovOfficialContentResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class GovOfficialContentResourceIT {

    private static final String DEFAULT_LAW = "AAAAAAAAAA";
    private static final String UPDATED_LAW = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_ACTION = "AAAAAAAAAA";
    private static final String UPDATED_ACTION = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
    private static final ZonedDateTime SMALLER_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(-1L), ZoneOffset.UTC);

    private static final String ENTITY_API_URL = "/api/gov-official-contents";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private GovOfficialContentRepository govOfficialContentRepository;

    @Autowired
    private GovOfficialContentMapper govOfficialContentMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private GovOfficialContent govOfficialContent;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static GovOfficialContent createEntity(EntityManager em) {
        GovOfficialContent govOfficialContent = new GovOfficialContent()
            .law(DEFAULT_LAW)
            .description(DEFAULT_DESCRIPTION)
            .action(DEFAULT_ACTION)
            .date(DEFAULT_DATE);
        return govOfficialContent;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static GovOfficialContent createUpdatedEntity(EntityManager em) {
        GovOfficialContent govOfficialContent = new GovOfficialContent()
            .law(UPDATED_LAW)
            .description(UPDATED_DESCRIPTION)
            .action(UPDATED_ACTION)
            .date(UPDATED_DATE);
        return govOfficialContent;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(GovOfficialContent.class).block();
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
        govOfficialContent = createEntity(em);
    }

    @Test
    void createGovOfficialContent() throws Exception {
        int databaseSizeBeforeCreate = govOfficialContentRepository.findAll().collectList().block().size();
        // Create the GovOfficialContent
        GovOfficialContentDTO govOfficialContentDTO = govOfficialContentMapper.toDto(govOfficialContent);
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(govOfficialContentDTO))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the GovOfficialContent in the database
        List<GovOfficialContent> govOfficialContentList = govOfficialContentRepository.findAll().collectList().block();
        assertThat(govOfficialContentList).hasSize(databaseSizeBeforeCreate + 1);
        GovOfficialContent testGovOfficialContent = govOfficialContentList.get(govOfficialContentList.size() - 1);
        assertThat(testGovOfficialContent.getLaw()).isEqualTo(DEFAULT_LAW);
        assertThat(testGovOfficialContent.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testGovOfficialContent.getAction()).isEqualTo(DEFAULT_ACTION);
        assertThat(testGovOfficialContent.getDate()).isEqualTo(DEFAULT_DATE);
    }

    @Test
    void createGovOfficialContentWithExistingId() throws Exception {
        // Create the GovOfficialContent with an existing ID
        govOfficialContent.setId(1L);
        GovOfficialContentDTO govOfficialContentDTO = govOfficialContentMapper.toDto(govOfficialContent);

        int databaseSizeBeforeCreate = govOfficialContentRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(govOfficialContentDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the GovOfficialContent in the database
        List<GovOfficialContent> govOfficialContentList = govOfficialContentRepository.findAll().collectList().block();
        assertThat(govOfficialContentList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllGovOfficialContents() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList
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
            .value(hasItem(govOfficialContent.getId().intValue()))
            .jsonPath("$.[*].law")
            .value(hasItem(DEFAULT_LAW))
            .jsonPath("$.[*].description")
            .value(hasItem(DEFAULT_DESCRIPTION))
            .jsonPath("$.[*].action")
            .value(hasItem(DEFAULT_ACTION))
            .jsonPath("$.[*].date")
            .value(hasItem(sameInstant(DEFAULT_DATE)));
    }

    @Test
    void getGovOfficialContent() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get the govOfficialContent
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, govOfficialContent.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(govOfficialContent.getId().intValue()))
            .jsonPath("$.law")
            .value(is(DEFAULT_LAW))
            .jsonPath("$.description")
            .value(is(DEFAULT_DESCRIPTION))
            .jsonPath("$.action")
            .value(is(DEFAULT_ACTION))
            .jsonPath("$.date")
            .value(is(sameInstant(DEFAULT_DATE)));
    }

    @Test
    void getGovOfficialContentsByIdFiltering() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        Long id = govOfficialContent.getId();

        defaultGovOfficialContentShouldBeFound("id.equals=" + id);
        defaultGovOfficialContentShouldNotBeFound("id.notEquals=" + id);

        defaultGovOfficialContentShouldBeFound("id.greaterThanOrEqual=" + id);
        defaultGovOfficialContentShouldNotBeFound("id.greaterThan=" + id);

        defaultGovOfficialContentShouldBeFound("id.lessThanOrEqual=" + id);
        defaultGovOfficialContentShouldNotBeFound("id.lessThan=" + id);
    }

    @Test
    void getAllGovOfficialContentsByLawIsEqualToSomething() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where law equals to DEFAULT_LAW
        defaultGovOfficialContentShouldBeFound("law.equals=" + DEFAULT_LAW);

        // Get all the govOfficialContentList where law equals to UPDATED_LAW
        defaultGovOfficialContentShouldNotBeFound("law.equals=" + UPDATED_LAW);
    }

    @Test
    void getAllGovOfficialContentsByLawIsInShouldWork() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where law in DEFAULT_LAW or UPDATED_LAW
        defaultGovOfficialContentShouldBeFound("law.in=" + DEFAULT_LAW + "," + UPDATED_LAW);

        // Get all the govOfficialContentList where law equals to UPDATED_LAW
        defaultGovOfficialContentShouldNotBeFound("law.in=" + UPDATED_LAW);
    }

    @Test
    void getAllGovOfficialContentsByLawIsNullOrNotNull() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where law is not null
        defaultGovOfficialContentShouldBeFound("law.specified=true");

        // Get all the govOfficialContentList where law is null
        defaultGovOfficialContentShouldNotBeFound("law.specified=false");
    }

    @Test
    void getAllGovOfficialContentsByLawContainsSomething() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where law contains DEFAULT_LAW
        defaultGovOfficialContentShouldBeFound("law.contains=" + DEFAULT_LAW);

        // Get all the govOfficialContentList where law contains UPDATED_LAW
        defaultGovOfficialContentShouldNotBeFound("law.contains=" + UPDATED_LAW);
    }

    @Test
    void getAllGovOfficialContentsByLawNotContainsSomething() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where law does not contain DEFAULT_LAW
        defaultGovOfficialContentShouldNotBeFound("law.doesNotContain=" + DEFAULT_LAW);

        // Get all the govOfficialContentList where law does not contain UPDATED_LAW
        defaultGovOfficialContentShouldBeFound("law.doesNotContain=" + UPDATED_LAW);
    }

    @Test
    void getAllGovOfficialContentsByDescriptionIsEqualToSomething() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where description equals to DEFAULT_DESCRIPTION
        defaultGovOfficialContentShouldBeFound("description.equals=" + DEFAULT_DESCRIPTION);

        // Get all the govOfficialContentList where description equals to UPDATED_DESCRIPTION
        defaultGovOfficialContentShouldNotBeFound("description.equals=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllGovOfficialContentsByDescriptionIsInShouldWork() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where description in DEFAULT_DESCRIPTION or UPDATED_DESCRIPTION
        defaultGovOfficialContentShouldBeFound("description.in=" + DEFAULT_DESCRIPTION + "," + UPDATED_DESCRIPTION);

        // Get all the govOfficialContentList where description equals to UPDATED_DESCRIPTION
        defaultGovOfficialContentShouldNotBeFound("description.in=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllGovOfficialContentsByDescriptionIsNullOrNotNull() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where description is not null
        defaultGovOfficialContentShouldBeFound("description.specified=true");

        // Get all the govOfficialContentList where description is null
        defaultGovOfficialContentShouldNotBeFound("description.specified=false");
    }

    @Test
    void getAllGovOfficialContentsByDescriptionContainsSomething() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where description contains DEFAULT_DESCRIPTION
        defaultGovOfficialContentShouldBeFound("description.contains=" + DEFAULT_DESCRIPTION);

        // Get all the govOfficialContentList where description contains UPDATED_DESCRIPTION
        defaultGovOfficialContentShouldNotBeFound("description.contains=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllGovOfficialContentsByDescriptionNotContainsSomething() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where description does not contain DEFAULT_DESCRIPTION
        defaultGovOfficialContentShouldNotBeFound("description.doesNotContain=" + DEFAULT_DESCRIPTION);

        // Get all the govOfficialContentList where description does not contain UPDATED_DESCRIPTION
        defaultGovOfficialContentShouldBeFound("description.doesNotContain=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllGovOfficialContentsByActionIsEqualToSomething() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where action equals to DEFAULT_ACTION
        defaultGovOfficialContentShouldBeFound("action.equals=" + DEFAULT_ACTION);

        // Get all the govOfficialContentList where action equals to UPDATED_ACTION
        defaultGovOfficialContentShouldNotBeFound("action.equals=" + UPDATED_ACTION);
    }

    @Test
    void getAllGovOfficialContentsByActionIsInShouldWork() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where action in DEFAULT_ACTION or UPDATED_ACTION
        defaultGovOfficialContentShouldBeFound("action.in=" + DEFAULT_ACTION + "," + UPDATED_ACTION);

        // Get all the govOfficialContentList where action equals to UPDATED_ACTION
        defaultGovOfficialContentShouldNotBeFound("action.in=" + UPDATED_ACTION);
    }

    @Test
    void getAllGovOfficialContentsByActionIsNullOrNotNull() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where action is not null
        defaultGovOfficialContentShouldBeFound("action.specified=true");

        // Get all the govOfficialContentList where action is null
        defaultGovOfficialContentShouldNotBeFound("action.specified=false");
    }

    @Test
    void getAllGovOfficialContentsByActionContainsSomething() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where action contains DEFAULT_ACTION
        defaultGovOfficialContentShouldBeFound("action.contains=" + DEFAULT_ACTION);

        // Get all the govOfficialContentList where action contains UPDATED_ACTION
        defaultGovOfficialContentShouldNotBeFound("action.contains=" + UPDATED_ACTION);
    }

    @Test
    void getAllGovOfficialContentsByActionNotContainsSomething() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where action does not contain DEFAULT_ACTION
        defaultGovOfficialContentShouldNotBeFound("action.doesNotContain=" + DEFAULT_ACTION);

        // Get all the govOfficialContentList where action does not contain UPDATED_ACTION
        defaultGovOfficialContentShouldBeFound("action.doesNotContain=" + UPDATED_ACTION);
    }

    @Test
    void getAllGovOfficialContentsByDateIsEqualToSomething() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where date equals to DEFAULT_DATE
        defaultGovOfficialContentShouldBeFound("date.equals=" + DEFAULT_DATE);

        // Get all the govOfficialContentList where date equals to UPDATED_DATE
        defaultGovOfficialContentShouldNotBeFound("date.equals=" + UPDATED_DATE);
    }

    @Test
    void getAllGovOfficialContentsByDateIsInShouldWork() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where date in DEFAULT_DATE or UPDATED_DATE
        defaultGovOfficialContentShouldBeFound("date.in=" + DEFAULT_DATE + "," + UPDATED_DATE);

        // Get all the govOfficialContentList where date equals to UPDATED_DATE
        defaultGovOfficialContentShouldNotBeFound("date.in=" + UPDATED_DATE);
    }

    @Test
    void getAllGovOfficialContentsByDateIsNullOrNotNull() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where date is not null
        defaultGovOfficialContentShouldBeFound("date.specified=true");

        // Get all the govOfficialContentList where date is null
        defaultGovOfficialContentShouldNotBeFound("date.specified=false");
    }

    @Test
    void getAllGovOfficialContentsByDateIsGreaterThanOrEqualToSomething() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where date is greater than or equal to DEFAULT_DATE
        defaultGovOfficialContentShouldBeFound("date.greaterThanOrEqual=" + DEFAULT_DATE);

        // Get all the govOfficialContentList where date is greater than or equal to UPDATED_DATE
        defaultGovOfficialContentShouldNotBeFound("date.greaterThanOrEqual=" + UPDATED_DATE);
    }

    @Test
    void getAllGovOfficialContentsByDateIsLessThanOrEqualToSomething() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where date is less than or equal to DEFAULT_DATE
        defaultGovOfficialContentShouldBeFound("date.lessThanOrEqual=" + DEFAULT_DATE);

        // Get all the govOfficialContentList where date is less than or equal to SMALLER_DATE
        defaultGovOfficialContentShouldNotBeFound("date.lessThanOrEqual=" + SMALLER_DATE);
    }

    @Test
    void getAllGovOfficialContentsByDateIsLessThanSomething() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where date is less than DEFAULT_DATE
        defaultGovOfficialContentShouldNotBeFound("date.lessThan=" + DEFAULT_DATE);

        // Get all the govOfficialContentList where date is less than UPDATED_DATE
        defaultGovOfficialContentShouldBeFound("date.lessThan=" + UPDATED_DATE);
    }

    @Test
    void getAllGovOfficialContentsByDateIsGreaterThanSomething() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        // Get all the govOfficialContentList where date is greater than DEFAULT_DATE
        defaultGovOfficialContentShouldNotBeFound("date.greaterThan=" + DEFAULT_DATE);

        // Get all the govOfficialContentList where date is greater than SMALLER_DATE
        defaultGovOfficialContentShouldBeFound("date.greaterThan=" + SMALLER_DATE);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultGovOfficialContentShouldBeFound(String filter) {
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
            .value(hasItem(govOfficialContent.getId().intValue()))
            .jsonPath("$.[*].law")
            .value(hasItem(DEFAULT_LAW))
            .jsonPath("$.[*].description")
            .value(hasItem(DEFAULT_DESCRIPTION))
            .jsonPath("$.[*].action")
            .value(hasItem(DEFAULT_ACTION))
            .jsonPath("$.[*].date")
            .value(hasItem(sameInstant(DEFAULT_DATE)));

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
    private void defaultGovOfficialContentShouldNotBeFound(String filter) {
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
    void getNonExistingGovOfficialContent() {
        // Get the govOfficialContent
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_PROBLEM_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putExistingGovOfficialContent() throws Exception {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        int databaseSizeBeforeUpdate = govOfficialContentRepository.findAll().collectList().block().size();

        // Update the govOfficialContent
        GovOfficialContent updatedGovOfficialContent = govOfficialContentRepository.findById(govOfficialContent.getId()).block();
        updatedGovOfficialContent.law(UPDATED_LAW).description(UPDATED_DESCRIPTION).action(UPDATED_ACTION).date(UPDATED_DATE);
        GovOfficialContentDTO govOfficialContentDTO = govOfficialContentMapper.toDto(updatedGovOfficialContent);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, govOfficialContentDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(govOfficialContentDTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the GovOfficialContent in the database
        List<GovOfficialContent> govOfficialContentList = govOfficialContentRepository.findAll().collectList().block();
        assertThat(govOfficialContentList).hasSize(databaseSizeBeforeUpdate);
        GovOfficialContent testGovOfficialContent = govOfficialContentList.get(govOfficialContentList.size() - 1);
        assertThat(testGovOfficialContent.getLaw()).isEqualTo(UPDATED_LAW);
        assertThat(testGovOfficialContent.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testGovOfficialContent.getAction()).isEqualTo(UPDATED_ACTION);
        assertThat(testGovOfficialContent.getDate()).isEqualTo(UPDATED_DATE);
    }

    @Test
    void putNonExistingGovOfficialContent() throws Exception {
        int databaseSizeBeforeUpdate = govOfficialContentRepository.findAll().collectList().block().size();
        govOfficialContent.setId(longCount.incrementAndGet());

        // Create the GovOfficialContent
        GovOfficialContentDTO govOfficialContentDTO = govOfficialContentMapper.toDto(govOfficialContent);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, govOfficialContentDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(govOfficialContentDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the GovOfficialContent in the database
        List<GovOfficialContent> govOfficialContentList = govOfficialContentRepository.findAll().collectList().block();
        assertThat(govOfficialContentList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchGovOfficialContent() throws Exception {
        int databaseSizeBeforeUpdate = govOfficialContentRepository.findAll().collectList().block().size();
        govOfficialContent.setId(longCount.incrementAndGet());

        // Create the GovOfficialContent
        GovOfficialContentDTO govOfficialContentDTO = govOfficialContentMapper.toDto(govOfficialContent);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, longCount.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(govOfficialContentDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the GovOfficialContent in the database
        List<GovOfficialContent> govOfficialContentList = govOfficialContentRepository.findAll().collectList().block();
        assertThat(govOfficialContentList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamGovOfficialContent() throws Exception {
        int databaseSizeBeforeUpdate = govOfficialContentRepository.findAll().collectList().block().size();
        govOfficialContent.setId(longCount.incrementAndGet());

        // Create the GovOfficialContent
        GovOfficialContentDTO govOfficialContentDTO = govOfficialContentMapper.toDto(govOfficialContent);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(govOfficialContentDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the GovOfficialContent in the database
        List<GovOfficialContent> govOfficialContentList = govOfficialContentRepository.findAll().collectList().block();
        assertThat(govOfficialContentList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateGovOfficialContentWithPatch() throws Exception {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        int databaseSizeBeforeUpdate = govOfficialContentRepository.findAll().collectList().block().size();

        // Update the govOfficialContent using partial update
        GovOfficialContent partialUpdatedGovOfficialContent = new GovOfficialContent();
        partialUpdatedGovOfficialContent.setId(govOfficialContent.getId());

        partialUpdatedGovOfficialContent.description(UPDATED_DESCRIPTION).date(UPDATED_DATE);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedGovOfficialContent.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedGovOfficialContent))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the GovOfficialContent in the database
        List<GovOfficialContent> govOfficialContentList = govOfficialContentRepository.findAll().collectList().block();
        assertThat(govOfficialContentList).hasSize(databaseSizeBeforeUpdate);
        GovOfficialContent testGovOfficialContent = govOfficialContentList.get(govOfficialContentList.size() - 1);
        assertThat(testGovOfficialContent.getLaw()).isEqualTo(DEFAULT_LAW);
        assertThat(testGovOfficialContent.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testGovOfficialContent.getAction()).isEqualTo(DEFAULT_ACTION);
        assertThat(testGovOfficialContent.getDate()).isEqualTo(UPDATED_DATE);
    }

    @Test
    void fullUpdateGovOfficialContentWithPatch() throws Exception {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        int databaseSizeBeforeUpdate = govOfficialContentRepository.findAll().collectList().block().size();

        // Update the govOfficialContent using partial update
        GovOfficialContent partialUpdatedGovOfficialContent = new GovOfficialContent();
        partialUpdatedGovOfficialContent.setId(govOfficialContent.getId());

        partialUpdatedGovOfficialContent.law(UPDATED_LAW).description(UPDATED_DESCRIPTION).action(UPDATED_ACTION).date(UPDATED_DATE);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedGovOfficialContent.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedGovOfficialContent))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the GovOfficialContent in the database
        List<GovOfficialContent> govOfficialContentList = govOfficialContentRepository.findAll().collectList().block();
        assertThat(govOfficialContentList).hasSize(databaseSizeBeforeUpdate);
        GovOfficialContent testGovOfficialContent = govOfficialContentList.get(govOfficialContentList.size() - 1);
        assertThat(testGovOfficialContent.getLaw()).isEqualTo(UPDATED_LAW);
        assertThat(testGovOfficialContent.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testGovOfficialContent.getAction()).isEqualTo(UPDATED_ACTION);
        assertThat(testGovOfficialContent.getDate()).isEqualTo(UPDATED_DATE);
    }

    @Test
    void patchNonExistingGovOfficialContent() throws Exception {
        int databaseSizeBeforeUpdate = govOfficialContentRepository.findAll().collectList().block().size();
        govOfficialContent.setId(longCount.incrementAndGet());

        // Create the GovOfficialContent
        GovOfficialContentDTO govOfficialContentDTO = govOfficialContentMapper.toDto(govOfficialContent);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, govOfficialContentDTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(govOfficialContentDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the GovOfficialContent in the database
        List<GovOfficialContent> govOfficialContentList = govOfficialContentRepository.findAll().collectList().block();
        assertThat(govOfficialContentList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchGovOfficialContent() throws Exception {
        int databaseSizeBeforeUpdate = govOfficialContentRepository.findAll().collectList().block().size();
        govOfficialContent.setId(longCount.incrementAndGet());

        // Create the GovOfficialContent
        GovOfficialContentDTO govOfficialContentDTO = govOfficialContentMapper.toDto(govOfficialContent);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, longCount.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(govOfficialContentDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the GovOfficialContent in the database
        List<GovOfficialContent> govOfficialContentList = govOfficialContentRepository.findAll().collectList().block();
        assertThat(govOfficialContentList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamGovOfficialContent() throws Exception {
        int databaseSizeBeforeUpdate = govOfficialContentRepository.findAll().collectList().block().size();
        govOfficialContent.setId(longCount.incrementAndGet());

        // Create the GovOfficialContent
        GovOfficialContentDTO govOfficialContentDTO = govOfficialContentMapper.toDto(govOfficialContent);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(govOfficialContentDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the GovOfficialContent in the database
        List<GovOfficialContent> govOfficialContentList = govOfficialContentRepository.findAll().collectList().block();
        assertThat(govOfficialContentList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteGovOfficialContent() {
        // Initialize the database
        govOfficialContentRepository.save(govOfficialContent).block();

        int databaseSizeBeforeDelete = govOfficialContentRepository.findAll().collectList().block().size();

        // Delete the govOfficialContent
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, govOfficialContent.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<GovOfficialContent> govOfficialContentList = govOfficialContentRepository.findAll().collectList().block();
        assertThat(govOfficialContentList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
