package com.example.accessingdatarest.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cleaners")
public class Cleaner{
    @Id
    private long id;
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
    @NotNull
    @NotBlank
    private String phone;
    @NotNull
    private int age;
    @NotNull
    @NotBlank
    private String city;
    private int rank;
    private int balance;
    private long ordersId;
    private Long[] itemOrdersId;

    public void copyFromClient(Client client){
        id = client.getId();
        firstName = client.getFirstName();
        lastName = client.getLastName();
        phone = client.getPhone();
        age = client.getAge();
        city = client.getCity();
    }

    public void plusBalance(int value){
        balance += value;
    }

    public void minusBalance(int value){
        balance -= value;
    }

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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void incRank(){
        rank++;
    }

    public void decRank(){
        rank--;
    }

    public long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(long ordersId) {
        this.ordersId = ordersId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Long[] getItemOrdersId() {
        return itemOrdersId;
    }

    public void setItemOrdersId(Long[] itemOrdersId) {
        this.itemOrdersId = itemOrdersId;
    }
}
