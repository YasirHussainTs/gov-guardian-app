package com.govguardian.app.domain;

import static com.govguardian.app.domain.AppUserTestSamples.*;
import static com.govguardian.app.domain.ReportDetailsTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.govguardian.app.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ReportDetailsTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReportDetails.class);
        ReportDetails reportDetails1 = getReportDetailsSample1();
        ReportDetails reportDetails2 = new ReportDetails();
        assertThat(reportDetails1).isNotEqualTo(reportDetails2);

        reportDetails2.setId(reportDetails1.getId());
        assertThat(reportDetails1).isEqualTo(reportDetails2);

        reportDetails2 = getReportDetailsSample2();
        assertThat(reportDetails1).isNotEqualTo(reportDetails2);
    }

    @Test
    void appUserTest() throws Exception {
        ReportDetails reportDetails = getReportDetailsRandomSampleGenerator();
        AppUser appUserBack = getAppUserRandomSampleGenerator();

        reportDetails.setAppUser(appUserBack);
        assertThat(reportDetails.getAppUser()).isEqualTo(appUserBack);

        reportDetails.appUser(null);
        assertThat(reportDetails.getAppUser()).isNull();
    }
}
