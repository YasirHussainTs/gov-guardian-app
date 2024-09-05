package com.govguardian.app.domain.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.govguardian.app.domain.ReportHeader} entity. This class is used
 * in {@link com.govguardian.app.web.rest.ReportHeaderResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /report-headers?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ReportHeaderCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private StringFilter id;

    private StringFilter description;

    private StringFilter title;

    private ZonedDateTimeFilter timestamp;

    private StringFilter status;

    private LongFilter appUserId;

    private Boolean distinct;

    public ReportHeaderCriteria() {}

    public ReportHeaderCriteria(ReportHeaderCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.title = other.title == null ? null : other.title.copy();
        this.timestamp = other.timestamp == null ? null : other.timestamp.copy();
        this.status = other.status == null ? null : other.status.copy();
        this.appUserId = other.appUserId == null ? null : other.appUserId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public ReportHeaderCriteria copy() {
        return new ReportHeaderCriteria(this);
    }

    public StringFilter getId() {
        return id;
    }

    public StringFilter id() {
        if (id == null) {
            id = new StringFilter();
        }
        return id;
    }

    public void setId(StringFilter id) {
        this.id = id;
    }

    public StringFilter getDescription() {
        return description;
    }

    public StringFilter description() {
        if (description == null) {
            description = new StringFilter();
        }
        return description;
    }

    public void setDescription(StringFilter description) {
        this.description = description;
    }

    public StringFilter getTitle() {
        return title;
    }

    public StringFilter title() {
        if (title == null) {
            title = new StringFilter();
        }
        return title;
    }

    public void setTitle(StringFilter title) {
        this.title = title;
    }

    public ZonedDateTimeFilter getTimestamp() {
        return timestamp;
    }

    public ZonedDateTimeFilter timestamp() {
        if (timestamp == null) {
            timestamp = new ZonedDateTimeFilter();
        }
        return timestamp;
    }

    public void setTimestamp(ZonedDateTimeFilter timestamp) {
        this.timestamp = timestamp;
    }

    public StringFilter getStatus() {
        return status;
    }

    public StringFilter status() {
        if (status == null) {
            status = new StringFilter();
        }
        return status;
    }

    public void setStatus(StringFilter status) {
        this.status = status;
    }

    public LongFilter getAppUserId() {
        return appUserId;
    }

    public LongFilter appUserId() {
        if (appUserId == null) {
            appUserId = new LongFilter();
        }
        return appUserId;
    }

    public void setAppUserId(LongFilter appUserId) {
        this.appUserId = appUserId;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ReportHeaderCriteria that = (ReportHeaderCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(description, that.description) &&
            Objects.equals(title, that.title) &&
            Objects.equals(timestamp, that.timestamp) &&
            Objects.equals(status, that.status) &&
            Objects.equals(appUserId, that.appUserId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, title, timestamp, status, appUserId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ReportHeaderCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (description != null ? "description=" + description + ", " : "") +
            (title != null ? "title=" + title + ", " : "") +
            (timestamp != null ? "timestamp=" + timestamp + ", " : "") +
            (status != null ? "status=" + status + ", " : "") +
            (appUserId != null ? "appUserId=" + appUserId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
