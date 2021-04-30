package com.sp.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "superhero")
public class Superhero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String skill;
    private Integer weight;

    public Superhero(String name, String skill, int weight) {
        this.name = name;
        this.skill = skill;
        this.weight = weight;
    }

}
