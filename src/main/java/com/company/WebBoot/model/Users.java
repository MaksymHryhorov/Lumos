package com.company.WebBoot.model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @NotNull
    private String firstName;

    @NotNull
    private String secondName;

    public Users(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Features> features;

    public Users() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
