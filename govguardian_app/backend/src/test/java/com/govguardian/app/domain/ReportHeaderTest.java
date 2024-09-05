package com.govguardian.app.domain;

import static com.govguardian.app.domain.AppUserTestSamples.*;
import static com.govguardian.app.domain.ReportHeaderTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.govguardian.app.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ReportHeaderTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReportHeader.class);
        ReportHeader reportHeader1 = getReportHeaderSample1();
        ReportHeader reportHeader2 = new ReportHeader();
        assertThat(reportHeader1).isNotEqualTo(reportHeader2);

        reportHeader2.setId(reportHeader1.getId());
        assertThat(reportHeader1).isEqualTo(reportHeader2);

        reportHeader2 = getReportHeaderSample2();
        assertThat(reportHeader1).isNotEqualTo(reportHeader2);
    }

    @Test
    void appUserTest() throws Exception {
        ReportHeader reportHeader = getReportHeaderRandomSampleGenerator();
        AppUser appUserBack = getAppUserRandomSampleGenerator();

        reportHeader.setAppUser(appUserBack);
        assertThat(reportHeader.getAppUser()).isEqualTo(appUserBack);

        reportHeader.appUser(null);
        assertThat(reportHeader.getAppUser()).isNull();
    }
}
