package codemasters.codematersspringcrud.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "AboutUs")
public class About {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 65535)
    private String about_us;
    @Column(length = 65535)
    private String mission;
    @Column(length = 65535)
    private String vision;
    @Column(length = 65535)
    private String admin_id;
    @Column(length = 65535)
    private Instant date;
    public About() {
    }

    public About(Integer id, String about_us, String mission, String vision,String admin_id, Instant date) {
        this.id = id;
        this.about_us = about_us;
        this.mission = mission;
        this.vision = vision;
        this.admin_id = admin_id;
        this.date = date;
    }

    public About(String about_us, String mission, String vision,String admin_id, Instant date) {
        this.about_us = about_us;
        this.mission = mission;
        this.vision = vision;
        this.admin_id = admin_id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbout_us() {
        return about_us;
    }

    public void setAbout_us(String about_us) {
        this.about_us = about_us;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getVision() {
        return vision;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }
    public void setVision(String vision) {
        this.vision = vision;
    }
    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "About{" +
                "id=" + id +
                ", about_us='" + about_us + '\'' +
                ", mission='" + mission + '\'' +
                ", vision='" + vision + '\'' +
                ", admin_id='" + admin_id + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
