package com.software.ERP.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class user {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String phone;


    private String email;


    private String address;

    public user(String name, String phone, String email, String address){
        this.name=name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

}
