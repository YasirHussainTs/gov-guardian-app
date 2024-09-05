package com.govguardian.app.service;

import com.govguardian.app.domain.criteria.GovOfficialContentCriteria;
import com.govguardian.app.service.dto.GovOfficialContentDTO;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Interface for managing {@link com.govguardian.app.domain.GovOfficialContent}.
 */
public interface GovOfficialContentService {
    /**
     * Save a govOfficialContent.
     *
     * @param govOfficialContentDTO the entity to save.
     * @return the persisted entity.
     */
    Mono<GovOfficialContentDTO> save(GovOfficialContentDTO govOfficialContentDTO);

    /**
     * Updates a govOfficialContent.
     *
     * @param govOfficialContentDTO the entity to update.
     * @return the persisted entity.
     */
    Mono<GovOfficialContentDTO> update(GovOfficialContentDTO govOfficialContentDTO);

    /**
     * Partially updates a govOfficialContent.
     *
     * @param govOfficialContentDTO the entity to update partially.
     * @return the persisted entity.
     */
    Mono<GovOfficialContentDTO> partialUpdate(GovOfficialContentDTO govOfficialContentDTO);

    /**
     * Get all the govOfficialContents.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Flux<GovOfficialContentDTO> findAll(Pageable pageable);

    /**
     * Find govOfficialContents by criteria.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Flux<GovOfficialContentDTO> findByCriteria(GovOfficialContentCriteria criteria, Pageable pageable);

    /**
     * Find the count of govOfficialContents by criteria.
     * @param criteria filtering criteria
     * @return the count of govOfficialContents
     */
    public Mono<Long> countByCriteria(GovOfficialContentCriteria criteria);

    /**
     * Returns the number of govOfficialContents available.
     * @return the number of entities in the database.
     *
     */
    Mono<Long> countAll();

    /**
     * Get the "id" govOfficialContent.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Mono<GovOfficialContentDTO> findOne(Long id);

    /**
     * Delete the "id" govOfficialContent.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    Mono<Void> delete(Long id);
}
