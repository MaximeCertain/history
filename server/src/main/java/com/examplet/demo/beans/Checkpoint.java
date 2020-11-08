package com.examplet.demo.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class)
public class Checkpoint {
    @Id
    @GeneratedValue
    private int id;

    private String description;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = {CascadeType.ALL})
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
