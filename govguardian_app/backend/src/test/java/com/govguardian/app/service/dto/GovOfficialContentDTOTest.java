package com.govguardian.app.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.govguardian.app.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class GovOfficialContentDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(GovOfficialContentDTO.class);
        GovOfficialContentDTO govOfficialContentDTO1 = new GovOfficialContentDTO();
        govOfficialContentDTO1.setId(1L);
        GovOfficialContentDTO govOfficialContentDTO2 = new GovOfficialContentDTO();
        assertThat(govOfficialContentDTO1).isNotEqualTo(govOfficialContentDTO2);
        govOfficialContentDTO2.setId(govOfficialContentDTO1.getId());
        assertThat(govOfficialContentDTO1).isEqualTo(govOfficialContentDTO2);
        govOfficialContentDTO2.setId(2L);
        assertThat(govOfficialContentDTO1).isNotEqualTo(govOfficialContentDTO2);
        govOfficialContentDTO1.setId(null);
        assertThat(govOfficialContentDTO1).isNotEqualTo(govOfficialContentDTO2);
    }
}
