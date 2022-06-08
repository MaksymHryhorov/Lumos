package com.company.WebBoot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Features {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "Title shouldn't be empty")
    @Size(message = "Size symbols of the title must be more than 5")
    private String title;

    @NotEmpty(message = "Name shouldn't be empty")
    @Size(message = "Size symbols of the title must be more than 5")
    private String name;

    @NotEmpty(message = "Test shouldn't be empty")
    @Size(message = "Size symbols of the title must be more than 5")
    private String text;

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
