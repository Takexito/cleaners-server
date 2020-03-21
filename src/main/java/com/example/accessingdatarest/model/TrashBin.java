package com.example.accessingdatarest.model;

import javax.persistence.*;

@Entity
@Table(name = "bins")
public class TrashBin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String location;
    private boolean isSeparate;

    public TrashBin() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isSeparate() {
        return isSeparate;
    }

    public void setSeparate(boolean separate) {
        isSeparate = separate;
    }

}
