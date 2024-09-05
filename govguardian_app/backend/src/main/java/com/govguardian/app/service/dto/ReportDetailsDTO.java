package com.govguardian.app.service.dto;

import jakarta.persistence.Lob;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.govguardian.app.domain.ReportDetails} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ReportDetailsDTO implements Serializable {

    private Long id;

    private String owner;

    private String responder;

    private String description;

    private String title;

    private ZonedDateTime timestamp;

    private String status;

    @Lob
    private byte[] image;

    private String imageContentType;

    @Lob
    private byte[] video;

    private String videoContentType;

    @Lob
    private byte[] voiceData;

    private String voiceDataContentType;

    @Lob
    private byte[] file1;

    private String file1ContentType;

    @Lob
    private byte[] file2;

    private String file2ContentType;

    @Lob
    private byte[] file3;

    private String file3ContentType;
    private AppUserDTO appUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getResponder() {
        return responder;
    }

    public void setResponder(String responder) {
        this.responder = responder;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
    }

    public String getVideoContentType() {
        return videoContentType;
    }

    public void setVideoContentType(String videoContentType) {
        this.videoContentType = videoContentType;
    }

    public byte[] getVoiceData() {
        return voiceData;
    }

    public void setVoiceData(byte[] voiceData) {
        this.voiceData = voiceData;
    }

    public String getVoiceDataContentType() {
        return voiceDataContentType;
    }

    public void setVoiceDataContentType(String voiceDataContentType) {
        this.voiceDataContentType = voiceDataContentType;
    }

    public byte[] getFile1() {
        return file1;
    }

    public void setFile1(byte[] file1) {
        this.file1 = file1;
    }

    public String getFile1ContentType() {
        return file1ContentType;
    }

    public void setFile1ContentType(String file1ContentType) {
        this.file1ContentType = file1ContentType;
    }

    public byte[] getFile2() {
        return file2;
    }

    public void setFile2(byte[] file2) {
        this.file2 = file2;
    }

    public String getFile2ContentType() {
        return file2ContentType;
    }

    public void setFile2ContentType(String file2ContentType) {
        this.file2ContentType = file2ContentType;
    }

    public byte[] getFile3() {
        return file3;
    }

    public void setFile3(byte[] file3) {
        this.file3 = file3;
    }

    public String getFile3ContentType() {
        return file3ContentType;
    }

    public void setFile3ContentType(String file3ContentType) {
        this.file3ContentType = file3ContentType;
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
        if (!(o instanceof ReportDetailsDTO)) {
            return false;
        }

        ReportDetailsDTO reportDetailsDTO = (ReportDetailsDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, reportDetailsDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ReportDetailsDTO{" +
            "id=" + getId() +
            ", owner='" + getOwner() + "'" +
            ", responder='" + getResponder() + "'" +
            ", description='" + getDescription() + "'" +
            ", title='" + getTitle() + "'" +
            ", timestamp='" + getTimestamp() + "'" +
            ", status='" + getStatus() + "'" +
            ", image='" + getImage() + "'" +
            ", video='" + getVideo() + "'" +
            ", voiceData='" + getVoiceData() + "'" +
            ", file1='" + getFile1() + "'" +
            ", file2='" + getFile2() + "'" +
            ", file3='" + getFile3() + "'" +
            ", appUser=" + getAppUser() +
            "}";
    }
}
