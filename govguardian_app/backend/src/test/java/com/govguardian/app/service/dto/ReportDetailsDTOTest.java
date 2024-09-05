package com.govguardian.app.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.govguardian.app.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ReportDetailsDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReportDetailsDTO.class);
        ReportDetailsDTO reportDetailsDTO1 = new ReportDetailsDTO();
        reportDetailsDTO1.setId(1L);
        ReportDetailsDTO reportDetailsDTO2 = new ReportDetailsDTO();
        assertThat(reportDetailsDTO1).isNotEqualTo(reportDetailsDTO2);
        reportDetailsDTO2.setId(reportDetailsDTO1.getId());
        assertThat(reportDetailsDTO1).isEqualTo(reportDetailsDTO2);
        reportDetailsDTO2.setId(2L);
        assertThat(reportDetailsDTO1).isNotEqualTo(reportDetailsDTO2);
        reportDetailsDTO1.setId(null);
        assertThat(reportDetailsDTO1).isNotEqualTo(reportDetailsDTO2);
    }
}
