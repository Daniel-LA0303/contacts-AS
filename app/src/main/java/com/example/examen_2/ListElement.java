package com.example.examen_2;

public class ListElement {
    public String name;
    public String city;
    public String status;
    public String id;
    public ListElement(String name, String city, String status, String id) {
        this.name = name;
        this.city = city;
        this.status = status;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
