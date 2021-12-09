package com.techiteasy.techiteasy.controllers;

import com.techiteasy.techiteasy.Dtos.CiModuleDto;
import com.techiteasy.techiteasy.Dtos.CiModuleInputDto;
import com.techiteasy.techiteasy.model.CiModule;
import com.techiteasy.techiteasy.services.CiModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CiModuleController {

    private final CiModuleService ciModuleService;

    @Autowired
    public CiModuleController(CiModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }


    @GetMapping("/cimodules")
    public List<CiModuleDto> getCiModules() {

        var dtos = new ArrayList<CiModuleDto>();

        var ciModules = ciModuleService.getCiModules();

        for (CiModule ciModule : ciModules){
            dtos.add(CiModuleDto.fromCiModule(ciModule));
        }

        return dtos;

    }


    @GetMapping("/cimodules/{id}")
    public CiModuleDto getCiModule(@PathVariable("id") long id) {
        var cimodule = ciModuleService.getCiModule(id);

        return CiModuleDto.fromCiModule(cimodule);
    }

    @PostMapping("/cimodules")
    public CiModuleDto addCiModule(@RequestBody CiModuleInputDto dto) {
        var cimodule = ciModuleService.addCiModule(dto.toCiModule());
        return CiModuleDto.fromCiModule(cimodule);
    }


    @DeleteMapping("/cimodules/{id}")
    public void deleteCiModule(@PathVariable("id") Long id) {
        ciModuleService.deleteCiModule(id);
    }


    @PutMapping("cimodules/{id}")
    public CiModuleDto updateCiModule(@PathVariable("id") Long id, @RequestBody CiModule cimodule) {
        ciModuleService.updateCiModule(id, cimodule);
        return CiModuleDto.fromCiModule(cimodule);
    }


}
