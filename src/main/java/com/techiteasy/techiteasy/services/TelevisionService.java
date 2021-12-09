package com.techiteasy.techiteasy.services;

import com.techiteasy.techiteasy.exceptions.RecordNotFoundException;
import com.techiteasy.techiteasy.model.Television;
import com.techiteasy.techiteasy.repository.CiModuleRepository;
import com.techiteasy.techiteasy.repository.RemoteControllerRepository;
import com.techiteasy.techiteasy.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private TelevisionRepository televisionRepository;
    private RemoteControllerRepository remoteControllerRepository;
    private CiModuleRepository ciModuleRepository;

    @Autowired
    public TelevisionService(TelevisionRepository televisionRepository, RemoteControllerRepository remoteControllerRepository, CiModuleRepository ciModuleRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteControllerRepository = remoteControllerRepository;
        this.ciModuleRepository = ciModuleRepository;
    }

    public List<Television> getTelevisions(){
        return televisionRepository.findAll();
    }

    public Television getTelevision(long id){
        Optional<Television> television = televisionRepository.findById(id);

        if(television.isPresent()){
            return television.get();
        } else{
            // exception
            throw new RecordNotFoundException("No television found!");
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
            throw new RecordNotFoundException("No television found!");
        }
        Television existingTelevision = televisionRepository.findById(id).orElse(null);

        existingTelevision.setId(television.getId());
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

    public List<Television> getTelevisionsByBrand(String brand) {
        return televisionRepository.findAllByBrandContainingIgnoreCase(brand);
    }

    public void assignRemoteControllerToTelevision(long id, Long remotecontrollerId){
        var optionalTelevision = televisionRepository.findById(id);
        var optionalRemoteController = remoteControllerRepository.findById(remotecontrollerId);

        if(optionalTelevision.isPresent() && optionalRemoteController.isPresent()) {
            var television = optionalTelevision.get();
            var remoteController = optionalRemoteController.get();

            television.setRemoteController(remoteController);
            televisionRepository.save(television);
        } else {
            throw new RecordNotFoundException();
        }
    }

    public void assignCIModuleToTelevision(Long id, Long ciModuleId) {
        var optionalTelevision = televisionRepository.findById(id);
        var optionalCIModule = ciModuleRepository.findById(ciModuleId);

        if(optionalTelevision.isPresent() && optionalCIModule.isPresent()) {
            var television = optionalTelevision.get();
            var ciModule = optionalCIModule.get();

            television.setCiModule(ciModule);
            televisionRepository.save(television);
        } else {
            throw new RecordNotFoundException();
        }
    }
}
