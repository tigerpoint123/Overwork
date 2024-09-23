package com.example.overwork.entiry;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TotalAdmin {
    @Id
    private Long id;

    private String name;
    private String job;
    private int carrer;
    private String department;

    public int getCarrer() {
        return carrer;
    }

    public void setCarrer(int carrer) {
        this.carrer = carrer;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
