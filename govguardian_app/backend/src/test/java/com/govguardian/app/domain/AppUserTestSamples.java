package com.govguardian.app.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class AppUserTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static AppUser getAppUserSample1() {
        return new AppUser()
            .id(1L)
            .email("email1")
            .address("address1")
            .phone("phone1")
            .gender("gender1")
            .department("department1")
            .description("description1");
    }

    public static AppUser getAppUserSample2() {
        return new AppUser()
            .id(2L)
            .email("email2")
            .address("address2")
            .phone("phone2")
            .gender("gender2")
            .department("department2")
            .description("description2");
    }

    public static AppUser getAppUserRandomSampleGenerator() {
        return new AppUser()
            .id(longCount.incrementAndGet())
            .email(UUID.randomUUID().toString())
            .address(UUID.randomUUID().toString())
            .phone(UUID.randomUUID().toString())
            .gender(UUID.randomUUID().toString())
            .department(UUID.randomUUID().toString())
            .description(UUID.randomUUID().toString());
    }
}
