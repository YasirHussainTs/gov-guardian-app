package com.govguardian.app.repository;

import com.govguardian.app.domain.Reward;
import com.govguardian.app.domain.criteria.RewardCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the Reward entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RewardRepository extends ReactiveCrudRepository<Reward, Long>, RewardRepositoryInternal {
    Flux<Reward> findAllBy(Pageable pageable);

    @Override
    <S extends Reward> Mono<S> save(S entity);

    @Override
    Flux<Reward> findAll();

    @Override
    Mono<Reward> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface RewardRepositoryInternal {
    <S extends Reward> Mono<S> save(S entity);

    Flux<Reward> findAllBy(Pageable pageable);

    Flux<Reward> findAll();

    Mono<Reward> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<Reward> findAllBy(Pageable pageable, Criteria criteria);
    Flux<Reward> findByCriteria(RewardCriteria criteria, Pageable pageable);

    Mono<Long> countByCriteria(RewardCriteria criteria);
}
