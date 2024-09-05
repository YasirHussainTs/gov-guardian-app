package com.govguardian.app.service.mapper;

import com.govguardian.app.domain.Reward;
import com.govguardian.app.service.dto.RewardDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Reward} and its DTO {@link RewardDTO}.
 */
@Mapper(componentModel = "spring")
public interface RewardMapper extends EntityMapper<RewardDTO, Reward> {}
