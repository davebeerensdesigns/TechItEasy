package com.techiteasy.techiteasy.services;

import com.techiteasy.techiteasy.exceptions.RecordNotFoundException;
import com.techiteasy.techiteasy.model.CiModule;
import com.techiteasy.techiteasy.repository.CiModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiModuleService {

    private CiModuleRepository cimoduleRepository;

    @Autowired
    public CiModuleService(CiModuleRepository cimoduleRepository) {
        this.cimoduleRepository = cimoduleRepository;
    }

    public List<CiModule> getCiModules(){
        return cimoduleRepository.findAll();
    }

    public CiModule getCiModule(long id){
        Optional<CiModule> ciModule = cimoduleRepository.findById(id);

        if(ciModule.isPresent()){
            return ciModule.get();
        } else{
            // exception
            throw new RecordNotFoundException("No ci-module found!");
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
            throw new RecordNotFoundException("No ci-module found!");
        }
        CiModule storedCiModule = cimoduleRepository.findById(id).orElse(null);

        storedCiModule.setId(cimodule.getId());
        storedCiModule.setType(cimodule.getType());
        storedCiModule.setName(cimodule.getName());
        storedCiModule.setPrice(cimodule.getPrice());

        cimoduleRepository.save(storedCiModule);
    }

}