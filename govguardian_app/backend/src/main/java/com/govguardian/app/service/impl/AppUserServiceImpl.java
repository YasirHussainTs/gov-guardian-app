package com.govguardian.app.service.impl;

import com.govguardian.app.domain.criteria.AppUserCriteria;
import com.govguardian.app.repository.AppUserRepository;
import com.govguardian.app.service.AppUserService;
import com.govguardian.app.service.dto.AppUserDTO;
import com.govguardian.app.service.mapper.AppUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Implementation for managing {@link com.govguardian.app.domain.AppUser}.
 */
@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

    private final Logger log = LoggerFactory.getLogger(AppUserServiceImpl.class);

    private final AppUserRepository appUserRepository;

    private final AppUserMapper appUserMapper;

    public AppUserServiceImpl(AppUserRepository appUserRepository, AppUserMapper appUserMapper) {
        this.appUserRepository = appUserRepository;
        this.appUserMapper = appUserMapper;
    }

    @Override
    public Mono<AppUserDTO> save(AppUserDTO appUserDTO) {
        log.debug("Request to save AppUser : {}", appUserDTO);
        return appUserRepository.save(appUserMapper.toEntity(appUserDTO)).map(appUserMapper::toDto);
    }

    @Override
    public Mono<AppUserDTO> update(AppUserDTO appUserDTO) {
        log.debug("Request to update AppUser : {}", appUserDTO);
        return appUserRepository.save(appUserMapper.toEntity(appUserDTO)).map(appUserMapper::toDto);
    }

    @Override
    public Mono<AppUserDTO> partialUpdate(AppUserDTO appUserDTO) {
        log.debug("Request to partially update AppUser : {}", appUserDTO);

        return appUserRepository
            .findById(appUserDTO.getId())
            .map(existingAppUser -> {
                appUserMapper.partialUpdate(existingAppUser, appUserDTO);

                return existingAppUser;
            })
            .flatMap(appUserRepository::save)
            .map(appUserMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<AppUserDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AppUsers");
        return appUserRepository.findAllBy(pageable).map(appUserMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<AppUserDTO> findByCriteria(AppUserCriteria criteria, Pageable pageable) {
        log.debug("Request to get all AppUsers by Criteria");
        return appUserRepository.findByCriteria(criteria, pageable).map(appUserMapper::toDto);
    }

    /**
     * Find the count of appUsers by criteria.
     * @param criteria filtering criteria
     * @return the count of appUsers
     */
    public Mono<Long> countByCriteria(AppUserCriteria criteria) {
        log.debug("Request to get the count of all AppUsers by Criteria");
        return appUserRepository.countByCriteria(criteria);
    }

    public Mono<Long> countAll() {
        return appUserRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<AppUserDTO> findOne(Long id) {
        log.debug("Request to get AppUser : {}", id);
        return appUserRepository.findById(id).map(appUserMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete AppUser : {}", id);
        return appUserRepository.deleteById(id);
    }
}
