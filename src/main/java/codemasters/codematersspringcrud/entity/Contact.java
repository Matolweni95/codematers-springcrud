package codemasters.codematersspringcrud.entity;

import jakarta.persistence.*;
import java.time.Instant;

import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String mobileNumber;
    private String address;
    private String facebookUrl;
    private String instagramUrl;
    private String tiktokUrl;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adminId", insertable = false, updatable = false)
    private User user;

    public Contact() {
    }

    private Contact(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.mobileNumber = builder.mobileNumber;
        this.address = builder.address;
        this.facebookUrl = builder.facebookUrl;
        this.instagramUrl = builder.instagramUrl;
        this.tiktokUrl = builder.tiktokUrl;
        this.user = builder.user;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public static class Builder {
        private Integer id;
        private String email;
        private String mobileNumber;
        private String address;
        private String facebookUrl;
        private String instagramUrl;
        private String tiktokUrl;
        private User user;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder mobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder facebookUrl(String facebookUrl) {
            this.facebookUrl = facebookUrl;
            return this;
        }

        public Builder instagramUrl(String instagramUrl) {
            this.instagramUrl = instagramUrl;
            return this;
        }

        public Builder tiktokUrl(String tiktokUrl) {
            this.tiktokUrl = tiktokUrl;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFacebookUrl() {
        return this.facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getInstagramUrl() {
        return this.instagramUrl;
    }

    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }

    public String getTiktokUrl() {
        return this.tiktokUrl;
    }

    public void setTiktokUrl(String tiktokUrl) {
        this.tiktokUrl = tiktokUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
