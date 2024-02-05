package org.irdb;

import java.util.UUID;

public class Robot {
    private Long id;
    private UUID serialNr;
    private String robotName;
    private String job;
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