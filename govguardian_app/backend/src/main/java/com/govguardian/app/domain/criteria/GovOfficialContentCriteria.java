package com.govguardian.app.domain.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.govguardian.app.domain.GovOfficialContent} entity. This class is used
 * in {@link com.govguardian.app.web.rest.GovOfficialContentResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /gov-official-contents?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class GovOfficialContentCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter law;

    private StringFilter description;

    private StringFilter action;

    private ZonedDateTimeFilter date;

    private Boolean distinct;

    public GovOfficialContentCriteria() {}

    public GovOfficialContentCriteria(GovOfficialContentCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.law = other.law == null ? null : other.law.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.action = other.action == null ? null : other.action.copy();
        this.date = other.date == null ? null : other.date.copy();
        this.distinct = other.distinct;
    }

    @Override
    public GovOfficialContentCriteria copy() {
        return new GovOfficialContentCriteria(this);
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

    public StringFilter getLaw() {
        return law;
    }

    public StringFilter law() {
        if (law == null) {
            law = new StringFilter();
        }
        return law;
    }

    public void setLaw(StringFilter law) {
        this.law = law;
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

    public StringFilter getAction() {
        return action;
    }

    public StringFilter action() {
        if (action == null) {
            action = new StringFilter();
        }
        return action;
    }

    public void setAction(StringFilter action) {
        this.action = action;
    }

    public ZonedDateTimeFilter getDate() {
        return date;
    }

    public ZonedDateTimeFilter date() {
        if (date == null) {
            date = new ZonedDateTimeFilter();
        }
        return date;
    }

    public void setDate(ZonedDateTimeFilter date) {
        this.date = date;
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
        final GovOfficialContentCriteria that = (GovOfficialContentCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(law, that.law) &&
            Objects.equals(description, that.description) &&
            Objects.equals(action, that.action) &&
            Objects.equals(date, that.date) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, law, description, action, date, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GovOfficialContentCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (law != null ? "law=" + law + ", " : "") +
            (description != null ? "description=" + description + ", " : "") +
            (action != null ? "action=" + action + ", " : "") +
            (date != null ? "date=" + date + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
