package com.govguardian.app.service.impl;

import com.govguardian.app.domain.criteria.RewardCriteria;
import com.govguardian.app.repository.RewardRepository;
import com.govguardian.app.service.RewardService;
import com.govguardian.app.service.dto.RewardDTO;
import com.govguardian.app.service.mapper.RewardMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Implementation for managing {@link com.govguardian.app.domain.Reward}.
 */
@Service
@Transactional
public class RewardServiceImpl implements RewardService {

    private final Logger log = LoggerFactory.getLogger(RewardServiceImpl.class);

    private final RewardRepository rewardRepository;

    private final RewardMapper rewardMapper;

    public RewardServiceImpl(RewardRepository rewardRepository, RewardMapper rewardMapper) {
        this.rewardRepository = rewardRepository;
        this.rewardMapper = rewardMapper;
    }

    @Override
    public Mono<RewardDTO> save(RewardDTO rewardDTO) {
        log.debug("Request to save Reward : {}", rewardDTO);
        return rewardRepository.save(rewardMapper.toEntity(rewardDTO)).map(rewardMapper::toDto);
    }

    @Override
    public Mono<RewardDTO> update(RewardDTO rewardDTO) {
        log.debug("Request to update Reward : {}", rewardDTO);
        return rewardRepository.save(rewardMapper.toEntity(rewardDTO)).map(rewardMapper::toDto);
    }

    @Override
    public Mono<RewardDTO> partialUpdate(RewardDTO rewardDTO) {
        log.debug("Request to partially update Reward : {}", rewardDTO);

        return rewardRepository
            .findById(rewardDTO.getId())
            .map(existingReward -> {
                rewardMapper.partialUpdate(existingReward, rewardDTO);

                return existingReward;
            })
            .flatMap(rewardRepository::save)
            .map(rewardMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<RewardDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Rewards");
        return rewardRepository.findAllBy(pageable).map(rewardMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<RewardDTO> findByCriteria(RewardCriteria criteria, Pageable pageable) {
        log.debug("Request to get all Rewards by Criteria");
        return rewardRepository.findByCriteria(criteria, pageable).map(rewardMapper::toDto);
    }

    /**
     * Find the count of rewards by criteria.
     * @param criteria filtering criteria
     * @return the count of rewards
     */
    public Mono<Long> countByCriteria(RewardCriteria criteria) {
        log.debug("Request to get the count of all Rewards by Criteria");
        return rewardRepository.countByCriteria(criteria);
    }

    public Mono<Long> countAll() {
        return rewardRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<RewardDTO> findOne(Long id) {
        log.debug("Request to get Reward : {}", id);
        return rewardRepository.findById(id).map(rewardMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete Reward : {}", id);
        return rewardRepository.deleteById(id);
    }
}
