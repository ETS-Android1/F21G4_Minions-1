package com.example.f21g4_minions.Model;

public class Users {

    private String name, phone, password;

    public Users(){

    }
    //Generating constructors
    public Users(String name, String phone, String password) {
        this.name = name;
        this.phone = phone;
        this.password = password;
    }

    //Generating the getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

