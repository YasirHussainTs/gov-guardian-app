package com.govguardian.app.repository;

import com.govguardian.app.domain.GovOfficialContent;
import com.govguardian.app.domain.criteria.GovOfficialContentCriteria;
import com.govguardian.app.repository.rowmapper.ColumnConverter;
import com.govguardian.app.repository.rowmapper.GovOfficialContentRowMapper;
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
 * Spring Data R2DBC custom repository implementation for the GovOfficialContent entity.
 */
@SuppressWarnings("unused")
class GovOfficialContentRepositoryInternalImpl
    extends SimpleR2dbcRepository<GovOfficialContent, Long>
    implements GovOfficialContentRepositoryInternal {

    private final DatabaseClient db;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;
    private final EntityManager entityManager;

    private final GovOfficialContentRowMapper govofficialcontentMapper;
    private final ColumnConverter columnConverter;

    private static final Table entityTable = Table.aliased("gov_official_content", EntityManager.ENTITY_ALIAS);

    public GovOfficialContentRepositoryInternalImpl(
        R2dbcEntityTemplate template,
        EntityManager entityManager,
        GovOfficialContentRowMapper govofficialcontentMapper,
        R2dbcEntityOperations entityOperations,
        R2dbcConverter converter,
        ColumnConverter columnConverter
    ) {
        super(
            new MappingRelationalEntityInformation(converter.getMappingContext().getRequiredPersistentEntity(GovOfficialContent.class)),
            entityOperations,
            converter
        );
        this.db = template.getDatabaseClient();
        this.r2dbcEntityTemplate = template;
        this.entityManager = entityManager;
        this.govofficialcontentMapper = govofficialcontentMapper;
        this.columnConverter = columnConverter;
    }

    @Override
    public Flux<GovOfficialContent> findAllBy(Pageable pageable) {
        return createQuery(pageable, null).all();
    }

    RowsFetchSpec<GovOfficialContent> createQuery(Pageable pageable, Condition whereClause) {
        List<Expression> columns = GovOfficialContentSqlHelper.getColumns(entityTable, EntityManager.ENTITY_ALIAS);
        SelectFromAndJoin selectFrom = Select.builder().select(columns).from(entityTable);
        // we do not support Criteria here for now as of https://github.com/jhipster/generator-jhipster/issues/18269
        String select = entityManager.createSelect(selectFrom, GovOfficialContent.class, pageable, whereClause);
        return db.sql(select).map(this::process);
    }

    @Override
    public Flux<GovOfficialContent> findAll() {
        return findAllBy(null);
    }

    @Override
    public Mono<GovOfficialContent> findById(Long id) {
        Comparison whereClause = Conditions.isEqual(entityTable.column("id"), Conditions.just(id.toString()));
        return createQuery(null, whereClause).one();
    }

    private GovOfficialContent process(Row row, RowMetadata metadata) {
        GovOfficialContent entity = govofficialcontentMapper.apply(row, "e");
        return entity;
    }

    @Override
    public <S extends GovOfficialContent> Mono<S> save(S entity) {
        return super.save(entity);
    }

    @Override
    public Flux<GovOfficialContent> findByCriteria(GovOfficialContentCriteria govOfficialContentCriteria, Pageable page) {
        return createQuery(page, buildConditions(govOfficialContentCriteria)).all();
    }

    @Override
    public Mono<Long> countByCriteria(GovOfficialContentCriteria criteria) {
        return findByCriteria(criteria, null)
            .collectList()
            .map(collectedList -> collectedList != null ? (long) collectedList.size() : (long) 0);
    }

    private Condition buildConditions(GovOfficialContentCriteria criteria) {
        ConditionBuilder builder = new ConditionBuilder(this.columnConverter);
        List<Condition> allConditions = new ArrayList<Condition>();
        if (criteria != null) {
            if (criteria.getId() != null) {
                builder.buildFilterConditionForField(criteria.getId(), entityTable.column("id"));
            }
            if (criteria.getLaw() != null) {
                builder.buildFilterConditionForField(criteria.getLaw(), entityTable.column("law"));
            }
            if (criteria.getDescription() != null) {
                builder.buildFilterConditionForField(criteria.getDescription(), entityTable.column("description"));
            }
            if (criteria.getAction() != null) {
                builder.buildFilterConditionForField(criteria.getAction(), entityTable.column("action"));
            }
            if (criteria.getDate() != null) {
                builder.buildFilterConditionForField(criteria.getDate(), entityTable.column("date"));
            }
        }
        return builder.buildConditions();
    }
}
