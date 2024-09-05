package com.govguardian.app.repository;

import com.govguardian.app.domain.Review;
import com.govguardian.app.domain.criteria.ReviewCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the Review entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReviewRepository extends ReactiveCrudRepository<Review, Long>, ReviewRepositoryInternal {
    Flux<Review> findAllBy(Pageable pageable);

    @Override
    <S extends Review> Mono<S> save(S entity);

    @Override
    Flux<Review> findAll();

    @Override
    Mono<Review> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface ReviewRepositoryInternal {
    <S extends Review> Mono<S> save(S entity);

    Flux<Review> findAllBy(Pageable pageable);

    Flux<Review> findAll();

    Mono<Review> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<Review> findAllBy(Pageable pageable, Criteria criteria);
    Flux<Review> findByCriteria(ReviewCriteria criteria, Pageable pageable);

    Mono<Long> countByCriteria(ReviewCriteria criteria);
}
