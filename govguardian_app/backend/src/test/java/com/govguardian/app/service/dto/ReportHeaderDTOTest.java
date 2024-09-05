package com.govguardian.app.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.govguardian.app.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ReportHeaderDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReportHeaderDTO.class);
        ReportHeaderDTO reportHeaderDTO1 = new ReportHeaderDTO();
        reportHeaderDTO1.setId("id1");
        ReportHeaderDTO reportHeaderDTO2 = new ReportHeaderDTO();
        assertThat(reportHeaderDTO1).isNotEqualTo(reportHeaderDTO2);
        reportHeaderDTO2.setId(reportHeaderDTO1.getId());
        assertThat(reportHeaderDTO1).isEqualTo(reportHeaderDTO2);
        reportHeaderDTO2.setId("id2");
        assertThat(reportHeaderDTO1).isNotEqualTo(reportHeaderDTO2);
        reportHeaderDTO1.setId(null);
        assertThat(reportHeaderDTO1).isNotEqualTo(reportHeaderDTO2);
    }
}
