package com.govguardian.app.service.mapper;

import com.govguardian.app.domain.AppUser;
import com.govguardian.app.domain.ReportDetails;
import com.govguardian.app.service.dto.AppUserDTO;
import com.govguardian.app.service.dto.ReportDetailsDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ReportDetails} and its DTO {@link ReportDetailsDTO}.
 */
@Mapper(componentModel = "spring")
public interface ReportDetailsMapper extends EntityMapper<ReportDetailsDTO, ReportDetails> {
    @Mapping(target = "appUser", source = "appUser", qualifiedByName = "appUserId")
    ReportDetailsDTO toDto(ReportDetails s);

    @Named("appUserId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    AppUserDTO toDtoAppUserId(AppUser appUser);
}
