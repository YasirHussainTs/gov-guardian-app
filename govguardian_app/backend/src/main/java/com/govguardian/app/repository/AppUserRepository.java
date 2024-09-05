package com.govguardian.app.repository;

import com.govguardian.app.domain.AppUser;
import com.govguardian.app.domain.criteria.AppUserCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the AppUser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AppUserRepository extends ReactiveCrudRepository<AppUser, Long>, AppUserRepositoryInternal {
    Flux<AppUser> findAllBy(Pageable pageable);

    @Query("SELECT * FROM app_user entity WHERE entity.user_id = :id")
    Flux<AppUser> findByUser(Long id);

    @Query("SELECT * FROM app_user entity WHERE entity.user_id IS NULL")
    Flux<AppUser> findAllWhereUserIsNull();

    @Query("SELECT * FROM app_user entity WHERE entity.reviews_id = :id")
    Flux<AppUser> findByReviews(Long id);

    @Query("SELECT * FROM app_user entity WHERE entity.reviews_id IS NULL")
    Flux<AppUser> findAllWhereReviewsIsNull();

    @Query("SELECT * FROM app_user entity WHERE entity.rewards_id = :id")
    Flux<AppUser> findByRewards(Long id);

    @Query("SELECT * FROM app_user entity WHERE entity.rewards_id IS NULL")
    Flux<AppUser> findAllWhereRewardsIsNull();

    @Query("SELECT * FROM app_user entity WHERE entity.gov_official_content_id = :id")
    Flux<AppUser> findByGovOfficialContent(Long id);

    @Query("SELECT * FROM app_user entity WHERE entity.gov_official_content_id IS NULL")
    Flux<AppUser> findAllWhereGovOfficialContentIsNull();

    @Override
    <S extends AppUser> Mono<S> save(S entity);

    @Override
    Flux<AppUser> findAll();

    @Override
    Mono<AppUser> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface AppUserRepositoryInternal {
    <S extends AppUser> Mono<S> save(S entity);

    Flux<AppUser> findAllBy(Pageable pageable);

    Flux<AppUser> findAll();

    Mono<AppUser> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<AppUser> findAllBy(Pageable pageable, Criteria criteria);
    Flux<AppUser> findByCriteria(AppUserCriteria criteria, Pageable pageable);

    Mono<Long> countByCriteria(AppUserCriteria criteria);
}
