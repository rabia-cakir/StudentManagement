package com.example.studentmanagement.entity;

import javax.persistence.*;
//entity annotation specifies that the class is an entity
@Entity
//table annotation specifies the table in the database with which this entity is mapped
//if you don't add table annotation then jpa by default add table name as name of the class
@Table(name="students")
public class Student {
    //id annotation specifies the primary key of the entity
    @Id
    //generatedValue annotation specifies the generation strategies for the values of primary keys
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //if you don't add column annotation then jpa by default add column name as name of the field
    @Column(name="first_name", nullable=false)
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    public Student() {
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
