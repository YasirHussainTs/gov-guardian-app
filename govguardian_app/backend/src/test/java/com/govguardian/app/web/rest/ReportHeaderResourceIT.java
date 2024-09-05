package com.govguardian.app.web.rest;

import static com.govguardian.app.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import com.govguardian.app.IntegrationTest;
import com.govguardian.app.domain.AppUser;
import com.govguardian.app.domain.ReportHeader;
import com.govguardian.app.repository.AppUserRepository;
import com.govguardian.app.repository.EntityManager;
import com.govguardian.app.repository.ReportHeaderRepository;
import com.govguardian.app.service.dto.ReportHeaderDTO;
import com.govguardian.app.service.mapper.ReportHeaderMapper;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * Integration tests for the {@link ReportHeaderResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class ReportHeaderResourceIT {

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_TIMESTAMP = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_TIMESTAMP = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
    private static final ZonedDateTime SMALLER_TIMESTAMP = ZonedDateTime.ofInstant(Instant.ofEpochMilli(-1L), ZoneOffset.UTC);

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/report-headers";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ReportHeaderRepository reportHeaderRepository;

    @Autowired
    private ReportHeaderMapper reportHeaderMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private ReportHeader reportHeader;

    @Autowired
    private AppUserRepository appUserRepository;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReportHeader createEntity(EntityManager em) {
        ReportHeader reportHeader = new ReportHeader()
            .description(DEFAULT_DESCRIPTION)
            .title(DEFAULT_TITLE)
            .timestamp(DEFAULT_TIMESTAMP)
            .status(DEFAULT_STATUS);
        return reportHeader;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReportHeader createUpdatedEntity(EntityManager em) {
        ReportHeader reportHeader = new ReportHeader()
            .description(UPDATED_DESCRIPTION)
            .title(UPDATED_TITLE)
            .timestamp(UPDATED_TIMESTAMP)
            .status(UPDATED_STATUS);
        return reportHeader;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(ReportHeader.class).block();
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
        reportHeader = createEntity(em);
    }

    @Test
    void createReportHeader() throws Exception {
        int databaseSizeBeforeCreate = reportHeaderRepository.findAll().collectList().block().size();
        // Create the ReportHeader
        ReportHeaderDTO reportHeaderDTO = reportHeaderMapper.toDto(reportHeader);
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(reportHeaderDTO))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the ReportHeader in the database
        List<ReportHeader> reportHeaderList = reportHeaderRepository.findAll().collectList().block();
        assertThat(reportHeaderList).hasSize(databaseSizeBeforeCreate + 1);
        ReportHeader testReportHeader = reportHeaderList.get(reportHeaderList.size() - 1);
        assertThat(testReportHeader.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testReportHeader.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testReportHeader.getTimestamp()).isEqualTo(DEFAULT_TIMESTAMP);
        assertThat(testReportHeader.getStatus()).isEqualTo(DEFAULT_STATUS);
    }

    @Test
    void createReportHeaderWithExistingId() throws Exception {
        // Create the ReportHeader with an existing ID
        reportHeader.setId("existing_id");
        ReportHeaderDTO reportHeaderDTO = reportHeaderMapper.toDto(reportHeader);

        int databaseSizeBeforeCreate = reportHeaderRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(reportHeaderDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the ReportHeader in the database
        List<ReportHeader> reportHeaderList = reportHeaderRepository.findAll().collectList().block();
        assertThat(reportHeaderList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllReportHeaders() {
        // Initialize the database
        reportHeader.setId(UUID.randomUUID().toString());
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList
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
            .value(hasItem(reportHeader.getId()))
            .jsonPath("$.[*].description")
            .value(hasItem(DEFAULT_DESCRIPTION))
            .jsonPath("$.[*].title")
            .value(hasItem(DEFAULT_TITLE))
            .jsonPath("$.[*].timestamp")
            .value(hasItem(sameInstant(DEFAULT_TIMESTAMP)))
            .jsonPath("$.[*].status")
            .value(hasItem(DEFAULT_STATUS));
    }

    @Test
    void getReportHeader() {
        // Initialize the database
        reportHeader.setId(UUID.randomUUID().toString());
        reportHeaderRepository.save(reportHeader).block();

        // Get the reportHeader
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, reportHeader.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(reportHeader.getId()))
            .jsonPath("$.description")
            .value(is(DEFAULT_DESCRIPTION))
            .jsonPath("$.title")
            .value(is(DEFAULT_TITLE))
            .jsonPath("$.timestamp")
            .value(is(sameInstant(DEFAULT_TIMESTAMP)))
            .jsonPath("$.status")
            .value(is(DEFAULT_STATUS));
    }

    @Test
    void getReportHeadersByIdFiltering() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        String id = reportHeader.getId();

        defaultReportHeaderShouldBeFound("id.equals=" + id);
        defaultReportHeaderShouldNotBeFound("id.notEquals=" + id);
    }

    @Test
    void getAllReportHeadersByDescriptionIsEqualToSomething() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where description equals to DEFAULT_DESCRIPTION
        defaultReportHeaderShouldBeFound("description.equals=" + DEFAULT_DESCRIPTION);

        // Get all the reportHeaderList where description equals to UPDATED_DESCRIPTION
        defaultReportHeaderShouldNotBeFound("description.equals=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllReportHeadersByDescriptionIsInShouldWork() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where description in DEFAULT_DESCRIPTION or UPDATED_DESCRIPTION
        defaultReportHeaderShouldBeFound("description.in=" + DEFAULT_DESCRIPTION + "," + UPDATED_DESCRIPTION);

        // Get all the reportHeaderList where description equals to UPDATED_DESCRIPTION
        defaultReportHeaderShouldNotBeFound("description.in=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllReportHeadersByDescriptionIsNullOrNotNull() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where description is not null
        defaultReportHeaderShouldBeFound("description.specified=true");

        // Get all the reportHeaderList where description is null
        defaultReportHeaderShouldNotBeFound("description.specified=false");
    }

    @Test
    void getAllReportHeadersByDescriptionContainsSomething() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where description contains DEFAULT_DESCRIPTION
        defaultReportHeaderShouldBeFound("description.contains=" + DEFAULT_DESCRIPTION);

        // Get all the reportHeaderList where description contains UPDATED_DESCRIPTION
        defaultReportHeaderShouldNotBeFound("description.contains=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllReportHeadersByDescriptionNotContainsSomething() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where description does not contain DEFAULT_DESCRIPTION
        defaultReportHeaderShouldNotBeFound("description.doesNotContain=" + DEFAULT_DESCRIPTION);

        // Get all the reportHeaderList where description does not contain UPDATED_DESCRIPTION
        defaultReportHeaderShouldBeFound("description.doesNotContain=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllReportHeadersByTitleIsEqualToSomething() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where title equals to DEFAULT_TITLE
        defaultReportHeaderShouldBeFound("title.equals=" + DEFAULT_TITLE);

        // Get all the reportHeaderList where title equals to UPDATED_TITLE
        defaultReportHeaderShouldNotBeFound("title.equals=" + UPDATED_TITLE);
    }

    @Test
    void getAllReportHeadersByTitleIsInShouldWork() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where title in DEFAULT_TITLE or UPDATED_TITLE
        defaultReportHeaderShouldBeFound("title.in=" + DEFAULT_TITLE + "," + UPDATED_TITLE);

        // Get all the reportHeaderList where title equals to UPDATED_TITLE
        defaultReportHeaderShouldNotBeFound("title.in=" + UPDATED_TITLE);
    }

    @Test
    void getAllReportHeadersByTitleIsNullOrNotNull() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where title is not null
        defaultReportHeaderShouldBeFound("title.specified=true");

        // Get all the reportHeaderList where title is null
        defaultReportHeaderShouldNotBeFound("title.specified=false");
    }

    @Test
    void getAllReportHeadersByTitleContainsSomething() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where title contains DEFAULT_TITLE
        defaultReportHeaderShouldBeFound("title.contains=" + DEFAULT_TITLE);

        // Get all the reportHeaderList where title contains UPDATED_TITLE
        defaultReportHeaderShouldNotBeFound("title.contains=" + UPDATED_TITLE);
    }

    @Test
    void getAllReportHeadersByTitleNotContainsSomething() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where title does not contain DEFAULT_TITLE
        defaultReportHeaderShouldNotBeFound("title.doesNotContain=" + DEFAULT_TITLE);

        // Get all the reportHeaderList where title does not contain UPDATED_TITLE
        defaultReportHeaderShouldBeFound("title.doesNotContain=" + UPDATED_TITLE);
    }

    @Test
    void getAllReportHeadersByTimestampIsEqualToSomething() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where timestamp equals to DEFAULT_TIMESTAMP
        defaultReportHeaderShouldBeFound("timestamp.equals=" + DEFAULT_TIMESTAMP);

        // Get all the reportHeaderList where timestamp equals to UPDATED_TIMESTAMP
        defaultReportHeaderShouldNotBeFound("timestamp.equals=" + UPDATED_TIMESTAMP);
    }

    @Test
    void getAllReportHeadersByTimestampIsInShouldWork() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where timestamp in DEFAULT_TIMESTAMP or UPDATED_TIMESTAMP
        defaultReportHeaderShouldBeFound("timestamp.in=" + DEFAULT_TIMESTAMP + "," + UPDATED_TIMESTAMP);

        // Get all the reportHeaderList where timestamp equals to UPDATED_TIMESTAMP
        defaultReportHeaderShouldNotBeFound("timestamp.in=" + UPDATED_TIMESTAMP);
    }

    @Test
    void getAllReportHeadersByTimestampIsNullOrNotNull() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where timestamp is not null
        defaultReportHeaderShouldBeFound("timestamp.specified=true");

        // Get all the reportHeaderList where timestamp is null
        defaultReportHeaderShouldNotBeFound("timestamp.specified=false");
    }

    @Test
    void getAllReportHeadersByTimestampIsGreaterThanOrEqualToSomething() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where timestamp is greater than or equal to DEFAULT_TIMESTAMP
        defaultReportHeaderShouldBeFound("timestamp.greaterThanOrEqual=" + DEFAULT_TIMESTAMP);

        // Get all the reportHeaderList where timestamp is greater than or equal to UPDATED_TIMESTAMP
        defaultReportHeaderShouldNotBeFound("timestamp.greaterThanOrEqual=" + UPDATED_TIMESTAMP);
    }

    @Test
    void getAllReportHeadersByTimestampIsLessThanOrEqualToSomething() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where timestamp is less than or equal to DEFAULT_TIMESTAMP
        defaultReportHeaderShouldBeFound("timestamp.lessThanOrEqual=" + DEFAULT_TIMESTAMP);

        // Get all the reportHeaderList where timestamp is less than or equal to SMALLER_TIMESTAMP
        defaultReportHeaderShouldNotBeFound("timestamp.lessThanOrEqual=" + SMALLER_TIMESTAMP);
    }

    @Test
    void getAllReportHeadersByTimestampIsLessThanSomething() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where timestamp is less than DEFAULT_TIMESTAMP
        defaultReportHeaderShouldNotBeFound("timestamp.lessThan=" + DEFAULT_TIMESTAMP);

        // Get all the reportHeaderList where timestamp is less than UPDATED_TIMESTAMP
        defaultReportHeaderShouldBeFound("timestamp.lessThan=" + UPDATED_TIMESTAMP);
    }

    @Test
    void getAllReportHeadersByTimestampIsGreaterThanSomething() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where timestamp is greater than DEFAULT_TIMESTAMP
        defaultReportHeaderShouldNotBeFound("timestamp.greaterThan=" + DEFAULT_TIMESTAMP);

        // Get all the reportHeaderList where timestamp is greater than SMALLER_TIMESTAMP
        defaultReportHeaderShouldBeFound("timestamp.greaterThan=" + SMALLER_TIMESTAMP);
    }

    @Test
    void getAllReportHeadersByStatusIsEqualToSomething() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where status equals to DEFAULT_STATUS
        defaultReportHeaderShouldBeFound("status.equals=" + DEFAULT_STATUS);

        // Get all the reportHeaderList where status equals to UPDATED_STATUS
        defaultReportHeaderShouldNotBeFound("status.equals=" + UPDATED_STATUS);
    }

    @Test
    void getAllReportHeadersByStatusIsInShouldWork() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where status in DEFAULT_STATUS or UPDATED_STATUS
        defaultReportHeaderShouldBeFound("status.in=" + DEFAULT_STATUS + "," + UPDATED_STATUS);

        // Get all the reportHeaderList where status equals to UPDATED_STATUS
        defaultReportHeaderShouldNotBeFound("status.in=" + UPDATED_STATUS);
    }

    @Test
    void getAllReportHeadersByStatusIsNullOrNotNull() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where status is not null
        defaultReportHeaderShouldBeFound("status.specified=true");

        // Get all the reportHeaderList where status is null
        defaultReportHeaderShouldNotBeFound("status.specified=false");
    }

    @Test
    void getAllReportHeadersByStatusContainsSomething() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where status contains DEFAULT_STATUS
        defaultReportHeaderShouldBeFound("status.contains=" + DEFAULT_STATUS);

        // Get all the reportHeaderList where status contains UPDATED_STATUS
        defaultReportHeaderShouldNotBeFound("status.contains=" + UPDATED_STATUS);
    }

    @Test
    void getAllReportHeadersByStatusNotContainsSomething() {
        // Initialize the database
        reportHeaderRepository.save(reportHeader).block();

        // Get all the reportHeaderList where status does not contain DEFAULT_STATUS
        defaultReportHeaderShouldNotBeFound("status.doesNotContain=" + DEFAULT_STATUS);

        // Get all the reportHeaderList where status does not contain UPDATED_STATUS
        defaultReportHeaderShouldBeFound("status.doesNotContain=" + UPDATED_STATUS);
    }

    @Test
    void getAllReportHeadersByAppUserIsEqualToSomething() {
        AppUser appUser = AppUserResourceIT.createEntity(em);
        appUserRepository.save(appUser).block();
        Long appUserId = appUser.getId();
        reportHeader.setAppUserId(appUserId);
        reportHeaderRepository.save(reportHeader).block();
        // Get all the reportHeaderList where appUser equals to appUserId
        defaultReportHeaderShouldBeFound("appUserId.equals=" + appUserId);

        // Get all the reportHeaderList where appUser equals to (appUserId + 1)
        defaultReportHeaderShouldNotBeFound("appUserId.equals=" + (appUserId + 1));
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultReportHeaderShouldBeFound(String filter) {
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
            .value(hasItem(reportHeader.getId()))
            .jsonPath("$.[*].description")
            .value(hasItem(DEFAULT_DESCRIPTION))
            .jsonPath("$.[*].title")
            .value(hasItem(DEFAULT_TITLE))
            .jsonPath("$.[*].timestamp")
            .value(hasItem(sameInstant(DEFAULT_TIMESTAMP)))
            .jsonPath("$.[*].status")
            .value(hasItem(DEFAULT_STATUS));

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
    private void defaultReportHeaderShouldNotBeFound(String filter) {
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
    void getNonExistingReportHeader() {
        // Get the reportHeader
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_PROBLEM_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putExistingReportHeader() throws Exception {
        // Initialize the database
        reportHeader.setId(UUID.randomUUID().toString());
        reportHeaderRepository.save(reportHeader).block();

        int databaseSizeBeforeUpdate = reportHeaderRepository.findAll().collectList().block().size();

        // Update the reportHeader
        ReportHeader updatedReportHeader = reportHeaderRepository.findById(reportHeader.getId()).block();
        updatedReportHeader.description(UPDATED_DESCRIPTION).title(UPDATED_TITLE).timestamp(UPDATED_TIMESTAMP).status(UPDATED_STATUS);
        ReportHeaderDTO reportHeaderDTO = reportHeaderMapper.toDto(updatedReportHeader);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, reportHeaderDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(reportHeaderDTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the ReportHeader in the database
        List<ReportHeader> reportHeaderList = reportHeaderRepository.findAll().collectList().block();
        assertThat(reportHeaderList).hasSize(databaseSizeBeforeUpdate);
        ReportHeader testReportHeader = reportHeaderList.get(reportHeaderList.size() - 1);
        assertThat(testReportHeader.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testReportHeader.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testReportHeader.getTimestamp()).isEqualTo(UPDATED_TIMESTAMP);
        assertThat(testReportHeader.getStatus()).isEqualTo(UPDATED_STATUS);
    }

    @Test
    void putNonExistingReportHeader() throws Exception {
        int databaseSizeBeforeUpdate = reportHeaderRepository.findAll().collectList().block().size();
        reportHeader.setId(UUID.randomUUID().toString());

        // Create the ReportHeader
        ReportHeaderDTO reportHeaderDTO = reportHeaderMapper.toDto(reportHeader);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, reportHeaderDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(reportHeaderDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the ReportHeader in the database
        List<ReportHeader> reportHeaderList = reportHeaderRepository.findAll().collectList().block();
        assertThat(reportHeaderList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchReportHeader() throws Exception {
        int databaseSizeBeforeUpdate = reportHeaderRepository.findAll().collectList().block().size();
        reportHeader.setId(UUID.randomUUID().toString());

        // Create the ReportHeader
        ReportHeaderDTO reportHeaderDTO = reportHeaderMapper.toDto(reportHeader);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, UUID.randomUUID().toString())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(reportHeaderDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the ReportHeader in the database
        List<ReportHeader> reportHeaderList = reportHeaderRepository.findAll().collectList().block();
        assertThat(reportHeaderList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamReportHeader() throws Exception {
        int databaseSizeBeforeUpdate = reportHeaderRepository.findAll().collectList().block().size();
        reportHeader.setId(UUID.randomUUID().toString());

        // Create the ReportHeader
        ReportHeaderDTO reportHeaderDTO = reportHeaderMapper.toDto(reportHeader);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(reportHeaderDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the ReportHeader in the database
        List<ReportHeader> reportHeaderList = reportHeaderRepository.findAll().collectList().block();
        assertThat(reportHeaderList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateReportHeaderWithPatch() throws Exception {
        // Initialize the database
        reportHeader.setId(UUID.randomUUID().toString());
        reportHeaderRepository.save(reportHeader).block();

        int databaseSizeBeforeUpdate = reportHeaderRepository.findAll().collectList().block().size();

        // Update the reportHeader using partial update
        ReportHeader partialUpdatedReportHeader = new ReportHeader();
        partialUpdatedReportHeader.setId(reportHeader.getId());

        partialUpdatedReportHeader.description(UPDATED_DESCRIPTION).status(UPDATED_STATUS);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedReportHeader.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedReportHeader))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the ReportHeader in the database
        List<ReportHeader> reportHeaderList = reportHeaderRepository.findAll().collectList().block();
        assertThat(reportHeaderList).hasSize(databaseSizeBeforeUpdate);
        ReportHeader testReportHeader = reportHeaderList.get(reportHeaderList.size() - 1);
        assertThat(testReportHeader.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testReportHeader.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testReportHeader.getTimestamp()).isEqualTo(DEFAULT_TIMESTAMP);
        assertThat(testReportHeader.getStatus()).isEqualTo(UPDATED_STATUS);
    }

    @Test
    void fullUpdateReportHeaderWithPatch() throws Exception {
        // Initialize the database
        reportHeader.setId(UUID.randomUUID().toString());
        reportHeaderRepository.save(reportHeader).block();

        int databaseSizeBeforeUpdate = reportHeaderRepository.findAll().collectList().block().size();

        // Update the reportHeader using partial update
        ReportHeader partialUpdatedReportHeader = new ReportHeader();
        partialUpdatedReportHeader.setId(reportHeader.getId());

        partialUpdatedReportHeader
            .description(UPDATED_DESCRIPTION)
            .title(UPDATED_TITLE)
            .timestamp(UPDATED_TIMESTAMP)
            .status(UPDATED_STATUS);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedReportHeader.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedReportHeader))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the ReportHeader in the database
        List<ReportHeader> reportHeaderList = reportHeaderRepository.findAll().collectList().block();
        assertThat(reportHeaderList).hasSize(databaseSizeBeforeUpdate);
        ReportHeader testReportHeader = reportHeaderList.get(reportHeaderList.size() - 1);
        assertThat(testReportHeader.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testReportHeader.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testReportHeader.getTimestamp()).isEqualTo(UPDATED_TIMESTAMP);
        assertThat(testReportHeader.getStatus()).isEqualTo(UPDATED_STATUS);
    }

    @Test
    void patchNonExistingReportHeader() throws Exception {
        int databaseSizeBeforeUpdate = reportHeaderRepository.findAll().collectList().block().size();
        reportHeader.setId(UUID.randomUUID().toString());

        // Create the ReportHeader
        ReportHeaderDTO reportHeaderDTO = reportHeaderMapper.toDto(reportHeader);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, reportHeaderDTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(reportHeaderDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the ReportHeader in the database
        List<ReportHeader> reportHeaderList = reportHeaderRepository.findAll().collectList().block();
        assertThat(reportHeaderList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchReportHeader() throws Exception {
        int databaseSizeBeforeUpdate = reportHeaderRepository.findAll().collectList().block().size();
        reportHeader.setId(UUID.randomUUID().toString());

        // Create the ReportHeader
        ReportHeaderDTO reportHeaderDTO = reportHeaderMapper.toDto(reportHeader);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, UUID.randomUUID().toString())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(reportHeaderDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the ReportHeader in the database
        List<ReportHeader> reportHeaderList = reportHeaderRepository.findAll().collectList().block();
        assertThat(reportHeaderList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamReportHeader() throws Exception {
        int databaseSizeBeforeUpdate = reportHeaderRepository.findAll().collectList().block().size();
        reportHeader.setId(UUID.randomUUID().toString());

        // Create the ReportHeader
        ReportHeaderDTO reportHeaderDTO = reportHeaderMapper.toDto(reportHeader);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(reportHeaderDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the ReportHeader in the database
        List<ReportHeader> reportHeaderList = reportHeaderRepository.findAll().collectList().block();
        assertThat(reportHeaderList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteReportHeader() {
        // Initialize the database
        reportHeader.setId(UUID.randomUUID().toString());
        reportHeaderRepository.save(reportHeader).block();

        int databaseSizeBeforeDelete = reportHeaderRepository.findAll().collectList().block().size();

        // Delete the reportHeader
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, reportHeader.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<ReportHeader> reportHeaderList = reportHeaderRepository.findAll().collectList().block();
        assertThat(reportHeaderList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
