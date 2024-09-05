package com.govguardian.app.service;

import com.govguardian.app.domain.criteria.ReportDetailsCriteria;
import com.govguardian.app.service.dto.ReportDetailsDTO;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Interface for managing {@link com.govguardian.app.domain.ReportDetails}.
 */
public interface ReportDetailsService {
    /**
     * Save a reportDetails.
     *
     * @param reportDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    Mono<ReportDetailsDTO> save(ReportDetailsDTO reportDetailsDTO);

    /**
     * Updates a reportDetails.
     *
     * @param reportDetailsDTO the entity to update.
     * @return the persisted entity.
     */
    Mono<ReportDetailsDTO> update(ReportDetailsDTO reportDetailsDTO);

    /**
     * Partially updates a reportDetails.
     *
     * @param reportDetailsDTO the entity to update partially.
     * @return the persisted entity.
     */
    Mono<ReportDetailsDTO> partialUpdate(ReportDetailsDTO reportDetailsDTO);

    /**
     * Get all the reportDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Flux<ReportDetailsDTO> findAll(Pageable pageable);

    /**
     * Find reportDetails by criteria.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Flux<ReportDetailsDTO> findByCriteria(ReportDetailsCriteria criteria, Pageable pageable);

    /**
     * Find the count of reportDetails by criteria.
     * @param criteria filtering criteria
     * @return the count of reportDetails
     */
    public Mono<Long> countByCriteria(ReportDetailsCriteria criteria);

    /**
     * Returns the number of reportDetails available.
     * @return the number of entities in the database.
     *
     */
    Mono<Long> countAll();

    /**
     * Get the "id" reportDetails.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Mono<ReportDetailsDTO> findOne(Long id);

    /**
     * Delete the "id" reportDetails.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    Mono<Void> delete(Long id);
}
