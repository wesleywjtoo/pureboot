package com.example.pureboot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Sp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spid")
    private UUID spId;

    @Column(name = "spcode") private String spCode;
    @Column(name = "spname") private String spName;
    @Column(name = "datejoin") private LocalDateTime dateJoin;
}
