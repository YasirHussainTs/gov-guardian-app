package com.govguardian.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.govguardian.app.domain.enumeration.UserType;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A AppUser.
 */
@Table("app_user")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("email")
    private String email;

    @Column("address")
    private String address;

    @Pattern(regexp = "^[0-9]{10}$")
    @Column("phone")
    private String phone;

    @Column("gender")
    private String gender;

    @Column("department")
    private String department;

    @Column("description")
    private String description;

    @Column("latitude")
    private Double latitude;

    @Column("longitude")
    private Double longitude;

    @Column("user_type")
    private UserType userType;

    @Transient
    private User user;

    @Transient
    @JsonIgnoreProperties(value = { "appUser" }, allowSetters = true)
    private Set<ReportHeader> reportHeaders = new HashSet<>();

    @Transient
    @JsonIgnoreProperties(value = { "appUser" }, allowSetters = true)
    private Set<ReportDetails> reportDetails = new HashSet<>();

    @Transient
    @JsonIgnoreProperties(value = { "appUsers" }, allowSetters = true)
    private Review reviews;

    @Transient
    @JsonIgnoreProperties(value = { "appUsers" }, allowSetters = true)
    private Reward rewards;

    @Transient
    @JsonIgnoreProperties(value = { "appUsers" }, allowSetters = true)
    private GovOfficialContent govOfficialContent;

    @Column("user_id")
    private Long userId;

    @Column("reviews_id")
    private Long reviewsId;

    @Column("rewards_id")
    private Long rewardsId;

    @Column("gov_official_content_id")
    private Long govOfficialContentId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public AppUser id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public AppUser email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public AppUser address(String address) {
        this.setAddress(address);
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public AppUser phone(String phone) {
        this.setPhone(phone);
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return this.gender;
    }

    public AppUser gender(String gender) {
        this.setGender(gender);
        return this;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return this.department;
    }

    public AppUser department(String department) {
        this.setDepartment(department);
        return this;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return this.description;
    }

    public AppUser description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public AppUser latitude(Double latitude) {
        this.setLatitude(latitude);
        return this;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public AppUser longitude(Double longitude) {
        this.setLongitude(longitude);
        return this;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public UserType getUserType() {
        return this.userType;
    }

    public AppUser userType(UserType userType) {
        this.setUserType(userType);
        return this;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
        this.userId = user != null ? user.getId() : null;
    }

    public AppUser user(User user) {
        this.setUser(user);
        return this;
    }

    public Set<ReportHeader> getReportHeaders() {
        return this.reportHeaders;
    }

    public void setReportHeaders(Set<ReportHeader> reportHeaders) {
        if (this.reportHeaders != null) {
            this.reportHeaders.forEach(i -> i.setAppUser(null));
        }
        if (reportHeaders != null) {
            reportHeaders.forEach(i -> i.setAppUser(this));
        }
        this.reportHeaders = reportHeaders;
    }

    public AppUser reportHeaders(Set<ReportHeader> reportHeaders) {
        this.setReportHeaders(reportHeaders);
        return this;
    }

    public AppUser addReportHeader(ReportHeader reportHeader) {
        this.reportHeaders.add(reportHeader);
        reportHeader.setAppUser(this);
        return this;
    }

    public AppUser removeReportHeader(ReportHeader reportHeader) {
        this.reportHeaders.remove(reportHeader);
        reportHeader.setAppUser(null);
        return this;
    }

    public Set<ReportDetails> getReportDetails() {
        return this.reportDetails;
    }

    public void setReportDetails(Set<ReportDetails> reportDetails) {
        if (this.reportDetails != null) {
            this.reportDetails.forEach(i -> i.setAppUser(null));
        }
        if (reportDetails != null) {
            reportDetails.forEach(i -> i.setAppUser(this));
        }
        this.reportDetails = reportDetails;
    }

    public AppUser reportDetails(Set<ReportDetails> reportDetails) {
        this.setReportDetails(reportDetails);
        return this;
    }

    public AppUser addReportDetails(ReportDetails reportDetails) {
        this.reportDetails.add(reportDetails);
        reportDetails.setAppUser(this);
        return this;
    }

    public AppUser removeReportDetails(ReportDetails reportDetails) {
        this.reportDetails.remove(reportDetails);
        reportDetails.setAppUser(null);
        return this;
    }

    public Review getReviews() {
        return this.reviews;
    }

    public void setReviews(Review review) {
        this.reviews = review;
        this.reviewsId = review != null ? review.getId() : null;
    }

    public AppUser reviews(Review review) {
        this.setReviews(review);
        return this;
    }

    public Reward getRewards() {
        return this.rewards;
    }

    public void setRewards(Reward reward) {
        this.rewards = reward;
        this.rewardsId = reward != null ? reward.getId() : null;
    }

    public AppUser rewards(Reward reward) {
        this.setRewards(reward);
        return this;
    }

    public GovOfficialContent getGovOfficialContent() {
        return this.govOfficialContent;
    }

    public void setGovOfficialContent(GovOfficialContent govOfficialContent) {
        this.govOfficialContent = govOfficialContent;
        this.govOfficialContentId = govOfficialContent != null ? govOfficialContent.getId() : null;
    }

    public AppUser govOfficialContent(GovOfficialContent govOfficialContent) {
        this.setGovOfficialContent(govOfficialContent);
        return this;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long user) {
        this.userId = user;
    }

    public Long getReviewsId() {
        return this.reviewsId;
    }

    public void setReviewsId(Long review) {
        this.reviewsId = review;
    }

    public Long getRewardsId() {
        return this.rewardsId;
    }

    public void setRewardsId(Long reward) {
        this.rewardsId = reward;
    }

    public Long getGovOfficialContentId() {
        return this.govOfficialContentId;
    }

    public void setGovOfficialContentId(Long govOfficialContent) {
        this.govOfficialContentId = govOfficialContent;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AppUser)) {
            return false;
        }
        return getId() != null && getId().equals(((AppUser) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AppUser{" +
            "id=" + getId() +
            ", email='" + getEmail() + "'" +
            ", address='" + getAddress() + "'" +
            ", phone='" + getPhone() + "'" +
            ", gender='" + getGender() + "'" +
            ", department='" + getDepartment() + "'" +
            ", description='" + getDescription() + "'" +
            ", latitude=" + getLatitude() +
            ", longitude=" + getLongitude() +
            ", userType='" + getUserType() + "'" +
            "}";
    }
}
