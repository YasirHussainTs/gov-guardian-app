package com.govguardian.app.repository;

import com.govguardian.app.domain.ReportHeader;
import com.govguardian.app.domain.criteria.ReportHeaderCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the ReportHeader entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReportHeaderRepository extends ReactiveCrudRepository<ReportHeader, String>, ReportHeaderRepositoryInternal {
    Flux<ReportHeader> findAllBy(Pageable pageable);

    @Query("SELECT * FROM report_header entity WHERE entity.app_user_id = :id")
    Flux<ReportHeader> findByAppUser(String id);

    @Query("SELECT * FROM report_header entity WHERE entity.app_user_id IS NULL")
    Flux<ReportHeader> findAllWhereAppUserIsNull();

    @Override
    <S extends ReportHeader> Mono<S> save(S entity);

    @Override
    Flux<ReportHeader> findAll();

    @Override
    Mono<ReportHeader> findById(String id);

    @Override
    Mono<Void> deleteById(String id);
}

interface ReportHeaderRepositoryInternal {
    <S extends ReportHeader> Mono<S> save(S entity);

    Flux<ReportHeader> findAllBy(Pageable pageable);

    Flux<ReportHeader> findAll();

    Mono<ReportHeader> findById(String id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<ReportHeader> findAllBy(Pageable pageable, Criteria criteria);
    Flux<ReportHeader> findByCriteria(ReportHeaderCriteria criteria, Pageable pageable);

    Mono<Long> countByCriteria(ReportHeaderCriteria criteria);
}
