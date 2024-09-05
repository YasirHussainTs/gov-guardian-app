package com.govguardian.app.repository;

import com.govguardian.app.domain.GovOfficialContent;
import com.govguardian.app.domain.criteria.GovOfficialContentCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the GovOfficialContent entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GovOfficialContentRepository
    extends ReactiveCrudRepository<GovOfficialContent, Long>, GovOfficialContentRepositoryInternal {
    Flux<GovOfficialContent> findAllBy(Pageable pageable);

    @Override
    <S extends GovOfficialContent> Mono<S> save(S entity);

    @Override
    Flux<GovOfficialContent> findAll();

    @Override
    Mono<GovOfficialContent> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface GovOfficialContentRepositoryInternal {
    <S extends GovOfficialContent> Mono<S> save(S entity);

    Flux<GovOfficialContent> findAllBy(Pageable pageable);

    Flux<GovOfficialContent> findAll();

    Mono<GovOfficialContent> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<GovOfficialContent> findAllBy(Pageable pageable, Criteria criteria);
    Flux<GovOfficialContent> findByCriteria(GovOfficialContentCriteria criteria, Pageable pageable);

    Mono<Long> countByCriteria(GovOfficialContentCriteria criteria);
}
