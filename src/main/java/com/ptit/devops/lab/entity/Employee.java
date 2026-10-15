
package com.ptit.devops.lab.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Employee() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
