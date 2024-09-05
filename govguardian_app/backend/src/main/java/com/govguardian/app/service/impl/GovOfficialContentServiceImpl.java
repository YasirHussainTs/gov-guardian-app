package com.govguardian.app.service.impl;

import com.govguardian.app.domain.criteria.GovOfficialContentCriteria;
import com.govguardian.app.repository.GovOfficialContentRepository;
import com.govguardian.app.service.GovOfficialContentService;
import com.govguardian.app.service.dto.GovOfficialContentDTO;
import com.govguardian.app.service.mapper.GovOfficialContentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Implementation for managing {@link com.govguardian.app.domain.GovOfficialContent}.
 */
@Service
@Transactional
public class GovOfficialContentServiceImpl implements GovOfficialContentService {

    private final Logger log = LoggerFactory.getLogger(GovOfficialContentServiceImpl.class);

    private final GovOfficialContentRepository govOfficialContentRepository;

    private final GovOfficialContentMapper govOfficialContentMapper;

    public GovOfficialContentServiceImpl(
        GovOfficialContentRepository govOfficialContentRepository,
        GovOfficialContentMapper govOfficialContentMapper
    ) {
        this.govOfficialContentRepository = govOfficialContentRepository;
        this.govOfficialContentMapper = govOfficialContentMapper;
    }

    @Override
    public Mono<GovOfficialContentDTO> save(GovOfficialContentDTO govOfficialContentDTO) {
        log.debug("Request to save GovOfficialContent : {}", govOfficialContentDTO);
        return govOfficialContentRepository
            .save(govOfficialContentMapper.toEntity(govOfficialContentDTO))
            .map(govOfficialContentMapper::toDto);
    }

    @Override
    public Mono<GovOfficialContentDTO> update(GovOfficialContentDTO govOfficialContentDTO) {
        log.debug("Request to update GovOfficialContent : {}", govOfficialContentDTO);
        return govOfficialContentRepository
            .save(govOfficialContentMapper.toEntity(govOfficialContentDTO))
            .map(govOfficialContentMapper::toDto);
    }

    @Override
    public Mono<GovOfficialContentDTO> partialUpdate(GovOfficialContentDTO govOfficialContentDTO) {
        log.debug("Request to partially update GovOfficialContent : {}", govOfficialContentDTO);

        return govOfficialContentRepository
            .findById(govOfficialContentDTO.getId())
            .map(existingGovOfficialContent -> {
                govOfficialContentMapper.partialUpdate(existingGovOfficialContent, govOfficialContentDTO);

                return existingGovOfficialContent;
            })
            .flatMap(govOfficialContentRepository::save)
            .map(govOfficialContentMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<GovOfficialContentDTO> findAll(Pageable pageable) {
        log.debug("Request to get all GovOfficialContents");
        return govOfficialContentRepository.findAllBy(pageable).map(govOfficialContentMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<GovOfficialContentDTO> findByCriteria(GovOfficialContentCriteria criteria, Pageable pageable) {
        log.debug("Request to get all GovOfficialContents by Criteria");
        return govOfficialContentRepository.findByCriteria(criteria, pageable).map(govOfficialContentMapper::toDto);
    }

    /**
     * Find the count of govOfficialContents by criteria.
     * @param criteria filtering criteria
     * @return the count of govOfficialContents
     */
    public Mono<Long> countByCriteria(GovOfficialContentCriteria criteria) {
        log.debug("Request to get the count of all GovOfficialContents by Criteria");
        return govOfficialContentRepository.countByCriteria(criteria);
    }

    public Mono<Long> countAll() {
        return govOfficialContentRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<GovOfficialContentDTO> findOne(Long id) {
        log.debug("Request to get GovOfficialContent : {}", id);
        return govOfficialContentRepository.findById(id).map(govOfficialContentMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete GovOfficialContent : {}", id);
        return govOfficialContentRepository.deleteById(id);
    }
}
