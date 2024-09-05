package com.govguardian.app.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import com.govguardian.app.IntegrationTest;
import com.govguardian.app.domain.AppUser;
import com.govguardian.app.domain.GovOfficialContent;
import com.govguardian.app.domain.Review;
import com.govguardian.app.domain.Reward;
import com.govguardian.app.domain.User;
import com.govguardian.app.domain.enumeration.UserType;
import com.govguardian.app.repository.AppUserRepository;
import com.govguardian.app.repository.EntityManager;
import com.govguardian.app.repository.GovOfficialContentRepository;
import com.govguardian.app.repository.ReviewRepository;
import com.govguardian.app.repository.RewardRepository;
import com.govguardian.app.repository.UserRepository;
import com.govguardian.app.service.dto.AppUserDTO;
import com.govguardian.app.service.mapper.AppUserMapper;
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
 * Integration tests for the {@link AppUserResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class AppUserResourceIT {

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE = "4610556106";
    private static final String UPDATED_PHONE = "5086695572";

    private static final String DEFAULT_GENDER = "AAAAAAAAAA";
    private static final String UPDATED_GENDER = "BBBBBBBBBB";

    private static final String DEFAULT_DEPARTMENT = "AAAAAAAAAA";
    private static final String UPDATED_DEPARTMENT = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final Double DEFAULT_LATITUDE = 1D;
    private static final Double UPDATED_LATITUDE = 2D;
    private static final Double SMALLER_LATITUDE = 1D - 1D;

    private static final Double DEFAULT_LONGITUDE = 1D;
    private static final Double UPDATED_LONGITUDE = 2D;
    private static final Double SMALLER_LONGITUDE = 1D - 1D;

    private static final UserType DEFAULT_USER_TYPE = UserType.USER;
    private static final UserType UPDATED_USER_TYPE = UserType.COMMUNITY_MEMBER;

    private static final String ENTITY_API_URL = "/api/app-users";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppUserMapper appUserMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private AppUser appUser;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private RewardRepository rewardRepository;

    @Autowired
    private GovOfficialContentRepository govOfficialContentRepository;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AppUser createEntity(EntityManager em) {
        AppUser appUser = new AppUser()
            .email(DEFAULT_EMAIL)
            .address(DEFAULT_ADDRESS)
            .phone(DEFAULT_PHONE)
            .gender(DEFAULT_GENDER)
            .department(DEFAULT_DEPARTMENT)
            .description(DEFAULT_DESCRIPTION)
            .latitude(DEFAULT_LATITUDE)
            .longitude(DEFAULT_LONGITUDE)
            .userType(DEFAULT_USER_TYPE);
        return appUser;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AppUser createUpdatedEntity(EntityManager em) {
        AppUser appUser = new AppUser()
            .email(UPDATED_EMAIL)
            .address(UPDATED_ADDRESS)
            .phone(UPDATED_PHONE)
            .gender(UPDATED_GENDER)
            .department(UPDATED_DEPARTMENT)
            .description(UPDATED_DESCRIPTION)
            .latitude(UPDATED_LATITUDE)
            .longitude(UPDATED_LONGITUDE)
            .userType(UPDATED_USER_TYPE);
        return appUser;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(AppUser.class).block();
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
        appUser = createEntity(em);
    }

    @Test
    void createAppUser() throws Exception {
        int databaseSizeBeforeCreate = appUserRepository.findAll().collectList().block().size();
        // Create the AppUser
        AppUserDTO appUserDTO = appUserMapper.toDto(appUser);
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(appUserDTO))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the AppUser in the database
        List<AppUser> appUserList = appUserRepository.findAll().collectList().block();
        assertThat(appUserList).hasSize(databaseSizeBeforeCreate + 1);
        AppUser testAppUser = appUserList.get(appUserList.size() - 1);
        assertThat(testAppUser.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testAppUser.getAddress()).isEqualTo(DEFAULT_ADDRESS);
        assertThat(testAppUser.getPhone()).isEqualTo(DEFAULT_PHONE);
        assertThat(testAppUser.getGender()).isEqualTo(DEFAULT_GENDER);
        assertThat(testAppUser.getDepartment()).isEqualTo(DEFAULT_DEPARTMENT);
        assertThat(testAppUser.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testAppUser.getLatitude()).isEqualTo(DEFAULT_LATITUDE);
        assertThat(testAppUser.getLongitude()).isEqualTo(DEFAULT_LONGITUDE);
        assertThat(testAppUser.getUserType()).isEqualTo(DEFAULT_USER_TYPE);
    }

    @Test
    void createAppUserWithExistingId() throws Exception {
        // Create the AppUser with an existing ID
        appUser.setId(1L);
        AppUserDTO appUserDTO = appUserMapper.toDto(appUser);

        int databaseSizeBeforeCreate = appUserRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(appUserDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the AppUser in the database
        List<AppUser> appUserList = appUserRepository.findAll().collectList().block();
        assertThat(appUserList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllAppUsers() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList
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
            .value(hasItem(appUser.getId().intValue()))
            .jsonPath("$.[*].email")
            .value(hasItem(DEFAULT_EMAIL))
            .jsonPath("$.[*].address")
            .value(hasItem(DEFAULT_ADDRESS))
            .jsonPath("$.[*].phone")
            .value(hasItem(DEFAULT_PHONE))
            .jsonPath("$.[*].gender")
            .value(hasItem(DEFAULT_GENDER))
            .jsonPath("$.[*].department")
            .value(hasItem(DEFAULT_DEPARTMENT))
            .jsonPath("$.[*].description")
            .value(hasItem(DEFAULT_DESCRIPTION))
            .jsonPath("$.[*].latitude")
            .value(hasItem(DEFAULT_LATITUDE.doubleValue()))
            .jsonPath("$.[*].longitude")
            .value(hasItem(DEFAULT_LONGITUDE.doubleValue()))
            .jsonPath("$.[*].userType")
            .value(hasItem(DEFAULT_USER_TYPE.toString()));
    }

    @Test
    void getAppUser() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get the appUser
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, appUser.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(appUser.getId().intValue()))
            .jsonPath("$.email")
            .value(is(DEFAULT_EMAIL))
            .jsonPath("$.address")
            .value(is(DEFAULT_ADDRESS))
            .jsonPath("$.phone")
            .value(is(DEFAULT_PHONE))
            .jsonPath("$.gender")
            .value(is(DEFAULT_GENDER))
            .jsonPath("$.department")
            .value(is(DEFAULT_DEPARTMENT))
            .jsonPath("$.description")
            .value(is(DEFAULT_DESCRIPTION))
            .jsonPath("$.latitude")
            .value(is(DEFAULT_LATITUDE.doubleValue()))
            .jsonPath("$.longitude")
            .value(is(DEFAULT_LONGITUDE.doubleValue()))
            .jsonPath("$.userType")
            .value(is(DEFAULT_USER_TYPE.toString()));
    }

    @Test
    void getAppUsersByIdFiltering() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        Long id = appUser.getId();

        defaultAppUserShouldBeFound("id.equals=" + id);
        defaultAppUserShouldNotBeFound("id.notEquals=" + id);

        defaultAppUserShouldBeFound("id.greaterThanOrEqual=" + id);
        defaultAppUserShouldNotBeFound("id.greaterThan=" + id);

        defaultAppUserShouldBeFound("id.lessThanOrEqual=" + id);
        defaultAppUserShouldNotBeFound("id.lessThan=" + id);
    }

    @Test
    void getAllAppUsersByEmailIsEqualToSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where email equals to DEFAULT_EMAIL
        defaultAppUserShouldBeFound("email.equals=" + DEFAULT_EMAIL);

        // Get all the appUserList where email equals to UPDATED_EMAIL
        defaultAppUserShouldNotBeFound("email.equals=" + UPDATED_EMAIL);
    }

    @Test
    void getAllAppUsersByEmailIsInShouldWork() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where email in DEFAULT_EMAIL or UPDATED_EMAIL
        defaultAppUserShouldBeFound("email.in=" + DEFAULT_EMAIL + "," + UPDATED_EMAIL);

        // Get all the appUserList where email equals to UPDATED_EMAIL
        defaultAppUserShouldNotBeFound("email.in=" + UPDATED_EMAIL);
    }

    @Test
    void getAllAppUsersByEmailIsNullOrNotNull() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where email is not null
        defaultAppUserShouldBeFound("email.specified=true");

        // Get all the appUserList where email is null
        defaultAppUserShouldNotBeFound("email.specified=false");
    }

    @Test
    void getAllAppUsersByEmailContainsSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where email contains DEFAULT_EMAIL
        defaultAppUserShouldBeFound("email.contains=" + DEFAULT_EMAIL);

        // Get all the appUserList where email contains UPDATED_EMAIL
        defaultAppUserShouldNotBeFound("email.contains=" + UPDATED_EMAIL);
    }

    @Test
    void getAllAppUsersByEmailNotContainsSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where email does not contain DEFAULT_EMAIL
        defaultAppUserShouldNotBeFound("email.doesNotContain=" + DEFAULT_EMAIL);

        // Get all the appUserList where email does not contain UPDATED_EMAIL
        defaultAppUserShouldBeFound("email.doesNotContain=" + UPDATED_EMAIL);
    }

    @Test
    void getAllAppUsersByAddressIsEqualToSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where address equals to DEFAULT_ADDRESS
        defaultAppUserShouldBeFound("address.equals=" + DEFAULT_ADDRESS);

        // Get all the appUserList where address equals to UPDATED_ADDRESS
        defaultAppUserShouldNotBeFound("address.equals=" + UPDATED_ADDRESS);
    }

    @Test
    void getAllAppUsersByAddressIsInShouldWork() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where address in DEFAULT_ADDRESS or UPDATED_ADDRESS
        defaultAppUserShouldBeFound("address.in=" + DEFAULT_ADDRESS + "," + UPDATED_ADDRESS);

        // Get all the appUserList where address equals to UPDATED_ADDRESS
        defaultAppUserShouldNotBeFound("address.in=" + UPDATED_ADDRESS);
    }

    @Test
    void getAllAppUsersByAddressIsNullOrNotNull() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where address is not null
        defaultAppUserShouldBeFound("address.specified=true");

        // Get all the appUserList where address is null
        defaultAppUserShouldNotBeFound("address.specified=false");
    }

    @Test
    void getAllAppUsersByAddressContainsSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where address contains DEFAULT_ADDRESS
        defaultAppUserShouldBeFound("address.contains=" + DEFAULT_ADDRESS);

        // Get all the appUserList where address contains UPDATED_ADDRESS
        defaultAppUserShouldNotBeFound("address.contains=" + UPDATED_ADDRESS);
    }

    @Test
    void getAllAppUsersByAddressNotContainsSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where address does not contain DEFAULT_ADDRESS
        defaultAppUserShouldNotBeFound("address.doesNotContain=" + DEFAULT_ADDRESS);

        // Get all the appUserList where address does not contain UPDATED_ADDRESS
        defaultAppUserShouldBeFound("address.doesNotContain=" + UPDATED_ADDRESS);
    }

    @Test
    void getAllAppUsersByPhoneIsEqualToSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where phone equals to DEFAULT_PHONE
        defaultAppUserShouldBeFound("phone.equals=" + DEFAULT_PHONE);

        // Get all the appUserList where phone equals to UPDATED_PHONE
        defaultAppUserShouldNotBeFound("phone.equals=" + UPDATED_PHONE);
    }

    @Test
    void getAllAppUsersByPhoneIsInShouldWork() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where phone in DEFAULT_PHONE or UPDATED_PHONE
        defaultAppUserShouldBeFound("phone.in=" + DEFAULT_PHONE + "," + UPDATED_PHONE);

        // Get all the appUserList where phone equals to UPDATED_PHONE
        defaultAppUserShouldNotBeFound("phone.in=" + UPDATED_PHONE);
    }

    @Test
    void getAllAppUsersByPhoneIsNullOrNotNull() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where phone is not null
        defaultAppUserShouldBeFound("phone.specified=true");

        // Get all the appUserList where phone is null
        defaultAppUserShouldNotBeFound("phone.specified=false");
    }

    @Test
    void getAllAppUsersByPhoneContainsSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where phone contains DEFAULT_PHONE
        defaultAppUserShouldBeFound("phone.contains=" + DEFAULT_PHONE);

        // Get all the appUserList where phone contains UPDATED_PHONE
        defaultAppUserShouldNotBeFound("phone.contains=" + UPDATED_PHONE);
    }

    @Test
    void getAllAppUsersByPhoneNotContainsSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where phone does not contain DEFAULT_PHONE
        defaultAppUserShouldNotBeFound("phone.doesNotContain=" + DEFAULT_PHONE);

        // Get all the appUserList where phone does not contain UPDATED_PHONE
        defaultAppUserShouldBeFound("phone.doesNotContain=" + UPDATED_PHONE);
    }

    @Test
    void getAllAppUsersByGenderIsEqualToSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where gender equals to DEFAULT_GENDER
        defaultAppUserShouldBeFound("gender.equals=" + DEFAULT_GENDER);

        // Get all the appUserList where gender equals to UPDATED_GENDER
        defaultAppUserShouldNotBeFound("gender.equals=" + UPDATED_GENDER);
    }

    @Test
    void getAllAppUsersByGenderIsInShouldWork() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where gender in DEFAULT_GENDER or UPDATED_GENDER
        defaultAppUserShouldBeFound("gender.in=" + DEFAULT_GENDER + "," + UPDATED_GENDER);

        // Get all the appUserList where gender equals to UPDATED_GENDER
        defaultAppUserShouldNotBeFound("gender.in=" + UPDATED_GENDER);
    }

    @Test
    void getAllAppUsersByGenderIsNullOrNotNull() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where gender is not null
        defaultAppUserShouldBeFound("gender.specified=true");

        // Get all the appUserList where gender is null
        defaultAppUserShouldNotBeFound("gender.specified=false");
    }

    @Test
    void getAllAppUsersByGenderContainsSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where gender contains DEFAULT_GENDER
        defaultAppUserShouldBeFound("gender.contains=" + DEFAULT_GENDER);

        // Get all the appUserList where gender contains UPDATED_GENDER
        defaultAppUserShouldNotBeFound("gender.contains=" + UPDATED_GENDER);
    }

    @Test
    void getAllAppUsersByGenderNotContainsSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where gender does not contain DEFAULT_GENDER
        defaultAppUserShouldNotBeFound("gender.doesNotContain=" + DEFAULT_GENDER);

        // Get all the appUserList where gender does not contain UPDATED_GENDER
        defaultAppUserShouldBeFound("gender.doesNotContain=" + UPDATED_GENDER);
    }

    @Test
    void getAllAppUsersByDepartmentIsEqualToSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where department equals to DEFAULT_DEPARTMENT
        defaultAppUserShouldBeFound("department.equals=" + DEFAULT_DEPARTMENT);

        // Get all the appUserList where department equals to UPDATED_DEPARTMENT
        defaultAppUserShouldNotBeFound("department.equals=" + UPDATED_DEPARTMENT);
    }

    @Test
    void getAllAppUsersByDepartmentIsInShouldWork() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where department in DEFAULT_DEPARTMENT or UPDATED_DEPARTMENT
        defaultAppUserShouldBeFound("department.in=" + DEFAULT_DEPARTMENT + "," + UPDATED_DEPARTMENT);

        // Get all the appUserList where department equals to UPDATED_DEPARTMENT
        defaultAppUserShouldNotBeFound("department.in=" + UPDATED_DEPARTMENT);
    }

    @Test
    void getAllAppUsersByDepartmentIsNullOrNotNull() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where department is not null
        defaultAppUserShouldBeFound("department.specified=true");

        // Get all the appUserList where department is null
        defaultAppUserShouldNotBeFound("department.specified=false");
    }

    @Test
    void getAllAppUsersByDepartmentContainsSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where department contains DEFAULT_DEPARTMENT
        defaultAppUserShouldBeFound("department.contains=" + DEFAULT_DEPARTMENT);

        // Get all the appUserList where department contains UPDATED_DEPARTMENT
        defaultAppUserShouldNotBeFound("department.contains=" + UPDATED_DEPARTMENT);
    }

    @Test
    void getAllAppUsersByDepartmentNotContainsSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where department does not contain DEFAULT_DEPARTMENT
        defaultAppUserShouldNotBeFound("department.doesNotContain=" + DEFAULT_DEPARTMENT);

        // Get all the appUserList where department does not contain UPDATED_DEPARTMENT
        defaultAppUserShouldBeFound("department.doesNotContain=" + UPDATED_DEPARTMENT);
    }

    @Test
    void getAllAppUsersByDescriptionIsEqualToSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where description equals to DEFAULT_DESCRIPTION
        defaultAppUserShouldBeFound("description.equals=" + DEFAULT_DESCRIPTION);

        // Get all the appUserList where description equals to UPDATED_DESCRIPTION
        defaultAppUserShouldNotBeFound("description.equals=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllAppUsersByDescriptionIsInShouldWork() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where description in DEFAULT_DESCRIPTION or UPDATED_DESCRIPTION
        defaultAppUserShouldBeFound("description.in=" + DEFAULT_DESCRIPTION + "," + UPDATED_DESCRIPTION);

        // Get all the appUserList where description equals to UPDATED_DESCRIPTION
        defaultAppUserShouldNotBeFound("description.in=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllAppUsersByDescriptionIsNullOrNotNull() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where description is not null
        defaultAppUserShouldBeFound("description.specified=true");

        // Get all the appUserList where description is null
        defaultAppUserShouldNotBeFound("description.specified=false");
    }

    @Test
    void getAllAppUsersByDescriptionContainsSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where description contains DEFAULT_DESCRIPTION
        defaultAppUserShouldBeFound("description.contains=" + DEFAULT_DESCRIPTION);

        // Get all the appUserList where description contains UPDATED_DESCRIPTION
        defaultAppUserShouldNotBeFound("description.contains=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllAppUsersByDescriptionNotContainsSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where description does not contain DEFAULT_DESCRIPTION
        defaultAppUserShouldNotBeFound("description.doesNotContain=" + DEFAULT_DESCRIPTION);

        // Get all the appUserList where description does not contain UPDATED_DESCRIPTION
        defaultAppUserShouldBeFound("description.doesNotContain=" + UPDATED_DESCRIPTION);
    }

    @Test
    void getAllAppUsersByLatitudeIsEqualToSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where latitude equals to DEFAULT_LATITUDE
        defaultAppUserShouldBeFound("latitude.equals=" + DEFAULT_LATITUDE);

        // Get all the appUserList where latitude equals to UPDATED_LATITUDE
        defaultAppUserShouldNotBeFound("latitude.equals=" + UPDATED_LATITUDE);
    }

    @Test
    void getAllAppUsersByLatitudeIsInShouldWork() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where latitude in DEFAULT_LATITUDE or UPDATED_LATITUDE
        defaultAppUserShouldBeFound("latitude.in=" + DEFAULT_LATITUDE + "," + UPDATED_LATITUDE);

        // Get all the appUserList where latitude equals to UPDATED_LATITUDE
        defaultAppUserShouldNotBeFound("latitude.in=" + UPDATED_LATITUDE);
    }

    @Test
    void getAllAppUsersByLatitudeIsNullOrNotNull() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where latitude is not null
        defaultAppUserShouldBeFound("latitude.specified=true");

        // Get all the appUserList where latitude is null
        defaultAppUserShouldNotBeFound("latitude.specified=false");
    }

    @Test
    void getAllAppUsersByLatitudeIsGreaterThanOrEqualToSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where latitude is greater than or equal to DEFAULT_LATITUDE
        defaultAppUserShouldBeFound("latitude.greaterThanOrEqual=" + DEFAULT_LATITUDE);

        // Get all the appUserList where latitude is greater than or equal to UPDATED_LATITUDE
        defaultAppUserShouldNotBeFound("latitude.greaterThanOrEqual=" + UPDATED_LATITUDE);
    }

    @Test
    void getAllAppUsersByLatitudeIsLessThanOrEqualToSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where latitude is less than or equal to DEFAULT_LATITUDE
        defaultAppUserShouldBeFound("latitude.lessThanOrEqual=" + DEFAULT_LATITUDE);

        // Get all the appUserList where latitude is less than or equal to SMALLER_LATITUDE
        defaultAppUserShouldNotBeFound("latitude.lessThanOrEqual=" + SMALLER_LATITUDE);
    }

    @Test
    void getAllAppUsersByLatitudeIsLessThanSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where latitude is less than DEFAULT_LATITUDE
        defaultAppUserShouldNotBeFound("latitude.lessThan=" + DEFAULT_LATITUDE);

        // Get all the appUserList where latitude is less than UPDATED_LATITUDE
        defaultAppUserShouldBeFound("latitude.lessThan=" + UPDATED_LATITUDE);
    }

    @Test
    void getAllAppUsersByLatitudeIsGreaterThanSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where latitude is greater than DEFAULT_LATITUDE
        defaultAppUserShouldNotBeFound("latitude.greaterThan=" + DEFAULT_LATITUDE);

        // Get all the appUserList where latitude is greater than SMALLER_LATITUDE
        defaultAppUserShouldBeFound("latitude.greaterThan=" + SMALLER_LATITUDE);
    }

    @Test
    void getAllAppUsersByLongitudeIsEqualToSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where longitude equals to DEFAULT_LONGITUDE
        defaultAppUserShouldBeFound("longitude.equals=" + DEFAULT_LONGITUDE);

        // Get all the appUserList where longitude equals to UPDATED_LONGITUDE
        defaultAppUserShouldNotBeFound("longitude.equals=" + UPDATED_LONGITUDE);
    }

    @Test
    void getAllAppUsersByLongitudeIsInShouldWork() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where longitude in DEFAULT_LONGITUDE or UPDATED_LONGITUDE
        defaultAppUserShouldBeFound("longitude.in=" + DEFAULT_LONGITUDE + "," + UPDATED_LONGITUDE);

        // Get all the appUserList where longitude equals to UPDATED_LONGITUDE
        defaultAppUserShouldNotBeFound("longitude.in=" + UPDATED_LONGITUDE);
    }

    @Test
    void getAllAppUsersByLongitudeIsNullOrNotNull() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where longitude is not null
        defaultAppUserShouldBeFound("longitude.specified=true");

        // Get all the appUserList where longitude is null
        defaultAppUserShouldNotBeFound("longitude.specified=false");
    }

    @Test
    void getAllAppUsersByLongitudeIsGreaterThanOrEqualToSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where longitude is greater than or equal to DEFAULT_LONGITUDE
        defaultAppUserShouldBeFound("longitude.greaterThanOrEqual=" + DEFAULT_LONGITUDE);

        // Get all the appUserList where longitude is greater than or equal to UPDATED_LONGITUDE
        defaultAppUserShouldNotBeFound("longitude.greaterThanOrEqual=" + UPDATED_LONGITUDE);
    }

    @Test
    void getAllAppUsersByLongitudeIsLessThanOrEqualToSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where longitude is less than or equal to DEFAULT_LONGITUDE
        defaultAppUserShouldBeFound("longitude.lessThanOrEqual=" + DEFAULT_LONGITUDE);

        // Get all the appUserList where longitude is less than or equal to SMALLER_LONGITUDE
        defaultAppUserShouldNotBeFound("longitude.lessThanOrEqual=" + SMALLER_LONGITUDE);
    }

    @Test
    void getAllAppUsersByLongitudeIsLessThanSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where longitude is less than DEFAULT_LONGITUDE
        defaultAppUserShouldNotBeFound("longitude.lessThan=" + DEFAULT_LONGITUDE);

        // Get all the appUserList where longitude is less than UPDATED_LONGITUDE
        defaultAppUserShouldBeFound("longitude.lessThan=" + UPDATED_LONGITUDE);
    }

    @Test
    void getAllAppUsersByLongitudeIsGreaterThanSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where longitude is greater than DEFAULT_LONGITUDE
        defaultAppUserShouldNotBeFound("longitude.greaterThan=" + DEFAULT_LONGITUDE);

        // Get all the appUserList where longitude is greater than SMALLER_LONGITUDE
        defaultAppUserShouldBeFound("longitude.greaterThan=" + SMALLER_LONGITUDE);
    }

    @Test
    void getAllAppUsersByUserTypeIsEqualToSomething() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where userType equals to DEFAULT_USER_TYPE
        defaultAppUserShouldBeFound("userType.equals=" + DEFAULT_USER_TYPE);

        // Get all the appUserList where userType equals to UPDATED_USER_TYPE
        defaultAppUserShouldNotBeFound("userType.equals=" + UPDATED_USER_TYPE);
    }

    @Test
    void getAllAppUsersByUserTypeIsInShouldWork() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where userType in DEFAULT_USER_TYPE or UPDATED_USER_TYPE
        defaultAppUserShouldBeFound("userType.in=" + DEFAULT_USER_TYPE + "," + UPDATED_USER_TYPE);

        // Get all the appUserList where userType equals to UPDATED_USER_TYPE
        defaultAppUserShouldNotBeFound("userType.in=" + UPDATED_USER_TYPE);
    }

    @Test
    void getAllAppUsersByUserTypeIsNullOrNotNull() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        // Get all the appUserList where userType is not null
        defaultAppUserShouldBeFound("userType.specified=true");

        // Get all the appUserList where userType is null
        defaultAppUserShouldNotBeFound("userType.specified=false");
    }

    @Test
    void getAllAppUsersByUserIsEqualToSomething() {
        User user = UserResourceIT.createEntity(em);
        userRepository.save(user).block();
        Long userId = user.getId();
        appUser.setUserId(userId);
        appUserRepository.save(appUser).block();
        // Get all the appUserList where user equals to userId
        defaultAppUserShouldBeFound("userId.equals=" + userId);

        // Get all the appUserList where user equals to (userId + 1)
        defaultAppUserShouldNotBeFound("userId.equals=" + (userId + 1));
    }

    @Test
    void getAllAppUsersByReviewsIsEqualToSomething() {
        Review reviews = ReviewResourceIT.createEntity(em);
        reviewRepository.save(reviews).block();
        Long reviewsId = reviews.getId();
        appUser.setReviewsId(reviewsId);
        appUserRepository.save(appUser).block();
        // Get all the appUserList where reviews equals to reviewsId
        defaultAppUserShouldBeFound("reviewsId.equals=" + reviewsId);

        // Get all the appUserList where reviews equals to (reviewsId + 1)
        defaultAppUserShouldNotBeFound("reviewsId.equals=" + (reviewsId + 1));
    }

    @Test
    void getAllAppUsersByRewardsIsEqualToSomething() {
        Reward rewards = RewardResourceIT.createEntity(em);
        rewardRepository.save(rewards).block();
        Long rewardsId = rewards.getId();
        appUser.setRewardsId(rewardsId);
        appUserRepository.save(appUser).block();
        // Get all the appUserList where rewards equals to rewardsId
        defaultAppUserShouldBeFound("rewardsId.equals=" + rewardsId);

        // Get all the appUserList where rewards equals to (rewardsId + 1)
        defaultAppUserShouldNotBeFound("rewardsId.equals=" + (rewardsId + 1));
    }

    @Test
    void getAllAppUsersByGovOfficialContentIsEqualToSomething() {
        GovOfficialContent govOfficialContent = GovOfficialContentResourceIT.createEntity(em);
        govOfficialContentRepository.save(govOfficialContent).block();
        Long govOfficialContentId = govOfficialContent.getId();
        appUser.setGovOfficialContentId(govOfficialContentId);
        appUserRepository.save(appUser).block();
        // Get all the appUserList where govOfficialContent equals to govOfficialContentId
        defaultAppUserShouldBeFound("govOfficialContentId.equals=" + govOfficialContentId);

        // Get all the appUserList where govOfficialContent equals to (govOfficialContentId + 1)
        defaultAppUserShouldNotBeFound("govOfficialContentId.equals=" + (govOfficialContentId + 1));
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultAppUserShouldBeFound(String filter) {
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
            .value(hasItem(appUser.getId().intValue()))
            .jsonPath("$.[*].email")
            .value(hasItem(DEFAULT_EMAIL))
            .jsonPath("$.[*].address")
            .value(hasItem(DEFAULT_ADDRESS))
            .jsonPath("$.[*].phone")
            .value(hasItem(DEFAULT_PHONE))
            .jsonPath("$.[*].gender")
            .value(hasItem(DEFAULT_GENDER))
            .jsonPath("$.[*].department")
            .value(hasItem(DEFAULT_DEPARTMENT))
            .jsonPath("$.[*].description")
            .value(hasItem(DEFAULT_DESCRIPTION))
            .jsonPath("$.[*].latitude")
            .value(hasItem(DEFAULT_LATITUDE.doubleValue()))
            .jsonPath("$.[*].longitude")
            .value(hasItem(DEFAULT_LONGITUDE.doubleValue()))
            .jsonPath("$.[*].userType")
            .value(hasItem(DEFAULT_USER_TYPE.toString()));

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
    private void defaultAppUserShouldNotBeFound(String filter) {
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
    void getNonExistingAppUser() {
        // Get the appUser
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_PROBLEM_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putExistingAppUser() throws Exception {
        // Initialize the database
        appUserRepository.save(appUser).block();

        int databaseSizeBeforeUpdate = appUserRepository.findAll().collectList().block().size();

        // Update the appUser
        AppUser updatedAppUser = appUserRepository.findById(appUser.getId()).block();
        updatedAppUser
            .email(UPDATED_EMAIL)
            .address(UPDATED_ADDRESS)
            .phone(UPDATED_PHONE)
            .gender(UPDATED_GENDER)
            .department(UPDATED_DEPARTMENT)
            .description(UPDATED_DESCRIPTION)
            .latitude(UPDATED_LATITUDE)
            .longitude(UPDATED_LONGITUDE)
            .userType(UPDATED_USER_TYPE);
        AppUserDTO appUserDTO = appUserMapper.toDto(updatedAppUser);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, appUserDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(appUserDTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the AppUser in the database
        List<AppUser> appUserList = appUserRepository.findAll().collectList().block();
        assertThat(appUserList).hasSize(databaseSizeBeforeUpdate);
        AppUser testAppUser = appUserList.get(appUserList.size() - 1);
        assertThat(testAppUser.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testAppUser.getAddress()).isEqualTo(UPDATED_ADDRESS);
        assertThat(testAppUser.getPhone()).isEqualTo(UPDATED_PHONE);
        assertThat(testAppUser.getGender()).isEqualTo(UPDATED_GENDER);
        assertThat(testAppUser.getDepartment()).isEqualTo(UPDATED_DEPARTMENT);
        assertThat(testAppUser.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testAppUser.getLatitude()).isEqualTo(UPDATED_LATITUDE);
        assertThat(testAppUser.getLongitude()).isEqualTo(UPDATED_LONGITUDE);
        assertThat(testAppUser.getUserType()).isEqualTo(UPDATED_USER_TYPE);
    }

    @Test
    void putNonExistingAppUser() throws Exception {
        int databaseSizeBeforeUpdate = appUserRepository.findAll().collectList().block().size();
        appUser.setId(longCount.incrementAndGet());

        // Create the AppUser
        AppUserDTO appUserDTO = appUserMapper.toDto(appUser);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, appUserDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(appUserDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the AppUser in the database
        List<AppUser> appUserList = appUserRepository.findAll().collectList().block();
        assertThat(appUserList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchAppUser() throws Exception {
        int databaseSizeBeforeUpdate = appUserRepository.findAll().collectList().block().size();
        appUser.setId(longCount.incrementAndGet());

        // Create the AppUser
        AppUserDTO appUserDTO = appUserMapper.toDto(appUser);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, longCount.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(appUserDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the AppUser in the database
        List<AppUser> appUserList = appUserRepository.findAll().collectList().block();
        assertThat(appUserList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamAppUser() throws Exception {
        int databaseSizeBeforeUpdate = appUserRepository.findAll().collectList().block().size();
        appUser.setId(longCount.incrementAndGet());

        // Create the AppUser
        AppUserDTO appUserDTO = appUserMapper.toDto(appUser);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(appUserDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the AppUser in the database
        List<AppUser> appUserList = appUserRepository.findAll().collectList().block();
        assertThat(appUserList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateAppUserWithPatch() throws Exception {
        // Initialize the database
        appUserRepository.save(appUser).block();

        int databaseSizeBeforeUpdate = appUserRepository.findAll().collectList().block().size();

        // Update the appUser using partial update
        AppUser partialUpdatedAppUser = new AppUser();
        partialUpdatedAppUser.setId(appUser.getId());

        partialUpdatedAppUser.email(UPDATED_EMAIL).description(UPDATED_DESCRIPTION).longitude(UPDATED_LONGITUDE);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedAppUser.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedAppUser))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the AppUser in the database
        List<AppUser> appUserList = appUserRepository.findAll().collectList().block();
        assertThat(appUserList).hasSize(databaseSizeBeforeUpdate);
        AppUser testAppUser = appUserList.get(appUserList.size() - 1);
        assertThat(testAppUser.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testAppUser.getAddress()).isEqualTo(DEFAULT_ADDRESS);
        assertThat(testAppUser.getPhone()).isEqualTo(DEFAULT_PHONE);
        assertThat(testAppUser.getGender()).isEqualTo(DEFAULT_GENDER);
        assertThat(testAppUser.getDepartment()).isEqualTo(DEFAULT_DEPARTMENT);
        assertThat(testAppUser.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testAppUser.getLatitude()).isEqualTo(DEFAULT_LATITUDE);
        assertThat(testAppUser.getLongitude()).isEqualTo(UPDATED_LONGITUDE);
        assertThat(testAppUser.getUserType()).isEqualTo(DEFAULT_USER_TYPE);
    }

    @Test
    void fullUpdateAppUserWithPatch() throws Exception {
        // Initialize the database
        appUserRepository.save(appUser).block();

        int databaseSizeBeforeUpdate = appUserRepository.findAll().collectList().block().size();

        // Update the appUser using partial update
        AppUser partialUpdatedAppUser = new AppUser();
        partialUpdatedAppUser.setId(appUser.getId());

        partialUpdatedAppUser
            .email(UPDATED_EMAIL)
            .address(UPDATED_ADDRESS)
            .phone(UPDATED_PHONE)
            .gender(UPDATED_GENDER)
            .department(UPDATED_DEPARTMENT)
            .description(UPDATED_DESCRIPTION)
            .latitude(UPDATED_LATITUDE)
            .longitude(UPDATED_LONGITUDE)
            .userType(UPDATED_USER_TYPE);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedAppUser.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedAppUser))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the AppUser in the database
        List<AppUser> appUserList = appUserRepository.findAll().collectList().block();
        assertThat(appUserList).hasSize(databaseSizeBeforeUpdate);
        AppUser testAppUser = appUserList.get(appUserList.size() - 1);
        assertThat(testAppUser.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testAppUser.getAddress()).isEqualTo(UPDATED_ADDRESS);
        assertThat(testAppUser.getPhone()).isEqualTo(UPDATED_PHONE);
        assertThat(testAppUser.getGender()).isEqualTo(UPDATED_GENDER);
        assertThat(testAppUser.getDepartment()).isEqualTo(UPDATED_DEPARTMENT);
        assertThat(testAppUser.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testAppUser.getLatitude()).isEqualTo(UPDATED_LATITUDE);
        assertThat(testAppUser.getLongitude()).isEqualTo(UPDATED_LONGITUDE);
        assertThat(testAppUser.getUserType()).isEqualTo(UPDATED_USER_TYPE);
    }

    @Test
    void patchNonExistingAppUser() throws Exception {
        int databaseSizeBeforeUpdate = appUserRepository.findAll().collectList().block().size();
        appUser.setId(longCount.incrementAndGet());

        // Create the AppUser
        AppUserDTO appUserDTO = appUserMapper.toDto(appUser);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, appUserDTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(appUserDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the AppUser in the database
        List<AppUser> appUserList = appUserRepository.findAll().collectList().block();
        assertThat(appUserList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchAppUser() throws Exception {
        int databaseSizeBeforeUpdate = appUserRepository.findAll().collectList().block().size();
        appUser.setId(longCount.incrementAndGet());

        // Create the AppUser
        AppUserDTO appUserDTO = appUserMapper.toDto(appUser);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, longCount.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(appUserDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the AppUser in the database
        List<AppUser> appUserList = appUserRepository.findAll().collectList().block();
        assertThat(appUserList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamAppUser() throws Exception {
        int databaseSizeBeforeUpdate = appUserRepository.findAll().collectList().block().size();
        appUser.setId(longCount.incrementAndGet());

        // Create the AppUser
        AppUserDTO appUserDTO = appUserMapper.toDto(appUser);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(appUserDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the AppUser in the database
        List<AppUser> appUserList = appUserRepository.findAll().collectList().block();
        assertThat(appUserList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteAppUser() {
        // Initialize the database
        appUserRepository.save(appUser).block();

        int databaseSizeBeforeDelete = appUserRepository.findAll().collectList().block().size();

        // Delete the appUser
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, appUser.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<AppUser> appUserList = appUserRepository.findAll().collectList().block();
        assertThat(appUserList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
