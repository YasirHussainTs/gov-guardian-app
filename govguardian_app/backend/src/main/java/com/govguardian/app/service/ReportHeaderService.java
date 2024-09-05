package com.govguardian.app.service;

import com.govguardian.app.domain.criteria.ReportHeaderCriteria;
import com.govguardian.app.service.dto.ReportHeaderDTO;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Interface for managing {@link com.govguardian.app.domain.ReportHeader}.
 */
public interface ReportHeaderService {
    /**
     * Save a reportHeader.
     *
     * @param reportHeaderDTO the entity to save.
     * @return the persisted entity.
     */
    Mono<ReportHeaderDTO> save(ReportHeaderDTO reportHeaderDTO);

    /**
     * Updates a reportHeader.
     *
     * @param reportHeaderDTO the entity to update.
     * @return the persisted entity.
     */
    Mono<ReportHeaderDTO> update(ReportHeaderDTO reportHeaderDTO);

    /**
     * Partially updates a reportHeader.
     *
     * @param reportHeaderDTO the entity to update partially.
     * @return the persisted entity.
     */
    Mono<ReportHeaderDTO> partialUpdate(ReportHeaderDTO reportHeaderDTO);

    /**
     * Get all the reportHeaders.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Flux<ReportHeaderDTO> findAll(Pageable pageable);

    /**
     * Find reportHeaders by criteria.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Flux<ReportHeaderDTO> findByCriteria(ReportHeaderCriteria criteria, Pageable pageable);

    /**
     * Find the count of reportHeaders by criteria.
     * @param criteria filtering criteria
     * @return the count of reportHeaders
     */
    public Mono<Long> countByCriteria(ReportHeaderCriteria criteria);

    /**
     * Returns the number of reportHeaders available.
     * @return the number of entities in the database.
     *
     */
    Mono<Long> countAll();

    /**
     * Get the "id" reportHeader.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Mono<ReportHeaderDTO> findOne(String id);

    /**
     * Delete the "id" reportHeader.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    Mono<Void> delete(String id);
}
