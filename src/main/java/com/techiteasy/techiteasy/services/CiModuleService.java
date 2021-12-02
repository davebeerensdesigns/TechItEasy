package com.techiteasy.techiteasy.services;

import com.techiteasy.techiteasy.Dtos.CiModuleDto;
import com.techiteasy.techiteasy.exceptions.RecordNotFoundException;
import com.techiteasy.techiteasy.model.CiModule;
import com.techiteasy.techiteasy.repository.CiModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CiModuleService {

    private CiModuleRepository cimoduleRepository;

    @Autowired
    public CiModuleService(CiModuleRepository cimoduleRepository) {
        this.cimoduleRepository = cimoduleRepository;
    }

    public List<CiModuleDto> getCiModules(){
        var dtos = new ArrayList<CiModuleDto>();
        var cimodules = cimoduleRepository.findAll();

        for (CiModule cimodule : cimodules) {
            dtos.add(CiModuleDto.fromCiModule(cimodule));
        }

        return dtos;
    }

    public CiModule getCiModule(long id){
        Optional<CiModule> optionalCiModule = cimoduleRepository.findById(id);

        if(optionalCiModule.isPresent()){
            return optionalCiModule.get();
        } else{
            // exception
            throw new RecordNotFoundException("ID does not exist!");
        }
    }

    public CiModule addCiModule(CiModule cimodule){
        return cimoduleRepository.save(cimodule);
    }

    public void deleteCiModule(long id){
        cimoduleRepository.deleteById(id);
    }

    public void updateCiModule(long id, CiModule cimodule){
        if (!cimoduleRepository.existsById(id)) {
            throw new RecordNotFoundException("ID does not exist!");
        }
        CiModule existingCiModule = cimoduleRepository.findById(id).orElse(null);

        existingCiModule.setName(cimodule.getName());
        existingCiModule.setType(cimodule.getType());
        existingCiModule.setPrice(cimodule.getPrice());

        cimoduleRepository.save(existingCiModule);
    }

}