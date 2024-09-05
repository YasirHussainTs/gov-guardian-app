package com.govguardian.app.domain;

import static com.govguardian.app.domain.AppUserTestSamples.*;
import static com.govguardian.app.domain.GovOfficialContentTestSamples.*;
import static com.govguardian.app.domain.ReportDetailsTestSamples.*;
import static com.govguardian.app.domain.ReportHeaderTestSamples.*;
import static com.govguardian.app.domain.ReviewTestSamples.*;
import static com.govguardian.app.domain.RewardTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.govguardian.app.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class AppUserTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AppUser.class);
        AppUser appUser1 = getAppUserSample1();
        AppUser appUser2 = new AppUser();
        assertThat(appUser1).isNotEqualTo(appUser2);

        appUser2.setId(appUser1.getId());
        assertThat(appUser1).isEqualTo(appUser2);

        appUser2 = getAppUserSample2();
        assertThat(appUser1).isNotEqualTo(appUser2);
    }

    @Test
    void reportHeaderTest() throws Exception {
        AppUser appUser = getAppUserRandomSampleGenerator();
        ReportHeader reportHeaderBack = getReportHeaderRandomSampleGenerator();

        appUser.addReportHeader(reportHeaderBack);
        assertThat(appUser.getReportHeaders()).containsOnly(reportHeaderBack);
        assertThat(reportHeaderBack.getAppUser()).isEqualTo(appUser);

        appUser.removeReportHeader(reportHeaderBack);
        assertThat(appUser.getReportHeaders()).doesNotContain(reportHeaderBack);
        assertThat(reportHeaderBack.getAppUser()).isNull();

        appUser.reportHeaders(new HashSet<>(Set.of(reportHeaderBack)));
        assertThat(appUser.getReportHeaders()).containsOnly(reportHeaderBack);
        assertThat(reportHeaderBack.getAppUser()).isEqualTo(appUser);

        appUser.setReportHeaders(new HashSet<>());
        assertThat(appUser.getReportHeaders()).doesNotContain(reportHeaderBack);
        assertThat(reportHeaderBack.getAppUser()).isNull();
    }

    @Test
    void reportDetailsTest() throws Exception {
        AppUser appUser = getAppUserRandomSampleGenerator();
        ReportDetails reportDetailsBack = getReportDetailsRandomSampleGenerator();

        appUser.addReportDetails(reportDetailsBack);
        assertThat(appUser.getReportDetails()).containsOnly(reportDetailsBack);
        assertThat(reportDetailsBack.getAppUser()).isEqualTo(appUser);

        appUser.removeReportDetails(reportDetailsBack);
        assertThat(appUser.getReportDetails()).doesNotContain(reportDetailsBack);
        assertThat(reportDetailsBack.getAppUser()).isNull();

        appUser.reportDetails(new HashSet<>(Set.of(reportDetailsBack)));
        assertThat(appUser.getReportDetails()).containsOnly(reportDetailsBack);
        assertThat(reportDetailsBack.getAppUser()).isEqualTo(appUser);

        appUser.setReportDetails(new HashSet<>());
        assertThat(appUser.getReportDetails()).doesNotContain(reportDetailsBack);
        assertThat(reportDetailsBack.getAppUser()).isNull();
    }

    @Test
    void reviewsTest() throws Exception {
        AppUser appUser = getAppUserRandomSampleGenerator();
        Review reviewBack = getReviewRandomSampleGenerator();

        appUser.setReviews(reviewBack);
        assertThat(appUser.getReviews()).isEqualTo(reviewBack);

        appUser.reviews(null);
        assertThat(appUser.getReviews()).isNull();
    }

    @Test
    void rewardsTest() throws Exception {
        AppUser appUser = getAppUserRandomSampleGenerator();
        Reward rewardBack = getRewardRandomSampleGenerator();

        appUser.setRewards(rewardBack);
        assertThat(appUser.getRewards()).isEqualTo(rewardBack);

        appUser.rewards(null);
        assertThat(appUser.getRewards()).isNull();
    }

    @Test
    void govOfficialContentTest() throws Exception {
        AppUser appUser = getAppUserRandomSampleGenerator();
        GovOfficialContent govOfficialContentBack = getGovOfficialContentRandomSampleGenerator();

        appUser.setGovOfficialContent(govOfficialContentBack);
        assertThat(appUser.getGovOfficialContent()).isEqualTo(govOfficialContentBack);

        appUser.govOfficialContent(null);
        assertThat(appUser.getGovOfficialContent()).isNull();
    }
}
