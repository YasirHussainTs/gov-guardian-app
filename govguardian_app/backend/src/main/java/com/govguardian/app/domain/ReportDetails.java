package com.govguardian.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.ZonedDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A ReportDetails.
 */
@Table("report_details")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ReportDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("owner")
    private String owner;

    @Column("responder")
    private String responder;

    @Column("description")
    private String description;

    @Column("title")
    private String title;

    @Column("timestamp")
    private ZonedDateTime timestamp;

    @Column("status")
    private String status;

    @Column("image")
    private byte[] image;

    @Column("image_content_type")
    private String imageContentType;

    @Column("video")
    private byte[] video;

    @Column("video_content_type")
    private String videoContentType;

    @Column("voice_data")
    private byte[] voiceData;

    @Column("voice_data_content_type")
    private String voiceDataContentType;

    @Column("file_1")
    private byte[] file1;

    @Column("file_1_content_type")
    private String file1ContentType;

    @Column("file_2")
    private byte[] file2;

    @Column("file_2_content_type")
    private String file2ContentType;

    @Column("file_3")
    private byte[] file3;

    @Column("file_3_content_type")
    private String file3ContentType;

    @Transient
    @JsonIgnoreProperties(
        value = { "user", "reportHeaders", "reportDetails", "reviews", "rewards", "govOfficialContent" },
        allowSetters = true
    )
    private AppUser appUser;

    @Column("app_user_id")
    private Long appUserId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ReportDetails id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return this.owner;
    }

    public ReportDetails owner(String owner) {
        this.setOwner(owner);
        return this;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getResponder() {
        return this.responder;
    }

    public ReportDetails responder(String responder) {
        this.setResponder(responder);
        return this;
    }

    public void setResponder(String responder) {
        this.responder = responder;
    }

    public String getDescription() {
        return this.description;
    }

    public ReportDetails description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public ReportDetails title(String title) {
        this.setTitle(title);
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ZonedDateTime getTimestamp() {
        return this.timestamp;
    }

    public ReportDetails timestamp(ZonedDateTime timestamp) {
        this.setTimestamp(timestamp);
        return this;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return this.status;
    }

    public ReportDetails status(String status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getImage() {
        return this.image;
    }

    public ReportDetails image(byte[] image) {
        this.setImage(image);
        return this;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageContentType() {
        return this.imageContentType;
    }

    public ReportDetails imageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
        return this;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public byte[] getVideo() {
        return this.video;
    }

    public ReportDetails video(byte[] video) {
        this.setVideo(video);
        return this;
    }

    public void setVideo(byte[] video) {
        this.video = video;
    }

    public String getVideoContentType() {
        return this.videoContentType;
    }

    public ReportDetails videoContentType(String videoContentType) {
        this.videoContentType = videoContentType;
        return this;
    }

    public void setVideoContentType(String videoContentType) {
        this.videoContentType = videoContentType;
    }

    public byte[] getVoiceData() {
        return this.voiceData;
    }

    public ReportDetails voiceData(byte[] voiceData) {
        this.setVoiceData(voiceData);
        return this;
    }

    public void setVoiceData(byte[] voiceData) {
        this.voiceData = voiceData;
    }

    public String getVoiceDataContentType() {
        return this.voiceDataContentType;
    }

    public ReportDetails voiceDataContentType(String voiceDataContentType) {
        this.voiceDataContentType = voiceDataContentType;
        return this;
    }

    public void setVoiceDataContentType(String voiceDataContentType) {
        this.voiceDataContentType = voiceDataContentType;
    }

    public byte[] getFile1() {
        return this.file1;
    }

    public ReportDetails file1(byte[] file1) {
        this.setFile1(file1);
        return this;
    }

    public void setFile1(byte[] file1) {
        this.file1 = file1;
    }

    public String getFile1ContentType() {
        return this.file1ContentType;
    }

    public ReportDetails file1ContentType(String file1ContentType) {
        this.file1ContentType = file1ContentType;
        return this;
    }

    public void setFile1ContentType(String file1ContentType) {
        this.file1ContentType = file1ContentType;
    }

    public byte[] getFile2() {
        return this.file2;
    }

    public ReportDetails file2(byte[] file2) {
        this.setFile2(file2);
        return this;
    }

    public void setFile2(byte[] file2) {
        this.file2 = file2;
    }

    public String getFile2ContentType() {
        return this.file2ContentType;
    }

    public ReportDetails file2ContentType(String file2ContentType) {
        this.file2ContentType = file2ContentType;
        return this;
    }

    public void setFile2ContentType(String file2ContentType) {
        this.file2ContentType = file2ContentType;
    }

    public byte[] getFile3() {
        return this.file3;
    }

    public ReportDetails file3(byte[] file3) {
        this.setFile3(file3);
        return this;
    }

    public void setFile3(byte[] file3) {
        this.file3 = file3;
    }

    public String getFile3ContentType() {
        return this.file3ContentType;
    }

    public ReportDetails file3ContentType(String file3ContentType) {
        this.file3ContentType = file3ContentType;
        return this;
    }

    public void setFile3ContentType(String file3ContentType) {
        this.file3ContentType = file3ContentType;
    }

    public AppUser getAppUser() {
        return this.appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
        this.appUserId = appUser != null ? appUser.getId() : null;
    }

    public ReportDetails appUser(AppUser appUser) {
        this.setAppUser(appUser);
        return this;
    }

    public Long getAppUserId() {
        return this.appUserId;
    }

    public void setAppUserId(Long appUser) {
        this.appUserId = appUser;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReportDetails)) {
            return false;
        }
        return getId() != null && getId().equals(((ReportDetails) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ReportDetails{" +
            "id=" + getId() +
            ", owner='" + getOwner() + "'" +
            ", responder='" + getResponder() + "'" +
            ", description='" + getDescription() + "'" +
            ", title='" + getTitle() + "'" +
            ", timestamp='" + getTimestamp() + "'" +
            ", status='" + getStatus() + "'" +
            ", image='" + getImage() + "'" +
            ", imageContentType='" + getImageContentType() + "'" +
            ", video='" + getVideo() + "'" +
            ", videoContentType='" + getVideoContentType() + "'" +
            ", voiceData='" + getVoiceData() + "'" +
            ", voiceDataContentType='" + getVoiceDataContentType() + "'" +
            ", file1='" + getFile1() + "'" +
            ", file1ContentType='" + getFile1ContentType() + "'" +
            ", file2='" + getFile2() + "'" +
            ", file2ContentType='" + getFile2ContentType() + "'" +
            ", file3='" + getFile3() + "'" +
            ", file3ContentType='" + getFile3ContentType() + "'" +
            "}";
    }
}
