package com.govguardian.app.repository.rowmapper;

import com.govguardian.app.domain.ReportDetails;
import io.r2dbc.spi.Row;
import java.time.ZonedDateTime;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link ReportDetails}, with proper type conversions.
 */
@Service
public class ReportDetailsRowMapper implements BiFunction<Row, String, ReportDetails> {

    private final ColumnConverter converter;

    public ReportDetailsRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link ReportDetails} stored in the database.
     */
    @Override
    public ReportDetails apply(Row row, String prefix) {
        ReportDetails entity = new ReportDetails();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setOwner(converter.fromRow(row, prefix + "_owner", String.class));
        entity.setResponder(converter.fromRow(row, prefix + "_responder", String.class));
        entity.setDescription(converter.fromRow(row, prefix + "_description", String.class));
        entity.setTitle(converter.fromRow(row, prefix + "_title", String.class));
        entity.setTimestamp(converter.fromRow(row, prefix + "_timestamp", ZonedDateTime.class));
        entity.setStatus(converter.fromRow(row, prefix + "_status", String.class));
        entity.setImageContentType(converter.fromRow(row, prefix + "_image_content_type", String.class));
        entity.setImage(converter.fromRow(row, prefix + "_image", byte[].class));
        entity.setVideoContentType(converter.fromRow(row, prefix + "_video_content_type", String.class));
        entity.setVideo(converter.fromRow(row, prefix + "_video", byte[].class));
        entity.setVoiceDataContentType(converter.fromRow(row, prefix + "_voice_data_content_type", String.class));
        entity.setVoiceData(converter.fromRow(row, prefix + "_voice_data", byte[].class));
        entity.setFile1ContentType(converter.fromRow(row, prefix + "_file_1_content_type", String.class));
        entity.setFile1(converter.fromRow(row, prefix + "_file_1", byte[].class));
        entity.setFile2ContentType(converter.fromRow(row, prefix + "_file_2_content_type", String.class));
        entity.setFile2(converter.fromRow(row, prefix + "_file_2", byte[].class));
        entity.setFile3ContentType(converter.fromRow(row, prefix + "_file_3_content_type", String.class));
        entity.setFile3(converter.fromRow(row, prefix + "_file_3", byte[].class));
        entity.setAppUserId(converter.fromRow(row, prefix + "_app_user_id", Long.class));
        return entity;
    }
}
