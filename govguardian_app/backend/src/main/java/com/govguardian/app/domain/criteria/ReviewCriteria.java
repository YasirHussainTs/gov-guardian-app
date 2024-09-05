package com.govguardian.app.domain.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.govguardian.app.domain.Review} entity. This class is used
 * in {@link com.govguardian.app.web.rest.ReviewResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /reviews?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ReviewCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter content;

    private IntegerFilter rating;

    private StringFilter feedback;

    private ZonedDateTimeFilter timestamp;

    private Boolean distinct;

    public ReviewCriteria() {}

    public ReviewCriteria(ReviewCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.content = other.content == null ? null : other.content.copy();
        this.rating = other.rating == null ? null : other.rating.copy();
        this.feedback = other.feedback == null ? null : other.feedback.copy();
        this.timestamp = other.timestamp == null ? null : other.timestamp.copy();
        this.distinct = other.distinct;
    }

    @Override
    public ReviewCriteria copy() {
        return new ReviewCriteria(this);
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

    public StringFilter getContent() {
        return content;
    }

    public StringFilter content() {
        if (content == null) {
            content = new StringFilter();
        }
        return content;
    }

    public void setContent(StringFilter content) {
        this.content = content;
    }

    public IntegerFilter getRating() {
        return rating;
    }

    public IntegerFilter rating() {
        if (rating == null) {
            rating = new IntegerFilter();
        }
        return rating;
    }

    public void setRating(IntegerFilter rating) {
        this.rating = rating;
    }

    public StringFilter getFeedback() {
        return feedback;
    }

    public StringFilter feedback() {
        if (feedback == null) {
            feedback = new StringFilter();
        }
        return feedback;
    }

    public void setFeedback(StringFilter feedback) {
        this.feedback = feedback;
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
        final ReviewCriteria that = (ReviewCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(content, that.content) &&
            Objects.equals(rating, that.rating) &&
            Objects.equals(feedback, that.feedback) &&
            Objects.equals(timestamp, that.timestamp) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, rating, feedback, timestamp, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ReviewCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (content != null ? "content=" + content + ", " : "") +
            (rating != null ? "rating=" + rating + ", " : "") +
            (feedback != null ? "feedback=" + feedback + ", " : "") +
            (timestamp != null ? "timestamp=" + timestamp + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
