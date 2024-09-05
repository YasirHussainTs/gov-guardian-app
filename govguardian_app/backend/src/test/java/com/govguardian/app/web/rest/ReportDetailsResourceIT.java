package com.govguardian.app.web.rest;

import static com.govguardian.app.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import com.govguardian.app.IntegrationTest;
import com.govguardian.app.domain.AppUser;
import com.govguardian.app.domain.ReportDetails;
import com.govguardian.app.repository.AppUserRepository;
import com.govguardian.app.repository.EntityManager;
import com.govguardian.app.repository.ReportDetailsRepository;
import com.govguardian.app.service.dto.ReportDetailsDTO;
import com.govguardian.app.service.mapper.ReportDetailsMapper;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Base64;
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
 * Integration tests for the {@link ReportDetailsResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class ReportDetailsResourceIT {

    private static final String DEFAULT_OWNER = "AAAAAAAAAA";
    private static final String UPDATED_OWNER = "BBBBBBBBBB";

    private static final String DEFAULT_RESPONDER = "AAAAAAAAAA";
    private static final String UPDATED_RESPONDER = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_TIMESTAMP = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_TIMESTAMP = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
    private static final ZonedDateTime SMALLER_TIMESTAMP = ZonedDateTime.ofInstant(Instant.ofEpochMilli(-1L), ZoneOffset.UTC);

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final byte[] DEFAULT_IMAGE = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_IMAGE = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_IMAGE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_IMAGE_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_VIDEO = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_VIDEO = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_VIDEO_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_VIDEO_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_VOICE_DATA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_VOICE_DATA = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_VOICE_DATA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_VOICE_DATA_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_FILE_1 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_FILE_1 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_FILE_1_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_FILE_1_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_FILE_2 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_FILE_2 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_FILE_2_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_FILE_2_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_FILE_3 = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_FILE_3 = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_FILE_3_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_FILE_3_CONTENT_TYPE = "image/png";

    private static final String ENTITY_API_URL = "/api/report-details";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ReportDetailsRepository reportDetailsRepository;

    @Autowired
    private ReportDetailsMapper reportDetailsMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private ReportDetails reportDetails;

    @Autowired
    private AppUserRepository appUserRepository;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReportDetails createEntity(EntityManager em) {
        ReportDetails reportDetails = new ReportDetails()
            .owner(DEFAULT_OWNER)
            .responder(DEFAULT_RESPONDER)
            .description(DEFAULT_DESCRIPTION)
            .title(DEFAULT_TITLE)
            .timestamp(DEFAULT_TIMESTAMP)
            .status(DEFAULT_STATUS)
            .image(DEFAULT_IMAGE)
            .imageContentType(DEFAULT_IMAGE_CONTENT_TYPE)
            .video(DEFAULT_VIDEO)
            .videoContentType(DEFAULT_VIDEO_CONTENT_TYPE)
            .voiceData(DEFAULT_VOICE_DATA)
            .voiceDataContentType(DEFAULT_VOICE_DATA_CONTENT_TYPE)
            .file1(DEFAULT_FILE_1)
            .file1ContentType(DEFAULT_FILE_1_CONTENT_TYPE)
            .file2(DEFAULT_FILE_2)
            .file2ContentType(DEFAULT_FILE_2_CONTENT_TYPE)
            .file3(DEFAULT_FILE_3)
            .file3ContentType(DEFAULT_FILE_3_CONTENT_TYPE);
        return reportDetails;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReportDetails createUpdatedEntity(EntityManager em) {
        ReportDetails reportDetails = new ReportDetails()
            .owner(UPDATED_OWNER)
            .responder(UPDATED_RESPONDER)
            .description(UPDATED_DESCRIPTION)
            .title(UPDATED_TITLE)
            .timestamp(UPDATED_TIMESTAMP)
            .status(UPDATED_STATUS)
            .image(UPDATED_IMAGE)
            .imageContentType(UPDATED_IMAGE_CONTENT_TYPE)
            .video(UPDATED_VIDEO)
            .videoContentType(UPDATED_VIDEO_CONTENT_TYPE)
            .voiceData(UPDATED_VOICE_DATA)
            .voiceDataContentType(UPDATED_VOICE_DATA_CONTENT_TYPE)
            .file1(UPDATED_FILE_1)
            .file1ContentType(UPDATED_FILE_1_CONTENT_TYPE)
            .file2(UPDATED_FILE_2)
            .file2ContentType(UPDATED_FILE_2_CONTENT_TYPE)
            .file3(UPDATED_FILE_3)
            .file3ContentType(UPDATED_FILE_3_CONTENT_TYPE);
        return reportDetails;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(ReportDetails.class).block();
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
        reportDetails = createEntity(em);
    }

    @Test
    void createReportDetails() throws Exception {
        int databaseSizeBeforeCreate = reportDetailsRepository.findAll().collectList().block().size();
        // Create the ReportDetails
        ReportDetailsDTO reportDetailsDTO = reportDetailsMapper.toDto(reportDetails);
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(reportDetailsDTO))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the ReportDetails in the database
        List<ReportDetails> reportDetailsList = reportDetailsRepository.findAll().collectList().block();
        assertThat(reportDetailsList).hasSize(databaseSizeBeforeCreate + 1);
        ReportDetails testReportDetails = reportDetailsList.get(reportDetailsList.size() - 1);
        assertThat(testReportDetails.getOwner()).isEqualTo(DEFAULT_OWNER);
        assertThat(testReportDetails.getResponder()).isEqualTo(DEFAULT_RESPONDER);
        assertThat(testReportDetails.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testReportDetails.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testReportDetails.getTimestamp()).isEqualTo(DEFAULT_TIMESTAMP);
        assertThat(testReportDetails.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testReportDetails.getImage()).isEqualTo(DEFAULT_IMAGE);
        assertThat(testReportDetails.getImageContentType()).isEqualTo(DEFAULT_IMAGE_CONTENT_TYPE);
        assertThat(testReportDetails.getVideo()).isEqualTo(DEFAULT_VIDEO);
        assertThat(testReportDetails.getVideoContentType()).isEqualTo(DEFAULT_VIDEO_CONTENT_TYPE);
        assertThat(testReportDetails.getVoiceData()).isEqualTo(DEFAULT_VOICE_DATA);
        assertThat(testReportDetails.getVoiceDataContentType()).isEqualTo(DEFAULT_VOICE_DATA_CONTENT_TYPE);
        assertThat(testReportDetails.getFile1()).isEqualTo(DEFAULT_FILE_1);
        assertThat(testReportDetails.getFile1ContentType()).isEqualTo(DEFAULT_FILE_1_CONTENT_TYPE);
        assertThat(testReportDetails.getFile2()).isEqualTo(DEFAULT_FILE_2);
        assertThat(testReportDetails.getFile2ContentType()).isEqualTo(DEFAULT_FILE_2_CONTENT_TYPE);
        assertThat(testReportDetails.getFile3()).isEqualTo(DEFAULT_FILE_3);
        assertThat(testReportDetails.getFile3ContentType()).isEqualTo(DEFAULT_FILE_3_CONTENT_TYPE);
    }

    @Test
    void createReportDetailsWithExistingId() throws Exception {
        // Create the ReportDetails with an existing ID
        reportDetails.setId(1L);
        ReportDetailsDTO reportDetailsDTO = reportDetailsMapper.toDto(reportDetails);

        int databaseSizeBeforeCreate = reportDetailsRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(reportDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the ReportDetails in the database
        List<ReportDetails> reportDetailsList = reportDetailsRepository.findAll().collectList().block();
        assertThat(reportDetailsList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllReportDetails() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList
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
            .value(hasItem(reportDetails.getId().intValue()))
            .jsonPath("$.[*].owner")
            .value(hasItem(DEFAULT_OWNER))
            .jsonPath("$.[*].responder")
            .value(hasItem(DEFAULT_RESPONDER))
            .jsonPath("$.[*].description")
            .value(hasItem(DEFAULT_DESCRIPTION))
            .jsonPath("$.[*].title")
            .value(hasItem(DEFAULT_TITLE))
            .jsonPath("$.[*].timestamp")
            .value(hasItem(sameInstant(DEFAULT_TIMESTAMP)))
            .jsonPath("$.[*].status")
            .value(hasItem(DEFAULT_STATUS))
            .jsonPath("$.[*].imageContentType")
            .value(hasItem(DEFAULT_IMAGE_CONTENT_TYPE))
            .jsonPath("$.[*].image")
            .value(hasItem(Base64.getEncoder().encodeToString(DEFAULT_IMAGE)))
            .jsonPath("$.[*].videoContentType")
            .value(hasItem(DEFAULT_VIDEO_CONTENT_TYPE))
            .jsonPath("$.[*].video")
            .value(hasItem(Base64.getEncoder().encodeToString(DEFAULT_VIDEO)))
            .jsonPath("$.[*].voiceDataContentType")
            .value(hasItem(DEFAULT_VOICE_DATA_CONTENT_TYPE))
            .jsonPath("$.[*].voiceData")
            .value(hasItem(Base64.getEncoder().encodeToString(DEFAULT_VOICE_DATA)))
            .jsonPath("$.[*].file1ContentType")
            .value(hasItem(DEFAULT_FILE_1_CONTENT_TYPE))
            .jsonPath("$.[*].file1")
            .value(hasItem(Base64.getEncoder().encodeToString(DEFAULT_FILE_1)))
            .jsonPath("$.[*].file2ContentType")
            .value(hasItem(DEFAULT_FILE_2_CONTENT_TYPE))
            .jsonPath("$.[*].file2")
            .value(hasItem(Base64.getEncoder().encodeToString(DEFAULT_FILE_2)))
            .jsonPath("$.[*].file3ContentType")
            .value(hasItem(DEFAULT_FILE_3_CONTENT_TYPE))
            .jsonPath("$.[*].file3")
            .value(hasItem(Base64.getEncoder().encodeToString(DEFAULT_FILE_3)));
    }

    @Test
    void getReportDetails() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get the reportDetails
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, reportDetails.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(reportDetails.getId().intValue()))
            .jsonPath("$.owner")
            .value(is(DEFAULT_OWNER))
            .jsonPath("$.responder")
            .value(is(DEFAULT_RESPONDER))
            .jsonPath("$.description")
            .value(is(DEFAULT_DESCRIPTION))
            .jsonPath("$.title")
            .value(is(DEFAULT_TITLE))
            .jsonPath("$.timestamp")
            .value(is(sameInstant(DEFAULT_TIMESTAMP)))
            .jsonPath("$.status")
            .value(is(DEFAULT_STATUS))
            .jsonPath("$.imageContentType")
            .value(is(DEFAULT_IMAGE_CONTENT_TYPE))
            .jsonPath("$.image")
            .value(is(Base64.getEncoder().encodeToString(DEFAULT_IMAGE)))
            .jsonPath("$.videoContentType")
            .value(is(DEFAULT_VIDEO_CONTENT_TYPE))
            .jsonPath("$.video")
            .value(is(Base64.getEncoder().encodeToString(DEFAULT_VIDEO)))
            .jsonPath("$.voiceDataContentType")
            .value(is(DEFAULT_VOICE_DATA_CONTENT_TYPE))
            .jsonPath("$.voiceData")
            .value(is(Base64.getEncoder().encodeToString(DEFAULT_VOICE_DATA)))
            .jsonPath("$.file1ContentType")
            .value(is(DEFAULT_FILE_1_CONTENT_TYPE))
            .jsonPath("$.file1")
            .value(is(Base64.getEncoder().encodeToString(DEFAULT_FILE_1)))
            .jsonPath("$.file2ContentType")
            .value(is(DEFAULT_FILE_2_CONTENT_TYPE))
            .jsonPath("$.file2")
            .value(is(Base64.getEncoder().encodeToString(DEFAULT_FILE_2)))
            .jsonPath("$.file3ContentType")
            .value(is(DEFAULT_FILE_3_CONTENT_TYPE))
            .jsonPath("$.file3")
            .value(is(Base64.getEncoder().encodeToString(DEFAULT_FILE_3)));
    }

    @Test
    void getReportDetailsByIdFiltering() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        Long id = reportDetails.getId();

        defaultReportDetailsShouldBeFound("id.equals=" + id);
        defaultReportDetailsShouldNotBeFound("id.notEquals=" + id);

        defaultReportDetailsShouldBeFound("id.greaterThanOrEqual=" + id);
        defaultReportDetailsShouldNotBeFound("id.greaterThan=" + id);

        defaultReportDetailsShouldBeFound("id.lessThanOrEqual=" + id);
        defaultReportDetailsShouldNotBeFound("id.lessThan=" + id);
    }

    @Test
    void getAllReportDetailsByOwnerIsEqualToSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where owner equals to DEFAULT_OWNER
        defaultReportDetailsShouldBeFound("owner.equals=" + DEFAULT_OWNER);

        // Get all the reportDetailsList where owner equals to UPDATED_OWNER
        defaultReportDetailsShouldNotBeFound("owner.equals=" + UPDATED_OWNER);
    }

    @Test
    void getAllReportDetailsByOwnerIsInShouldWork() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where owner in DEFAULT_OWNER or UPDATED_OWNER
        defaultReportDetailsShouldBeFound("owner.in=" + DEFAULT_OWNER + "," + UPDATED_OWNER);

        // Get all the reportDetailsList where owner equals to UPDATED_OWNER
        defaultReportDetailsShouldNotBeFound("owner.in=" + UPDATED_OWNER);
    }

    @Test
    void getAllReportDetailsByOwnerIsNullOrNotNull() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where owner is not null
        defaultReportDetailsShouldBeFound("owner.specified=true");

        // Get all the reportDetailsList where owner is null
        defaultReportDetailsShouldNotBeFound("owner.specified=false");
    }

    @Test
    void getAllReportDetailsByOwnerContainsSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where owner contains DEFAULT_OWNER
        defaultReportDetailsShouldBeFound("owner.contains=" + DEFAULT_OWNER);

        // Get all the reportDetailsList where owner contains UPDATED_OWNER
        defaultReportDetailsShouldNotBeFound("owner.contains=" + UPDATED_OWNER);
    }

    @Test
    void getAllReportDetailsByOwnerNotContainsSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where owner does not contain DEFAULT_OWNER
        defaultReportDetailsShouldNotBeFound("owner.doesNotContain=" + DEFAULT_OWNER);

        // Get all the reportDetailsList where owner does not contain UPDATED_OWNER
        defaultReportDetailsShouldBeFound("owner.doesNotContain=" + UPDATED_OWNER);
    }

    @Test
    void getAllReportDetailsByResponderIsEqualToSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where responder equals to DEFAULT_RESPONDER
        defaultReportDetailsShouldBeFound("responder.equals=" + DEFAULT_RESPONDER);

        // Get all the reportDetailsList where responder equals to UPDATED_RESPONDER
        defaultReportDetailsShouldNotBeFound("responder.equals=" + UPDATED_RESPONDER);
    }

    @Test
    void getAllReportDetailsByResponderIsInShouldWork() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where responder in DEFAULT_RESPONDER or UPDATED_RESPONDER
        defaultReportDetailsShouldBeFound("responder.in=" + DEFAULT_RESPONDER + "," + UPDATED_RESPONDER);

        // Get all the reportDetailsList where responder equals to UPDATED_RESPONDER
        defaultReportDetailsShouldNotBeFound("responder.in=" + UPDATED_RESPONDER);
    }

    @Test
    void getAllReportDetailsByResponderIsNullOrNotNull() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where responder is not null
        defaultReportDetailsShouldBeFound("responder.specified=true");

        // Get all the reportDetailsList where responder is null
        defaultReportDetailsShouldNotBeFound("responder.specified=false");
    }

    @Test
    void getAllReportDetailsByResponderContainsSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where responder contains DEFAULT_RESPONDER
        defaultReportDetailsShouldBeFound("responder.contains=" + DEFAULT_RESPONDER);

        // Get all the reportDetailsList where responder contains UPDATED_RESPONDER
        defaultReportDetailsShouldNotBeFound("responder.contains=" + UPDATED_RESPONDER);
    }

    @Test
    void getAllReportDetailsByResponderNotContainsSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where responder does not contain DEFAULT_RESPONDER
        defaultReportDetailsShouldNotBeFound("responder.doesNotContain=" + DEFAULT_RESPONDER);

        // Get all the reportDetailsList where responder does not contain UPDATED_RESPONDER
        defaultReportDetailsShouldBeFound("responder.doesNotContain=" + UPDATED_RESPONDER);
    }

    @Test
    void getAllReportDetailsByDescriptionIsEqualToSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where description equals to DEFAULT_DESCRIPTION
        defaultReportDetailsShouldBeFound("description.equals=" + DEFAULT_DESCRIPTION);

        // Get all the reportDetailsList where description equals to UPDATED_DESCRIPTION
        defaultReportDetailsShouldNotBeFound("description.equals=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllReportDetailsByDescriptionIsInShouldWork() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where description in DEFAULT_DESCRIPTION or UPDATED_DESCRIPTION
        defaultReportDetailsShouldBeFound("description.in=" + DEFAULT_DESCRIPTION + "," + UPDATED_DESCRIPTION);

        // Get all the reportDetailsList where description equals to UPDATED_DESCRIPTION
        defaultReportDetailsShouldNotBeFound("description.in=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllReportDetailsByDescriptionIsNullOrNotNull() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where description is not null
        defaultReportDetailsShouldBeFound("description.specified=true");

        // Get all the reportDetailsList where description is null
        defaultReportDetailsShouldNotBeFound("description.specified=false");
    }

    @Test
    void getAllReportDetailsByDescriptionContainsSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where description contains DEFAULT_DESCRIPTION
        defaultReportDetailsShouldBeFound("description.contains=" + DEFAULT_DESCRIPTION);

        // Get all the reportDetailsList where description contains UPDATED_DESCRIPTION
        defaultReportDetailsShouldNotBeFound("description.contains=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllReportDetailsByDescriptionNotContainsSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where description does not contain DEFAULT_DESCRIPTION
        defaultReportDetailsShouldNotBeFound("description.doesNotContain=" + DEFAULT_DESCRIPTION);

        // Get all the reportDetailsList where description does not contain UPDATED_DESCRIPTION
        defaultReportDetailsShouldBeFound("description.doesNotContain=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllReportDetailsByTitleIsEqualToSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where title equals to DEFAULT_TITLE
        defaultReportDetailsShouldBeFound("title.equals=" + DEFAULT_TITLE);

        // Get all the reportDetailsList where title equals to UPDATED_TITLE
        defaultReportDetailsShouldNotBeFound("title.equals=" + UPDATED_TITLE);
    }

    @Test
    void getAllReportDetailsByTitleIsInShouldWork() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where title in DEFAULT_TITLE or UPDATED_TITLE
        defaultReportDetailsShouldBeFound("title.in=" + DEFAULT_TITLE + "," + UPDATED_TITLE);

        // Get all the reportDetailsList where title equals to UPDATED_TITLE
        defaultReportDetailsShouldNotBeFound("title.in=" + UPDATED_TITLE);
    }

    @Test
    void getAllReportDetailsByTitleIsNullOrNotNull() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where title is not null
        defaultReportDetailsShouldBeFound("title.specified=true");

        // Get all the reportDetailsList where title is null
        defaultReportDetailsShouldNotBeFound("title.specified=false");
    }

    @Test
    void getAllReportDetailsByTitleContainsSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where title contains DEFAULT_TITLE
        defaultReportDetailsShouldBeFound("title.contains=" + DEFAULT_TITLE);

        // Get all the reportDetailsList where title contains UPDATED_TITLE
        defaultReportDetailsShouldNotBeFound("title.contains=" + UPDATED_TITLE);
    }

    @Test
    void getAllReportDetailsByTitleNotContainsSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where title does not contain DEFAULT_TITLE
        defaultReportDetailsShouldNotBeFound("title.doesNotContain=" + DEFAULT_TITLE);

        // Get all the reportDetailsList where title does not contain UPDATED_TITLE
        defaultReportDetailsShouldBeFound("title.doesNotContain=" + UPDATED_TITLE);
    }

    @Test
    void getAllReportDetailsByTimestampIsEqualToSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where timestamp equals to DEFAULT_TIMESTAMP
        defaultReportDetailsShouldBeFound("timestamp.equals=" + DEFAULT_TIMESTAMP);

        // Get all the reportDetailsList where timestamp equals to UPDATED_TIMESTAMP
        defaultReportDetailsShouldNotBeFound("timestamp.equals=" + UPDATED_TIMESTAMP);
    }

    @Test
    void getAllReportDetailsByTimestampIsInShouldWork() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where timestamp in DEFAULT_TIMESTAMP or UPDATED_TIMESTAMP
        defaultReportDetailsShouldBeFound("timestamp.in=" + DEFAULT_TIMESTAMP + "," + UPDATED_TIMESTAMP);

        // Get all the reportDetailsList where timestamp equals to UPDATED_TIMESTAMP
        defaultReportDetailsShouldNotBeFound("timestamp.in=" + UPDATED_TIMESTAMP);
    }

    @Test
    void getAllReportDetailsByTimestampIsNullOrNotNull() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where timestamp is not null
        defaultReportDetailsShouldBeFound("timestamp.specified=true");

        // Get all the reportDetailsList where timestamp is null
        defaultReportDetailsShouldNotBeFound("timestamp.specified=false");
    }

    @Test
    void getAllReportDetailsByTimestampIsGreaterThanOrEqualToSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where timestamp is greater than or equal to DEFAULT_TIMESTAMP
        defaultReportDetailsShouldBeFound("timestamp.greaterThanOrEqual=" + DEFAULT_TIMESTAMP);

        // Get all the reportDetailsList where timestamp is greater than or equal to UPDATED_TIMESTAMP
        defaultReportDetailsShouldNotBeFound("timestamp.greaterThanOrEqual=" + UPDATED_TIMESTAMP);
    }

    @Test
    void getAllReportDetailsByTimestampIsLessThanOrEqualToSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where timestamp is less than or equal to DEFAULT_TIMESTAMP
        defaultReportDetailsShouldBeFound("timestamp.lessThanOrEqual=" + DEFAULT_TIMESTAMP);

        // Get all the reportDetailsList where timestamp is less than or equal to SMALLER_TIMESTAMP
        defaultReportDetailsShouldNotBeFound("timestamp.lessThanOrEqual=" + SMALLER_TIMESTAMP);
    }

    @Test
    void getAllReportDetailsByTimestampIsLessThanSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where timestamp is less than DEFAULT_TIMESTAMP
        defaultReportDetailsShouldNotBeFound("timestamp.lessThan=" + DEFAULT_TIMESTAMP);

        // Get all the reportDetailsList where timestamp is less than UPDATED_TIMESTAMP
        defaultReportDetailsShouldBeFound("timestamp.lessThan=" + UPDATED_TIMESTAMP);
    }

    @Test
    void getAllReportDetailsByTimestampIsGreaterThanSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where timestamp is greater than DEFAULT_TIMESTAMP
        defaultReportDetailsShouldNotBeFound("timestamp.greaterThan=" + DEFAULT_TIMESTAMP);

        // Get all the reportDetailsList where timestamp is greater than SMALLER_TIMESTAMP
        defaultReportDetailsShouldBeFound("timestamp.greaterThan=" + SMALLER_TIMESTAMP);
    }

    @Test
    void getAllReportDetailsByStatusIsEqualToSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where status equals to DEFAULT_STATUS
        defaultReportDetailsShouldBeFound("status.equals=" + DEFAULT_STATUS);

        // Get all the reportDetailsList where status equals to UPDATED_STATUS
        defaultReportDetailsShouldNotBeFound("status.equals=" + UPDATED_STATUS);
    }

    @Test
    void getAllReportDetailsByStatusIsInShouldWork() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where status in DEFAULT_STATUS or UPDATED_STATUS
        defaultReportDetailsShouldBeFound("status.in=" + DEFAULT_STATUS + "," + UPDATED_STATUS);

        // Get all the reportDetailsList where status equals to UPDATED_STATUS
        defaultReportDetailsShouldNotBeFound("status.in=" + UPDATED_STATUS);
    }

    @Test
    void getAllReportDetailsByStatusIsNullOrNotNull() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where status is not null
        defaultReportDetailsShouldBeFound("status.specified=true");

        // Get all the reportDetailsList where status is null
        defaultReportDetailsShouldNotBeFound("status.specified=false");
    }

    @Test
    void getAllReportDetailsByStatusContainsSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where status contains DEFAULT_STATUS
        defaultReportDetailsShouldBeFound("status.contains=" + DEFAULT_STATUS);

        // Get all the reportDetailsList where status contains UPDATED_STATUS
        defaultReportDetailsShouldNotBeFound("status.contains=" + UPDATED_STATUS);
    }

    @Test
    void getAllReportDetailsByStatusNotContainsSomething() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        // Get all the reportDetailsList where status does not contain DEFAULT_STATUS
        defaultReportDetailsShouldNotBeFound("status.doesNotContain=" + DEFAULT_STATUS);

        // Get all the reportDetailsList where status does not contain UPDATED_STATUS
        defaultReportDetailsShouldBeFound("status.doesNotContain=" + UPDATED_STATUS);
    }

    @Test
    void getAllReportDetailsByAppUserIsEqualToSomething() {
        AppUser appUser = AppUserResourceIT.createEntity(em);
        appUserRepository.save(appUser).block();
        Long appUserId = appUser.getId();
        reportDetails.setAppUserId(appUserId);
        reportDetailsRepository.save(reportDetails).block();
        // Get all the reportDetailsList where appUser equals to appUserId
        defaultReportDetailsShouldBeFound("appUserId.equals=" + appUserId);

        // Get all the reportDetailsList where appUser equals to (appUserId + 1)
        defaultReportDetailsShouldNotBeFound("appUserId.equals=" + (appUserId + 1));
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultReportDetailsShouldBeFound(String filter) {
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
            .value(hasItem(reportDetails.getId().intValue()))
            .jsonPath("$.[*].owner")
            .value(hasItem(DEFAULT_OWNER))
            .jsonPath("$.[*].responder")
            .value(hasItem(DEFAULT_RESPONDER))
            .jsonPath("$.[*].description")
            .value(hasItem(DEFAULT_DESCRIPTION))
            .jsonPath("$.[*].title")
            .value(hasItem(DEFAULT_TITLE))
            .jsonPath("$.[*].timestamp")
            .value(hasItem(sameInstant(DEFAULT_TIMESTAMP)))
            .jsonPath("$.[*].status")
            .value(hasItem(DEFAULT_STATUS))
            .jsonPath("$.[*].imageContentType")
            .value(hasItem(DEFAULT_IMAGE_CONTENT_TYPE))
            .jsonPath("$.[*].image")
            .value(hasItem(Base64.getEncoder().encodeToString(DEFAULT_IMAGE)))
            .jsonPath("$.[*].videoContentType")
            .value(hasItem(DEFAULT_VIDEO_CONTENT_TYPE))
            .jsonPath("$.[*].video")
            .value(hasItem(Base64.getEncoder().encodeToString(DEFAULT_VIDEO)))
            .jsonPath("$.[*].voiceDataContentType")
            .value(hasItem(DEFAULT_VOICE_DATA_CONTENT_TYPE))
            .jsonPath("$.[*].voiceData")
            .value(hasItem(Base64.getEncoder().encodeToString(DEFAULT_VOICE_DATA)))
            .jsonPath("$.[*].file1ContentType")
            .value(hasItem(DEFAULT_FILE_1_CONTENT_TYPE))
            .jsonPath("$.[*].file1")
            .value(hasItem(Base64.getEncoder().encodeToString(DEFAULT_FILE_1)))
            .jsonPath("$.[*].file2ContentType")
            .value(hasItem(DEFAULT_FILE_2_CONTENT_TYPE))
            .jsonPath("$.[*].file2")
            .value(hasItem(Base64.getEncoder().encodeToString(DEFAULT_FILE_2)))
            .jsonPath("$.[*].file3ContentType")
            .value(hasItem(DEFAULT_FILE_3_CONTENT_TYPE))
            .jsonPath("$.[*].file3")
            .value(hasItem(Base64.getEncoder().encodeToString(DEFAULT_FILE_3)));

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
    private void defaultReportDetailsShouldNotBeFound(String filter) {
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
    void getNonExistingReportDetails() {
        // Get the reportDetails
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_PROBLEM_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putExistingReportDetails() throws Exception {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        int databaseSizeBeforeUpdate = reportDetailsRepository.findAll().collectList().block().size();

        // Update the reportDetails
        ReportDetails updatedReportDetails = reportDetailsRepository.findById(reportDetails.getId()).block();
        updatedReportDetails
            .owner(UPDATED_OWNER)
            .responder(UPDATED_RESPONDER)
            .description(UPDATED_DESCRIPTION)
            .title(UPDATED_TITLE)
            .timestamp(UPDATED_TIMESTAMP)
            .status(UPDATED_STATUS)
            .image(UPDATED_IMAGE)
            .imageContentType(UPDATED_IMAGE_CONTENT_TYPE)
            .video(UPDATED_VIDEO)
            .videoContentType(UPDATED_VIDEO_CONTENT_TYPE)
            .voiceData(UPDATED_VOICE_DATA)
            .voiceDataContentType(UPDATED_VOICE_DATA_CONTENT_TYPE)
            .file1(UPDATED_FILE_1)
            .file1ContentType(UPDATED_FILE_1_CONTENT_TYPE)
            .file2(UPDATED_FILE_2)
            .file2ContentType(UPDATED_FILE_2_CONTENT_TYPE)
            .file3(UPDATED_FILE_3)
            .file3ContentType(UPDATED_FILE_3_CONTENT_TYPE);
        ReportDetailsDTO reportDetailsDTO = reportDetailsMapper.toDto(updatedReportDetails);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, reportDetailsDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(reportDetailsDTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the ReportDetails in the database
        List<ReportDetails> reportDetailsList = reportDetailsRepository.findAll().collectList().block();
        assertThat(reportDetailsList).hasSize(databaseSizeBeforeUpdate);
        ReportDetails testReportDetails = reportDetailsList.get(reportDetailsList.size() - 1);
        assertThat(testReportDetails.getOwner()).isEqualTo(UPDATED_OWNER);
        assertThat(testReportDetails.getResponder()).isEqualTo(UPDATED_RESPONDER);
        assertThat(testReportDetails.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testReportDetails.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testReportDetails.getTimestamp()).isEqualTo(UPDATED_TIMESTAMP);
        assertThat(testReportDetails.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testReportDetails.getImage()).isEqualTo(UPDATED_IMAGE);
        assertThat(testReportDetails.getImageContentType()).isEqualTo(UPDATED_IMAGE_CONTENT_TYPE);
        assertThat(testReportDetails.getVideo()).isEqualTo(UPDATED_VIDEO);
        assertThat(testReportDetails.getVideoContentType()).isEqualTo(UPDATED_VIDEO_CONTENT_TYPE);
        assertThat(testReportDetails.getVoiceData()).isEqualTo(UPDATED_VOICE_DATA);
        assertThat(testReportDetails.getVoiceDataContentType()).isEqualTo(UPDATED_VOICE_DATA_CONTENT_TYPE);
        assertThat(testReportDetails.getFile1()).isEqualTo(UPDATED_FILE_1);
        assertThat(testReportDetails.getFile1ContentType()).isEqualTo(UPDATED_FILE_1_CONTENT_TYPE);
        assertThat(testReportDetails.getFile2()).isEqualTo(UPDATED_FILE_2);
        assertThat(testReportDetails.getFile2ContentType()).isEqualTo(UPDATED_FILE_2_CONTENT_TYPE);
        assertThat(testReportDetails.getFile3()).isEqualTo(UPDATED_FILE_3);
        assertThat(testReportDetails.getFile3ContentType()).isEqualTo(UPDATED_FILE_3_CONTENT_TYPE);
    }

    @Test
    void putNonExistingReportDetails() throws Exception {
        int databaseSizeBeforeUpdate = reportDetailsRepository.findAll().collectList().block().size();
        reportDetails.setId(longCount.incrementAndGet());

        // Create the ReportDetails
        ReportDetailsDTO reportDetailsDTO = reportDetailsMapper.toDto(reportDetails);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, reportDetailsDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(reportDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the ReportDetails in the database
        List<ReportDetails> reportDetailsList = reportDetailsRepository.findAll().collectList().block();
        assertThat(reportDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchReportDetails() throws Exception {
        int databaseSizeBeforeUpdate = reportDetailsRepository.findAll().collectList().block().size();
        reportDetails.setId(longCount.incrementAndGet());

        // Create the ReportDetails
        ReportDetailsDTO reportDetailsDTO = reportDetailsMapper.toDto(reportDetails);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, longCount.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(reportDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the ReportDetails in the database
        List<ReportDetails> reportDetailsList = reportDetailsRepository.findAll().collectList().block();
        assertThat(reportDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamReportDetails() throws Exception {
        int databaseSizeBeforeUpdate = reportDetailsRepository.findAll().collectList().block().size();
        reportDetails.setId(longCount.incrementAndGet());

        // Create the ReportDetails
        ReportDetailsDTO reportDetailsDTO = reportDetailsMapper.toDto(reportDetails);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(reportDetailsDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the ReportDetails in the database
        List<ReportDetails> reportDetailsList = reportDetailsRepository.findAll().collectList().block();
        assertThat(reportDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateReportDetailsWithPatch() throws Exception {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        int databaseSizeBeforeUpdate = reportDetailsRepository.findAll().collectList().block().size();

        // Update the reportDetails using partial update
        ReportDetails partialUpdatedReportDetails = new ReportDetails();
        partialUpdatedReportDetails.setId(reportDetails.getId());

        partialUpdatedReportDetails
            .owner(UPDATED_OWNER)
            .responder(UPDATED_RESPONDER)
            .description(UPDATED_DESCRIPTION)
            .title(UPDATED_TITLE)
            .status(UPDATED_STATUS)
            .video(UPDATED_VIDEO)
            .videoContentType(UPDATED_VIDEO_CONTENT_TYPE)
            .voiceData(UPDATED_VOICE_DATA)
            .voiceDataContentType(UPDATED_VOICE_DATA_CONTENT_TYPE)
            .file3(UPDATED_FILE_3)
            .file3ContentType(UPDATED_FILE_3_CONTENT_TYPE);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedReportDetails.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedReportDetails))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the ReportDetails in the database
        List<ReportDetails> reportDetailsList = reportDetailsRepository.findAll().collectList().block();
        assertThat(reportDetailsList).hasSize(databaseSizeBeforeUpdate);
        ReportDetails testReportDetails = reportDetailsList.get(reportDetailsList.size() - 1);
        assertThat(testReportDetails.getOwner()).isEqualTo(UPDATED_OWNER);
        assertThat(testReportDetails.getResponder()).isEqualTo(UPDATED_RESPONDER);
        assertThat(testReportDetails.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testReportDetails.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testReportDetails.getTimestamp()).isEqualTo(DEFAULT_TIMESTAMP);
        assertThat(testReportDetails.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testReportDetails.getImage()).isEqualTo(DEFAULT_IMAGE);
        assertThat(testReportDetails.getImageContentType()).isEqualTo(DEFAULT_IMAGE_CONTENT_TYPE);
        assertThat(testReportDetails.getVideo()).isEqualTo(UPDATED_VIDEO);
        assertThat(testReportDetails.getVideoContentType()).isEqualTo(UPDATED_VIDEO_CONTENT_TYPE);
        assertThat(testReportDetails.getVoiceData()).isEqualTo(UPDATED_VOICE_DATA);
        assertThat(testReportDetails.getVoiceDataContentType()).isEqualTo(UPDATED_VOICE_DATA_CONTENT_TYPE);
        assertThat(testReportDetails.getFile1()).isEqualTo(DEFAULT_FILE_1);
        assertThat(testReportDetails.getFile1ContentType()).isEqualTo(DEFAULT_FILE_1_CONTENT_TYPE);
        assertThat(testReportDetails.getFile2()).isEqualTo(DEFAULT_FILE_2);
        assertThat(testReportDetails.getFile2ContentType()).isEqualTo(DEFAULT_FILE_2_CONTENT_TYPE);
        assertThat(testReportDetails.getFile3()).isEqualTo(UPDATED_FILE_3);
        assertThat(testReportDetails.getFile3ContentType()).isEqualTo(UPDATED_FILE_3_CONTENT_TYPE);
    }

    @Test
    void fullUpdateReportDetailsWithPatch() throws Exception {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        int databaseSizeBeforeUpdate = reportDetailsRepository.findAll().collectList().block().size();

        // Update the reportDetails using partial update
        ReportDetails partialUpdatedReportDetails = new ReportDetails();
        partialUpdatedReportDetails.setId(reportDetails.getId());

        partialUpdatedReportDetails
            .owner(UPDATED_OWNER)
            .responder(UPDATED_RESPONDER)
            .description(UPDATED_DESCRIPTION)
            .title(UPDATED_TITLE)
            .timestamp(UPDATED_TIMESTAMP)
            .status(UPDATED_STATUS)
            .image(UPDATED_IMAGE)
            .imageContentType(UPDATED_IMAGE_CONTENT_TYPE)
            .video(UPDATED_VIDEO)
            .videoContentType(UPDATED_VIDEO_CONTENT_TYPE)
            .voiceData(UPDATED_VOICE_DATA)
            .voiceDataContentType(UPDATED_VOICE_DATA_CONTENT_TYPE)
            .file1(UPDATED_FILE_1)
            .file1ContentType(UPDATED_FILE_1_CONTENT_TYPE)
            .file2(UPDATED_FILE_2)
            .file2ContentType(UPDATED_FILE_2_CONTENT_TYPE)
            .file3(UPDATED_FILE_3)
            .file3ContentType(UPDATED_FILE_3_CONTENT_TYPE);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedReportDetails.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedReportDetails))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the ReportDetails in the database
        List<ReportDetails> reportDetailsList = reportDetailsRepository.findAll().collectList().block();
        assertThat(reportDetailsList).hasSize(databaseSizeBeforeUpdate);
        ReportDetails testReportDetails = reportDetailsList.get(reportDetailsList.size() - 1);
        assertThat(testReportDetails.getOwner()).isEqualTo(UPDATED_OWNER);
        assertThat(testReportDetails.getResponder()).isEqualTo(UPDATED_RESPONDER);
        assertThat(testReportDetails.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testReportDetails.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testReportDetails.getTimestamp()).isEqualTo(UPDATED_TIMESTAMP);
        assertThat(testReportDetails.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testReportDetails.getImage()).isEqualTo(UPDATED_IMAGE);
        assertThat(testReportDetails.getImageContentType()).isEqualTo(UPDATED_IMAGE_CONTENT_TYPE);
        assertThat(testReportDetails.getVideo()).isEqualTo(UPDATED_VIDEO);
        assertThat(testReportDetails.getVideoContentType()).isEqualTo(UPDATED_VIDEO_CONTENT_TYPE);
        assertThat(testReportDetails.getVoiceData()).isEqualTo(UPDATED_VOICE_DATA);
        assertThat(testReportDetails.getVoiceDataContentType()).isEqualTo(UPDATED_VOICE_DATA_CONTENT_TYPE);
        assertThat(testReportDetails.getFile1()).isEqualTo(UPDATED_FILE_1);
        assertThat(testReportDetails.getFile1ContentType()).isEqualTo(UPDATED_FILE_1_CONTENT_TYPE);
        assertThat(testReportDetails.getFile2()).isEqualTo(UPDATED_FILE_2);
        assertThat(testReportDetails.getFile2ContentType()).isEqualTo(UPDATED_FILE_2_CONTENT_TYPE);
        assertThat(testReportDetails.getFile3()).isEqualTo(UPDATED_FILE_3);
        assertThat(testReportDetails.getFile3ContentType()).isEqualTo(UPDATED_FILE_3_CONTENT_TYPE);
    }

    @Test
    void patchNonExistingReportDetails() throws Exception {
        int databaseSizeBeforeUpdate = reportDetailsRepository.findAll().collectList().block().size();
        reportDetails.setId(longCount.incrementAndGet());

        // Create the ReportDetails
        ReportDetailsDTO reportDetailsDTO = reportDetailsMapper.toDto(reportDetails);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, reportDetailsDTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(reportDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the ReportDetails in the database
        List<ReportDetails> reportDetailsList = reportDetailsRepository.findAll().collectList().block();
        assertThat(reportDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchReportDetails() throws Exception {
        int databaseSizeBeforeUpdate = reportDetailsRepository.findAll().collectList().block().size();
        reportDetails.setId(longCount.incrementAndGet());

        // Create the ReportDetails
        ReportDetailsDTO reportDetailsDTO = reportDetailsMapper.toDto(reportDetails);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, longCount.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(reportDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the ReportDetails in the database
        List<ReportDetails> reportDetailsList = reportDetailsRepository.findAll().collectList().block();
        assertThat(reportDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamReportDetails() throws Exception {
        int databaseSizeBeforeUpdate = reportDetailsRepository.findAll().collectList().block().size();
        reportDetails.setId(longCount.incrementAndGet());

        // Create the ReportDetails
        ReportDetailsDTO reportDetailsDTO = reportDetailsMapper.toDto(reportDetails);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(reportDetailsDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the ReportDetails in the database
        List<ReportDetails> reportDetailsList = reportDetailsRepository.findAll().collectList().block();
        assertThat(reportDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteReportDetails() {
        // Initialize the database
        reportDetailsRepository.save(reportDetails).block();

        int databaseSizeBeforeDelete = reportDetailsRepository.findAll().collectList().block().size();

        // Delete the reportDetails
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, reportDetails.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<ReportDetails> reportDetailsList = reportDetailsRepository.findAll().collectList().block();
        assertThat(reportDetailsList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
