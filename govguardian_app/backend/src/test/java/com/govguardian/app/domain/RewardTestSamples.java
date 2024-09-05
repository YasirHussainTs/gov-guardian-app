package com.govguardian.app.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class RewardTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static Reward getRewardSample1() {
        return new Reward().id(1L).description("description1").points(1);
    }

    public static Reward getRewardSample2() {
        return new Reward().id(2L).description("description2").points(2);
    }

    public static Reward getRewardRandomSampleGenerator() {
        return new Reward().id(longCount.incrementAndGet()).description(UUID.randomUUID().toString()).points(intCount.incrementAndGet());
    }
}
