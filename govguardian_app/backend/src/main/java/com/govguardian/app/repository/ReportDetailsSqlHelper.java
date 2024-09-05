package com.govguardian.app.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class ReportDetailsSqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("id", table, columnPrefix + "_id"));
        columns.add(Column.aliased("owner", table, columnPrefix + "_owner"));
        columns.add(Column.aliased("responder", table, columnPrefix + "_responder"));
        columns.add(Column.aliased("description", table, columnPrefix + "_description"));
        columns.add(Column.aliased("title", table, columnPrefix + "_title"));
        columns.add(Column.aliased("timestamp", table, columnPrefix + "_timestamp"));
        columns.add(Column.aliased("status", table, columnPrefix + "_status"));
        columns.add(Column.aliased("image", table, columnPrefix + "_image"));
        columns.add(Column.aliased("image_content_type", table, columnPrefix + "_image_content_type"));
        columns.add(Column.aliased("video", table, columnPrefix + "_video"));
        columns.add(Column.aliased("video_content_type", table, columnPrefix + "_video_content_type"));
        columns.add(Column.aliased("voice_data", table, columnPrefix + "_voice_data"));
        columns.add(Column.aliased("voice_data_content_type", table, columnPrefix + "_voice_data_content_type"));
        columns.add(Column.aliased("file_1", table, columnPrefix + "_file_1"));
        columns.add(Column.aliased("file_1_content_type", table, columnPrefix + "_file_1_content_type"));
        columns.add(Column.aliased("file_2", table, columnPrefix + "_file_2"));
        columns.add(Column.aliased("file_2_content_type", table, columnPrefix + "_file_2_content_type"));
        columns.add(Column.aliased("file_3", table, columnPrefix + "_file_3"));
        columns.add(Column.aliased("file_3_content_type", table, columnPrefix + "_file_3_content_type"));

        columns.add(Column.aliased("app_user_id", table, columnPrefix + "_app_user_id"));
        return columns;
    }
}
