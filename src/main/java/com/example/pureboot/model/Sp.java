package com.example.pureboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spid")
    private UUID spId;

    @Column(name = "spcode") private String spCode;
    @Column(name = "spname") private String spName;
    @Column(name = "datejoin") private LocalDateTime dateJoin;
}
