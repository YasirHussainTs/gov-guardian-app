package com.govguardian.app.repository;

import com.govguardian.app.domain.Reward;
import com.govguardian.app.domain.criteria.RewardCriteria;
import com.govguardian.app.repository.rowmapper.ColumnConverter;
import com.govguardian.app.repository.rowmapper.RewardRowMapper;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.convert.R2dbcConverter;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.support.SimpleR2dbcRepository;
import org.springframework.data.relational.core.sql.Comparison;
import org.springframework.data.relational.core.sql.Condition;
import org.springframework.data.relational.core.sql.Conditions;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Select;
import org.springframework.data.relational.core.sql.SelectBuilder.SelectFromAndJoin;
import org.springframework.data.relational.core.sql.Table;
import org.springframework.data.relational.repository.support.MappingRelationalEntityInformation;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.r2dbc.core.RowsFetchSpec;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.service.ConditionBuilder;

/**
 * Spring Data R2DBC custom repository implementation for the Reward entity.
 */
@SuppressWarnings("unused")
class RewardRepositoryInternalImpl extends SimpleR2dbcRepository<Reward, Long> implements RewardRepositoryInternal {

    private final DatabaseClient db;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;
    private final EntityManager entityManager;

    private final RewardRowMapper rewardMapper;
    private final ColumnConverter columnConverter;

    private static final Table entityTable = Table.aliased("reward", EntityManager.ENTITY_ALIAS);

    public RewardRepositoryInternalImpl(
        R2dbcEntityTemplate template,
        EntityManager entityManager,
        RewardRowMapper rewardMapper,
        R2dbcEntityOperations entityOperations,
        R2dbcConverter converter,
        ColumnConverter columnConverter
    ) {
        super(
            new MappingRelationalEntityInformation(converter.getMappingContext().getRequiredPersistentEntity(Reward.class)),
            entityOperations,
            converter
        );
        this.db = template.getDatabaseClient();
        this.r2dbcEntityTemplate = template;
        this.entityManager = entityManager;
        this.rewardMapper = rewardMapper;
        this.columnConverter = columnConverter;
    }

    @Override
    public Flux<Reward> findAllBy(Pageable pageable) {
        return createQuery(pageable, null).all();
    }

    RowsFetchSpec<Reward> createQuery(Pageable pageable, Condition whereClause) {
        List<Expression> columns = RewardSqlHelper.getColumns(entityTable, EntityManager.ENTITY_ALIAS);
        SelectFromAndJoin selectFrom = Select.builder().select(columns).from(entityTable);
        // we do not support Criteria here for now as of https://github.com/jhipster/generator-jhipster/issues/18269
        String select = entityManager.createSelect(selectFrom, Reward.class, pageable, whereClause);
        return db.sql(select).map(this::process);
    }

    @Override
    public Flux<Reward> findAll() {
        return findAllBy(null);
    }

    @Override
    public Mono<Reward> findById(Long id) {
        Comparison whereClause = Conditions.isEqual(entityTable.column("id"), Conditions.just(id.toString()));
        return createQuery(null, whereClause).one();
    }

    private Reward process(Row row, RowMetadata metadata) {
        Reward entity = rewardMapper.apply(row, "e");
        return entity;
    }

    @Override
    public <S extends Reward> Mono<S> save(S entity) {
        return super.save(entity);
    }

    @Override
    public Flux<Reward> findByCriteria(RewardCriteria rewardCriteria, Pageable page) {
        return createQuery(page, buildConditions(rewardCriteria)).all();
    }

    @Override
    public Mono<Long> countByCriteria(RewardCriteria criteria) {
        return findByCriteria(criteria, null)
            .collectList()
            .map(collectedList -> collectedList != null ? (long) collectedList.size() : (long) 0);
    }

    private Condition buildConditions(RewardCriteria criteria) {
        ConditionBuilder builder = new ConditionBuilder(this.columnConverter);
        List<Condition> allConditions = new ArrayList<Condition>();
        if (criteria != null) {
            if (criteria.getId() != null) {
                builder.buildFilterConditionForField(criteria.getId(), entityTable.column("id"));
            }
            if (criteria.getDescription() != null) {
                builder.buildFilterConditionForField(criteria.getDescription(), entityTable.column("description"));
            }
            if (criteria.getPoints() != null) {
                builder.buildFilterConditionForField(criteria.getPoints(), entityTable.column("points"));
            }
            if (criteria.getTimestamp() != null) {
                builder.buildFilterConditionForField(criteria.getTimestamp(), entityTable.column("timestamp"));
            }
        }
        return builder.buildConditions();
    }
}
