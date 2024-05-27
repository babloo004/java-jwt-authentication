package com.avinash.SpringJWT2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users2")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
}
