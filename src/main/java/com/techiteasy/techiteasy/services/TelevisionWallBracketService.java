package com.techiteasy.techiteasy.services;

import com.techiteasy.techiteasy.exceptions.RecordNotFoundException;
import com.techiteasy.techiteasy.model.Television;
import com.techiteasy.techiteasy.model.TelevisionWallBracketKey;
import com.techiteasy.techiteasy.model.TelevisionWallbracket;
import com.techiteasy.techiteasy.model.WallBracket;
import com.techiteasy.techiteasy.repository.TelevisionRepository;
import com.techiteasy.techiteasy.repository.TelevisionWallBracketRepository;
import com.techiteasy.techiteasy.repository.WallBracketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class TelevisionWallBracketService {
    private final TelevisionRepository televisionRepository;
    private final WallBracketRepository wallBracketRepository;
    private final TelevisionWallBracketRepository televisionWallBracketRepository;

    @Autowired
    public TelevisionWallBracketService(TelevisionRepository televisionRepository,
                                        WallBracketRepository wallBracketRepository,
                                        TelevisionWallBracketRepository televisionWallBracketRepository){
        this.televisionRepository = televisionRepository;
        this.wallBracketRepository = wallBracketRepository;
        this.televisionWallBracketRepository = televisionWallBracketRepository;
    }

    public Collection<Television> getTelevisionWallBracketsByWallBracketId(Long wallBracketId) {
        Collection<Television> televisions = new HashSet<>();
        Collection<TelevisionWallbracket> televisionWallbrackets = televisionWallBracketRepository.findAllByWallBracketId(wallBracketId);
        for (TelevisionWallbracket televisionWallbracket : televisionWallbrackets) {
            televisions.add(televisionWallbracket.getTelevision());
        }
        return televisions;
    }

    public Collection<WallBracket> getTelevisionWallBracketByTelevisionId(Long televisionId) {
        Collection<WallBracket> wallBrackets = new HashSet<>();
        Collection<TelevisionWallbracket> televisionWallbrackets = televisionWallBracketRepository.findAllByTelevisionId(televisionId);
        for (TelevisionWallbracket televisionWallbracket : televisionWallbrackets) {
            wallBrackets.add(televisionWallbracket.getWallBracket());
        }
        return wallBrackets;
    }


    public TelevisionWallBracketKey addTelevisionWallBracket(Long televisionId, Long wallBracketId) {
        var televisionWallBracket = new TelevisionWallbracket();
        if (!televisionRepository.existsById(televisionId)) {throw new RecordNotFoundException();}
        Television television = televisionRepository.findById(televisionId).orElse(null);
        if (!wallBracketRepository.existsById(wallBracketId)) {throw new RecordNotFoundException();}
        WallBracket wallBracket = wallBracketRepository.findById(wallBracketId).orElse(null);
        televisionWallBracket.setTelevision(television);
        televisionWallBracket.setWallBracket(wallBracket);
        TelevisionWallBracketKey id = new TelevisionWallBracketKey(televisionId, wallBracketId);
        televisionWallBracket.setId(id);
        televisionWallBracketRepository.save(televisionWallBracket);
        return id;
    }
}