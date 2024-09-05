package com.govguardian.app.service.impl;

import com.govguardian.app.domain.criteria.ReportHeaderCriteria;
import com.govguardian.app.repository.ReportHeaderRepository;
import com.govguardian.app.service.ReportHeaderService;
import com.govguardian.app.service.dto.ReportHeaderDTO;
import com.govguardian.app.service.mapper.ReportHeaderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Implementation for managing {@link com.govguardian.app.domain.ReportHeader}.
 */
@Service
@Transactional
public class ReportHeaderServiceImpl implements ReportHeaderService {

    private final Logger log = LoggerFactory.getLogger(ReportHeaderServiceImpl.class);

    private final ReportHeaderRepository reportHeaderRepository;

    private final ReportHeaderMapper reportHeaderMapper;

    public ReportHeaderServiceImpl(ReportHeaderRepository reportHeaderRepository, ReportHeaderMapper reportHeaderMapper) {
        this.reportHeaderRepository = reportHeaderRepository;
        this.reportHeaderMapper = reportHeaderMapper;
    }

    @Override
    public Mono<ReportHeaderDTO> save(ReportHeaderDTO reportHeaderDTO) {
        log.debug("Request to save ReportHeader : {}", reportHeaderDTO);
        return reportHeaderRepository.save(reportHeaderMapper.toEntity(reportHeaderDTO)).map(reportHeaderMapper::toDto);
    }

    @Override
    public Mono<ReportHeaderDTO> update(ReportHeaderDTO reportHeaderDTO) {
        log.debug("Request to update ReportHeader : {}", reportHeaderDTO);
        return reportHeaderRepository.save(reportHeaderMapper.toEntity(reportHeaderDTO).setIsPersisted()).map(reportHeaderMapper::toDto);
    }

    @Override
    public Mono<ReportHeaderDTO> partialUpdate(ReportHeaderDTO reportHeaderDTO) {
        log.debug("Request to partially update ReportHeader : {}", reportHeaderDTO);

        return reportHeaderRepository
            .findById(reportHeaderDTO.getId())
            .map(existingReportHeader -> {
                reportHeaderMapper.partialUpdate(existingReportHeader, reportHeaderDTO);

                return existingReportHeader;
            })
            .flatMap(reportHeaderRepository::save)
            .map(reportHeaderMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<ReportHeaderDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ReportHeaders");
        return reportHeaderRepository.findAllBy(pageable).map(reportHeaderMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<ReportHeaderDTO> findByCriteria(ReportHeaderCriteria criteria, Pageable pageable) {
        log.debug("Request to get all ReportHeaders by Criteria");
        return reportHeaderRepository.findByCriteria(criteria, pageable).map(reportHeaderMapper::toDto);
    }

    /**
     * Find the count of reportHeaders by criteria.
     * @param criteria filtering criteria
     * @return the count of reportHeaders
     */
    public Mono<Long> countByCriteria(ReportHeaderCriteria criteria) {
        log.debug("Request to get the count of all ReportHeaders by Criteria");
        return reportHeaderRepository.countByCriteria(criteria);
    }

    public Mono<Long> countAll() {
        return reportHeaderRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<ReportHeaderDTO> findOne(String id) {
        log.debug("Request to get ReportHeader : {}", id);
        return reportHeaderRepository.findById(id).map(reportHeaderMapper::toDto);
    }

    @Override
    public Mono<Void> delete(String id) {
        log.debug("Request to delete ReportHeader : {}", id);
        return reportHeaderRepository.deleteById(id);
    }
}
