package com.techiteasy.techiteasy.repository;

import com.techiteasy.techiteasy.model.TelevisionWallBracketKey;
import com.techiteasy.techiteasy.model.TelevisionWallbracket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TelevisionWallBracketRepository extends JpaRepository<TelevisionWallbracket, TelevisionWallBracketKey> {
    Collection<TelevisionWallbracket> findAllByTelevisionId(Long televisionId);
    Collection<TelevisionWallbracket> findAllByWallBracketId(Long wallBracketId);
}