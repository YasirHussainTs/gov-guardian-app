package com.govguardian.app.service.mapper;

import com.govguardian.app.domain.AppUser;
import com.govguardian.app.domain.ReportHeader;
import com.govguardian.app.service.dto.AppUserDTO;
import com.govguardian.app.service.dto.ReportHeaderDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ReportHeader} and its DTO {@link ReportHeaderDTO}.
 */
@Mapper(componentModel = "spring")
public interface ReportHeaderMapper extends EntityMapper<ReportHeaderDTO, ReportHeader> {
    @Mapping(target = "appUser", source = "appUser", qualifiedByName = "appUserId")
    ReportHeaderDTO toDto(ReportHeader s);

    @Named("appUserId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    AppUserDTO toDtoAppUserId(AppUser appUser);
}
