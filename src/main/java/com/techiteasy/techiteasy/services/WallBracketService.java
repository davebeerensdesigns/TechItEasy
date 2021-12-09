package com.techiteasy.techiteasy.services;

import com.techiteasy.techiteasy.Dtos.WallBracketDto;
import com.techiteasy.techiteasy.exceptions.RecordNotFoundException;
import com.techiteasy.techiteasy.model.WallBracket;
import com.techiteasy.techiteasy.repository.WallBracketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallBracketService {

    private WallBracketRepository wallbracketRepository;

    @Autowired
    public WallBracketService(WallBracketRepository wallbracketRepository) {
        this.wallbracketRepository = wallbracketRepository;
    }

    public List<WallBracket> getWallBrackets(){
        return wallbracketRepository.findAll();
    }

    public WallBracket getWallBracket(long id){
        Optional<WallBracket> wallBracket = wallbracketRepository.findById(id);

        if(wallBracket.isPresent()){
            return wallBracket.get();
        } else{
            // exception
            throw new RecordNotFoundException("No wallbracket found!");
        }
    }

    public WallBracket addWallBracket(WallBracket wallbracket){
        return wallbracketRepository.save(wallbracket);
    }

    public void deleteWallBracket(long id){
        wallbracketRepository.deleteById(id);
    }

    public void updateWallBracket(long id, WallBracket wallBracket){
        if (!wallbracketRepository.existsById(id)) {
            throw new RecordNotFoundException("No wallbracket found!");
        }
        WallBracket existingWallBracket = wallbracketRepository.findById(id).orElse(null);

        existingWallBracket.setId(wallBracket.getId());
        existingWallBracket.setSize(wallBracket.getSize());
        existingWallBracket.setAdjustable(wallBracket.getAdjustable());
        existingWallBracket.setName(wallBracket.getName());
        existingWallBracket.setPrice(wallBracket.getPrice());

        wallbracketRepository.save(existingWallBracket);
    }

}