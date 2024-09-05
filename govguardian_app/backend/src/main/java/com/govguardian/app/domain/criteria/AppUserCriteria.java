package com.govguardian.app.domain.criteria;

import com.govguardian.app.domain.enumeration.UserType;
import java.io.Serializable;
import java.util.Objects;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.govguardian.app.domain.AppUser} entity. This class is used
 * in {@link com.govguardian.app.web.rest.AppUserResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /app-users?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AppUserCriteria implements Serializable, Criteria {

    /**
     * Class for filtering UserType
     */
    public static class UserTypeFilter extends Filter<UserType> {

        public UserTypeFilter() {}

        public UserTypeFilter(UserTypeFilter filter) {
            super(filter);
        }

        @Override
        public UserTypeFilter copy() {
            return new UserTypeFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter email;

    private StringFilter address;

    private StringFilter phone;

    private StringFilter gender;

    private StringFilter department;

    private StringFilter description;

    private DoubleFilter latitude;

    private DoubleFilter longitude;

    private UserTypeFilter userType;

    private LongFilter userId;

    private LongFilter reviewsId;

    private LongFilter rewardsId;

    private LongFilter govOfficialContentId;

    private Boolean distinct;

    public AppUserCriteria() {}

    public AppUserCriteria(AppUserCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.email = other.email == null ? null : other.email.copy();
        this.address = other.address == null ? null : other.address.copy();
        this.phone = other.phone == null ? null : other.phone.copy();
        this.gender = other.gender == null ? null : other.gender.copy();
        this.department = other.department == null ? null : other.department.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.latitude = other.latitude == null ? null : other.latitude.copy();
        this.longitude = other.longitude == null ? null : other.longitude.copy();
        this.userType = other.userType == null ? null : other.userType.copy();
        this.userId = other.userId == null ? null : other.userId.copy();
        this.reviewsId = other.reviewsId == null ? null : other.reviewsId.copy();
        this.rewardsId = other.rewardsId == null ? null : other.rewardsId.copy();
        this.govOfficialContentId = other.govOfficialContentId == null ? null : other.govOfficialContentId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public AppUserCriteria copy() {
        return new AppUserCriteria(this);
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

    public StringFilter getEmail() {
        return email;
    }

    public StringFilter email() {
        if (email == null) {
            email = new StringFilter();
        }
        return email;
    }

    public void setEmail(StringFilter email) {
        this.email = email;
    }

    public StringFilter getAddress() {
        return address;
    }

    public StringFilter address() {
        if (address == null) {
            address = new StringFilter();
        }
        return address;
    }

    public void setAddress(StringFilter address) {
        this.address = address;
    }

    public StringFilter getPhone() {
        return phone;
    }

    public StringFilter phone() {
        if (phone == null) {
            phone = new StringFilter();
        }
        return phone;
    }

    public void setPhone(StringFilter phone) {
        this.phone = phone;
    }

    public StringFilter getGender() {
        return gender;
    }

    public StringFilter gender() {
        if (gender == null) {
            gender = new StringFilter();
        }
        return gender;
    }

    public void setGender(StringFilter gender) {
        this.gender = gender;
    }

    public StringFilter getDepartment() {
        return department;
    }

    public StringFilter department() {
        if (department == null) {
            department = new StringFilter();
        }
        return department;
    }

    public void setDepartment(StringFilter department) {
        this.department = department;
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

    public DoubleFilter getLatitude() {
        return latitude;
    }

    public DoubleFilter latitude() {
        if (latitude == null) {
            latitude = new DoubleFilter();
        }
        return latitude;
    }

    public void setLatitude(DoubleFilter latitude) {
        this.latitude = latitude;
    }

    public DoubleFilter getLongitude() {
        return longitude;
    }

    public DoubleFilter longitude() {
        if (longitude == null) {
            longitude = new DoubleFilter();
        }
        return longitude;
    }

    public void setLongitude(DoubleFilter longitude) {
        this.longitude = longitude;
    }

    public UserTypeFilter getUserType() {
        return userType;
    }

    public UserTypeFilter userType() {
        if (userType == null) {
            userType = new UserTypeFilter();
        }
        return userType;
    }

    public void setUserType(UserTypeFilter userType) {
        this.userType = userType;
    }

    public LongFilter getUserId() {
        return userId;
    }

    public LongFilter userId() {
        if (userId == null) {
            userId = new LongFilter();
        }
        return userId;
    }

    public void setUserId(LongFilter userId) {
        this.userId = userId;
    }

    public LongFilter getReviewsId() {
        return reviewsId;
    }

    public LongFilter reviewsId() {
        if (reviewsId == null) {
            reviewsId = new LongFilter();
        }
        return reviewsId;
    }

    public void setReviewsId(LongFilter reviewsId) {
        this.reviewsId = reviewsId;
    }

    public LongFilter getRewardsId() {
        return rewardsId;
    }

    public LongFilter rewardsId() {
        if (rewardsId == null) {
            rewardsId = new LongFilter();
        }
        return rewardsId;
    }

    public void setRewardsId(LongFilter rewardsId) {
        this.rewardsId = rewardsId;
    }

    public LongFilter getGovOfficialContentId() {
        return govOfficialContentId;
    }

    public LongFilter govOfficialContentId() {
        if (govOfficialContentId == null) {
            govOfficialContentId = new LongFilter();
        }
        return govOfficialContentId;
    }

    public void setGovOfficialContentId(LongFilter govOfficialContentId) {
        this.govOfficialContentId = govOfficialContentId;
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
        final AppUserCriteria that = (AppUserCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(email, that.email) &&
            Objects.equals(address, that.address) &&
            Objects.equals(phone, that.phone) &&
            Objects.equals(gender, that.gender) &&
            Objects.equals(department, that.department) &&
            Objects.equals(description, that.description) &&
            Objects.equals(latitude, that.latitude) &&
            Objects.equals(longitude, that.longitude) &&
            Objects.equals(userType, that.userType) &&
            Objects.equals(userId, that.userId) &&
            Objects.equals(reviewsId, that.reviewsId) &&
            Objects.equals(rewardsId, that.rewardsId) &&
            Objects.equals(govOfficialContentId, that.govOfficialContentId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            email,
            address,
            phone,
            gender,
            department,
            description,
            latitude,
            longitude,
            userType,
            userId,
            reviewsId,
            rewardsId,
            govOfficialContentId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AppUserCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (email != null ? "email=" + email + ", " : "") +
            (address != null ? "address=" + address + ", " : "") +
            (phone != null ? "phone=" + phone + ", " : "") +
            (gender != null ? "gender=" + gender + ", " : "") +
            (department != null ? "department=" + department + ", " : "") +
            (description != null ? "description=" + description + ", " : "") +
            (latitude != null ? "latitude=" + latitude + ", " : "") +
            (longitude != null ? "longitude=" + longitude + ", " : "") +
            (userType != null ? "userType=" + userType + ", " : "") +
            (userId != null ? "userId=" + userId + ", " : "") +
            (reviewsId != null ? "reviewsId=" + reviewsId + ", " : "") +
            (rewardsId != null ? "rewardsId=" + rewardsId + ", " : "") +
            (govOfficialContentId != null ? "govOfficialContentId=" + govOfficialContentId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
