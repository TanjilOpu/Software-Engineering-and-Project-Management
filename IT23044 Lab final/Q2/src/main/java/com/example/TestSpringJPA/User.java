package com.example.TestSpringJPA;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    private Long id; // This is now the Student ID
    private String name;
    private Double cgpa;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getCgpa() { return cgpa; }
    public void setCgpa(Double cgpa) { this.cgpa = cgpa; }
}