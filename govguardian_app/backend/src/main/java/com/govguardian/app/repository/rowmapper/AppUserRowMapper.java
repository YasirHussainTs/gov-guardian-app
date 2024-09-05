package com.govguardian.app.repository.rowmapper;

import com.govguardian.app.domain.AppUser;
import com.govguardian.app.domain.enumeration.UserType;
import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link AppUser}, with proper type conversions.
 */
@Service
public class AppUserRowMapper implements BiFunction<Row, String, AppUser> {

    private final ColumnConverter converter;

    public AppUserRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link AppUser} stored in the database.
     */
    @Override
    public AppUser apply(Row row, String prefix) {
        AppUser entity = new AppUser();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setEmail(converter.fromRow(row, prefix + "_email", String.class));
        entity.setAddress(converter.fromRow(row, prefix + "_address", String.class));
        entity.setPhone(converter.fromRow(row, prefix + "_phone", String.class));
        entity.setGender(converter.fromRow(row, prefix + "_gender", String.class));
        entity.setDepartment(converter.fromRow(row, prefix + "_department", String.class));
        entity.setDescription(converter.fromRow(row, prefix + "_description", String.class));
        entity.setLatitude(converter.fromRow(row, prefix + "_latitude", Double.class));
        entity.setLongitude(converter.fromRow(row, prefix + "_longitude", Double.class));
        entity.setUserType(converter.fromRow(row, prefix + "_user_type", UserType.class));
        entity.setUserId(converter.fromRow(row, prefix + "_user_id", Long.class));
        entity.setReviewsId(converter.fromRow(row, prefix + "_reviews_id", Long.class));
        entity.setRewardsId(converter.fromRow(row, prefix + "_rewards_id", Long.class));
        entity.setGovOfficialContentId(converter.fromRow(row, prefix + "_gov_official_content_id", Long.class));
        return entity;
    }
}
