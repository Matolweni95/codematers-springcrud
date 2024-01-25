package codemasters.codematersspringcrud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;

import java.time.Instant;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    @Column(name = "published_on")
    private Instant published_on;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Instant getPublished_on() {
        return published_on;
    }

    public void setPublished_on(Instant published_on) {
        this.published_on = Instant.from(published_on);
    }

    private String body;

    public Post(Long id, String title, String body, String picture, Instant published_on) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.picture = picture;
        this.published_on = published_on;
    }

    public Post() {
    }

    private String picture;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
