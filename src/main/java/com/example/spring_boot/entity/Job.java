package com.example.spring_boot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskid;
    @NotNull
    private int machineid;
    @NotNull
    private int proirty;
    @NotEmpty
    private String type;
    @NotEmpty
    private String description;


    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public int getMachineid() {
        return machineid;
    }

    public void setMachineid(int machineid) {
        this.machineid = machineid;
    }

    public int getProirty() {
        return proirty;
    }

    public void setProirty(int proirty) {
        this.proirty = proirty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Job() {
        super();
    }
}