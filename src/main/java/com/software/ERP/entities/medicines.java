package com.software.ERP.entities;

import jakarta.persistence.*;

@Entity
public class medicines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String manufacturer;




    @Column(nullable = false)
    private String genericName;  // e.g., "Paracetamol"

    @Column(nullable = false, unique = true)
    private String code;  // Unique medicine code (like SKU)








}
