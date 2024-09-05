package com.govguardian.app.service.mapper;

import com.govguardian.app.domain.GovOfficialContent;
import com.govguardian.app.service.dto.GovOfficialContentDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link GovOfficialContent} and its DTO {@link GovOfficialContentDTO}.
 */
@Mapper(componentModel = "spring")
public interface GovOfficialContentMapper extends EntityMapper<GovOfficialContentDTO, GovOfficialContent> {}
