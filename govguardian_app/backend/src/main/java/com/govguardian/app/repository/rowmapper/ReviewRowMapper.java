package com.govguardian.app.repository.rowmapper;

import com.govguardian.app.domain.Review;
import io.r2dbc.spi.Row;
import java.time.ZonedDateTime;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link Review}, with proper type conversions.
 */
@Service
public class ReviewRowMapper implements BiFunction<Row, String, Review> {

    private final ColumnConverter converter;

    public ReviewRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link Review} stored in the database.
     */
    @Override
    public Review apply(Row row, String prefix) {
        Review entity = new Review();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setContent(converter.fromRow(row, prefix + "_content", String.class));
        entity.setRating(converter.fromRow(row, prefix + "_rating", Integer.class));
        entity.setFeedback(converter.fromRow(row, prefix + "_feedback", String.class));
        entity.setTimestamp(converter.fromRow(row, prefix + "_timestamp", ZonedDateTime.class));
        return entity;
    }
}
