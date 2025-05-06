package fullstack.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "speaker")
public class Speaker {
    @Id
    @Column(columnDefinition = "CHAR(36)")
    private String id;
    @Column(name = "user_id")
    private String userId;
    private String name;
    private String surname;
    private String biography;
    private String image;
    private String linkedin;

    public Speaker(String id, String userId, String name, String surname, String biography, String image, String linkedin) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.biography = biography;
        this.image = image;
        this.linkedin = linkedin;
    }

    public Speaker() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
}
