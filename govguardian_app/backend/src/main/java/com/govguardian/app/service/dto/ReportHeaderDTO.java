package com.govguardian.app.service.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.govguardian.app.domain.ReportHeader} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ReportHeaderDTO implements Serializable {

    private String id;

    private String description;

    private String title;

    private ZonedDateTime timestamp;

    private String status;

    private AppUserDTO appUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AppUserDTO getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUserDTO appUser) {
        this.appUser = appUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReportHeaderDTO)) {
            return false;
        }

        ReportHeaderDTO reportHeaderDTO = (ReportHeaderDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, reportHeaderDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ReportHeaderDTO{" +
            "id='" + getId() + "'" +
            ", description='" + getDescription() + "'" +
            ", title='" + getTitle() + "'" +
            ", timestamp='" + getTimestamp() + "'" +
            ", status='" + getStatus() + "'" +
            ", appUser=" + getAppUser() +
            "}";
    }
}
