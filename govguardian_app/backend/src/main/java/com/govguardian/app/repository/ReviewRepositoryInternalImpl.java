package com.govguardian.app.repository;

import com.govguardian.app.domain.Review;
import com.govguardian.app.domain.criteria.ReviewCriteria;
import com.govguardian.app.repository.rowmapper.ColumnConverter;
import com.govguardian.app.repository.rowmapper.ReviewRowMapper;
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
 * Spring Data R2DBC custom repository implementation for the Review entity.
 */
@SuppressWarnings("unused")
class ReviewRepositoryInternalImpl extends SimpleR2dbcRepository<Review, Long> implements ReviewRepositoryInternal {

    private final DatabaseClient db;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;
    private final EntityManager entityManager;

    private final ReviewRowMapper reviewMapper;
    private final ColumnConverter columnConverter;

    private static final Table entityTable = Table.aliased("review", EntityManager.ENTITY_ALIAS);

    public ReviewRepositoryInternalImpl(
        R2dbcEntityTemplate template,
        EntityManager entityManager,
        ReviewRowMapper reviewMapper,
        R2dbcEntityOperations entityOperations,
        R2dbcConverter converter,
        ColumnConverter columnConverter
    ) {
        super(
            new MappingRelationalEntityInformation(converter.getMappingContext().getRequiredPersistentEntity(Review.class)),
            entityOperations,
            converter
        );
        this.db = template.getDatabaseClient();
        this.r2dbcEntityTemplate = template;
        this.entityManager = entityManager;
        this.reviewMapper = reviewMapper;
        this.columnConverter = columnConverter;
    }

    @Override
    public Flux<Review> findAllBy(Pageable pageable) {
        return createQuery(pageable, null).all();
    }

    RowsFetchSpec<Review> createQuery(Pageable pageable, Condition whereClause) {
        List<Expression> columns = ReviewSqlHelper.getColumns(entityTable, EntityManager.ENTITY_ALIAS);
        SelectFromAndJoin selectFrom = Select.builder().select(columns).from(entityTable);
        // we do not support Criteria here for now as of https://github.com/jhipster/generator-jhipster/issues/18269
        String select = entityManager.createSelect(selectFrom, Review.class, pageable, whereClause);
        return db.sql(select).map(this::process);
    }

    @Override
    public Flux<Review> findAll() {
        return findAllBy(null);
    }

    @Override
    public Mono<Review> findById(Long id) {
        Comparison whereClause = Conditions.isEqual(entityTable.column("id"), Conditions.just(id.toString()));
        return createQuery(null, whereClause).one();
    }

    private Review process(Row row, RowMetadata metadata) {
        Review entity = reviewMapper.apply(row, "e");
        return entity;
    }

    @Override
    public <S extends Review> Mono<S> save(S entity) {
        return super.save(entity);
    }

    @Override
    public Flux<Review> findByCriteria(ReviewCriteria reviewCriteria, Pageable page) {
        return createQuery(page, buildConditions(reviewCriteria)).all();
    }

    @Override
    public Mono<Long> countByCriteria(ReviewCriteria criteria) {
        return findByCriteria(criteria, null)
            .collectList()
            .map(collectedList -> collectedList != null ? (long) collectedList.size() : (long) 0);
    }

    private Condition buildConditions(ReviewCriteria criteria) {
        ConditionBuilder builder = new ConditionBuilder(this.columnConverter);
        List<Condition> allConditions = new ArrayList<Condition>();
        if (criteria != null) {
            if (criteria.getId() != null) {
                builder.buildFilterConditionForField(criteria.getId(), entityTable.column("id"));
            }
            if (criteria.getContent() != null) {
                builder.buildFilterConditionForField(criteria.getContent(), entityTable.column("content"));
            }
            if (criteria.getRating() != null) {
                builder.buildFilterConditionForField(criteria.getRating(), entityTable.column("rating"));
            }
            if (criteria.getFeedback() != null) {
                builder.buildFilterConditionForField(criteria.getFeedback(), entityTable.column("feedback"));
            }
            if (criteria.getTimestamp() != null) {
                builder.buildFilterConditionForField(criteria.getTimestamp(), entityTable.column("timestamp"));
            }
        }
        return builder.buildConditions();
    }
}
