package com.govguardian.app.domain.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.govguardian.app.domain.Reward} entity. This class is used
 * in {@link com.govguardian.app.web.rest.RewardResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /rewards?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class RewardCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter description;

    private IntegerFilter points;

    private ZonedDateTimeFilter timestamp;

    private Boolean distinct;

    public RewardCriteria() {}

    public RewardCriteria(RewardCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.points = other.points == null ? null : other.points.copy();
        this.timestamp = other.timestamp == null ? null : other.timestamp.copy();
        this.distinct = other.distinct;
    }

    @Override
    public RewardCriteria copy() {
        return new RewardCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public LongFilter id() {
        if (id == null) {
            id = new LongFilter();
        }
        return id;
    }

    public void setId(LongFilter id) {
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

    public IntegerFilter getPoints() {
        return points;
    }

    public IntegerFilter points() {
        if (points == null) {
            points = new IntegerFilter();
        }
        return points;
    }

    public void setPoints(IntegerFilter points) {
        this.points = points;
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
        final RewardCriteria that = (RewardCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(description, that.description) &&
            Objects.equals(points, that.points) &&
            Objects.equals(timestamp, that.timestamp) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, points, timestamp, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RewardCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (description != null ? "description=" + description + ", " : "") +
            (points != null ? "points=" + points + ", " : "") +
            (timestamp != null ? "timestamp=" + timestamp + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
