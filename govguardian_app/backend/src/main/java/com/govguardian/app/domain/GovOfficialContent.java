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
 * A GovOfficialContent.
 */
@Table("gov_official_content")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class GovOfficialContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("law")
    private String law;

    @Column("description")
    private String description;

    @Column("action")
    private String action;

    @Column("date")
    private ZonedDateTime date;

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

    public GovOfficialContent id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLaw() {
        return this.law;
    }

    public GovOfficialContent law(String law) {
        this.setLaw(law);
        return this;
    }

    public void setLaw(String law) {
        this.law = law;
    }

    public String getDescription() {
        return this.description;
    }

    public GovOfficialContent description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction() {
        return this.action;
    }

    public GovOfficialContent action(String action) {
        this.setAction(action);
        return this;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ZonedDateTime getDate() {
        return this.date;
    }

    public GovOfficialContent date(ZonedDateTime date) {
        this.setDate(date);
        return this;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public Set<AppUser> getAppUsers() {
        return this.appUsers;
    }

    public void setAppUsers(Set<AppUser> appUsers) {
        if (this.appUsers != null) {
            this.appUsers.forEach(i -> i.setGovOfficialContent(null));
        }
        if (appUsers != null) {
            appUsers.forEach(i -> i.setGovOfficialContent(this));
        }
        this.appUsers = appUsers;
    }

    public GovOfficialContent appUsers(Set<AppUser> appUsers) {
        this.setAppUsers(appUsers);
        return this;
    }

    public GovOfficialContent addAppUser(AppUser appUser) {
        this.appUsers.add(appUser);
        appUser.setGovOfficialContent(this);
        return this;
    }

    public GovOfficialContent removeAppUser(AppUser appUser) {
        this.appUsers.remove(appUser);
        appUser.setGovOfficialContent(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GovOfficialContent)) {
            return false;
        }
        return getId() != null && getId().equals(((GovOfficialContent) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GovOfficialContent{" +
            "id=" + getId() +
            ", law='" + getLaw() + "'" +
            ", description='" + getDescription() + "'" +
            ", action='" + getAction() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }
}
