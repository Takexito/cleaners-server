package com.example.accessingdatarest.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private long clientId;
    @NotNull
    private long cleanerId;
    @NotNull
    private boolean isAccept;
    @NotNull
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getCleanerId() {
        return cleanerId;
    }

    public void setCleanerId(long cleanerId) {
        this.cleanerId = cleanerId;
    }

    public boolean isAccept() {
        return isAccept;
    }

    public void setAccept(boolean accept) {
        isAccept = accept;
    }
}
