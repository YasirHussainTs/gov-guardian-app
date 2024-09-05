package com.govguardian.app.service.mapper;

import com.govguardian.app.domain.AppUser;
import com.govguardian.app.domain.GovOfficialContent;
import com.govguardian.app.domain.Review;
import com.govguardian.app.domain.Reward;
import com.govguardian.app.domain.User;
import com.govguardian.app.service.dto.AppUserDTO;
import com.govguardian.app.service.dto.GovOfficialContentDTO;
import com.govguardian.app.service.dto.ReviewDTO;
import com.govguardian.app.service.dto.RewardDTO;
import com.govguardian.app.service.dto.UserDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link AppUser} and its DTO {@link AppUserDTO}.
 */
@Mapper(componentModel = "spring")
public interface AppUserMapper extends EntityMapper<AppUserDTO, AppUser> {
    @Mapping(target = "user", source = "user", qualifiedByName = "userId")
    @Mapping(target = "reviews", source = "reviews", qualifiedByName = "reviewId")
    @Mapping(target = "rewards", source = "rewards", qualifiedByName = "rewardId")
    @Mapping(target = "govOfficialContent", source = "govOfficialContent", qualifiedByName = "govOfficialContentId")
    AppUserDTO toDto(AppUser s);

    @Named("userId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UserDTO toDtoUserId(User user);

    @Named("reviewId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ReviewDTO toDtoReviewId(Review review);

    @Named("rewardId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RewardDTO toDtoRewardId(Reward reward);

    @Named("govOfficialContentId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    GovOfficialContentDTO toDtoGovOfficialContentId(GovOfficialContent govOfficialContent);
}
