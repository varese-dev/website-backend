package fullstack.persistence.model;

import jakarta.persistence.*;

@Entity
@Table(name = "partner")
public class Partner {
    @Id
    @Column(columnDefinition = "CHAR(36)")
    private String id;
    private String name;
    private String description;
    private String place;
    private String website;
    private String email;
    private String image;
    @Enumerated(EnumType.STRING)
    private Value value = Value.BRONZE;

    public Partner(String id, String name, String description, String place, String website, String email, String image, Value value) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.place = place;
        this.website = website;
        this.email = email;
        this.image = image;
        this.value = value;
    }

    public Partner() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
