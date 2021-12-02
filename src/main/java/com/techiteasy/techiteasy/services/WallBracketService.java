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

    public List<WallBracketDto> getWallBrackets(){
        var dtos = new ArrayList<WallBracketDto>();
        var wallbrackets = wallbracketRepository.findAll();

        for (WallBracket wallbracket : wallbrackets) {
            dtos.add(WallBracketDto.fromWallBracket(wallbracket));
        }

        return dtos;
    }

    public WallBracket getWallBracket(long id){
        Optional<WallBracket> optionalWallBracket = wallbracketRepository.findById(id);

        if(optionalWallBracket.isPresent()){
            return optionalWallBracket.get();
        } else{
            // exception
            throw new RecordNotFoundException("ID does not exist!");
        }
    }

    public WallBracket addWallBracket(WallBracket wallbracket){
        return wallbracketRepository.save(wallbracket);
    }

    public void deleteWallBracket(long id){
        wallbracketRepository.deleteById(id);
    }

    public void updateWallBracket(long id, WallBracket wallbracket){
        if (!wallbracketRepository.existsById(id)) {
            throw new RecordNotFoundException("ID does not exist!");
        }
        WallBracket existingWallBracket = wallbracketRepository.findById(id).orElse(null);

        existingWallBracket.setSize(wallbracket.getSize());
        existingWallBracket.setAdjustable(wallbracket.getAdjustable());
        existingWallBracket.setName(wallbracket.getName());
        existingWallBracket.setPrice(wallbracket.getPrice());

        wallbracketRepository.save(existingWallBracket);
    }

}