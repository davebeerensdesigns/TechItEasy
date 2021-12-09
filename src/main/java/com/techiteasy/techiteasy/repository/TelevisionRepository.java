package com.techiteasy.techiteasy.repository;

import com.techiteasy.techiteasy.model.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
    List<Television> findAllByBrandContainingIgnoreCase(String brand);
}


