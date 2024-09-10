package com.example.overwork.entiry;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ApplyRecord")
public class ApplyRecord {
    @Id
    private Long id;

    private String username;
    private String record;
    private boolean start;


    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
