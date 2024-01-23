package codemasters.codematersspringcrud.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "ImageUrl")
public class AboutImage {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 65535)
    private String imageUrl;
    @Column(length = 50)
    private String category;

    @Column(length = 50)
    private String admin_id;
    @Column(length = 50)
    private Instant date;

    public AboutImage() {
    }

    public AboutImage(String imageUrl, String category, String admin_id, Instant date) {
        this.imageUrl = imageUrl;
        this.category = category;
        this.admin_id = admin_id;
        this.date = date;
    }

    public AboutImage(Integer id, String imageUrl, String category,String admin_id, Instant date) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.category = category;
        this.admin_id = admin_id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AboutImage{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", category='" + category + '\'' +
                ", admin_id='" + admin_id + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}
