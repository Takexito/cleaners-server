package com.example.accessingdatarest.model;


import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String phone;
    private int age;
    private String city;
    private long trashBinId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private long trashPointId;
    private boolean isSubscribed;

    public long getTrashBinId() {
        return trashBinId;
    }

    public void setTrashBinId(long trashBinId) {
        this.trashBinId = trashBinId;
    }

    public long getTrashPointId() {
        return trashPointId;
    }

    public void setTrashPointId(long trashPointId) {
        this.trashPointId = trashPointId;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public void setSubscribed(boolean subscribed) {
        isSubscribed = subscribed;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    private boolean isConfirmed;
}
