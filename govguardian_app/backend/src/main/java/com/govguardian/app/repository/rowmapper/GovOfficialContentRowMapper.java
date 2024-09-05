package com.govguardian.app.repository.rowmapper;

import com.govguardian.app.domain.GovOfficialContent;
import io.r2dbc.spi.Row;
import java.time.ZonedDateTime;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link GovOfficialContent}, with proper type conversions.
 */
@Service
public class GovOfficialContentRowMapper implements BiFunction<Row, String, GovOfficialContent> {

    private final ColumnConverter converter;

    public GovOfficialContentRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link GovOfficialContent} stored in the database.
     */
    @Override
    public GovOfficialContent apply(Row row, String prefix) {
        GovOfficialContent entity = new GovOfficialContent();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setLaw(converter.fromRow(row, prefix + "_law", String.class));
        entity.setDescription(converter.fromRow(row, prefix + "_description", String.class));
        entity.setAction(converter.fromRow(row, prefix + "_action", String.class));
        entity.setDate(converter.fromRow(row, prefix + "_date", ZonedDateTime.class));
        return entity;
    }
}
