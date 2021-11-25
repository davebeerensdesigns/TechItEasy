package com.techiteasy.techiteasy.repository;

import com.techiteasy.techiteasy.model.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TelevisionRepository extends JpaRepository<Television, Long> {

    @Query("SELECT t FROM Television t WHERE t.name LIKE CONCAT('%',:s,'%')")
    Iterable<Television> searchByTitleLike(@Param("s") String s);
}


