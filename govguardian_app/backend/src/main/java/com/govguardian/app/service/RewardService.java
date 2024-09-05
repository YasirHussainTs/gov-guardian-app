package com.govguardian.app.service;

import com.govguardian.app.domain.criteria.RewardCriteria;
import com.govguardian.app.service.dto.RewardDTO;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Interface for managing {@link com.govguardian.app.domain.Reward}.
 */
public interface RewardService {
    /**
     * Save a reward.
     *
     * @param rewardDTO the entity to save.
     * @return the persisted entity.
     */
    Mono<RewardDTO> save(RewardDTO rewardDTO);

    /**
     * Updates a reward.
     *
     * @param rewardDTO the entity to update.
     * @return the persisted entity.
     */
    Mono<RewardDTO> update(RewardDTO rewardDTO);

    /**
     * Partially updates a reward.
     *
     * @param rewardDTO the entity to update partially.
     * @return the persisted entity.
     */
    Mono<RewardDTO> partialUpdate(RewardDTO rewardDTO);

    /**
     * Get all the rewards.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Flux<RewardDTO> findAll(Pageable pageable);

    /**
     * Find rewards by criteria.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Flux<RewardDTO> findByCriteria(RewardCriteria criteria, Pageable pageable);

    /**
     * Find the count of rewards by criteria.
     * @param criteria filtering criteria
     * @return the count of rewards
     */
    public Mono<Long> countByCriteria(RewardCriteria criteria);

    /**
     * Returns the number of rewards available.
     * @return the number of entities in the database.
     *
     */
    Mono<Long> countAll();

    /**
     * Get the "id" reward.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Mono<RewardDTO> findOne(Long id);

    /**
     * Delete the "id" reward.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    Mono<Void> delete(Long id);
}
