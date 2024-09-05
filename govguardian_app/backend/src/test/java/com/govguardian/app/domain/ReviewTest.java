package com.govguardian.app.domain;

import static com.govguardian.app.domain.AppUserTestSamples.*;
import static com.govguardian.app.domain.ReviewTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.govguardian.app.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ReviewTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Review.class);
        Review review1 = getReviewSample1();
        Review review2 = new Review();
        assertThat(review1).isNotEqualTo(review2);

        review2.setId(review1.getId());
        assertThat(review1).isEqualTo(review2);

        review2 = getReviewSample2();
        assertThat(review1).isNotEqualTo(review2);
    }

    @Test
    void appUserTest() throws Exception {
        Review review = getReviewRandomSampleGenerator();
        AppUser appUserBack = getAppUserRandomSampleGenerator();

        review.addAppUser(appUserBack);
        assertThat(review.getAppUsers()).containsOnly(appUserBack);
        assertThat(appUserBack.getReviews()).isEqualTo(review);

        review.removeAppUser(appUserBack);
        assertThat(review.getAppUsers()).doesNotContain(appUserBack);
        assertThat(appUserBack.getReviews()).isNull();

        review.appUsers(new HashSet<>(Set.of(appUserBack)));
        assertThat(review.getAppUsers()).containsOnly(appUserBack);
        assertThat(appUserBack.getReviews()).isEqualTo(review);

        review.setAppUsers(new HashSet<>());
        assertThat(review.getAppUsers()).doesNotContain(appUserBack);
        assertThat(appUserBack.getReviews()).isNull();
    }
}
