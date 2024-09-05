package com.govguardian.app.repository.rowmapper;

import com.govguardian.app.domain.Reward;
import io.r2dbc.spi.Row;
import java.time.ZonedDateTime;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link Reward}, with proper type conversions.
 */
@Service
public class RewardRowMapper implements BiFunction<Row, String, Reward> {

    private final ColumnConverter converter;

    public RewardRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link Reward} stored in the database.
     */
    @Override
    public Reward apply(Row row, String prefix) {
        Reward entity = new Reward();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setDescription(converter.fromRow(row, prefix + "_description", String.class));
        entity.setPoints(converter.fromRow(row, prefix + "_points", Integer.class));
        entity.setTimestamp(converter.fromRow(row, prefix + "_timestamp", ZonedDateTime.class));
        return entity;
    }
}
