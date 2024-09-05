package com.govguardian.app.repository.rowmapper;

import com.govguardian.app.domain.ReportHeader;
import io.r2dbc.spi.Row;
import java.time.ZonedDateTime;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link ReportHeader}, with proper type conversions.
 */
@Service
public class ReportHeaderRowMapper implements BiFunction<Row, String, ReportHeader> {

    private final ColumnConverter converter;

    public ReportHeaderRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link ReportHeader} stored in the database.
     */
    @Override
    public ReportHeader apply(Row row, String prefix) {
        ReportHeader entity = new ReportHeader();
        entity.setId(converter.fromRow(row, prefix + "_id", String.class));
        entity.setDescription(converter.fromRow(row, prefix + "_description", String.class));
        entity.setTitle(converter.fromRow(row, prefix + "_title", String.class));
        entity.setTimestamp(converter.fromRow(row, prefix + "_timestamp", ZonedDateTime.class));
        entity.setStatus(converter.fromRow(row, prefix + "_status", String.class));
        entity.setAppUserId(converter.fromRow(row, prefix + "_app_user_id", Long.class));
        return entity;
    }
}
