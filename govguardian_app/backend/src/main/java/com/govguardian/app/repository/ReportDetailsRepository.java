package com.govguardian.app.repository;

import com.govguardian.app.domain.ReportDetails;
import com.govguardian.app.domain.criteria.ReportDetailsCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the ReportDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReportDetailsRepository extends ReactiveCrudRepository<ReportDetails, Long>, ReportDetailsRepositoryInternal {
    Flux<ReportDetails> findAllBy(Pageable pageable);

    @Query("SELECT * FROM report_details entity WHERE entity.app_user_id = :id")
    Flux<ReportDetails> findByAppUser(Long id);

    @Query("SELECT * FROM report_details entity WHERE entity.app_user_id IS NULL")
    Flux<ReportDetails> findAllWhereAppUserIsNull();

    @Override
    <S extends ReportDetails> Mono<S> save(S entity);

    @Override
    Flux<ReportDetails> findAll();

    @Override
    Mono<ReportDetails> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface ReportDetailsRepositoryInternal {
    <S extends ReportDetails> Mono<S> save(S entity);

    Flux<ReportDetails> findAllBy(Pageable pageable);

    Flux<ReportDetails> findAll();

    Mono<ReportDetails> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<ReportDetails> findAllBy(Pageable pageable, Criteria criteria);
    Flux<ReportDetails> findByCriteria(ReportDetailsCriteria criteria, Pageable pageable);

    Mono<Long> countByCriteria(ReportDetailsCriteria criteria);
}
