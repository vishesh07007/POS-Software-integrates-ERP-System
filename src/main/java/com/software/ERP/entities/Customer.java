package com.software.ERP.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "customers")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String email;
    private String address;

    private String customerType; //patient OR big party

    private LocalDate firstVisitDate;
    private LocalDate lastVisitDate;
}
