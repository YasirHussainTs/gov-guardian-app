package com.govguardian.app.repository;

import com.govguardian.app.domain.ReportDetails;
import com.govguardian.app.domain.criteria.ReportDetailsCriteria;
import com.govguardian.app.repository.rowmapper.AppUserRowMapper;
import com.govguardian.app.repository.rowmapper.ColumnConverter;
import com.govguardian.app.repository.rowmapper.ReportDetailsRowMapper;
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
 * Spring Data R2DBC custom repository implementation for the ReportDetails entity.
 */
@SuppressWarnings("unused")
class ReportDetailsRepositoryInternalImpl extends SimpleR2dbcRepository<ReportDetails, Long> implements ReportDetailsRepositoryInternal {

    private final DatabaseClient db;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;
    private final EntityManager entityManager;

    private final AppUserRowMapper appuserMapper;
    private final ReportDetailsRowMapper reportdetailsMapper;
    private final ColumnConverter columnConverter;

    private static final Table entityTable = Table.aliased("report_details", EntityManager.ENTITY_ALIAS);
    private static final Table appUserTable = Table.aliased("app_user", "appUser");

    public ReportDetailsRepositoryInternalImpl(
        R2dbcEntityTemplate template,
        EntityManager entityManager,
        AppUserRowMapper appuserMapper,
        ReportDetailsRowMapper reportdetailsMapper,
        R2dbcEntityOperations entityOperations,
        R2dbcConverter converter,
        ColumnConverter columnConverter
    ) {
        super(
            new MappingRelationalEntityInformation(converter.getMappingContext().getRequiredPersistentEntity(ReportDetails.class)),
            entityOperations,
            converter
        );
        this.db = template.getDatabaseClient();
        this.r2dbcEntityTemplate = template;
        this.entityManager = entityManager;
        this.appuserMapper = appuserMapper;
        this.reportdetailsMapper = reportdetailsMapper;
        this.columnConverter = columnConverter;
    }

    @Override
    public Flux<ReportDetails> findAllBy(Pageable pageable) {
        return createQuery(pageable, null).all();
    }

    RowsFetchSpec<ReportDetails> createQuery(Pageable pageable, Condition whereClause) {
        List<Expression> columns = ReportDetailsSqlHelper.getColumns(entityTable, EntityManager.ENTITY_ALIAS);
        columns.addAll(AppUserSqlHelper.getColumns(appUserTable, "appUser"));
        SelectFromAndJoinCondition selectFrom = Select
            .builder()
            .select(columns)
            .from(entityTable)
            .leftOuterJoin(appUserTable)
            .on(Column.create("app_user_id", entityTable))
            .equals(Column.create("id", appUserTable));
        // we do not support Criteria here for now as of https://github.com/jhipster/generator-jhipster/issues/18269
        String select = entityManager.createSelect(selectFrom, ReportDetails.class, pageable, whereClause);
        return db.sql(select).map(this::process);
    }

    @Override
    public Flux<ReportDetails> findAll() {
        return findAllBy(null);
    }

    @Override
    public Mono<ReportDetails> findById(Long id) {
        Comparison whereClause = Conditions.isEqual(entityTable.column("id"), Conditions.just(id.toString()));
        return createQuery(null, whereClause).one();
    }

    private ReportDetails process(Row row, RowMetadata metadata) {
        ReportDetails entity = reportdetailsMapper.apply(row, "e");
        entity.setAppUser(appuserMapper.apply(row, "appUser"));
        return entity;
    }

    @Override
    public <S extends ReportDetails> Mono<S> save(S entity) {
        return super.save(entity);
    }

    @Override
    public Flux<ReportDetails> findByCriteria(ReportDetailsCriteria reportDetailsCriteria, Pageable page) {
        return createQuery(page, buildConditions(reportDetailsCriteria)).all();
    }

    @Override
    public Mono<Long> countByCriteria(ReportDetailsCriteria criteria) {
        return findByCriteria(criteria, null)
            .collectList()
            .map(collectedList -> collectedList != null ? (long) collectedList.size() : (long) 0);
    }

    private Condition buildConditions(ReportDetailsCriteria criteria) {
        ConditionBuilder builder = new ConditionBuilder(this.columnConverter);
        List<Condition> allConditions = new ArrayList<Condition>();
        if (criteria != null) {
            if (criteria.getId() != null) {
                builder.buildFilterConditionForField(criteria.getId(), entityTable.column("id"));
            }
            if (criteria.getOwner() != null) {
                builder.buildFilterConditionForField(criteria.getOwner(), entityTable.column("owner"));
            }
            if (criteria.getResponder() != null) {
                builder.buildFilterConditionForField(criteria.getResponder(), entityTable.column("responder"));
            }
            if (criteria.getDescription() != null) {
                builder.buildFilterConditionForField(criteria.getDescription(), entityTable.column("description"));
            }
            if (criteria.getTitle() != null) {
                builder.buildFilterConditionForField(criteria.getTitle(), entityTable.column("title"));
            }
            if (criteria.getTimestamp() != null) {
                builder.buildFilterConditionForField(criteria.getTimestamp(), entityTable.column("timestamp"));
            }
            if (criteria.getStatus() != null) {
                builder.buildFilterConditionForField(criteria.getStatus(), entityTable.column("status"));
            }
            if (criteria.getAppUserId() != null) {
                builder.buildFilterConditionForField(criteria.getAppUserId(), appUserTable.column("id"));
            }
        }
        return builder.buildConditions();
    }
}
