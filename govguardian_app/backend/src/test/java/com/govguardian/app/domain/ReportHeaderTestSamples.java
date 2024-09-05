package com.govguardian.app.domain;

import java.util.UUID;

public class ReportHeaderTestSamples {

    public static ReportHeader getReportHeaderSample1() {
        return new ReportHeader().id("id1").description("description1").title("title1").status("status1");
    }

    public static ReportHeader getReportHeaderSample2() {
        return new ReportHeader().id("id2").description("description2").title("title2").status("status2");
    }

    public static ReportHeader getReportHeaderRandomSampleGenerator() {
        return new ReportHeader()
            .id(UUID.randomUUID().toString())
            .description(UUID.randomUUID().toString())
            .title(UUID.randomUUID().toString())
            .status(UUID.randomUUID().toString());
    }
}
