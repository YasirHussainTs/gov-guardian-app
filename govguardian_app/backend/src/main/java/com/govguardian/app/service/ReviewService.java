package com.govguardian.app.service;

import com.govguardian.app.domain.criteria.ReviewCriteria;
import com.govguardian.app.service.dto.ReviewDTO;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Interface for managing {@link com.govguardian.app.domain.Review}.
 */
public interface ReviewService {
    /**
     * Save a review.
     *
     * @param reviewDTO the entity to save.
     * @return the persisted entity.
     */
    Mono<ReviewDTO> save(ReviewDTO reviewDTO);

    /**
     * Updates a review.
     *
     * @param reviewDTO the entity to update.
     * @return the persisted entity.
     */
    Mono<ReviewDTO> update(ReviewDTO reviewDTO);

    /**
     * Partially updates a review.
     *
     * @param reviewDTO the entity to update partially.
     * @return the persisted entity.
     */
    Mono<ReviewDTO> partialUpdate(ReviewDTO reviewDTO);

    /**
     * Get all the reviews.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Flux<ReviewDTO> findAll(Pageable pageable);

    /**
     * Find reviews by criteria.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Flux<ReviewDTO> findByCriteria(ReviewCriteria criteria, Pageable pageable);

    /**
     * Find the count of reviews by criteria.
     * @param criteria filtering criteria
     * @return the count of reviews
     */
    public Mono<Long> countByCriteria(ReviewCriteria criteria);

    /**
     * Returns the number of reviews available.
     * @return the number of entities in the database.
     *
     */
    Mono<Long> countAll();

    /**
     * Get the "id" review.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Mono<ReviewDTO> findOne(Long id);

    /**
     * Delete the "id" review.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    Mono<Void> delete(Long id);
}
