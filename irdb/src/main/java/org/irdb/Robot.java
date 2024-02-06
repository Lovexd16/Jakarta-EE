package org.irdb;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "t_robot") //Byter namn på table
public class Robot {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private UUID serialNr;
    @Column(length = 200, name = "robot_name") //Byter längd och namn på robotname
    @NotEmpty(message = "Du måste ange ett namn") //robotnamn måste existera och kan inte vara tomt
    private String robotName; //i postman skickas det fortfarande in som detta namn
    @Size(min=2, max=30) //Jobb-titeln måste vara minst 2- oh max 30 bokstäver
    private String job;
    @NotNull //bild-värdet måste existera, men kan vara tomt
    private String image;
    private String city;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public UUID getSerialNr() {
        return serialNr;
    }
    public void setSerialNr(UUID serialNr) {
        this.serialNr = serialNr;
    }
    public String getRobotName() {
        return robotName;
    }
    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    
}
