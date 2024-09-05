package com.govguardian.app.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class GovOfficialContentTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static GovOfficialContent getGovOfficialContentSample1() {
        return new GovOfficialContent().id(1L).law("law1").description("description1").action("action1");
    }

    public static GovOfficialContent getGovOfficialContentSample2() {
        return new GovOfficialContent().id(2L).law("law2").description("description2").action("action2");
    }

    public static GovOfficialContent getGovOfficialContentRandomSampleGenerator() {
        return new GovOfficialContent()
            .id(longCount.incrementAndGet())
            .law(UUID.randomUUID().toString())
            .description(UUID.randomUUID().toString())
            .action(UUID.randomUUID().toString());
    }
}
