package com.company.WebBoot.model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;


@Entity
public class Features {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String title;
    @NotNull
    private String name;
    @NotNull
    private String text;
    @NotNull
    private int views;

    public Features(String title, String name, String text) {
        this.title = title;
        this.name = name;
        this.text = text;
    }

    public Features() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
