package com.govguardian.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A Reward.
 */
@Table("reward")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Reward implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("description")
    private String description;

    @Column("points")
    private Integer points;

    @Column("timestamp")
    private ZonedDateTime timestamp;

    @Transient
    @JsonIgnoreProperties(
        value = { "user", "reportHeaders", "reportDetails", "reviews", "rewards", "govOfficialContent" },
        allowSetters = true
    )
    private Set<AppUser> appUsers = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Reward id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public Reward description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPoints() {
        return this.points;
    }

    public Reward points(Integer points) {
        this.setPoints(points);
        return this;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public ZonedDateTime getTimestamp() {
        return this.timestamp;
    }

    public Reward timestamp(ZonedDateTime timestamp) {
        this.setTimestamp(timestamp);
        return this;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Set<AppUser> getAppUsers() {
        return this.appUsers;
    }

    public void setAppUsers(Set<AppUser> appUsers) {
        if (this.appUsers != null) {
            this.appUsers.forEach(i -> i.setRewards(null));
        }
        if (appUsers != null) {
            appUsers.forEach(i -> i.setRewards(this));
        }
        this.appUsers = appUsers;
    }

    public Reward appUsers(Set<AppUser> appUsers) {
        this.setAppUsers(appUsers);
        return this;
    }

    public Reward addAppUser(AppUser appUser) {
        this.appUsers.add(appUser);
        appUser.setRewards(this);
        return this;
    }

    public Reward removeAppUser(AppUser appUser) {
        this.appUsers.remove(appUser);
        appUser.setRewards(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Reward)) {
            return false;
        }
        return getId() != null && getId().equals(((Reward) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Reward{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", points=" + getPoints() +
            ", timestamp='" + getTimestamp() + "'" +
            "}";
    }
}
