package com.govguardian.app.repository;

import com.govguardian.app.domain.AppUser;
import com.govguardian.app.domain.criteria.AppUserCriteria;
import com.govguardian.app.repository.rowmapper.AppUserRowMapper;
import com.govguardian.app.repository.rowmapper.ColumnConverter;
import com.govguardian.app.repository.rowmapper.GovOfficialContentRowMapper;
import com.govguardian.app.repository.rowmapper.ReviewRowMapper;
import com.govguardian.app.repository.rowmapper.RewardRowMapper;
import com.govguardian.app.repository.rowmapper.UserRowMapper;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.convert.R2dbcConverter;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.support.SimpleR2dbcRepository;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Comparison;
import org.springframework.data.relational.core.sql.Condition;
import org.springframework.data.relational.core.sql.Conditions;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Select;
import org.springframework.data.relational.core.sql.SelectBuilder.SelectFromAndJoinCondition;
import org.springframework.data.relational.core.sql.Table;
import org.springframework.data.relational.repository.support.MappingRelationalEntityInformation;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.r2dbc.core.RowsFetchSpec;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.service.ConditionBuilder;

/**
 * Spring Data R2DBC custom repository implementation for the AppUser entity.
 */
@SuppressWarnings("unused")
class AppUserRepositoryInternalImpl extends SimpleR2dbcRepository<AppUser, Long> implements AppUserRepositoryInternal {

    private final DatabaseClient db;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;
    private final EntityManager entityManager;

    private final UserRowMapper userMapper;
    private final ReviewRowMapper reviewMapper;
    private final RewardRowMapper rewardMapper;
    private final GovOfficialContentRowMapper govofficialcontentMapper;
    private final AppUserRowMapper appuserMapper;
    private final ColumnConverter columnConverter;

    private static final Table entityTable = Table.aliased("app_user", EntityManager.ENTITY_ALIAS);
    private static final Table userTable = Table.aliased("jhi_user", "e_user");
    private static final Table reviewsTable = Table.aliased("review", "reviews");
    private static final Table rewardsTable = Table.aliased("reward", "rewards");
    private static final Table govOfficialContentTable = Table.aliased("gov_official_content", "govOfficialContent");

    public AppUserRepositoryInternalImpl(
        R2dbcEntityTemplate template,
        EntityManager entityManager,
        UserRowMapper userMapper,
        ReviewRowMapper reviewMapper,
        RewardRowMapper rewardMapper,
        GovOfficialContentRowMapper govofficialcontentMapper,
        AppUserRowMapper appuserMapper,
        R2dbcEntityOperations entityOperations,
        R2dbcConverter converter,
        ColumnConverter columnConverter
    ) {
        super(
            new MappingRelationalEntityInformation(converter.getMappingContext().getRequiredPersistentEntity(AppUser.class)),
            entityOperations,
            converter
        );
        this.db = template.getDatabaseClient();
        this.r2dbcEntityTemplate = template;
        this.entityManager = entityManager;
        this.userMapper = userMapper;
        this.reviewMapper = reviewMapper;
        this.rewardMapper = rewardMapper;
        this.govofficialcontentMapper = govofficialcontentMapper;
        this.appuserMapper = appuserMapper;
        this.columnConverter = columnConverter;
    }

    @Override
    public Flux<AppUser> findAllBy(Pageable pageable) {
        return createQuery(pageable, null).all();
    }

    RowsFetchSpec<AppUser> createQuery(Pageable pageable, Condition whereClause) {
        List<Expression> columns = AppUserSqlHelper.getColumns(entityTable, EntityManager.ENTITY_ALIAS);
        columns.addAll(UserSqlHelper.getColumns(userTable, "user"));
        columns.addAll(ReviewSqlHelper.getColumns(reviewsTable, "reviews"));
        columns.addAll(RewardSqlHelper.getColumns(rewardsTable, "rewards"));
        columns.addAll(GovOfficialContentSqlHelper.getColumns(govOfficialContentTable, "govOfficialContent"));
        SelectFromAndJoinCondition selectFrom = Select
            .builder()
            .select(columns)
            .from(entityTable)
            .leftOuterJoin(userTable)
            .on(Column.create("user_id", entityTable))
            .equals(Column.create("id", userTable))
            .leftOuterJoin(reviewsTable)
            .on(Column.create("reviews_id", entityTable))
            .equals(Column.create("id", reviewsTable))
            .leftOuterJoin(rewardsTable)
            .on(Column.create("rewards_id", entityTable))
            .equals(Column.create("id", rewardsTable))
            .leftOuterJoin(govOfficialContentTable)
            .on(Column.create("gov_official_content_id", entityTable))
            .equals(Column.create("id", govOfficialContentTable));
        // we do not support Criteria here for now as of https://github.com/jhipster/generator-jhipster/issues/18269
        String select = entityManager.createSelect(selectFrom, AppUser.class, pageable, whereClause);
        return db.sql(select).map(this::process);
    }

    @Override
    public Flux<AppUser> findAll() {
        return findAllBy(null);
    }

    @Override
    public Mono<AppUser> findById(Long id) {
        Comparison whereClause = Conditions.isEqual(entityTable.column("id"), Conditions.just(id.toString()));
        return createQuery(null, whereClause).one();
    }

    private AppUser process(Row row, RowMetadata metadata) {
        AppUser entity = appuserMapper.apply(row, "e");
        entity.setUser(userMapper.apply(row, "user"));
        entity.setReviews(reviewMapper.apply(row, "reviews"));
        entity.setRewards(rewardMapper.apply(row, "rewards"));
        entity.setGovOfficialContent(govofficialcontentMapper.apply(row, "govOfficialContent"));
        return entity;
    }

    @Override
    public <S extends AppUser> Mono<S> save(S entity) {
        return super.save(entity);
    }

    @Override
    public Flux<AppUser> findByCriteria(AppUserCriteria appUserCriteria, Pageable page) {
        return createQuery(page, buildConditions(appUserCriteria)).all();
    }

    @Override
    public Mono<Long> countByCriteria(AppUserCriteria criteria) {
        return findByCriteria(criteria, null)
            .collectList()
            .map(collectedList -> collectedList != null ? (long) collectedList.size() : (long) 0);
    }

    private Condition buildConditions(AppUserCriteria criteria) {
        ConditionBuilder builder = new ConditionBuilder(this.columnConverter);
        List<Condition> allConditions = new ArrayList<Condition>();
        if (criteria != null) {
            if (criteria.getId() != null) {
                builder.buildFilterConditionForField(criteria.getId(), entityTable.column("id"));
            }
            if (criteria.getEmail() != null) {
                builder.buildFilterConditionForField(criteria.getEmail(), entityTable.column("email"));
            }
            if (criteria.getAddress() != null) {
                builder.buildFilterConditionForField(criteria.getAddress(), entityTable.column("address"));
            }
            if (criteria.getPhone() != null) {
                builder.buildFilterConditionForField(criteria.getPhone(), entityTable.column("phone"));
            }
            if (criteria.getGender() != null) {
                builder.buildFilterConditionForField(criteria.getGender(), entityTable.column("gender"));
            }
            if (criteria.getDepartment() != null) {
                builder.buildFilterConditionForField(criteria.getDepartment(), entityTable.column("department"));
            }
            if (criteria.getDescription() != null) {
                builder.buildFilterConditionForField(criteria.getDescription(), entityTable.column("description"));
            }
            if (criteria.getLatitude() != null) {
                builder.buildFilterConditionForField(criteria.getLatitude(), entityTable.column("latitude"));
            }
            if (criteria.getLongitude() != null) {
                builder.buildFilterConditionForField(criteria.getLongitude(), entityTable.column("longitude"));
            }
            if (criteria.getUserType() != null) {
                builder.buildFilterConditionForField(criteria.getUserType(), entityTable.column("user_type"));
            }
            if (criteria.getUserId() != null) {
                builder.buildFilterConditionForField(criteria.getUserId(), userTable.column("id"));
            }
            if (criteria.getReviewsId() != null) {
                builder.buildFilterConditionForField(criteria.getReviewsId(), reviewsTable.column("id"));
            }
            if (criteria.getRewardsId() != null) {
                builder.buildFilterConditionForField(criteria.getRewardsId(), rewardsTable.column("id"));
            }
            if (criteria.getGovOfficialContentId() != null) {
                builder.buildFilterConditionForField(criteria.getGovOfficialContentId(), govOfficialContentTable.column("id"));
            }
        }
        return builder.buildConditions();
    }
}
