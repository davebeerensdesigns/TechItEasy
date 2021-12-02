package com.techiteasy.techiteasy.services;

import com.techiteasy.techiteasy.Dtos.TelevisionDto;
import com.techiteasy.techiteasy.exceptions.RecordNotFoundException;
import com.techiteasy.techiteasy.model.Television;
import com.techiteasy.techiteasy.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private TelevisionRepository televisionRepository;

    @Autowired
    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<TelevisionDto> getTelevisions(){
        var dtos = new ArrayList<TelevisionDto>();
        var televisions = televisionRepository.findAll();

        for (Television television : televisions) {
            dtos.add(TelevisionDto.fromTelevision(television));
        }

        return dtos;
    }

    public Television getTelevision(long id){
        Optional<Television> optionalTelevision = televisionRepository.findById(id);

        if(optionalTelevision.isPresent()){
            return optionalTelevision.get();
        } else{
            // exception
            throw new RecordNotFoundException("ID does not exist!");
        }
    }

    public Television addTelevision(Television television){
        return televisionRepository.save(television);
    }

    public void deleteTelevision(long id){
        televisionRepository.deleteById(id);
    }

    public void updateTelevision(long id, Television television){
        if (!televisionRepository.existsById(id)) {
            throw new RecordNotFoundException("ID does not exist!");
        }
        Television existingTelevision = televisionRepository.findById(id).orElse(null);

        existingTelevision.setType(television.getType());
        existingTelevision.setBrand(television.getBrand());
        existingTelevision.setName(television.getName());
        existingTelevision.setPrice(television.getPrice());
        existingTelevision.setAvailableSize(television.getAvailableSize());
        existingTelevision.setRefreshRate(television.getRefreshRate());
        existingTelevision.setScreenType(television.getScreenType());
        existingTelevision.setScreenQuality(television.getScreenQuality());
        existingTelevision.setSmartTv(television.getSmartTv());
        existingTelevision.setVoiceControl(television.getVoiceControl());
        existingTelevision.setHdr(television.getHdr());
        existingTelevision.setBluetooth(television.getBluetooth());
        existingTelevision.setAmbiLight(television.getAmbiLight());
        existingTelevision.setOriginalStock(television.getOriginalStock());
        existingTelevision.setSold(television.getSold());

        televisionRepository.save(existingTelevision);
    }

}
