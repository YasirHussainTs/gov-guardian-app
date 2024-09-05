package com.govguardian.app.domain;

import static com.govguardian.app.domain.AppUserTestSamples.*;
import static com.govguardian.app.domain.GovOfficialContentTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.govguardian.app.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class GovOfficialContentTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(GovOfficialContent.class);
        GovOfficialContent govOfficialContent1 = getGovOfficialContentSample1();
        GovOfficialContent govOfficialContent2 = new GovOfficialContent();
        assertThat(govOfficialContent1).isNotEqualTo(govOfficialContent2);

        govOfficialContent2.setId(govOfficialContent1.getId());
        assertThat(govOfficialContent1).isEqualTo(govOfficialContent2);

        govOfficialContent2 = getGovOfficialContentSample2();
        assertThat(govOfficialContent1).isNotEqualTo(govOfficialContent2);
    }

    @Test
    void appUserTest() throws Exception {
        GovOfficialContent govOfficialContent = getGovOfficialContentRandomSampleGenerator();
        AppUser appUserBack = getAppUserRandomSampleGenerator();

        govOfficialContent.addAppUser(appUserBack);
        assertThat(govOfficialContent.getAppUsers()).containsOnly(appUserBack);
        assertThat(appUserBack.getGovOfficialContent()).isEqualTo(govOfficialContent);

        govOfficialContent.removeAppUser(appUserBack);
        assertThat(govOfficialContent.getAppUsers()).doesNotContain(appUserBack);
        assertThat(appUserBack.getGovOfficialContent()).isNull();

        govOfficialContent.appUsers(new HashSet<>(Set.of(appUserBack)));
        assertThat(govOfficialContent.getAppUsers()).containsOnly(appUserBack);
        assertThat(appUserBack.getGovOfficialContent()).isEqualTo(govOfficialContent);

        govOfficialContent.setAppUsers(new HashSet<>());
        assertThat(govOfficialContent.getAppUsers()).doesNotContain(appUserBack);
        assertThat(appUserBack.getGovOfficialContent()).isNull();
    }
}
