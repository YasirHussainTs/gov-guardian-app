package com.govguardian.app.service.dto;

import com.govguardian.app.domain.enumeration.UserType;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.govguardian.app.domain.AppUser} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AppUserDTO implements Serializable {

    private Long id;

    private String email;

    private String address;

    @Pattern(regexp = "^[0-9]{10}$")
    private String phone;

    private String gender;

    private String department;

    private String description;

    private Double latitude;

    private Double longitude;

    private UserType userType;

    private UserDTO user;

    private ReviewDTO reviews;

    private RewardDTO rewards;

    private GovOfficialContentDTO govOfficialContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public ReviewDTO getReviews() {
        return reviews;
    }

    public void setReviews(ReviewDTO reviews) {
        this.reviews = reviews;
    }

    public RewardDTO getRewards() {
        return rewards;
    }

    public void setRewards(RewardDTO rewards) {
        this.rewards = rewards;
    }

    public GovOfficialContentDTO getGovOfficialContent() {
        return govOfficialContent;
    }

    public void setGovOfficialContent(GovOfficialContentDTO govOfficialContent) {
        this.govOfficialContent = govOfficialContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AppUserDTO)) {
            return false;
        }

        AppUserDTO appUserDTO = (AppUserDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, appUserDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AppUserDTO{" +
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
            ", user=" + getUser() +
            ", reviews=" + getReviews() +
            ", rewards=" + getRewards() +
            ", govOfficialContent=" + getGovOfficialContent() +
            "}";
    }
}
