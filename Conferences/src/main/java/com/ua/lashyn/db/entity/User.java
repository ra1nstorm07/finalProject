package com.ua.lashyn.db.entity;

public class User {
    private long id;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String password;
    private boolean admin_privilegies;


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public boolean getAdmin_privilegies() {
        return admin_privilegies;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAdmin_privilegies(boolean admin_privilegies) {
        this.admin_privilegies = admin_privilegies;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", admin_privilegies=" + admin_privilegies +
                '}';
    }
}
