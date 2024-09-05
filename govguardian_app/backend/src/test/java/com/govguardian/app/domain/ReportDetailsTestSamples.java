package com.govguardian.app.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class ReportDetailsTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static ReportDetails getReportDetailsSample1() {
        return new ReportDetails()
            .id(1L)
            .owner("owner1")
            .responder("responder1")
            .description("description1")
            .title("title1")
            .status("status1");
    }

    public static ReportDetails getReportDetailsSample2() {
        return new ReportDetails()
            .id(2L)
            .owner("owner2")
            .responder("responder2")
            .description("description2")
            .title("title2")
            .status("status2");
    }

    public static ReportDetails getReportDetailsRandomSampleGenerator() {
        return new ReportDetails()
            .id(longCount.incrementAndGet())
            .owner(UUID.randomUUID().toString())
            .responder(UUID.randomUUID().toString())
            .description(UUID.randomUUID().toString())
            .title(UUID.randomUUID().toString())
            .status(UUID.randomUUID().toString());
    }
}
