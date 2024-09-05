package com.govguardian.app.service.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.govguardian.app.domain.Reward} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class RewardDTO implements Serializable {

    private Long id;

    private String description;

    private Integer points;

    private ZonedDateTime timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RewardDTO)) {
            return false;
        }

        RewardDTO rewardDTO = (RewardDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, rewardDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RewardDTO{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", points=" + getPoints() +
            ", timestamp='" + getTimestamp() + "'" +
            "}";
    }
}
