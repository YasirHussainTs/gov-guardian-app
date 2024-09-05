package com.govguardian.app.domain;

import static com.govguardian.app.domain.AppUserTestSamples.*;
import static com.govguardian.app.domain.RewardTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.govguardian.app.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class RewardTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Reward.class);
        Reward reward1 = getRewardSample1();
        Reward reward2 = new Reward();
        assertThat(reward1).isNotEqualTo(reward2);

        reward2.setId(reward1.getId());
        assertThat(reward1).isEqualTo(reward2);

        reward2 = getRewardSample2();
        assertThat(reward1).isNotEqualTo(reward2);
    }

    @Test
    void appUserTest() throws Exception {
        Reward reward = getRewardRandomSampleGenerator();
        AppUser appUserBack = getAppUserRandomSampleGenerator();

        reward.addAppUser(appUserBack);
        assertThat(reward.getAppUsers()).containsOnly(appUserBack);
        assertThat(appUserBack.getRewards()).isEqualTo(reward);

        reward.removeAppUser(appUserBack);
        assertThat(reward.getAppUsers()).doesNotContain(appUserBack);
        assertThat(appUserBack.getRewards()).isNull();

        reward.appUsers(new HashSet<>(Set.of(appUserBack)));
        assertThat(reward.getAppUsers()).containsOnly(appUserBack);
        assertThat(appUserBack.getRewards()).isEqualTo(reward);

        reward.setAppUsers(new HashSet<>());
        assertThat(reward.getAppUsers()).doesNotContain(appUserBack);
        assertThat(appUserBack.getRewards()).isNull();
    }
}
