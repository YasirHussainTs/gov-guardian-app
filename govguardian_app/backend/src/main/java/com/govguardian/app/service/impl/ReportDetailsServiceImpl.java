package com.govguardian.app.service.impl;

import com.govguardian.app.domain.criteria.ReportDetailsCriteria;
import com.govguardian.app.repository.ReportDetailsRepository;
import com.govguardian.app.service.ReportDetailsService;
import com.govguardian.app.service.dto.ReportDetailsDTO;
import com.govguardian.app.service.mapper.ReportDetailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Implementation for managing {@link com.govguardian.app.domain.ReportDetails}.
 */
@Service
@Transactional
public class ReportDetailsServiceImpl implements ReportDetailsService {

    private final Logger log = LoggerFactory.getLogger(ReportDetailsServiceImpl.class);

    private final ReportDetailsRepository reportDetailsRepository;

    private final ReportDetailsMapper reportDetailsMapper;

    public ReportDetailsServiceImpl(ReportDetailsRepository reportDetailsRepository, ReportDetailsMapper reportDetailsMapper) {
        this.reportDetailsRepository = reportDetailsRepository;
        this.reportDetailsMapper = reportDetailsMapper;
    }

    @Override
    public Mono<ReportDetailsDTO> save(ReportDetailsDTO reportDetailsDTO) {
        log.debug("Request to save ReportDetails : {}", reportDetailsDTO);
        return reportDetailsRepository.save(reportDetailsMapper.toEntity(reportDetailsDTO)).map(reportDetailsMapper::toDto);
    }

    @Override
    public Mono<ReportDetailsDTO> update(ReportDetailsDTO reportDetailsDTO) {
        log.debug("Request to update ReportDetails : {}", reportDetailsDTO);
        return reportDetailsRepository.save(reportDetailsMapper.toEntity(reportDetailsDTO)).map(reportDetailsMapper::toDto);
    }

    @Override
    public Mono<ReportDetailsDTO> partialUpdate(ReportDetailsDTO reportDetailsDTO) {
        log.debug("Request to partially update ReportDetails : {}", reportDetailsDTO);

        return reportDetailsRepository
            .findById(reportDetailsDTO.getId())
            .map(existingReportDetails -> {
                reportDetailsMapper.partialUpdate(existingReportDetails, reportDetailsDTO);

                return existingReportDetails;
            })
            .flatMap(reportDetailsRepository::save)
            .map(reportDetailsMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<ReportDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ReportDetails");
        return reportDetailsRepository.findAllBy(pageable).map(reportDetailsMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<ReportDetailsDTO> findByCriteria(ReportDetailsCriteria criteria, Pageable pageable) {
        log.debug("Request to get all ReportDetails by Criteria");
        return reportDetailsRepository.findByCriteria(criteria, pageable).map(reportDetailsMapper::toDto);
    }

    /**
     * Find the count of reportDetails by criteria.
     * @param criteria filtering criteria
     * @return the count of reportDetails
     */
    public Mono<Long> countByCriteria(ReportDetailsCriteria criteria) {
        log.debug("Request to get the count of all ReportDetails by Criteria");
        return reportDetailsRepository.countByCriteria(criteria);
    }

    public Mono<Long> countAll() {
        return reportDetailsRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<ReportDetailsDTO> findOne(Long id) {
        log.debug("Request to get ReportDetails : {}", id);
        return reportDetailsRepository.findById(id).map(reportDetailsMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete ReportDetails : {}", id);
        return reportDetailsRepository.deleteById(id);
    }
}
