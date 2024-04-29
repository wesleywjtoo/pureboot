package com.example.pureboot.repo;

import com.example.pureboot.model.Sp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PureBootRepo extends JpaRepository<Sp, UUID> {
}
