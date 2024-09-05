package com.govguardian.app.service.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.govguardian.app.domain.GovOfficialContent} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class GovOfficialContentDTO implements Serializable {

    private Long id;

    private String law;

    private String description;

    private String action;

    private ZonedDateTime date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLaw() {
        return law;
    }

    public void setLaw(String law) {
        this.law = law;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GovOfficialContentDTO)) {
            return false;
        }

        GovOfficialContentDTO govOfficialContentDTO = (GovOfficialContentDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, govOfficialContentDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GovOfficialContentDTO{" +
            "id=" + getId() +
            ", law='" + getLaw() + "'" +
            ", description='" + getDescription() + "'" +
            ", action='" + getAction() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }
}
