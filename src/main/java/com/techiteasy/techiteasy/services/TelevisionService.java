package com.techiteasy.techiteasy.services;

import com.techiteasy.techiteasy.Dtos.IdInputDto;
import com.techiteasy.techiteasy.Dtos.TelevisionDto;
import com.techiteasy.techiteasy.exceptions.RecordNotFoundException;
import com.techiteasy.techiteasy.model.RemoteController;
import com.techiteasy.techiteasy.model.Television;
import com.techiteasy.techiteasy.repository.RemoteControllerRepository;
import com.techiteasy.techiteasy.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private TelevisionRepository televisionRepository;

    private RemoteControllerRepository remoteControllerRepository;

    @Autowired
    public TelevisionService(TelevisionRepository televisionRepository, RemoteControllerRepository remoteControllerRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteControllerRepository = remoteControllerRepository;
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

    public void assignRemoteControllerToTelevision(long id, IdInputDto remote_id){
        if (!televisionRepository.existsById(id)) {
            throw new RecordNotFoundException("ID does not exist!");
        }
        if (!remoteControllerRepository.existsById(remote_id.id)) {
            throw new RecordNotFoundException("ID does not exist!");
        }
        Television television = televisionRepository.findById(id).orElse(null);
        RemoteController remoteController = remoteControllerRepository.findById(remote_id.id).orElse(null);
        television.setRemoteController(remoteController);
        televisionRepository.save(television);
    }
}
