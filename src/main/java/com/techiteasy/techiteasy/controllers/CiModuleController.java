package com.techiteasy.techiteasy.controllers;

import com.techiteasy.techiteasy.Dtos.CiModuleDto;
import com.techiteasy.techiteasy.Dtos.CiModuleInputDto;
import com.techiteasy.techiteasy.model.CiModule;
import com.techiteasy.techiteasy.services.CiModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CiModuleController {

    private CiModuleService cimoduleService;

    @Autowired
    public CiModuleController(CiModuleService cimoduleService) {
        this.cimoduleService = cimoduleService;
    }


    @GetMapping("/cimodules")
    public List<CiModuleDto> getCiModules() {

        return cimoduleService.getCiModules();

    }


    @GetMapping("/cimodules/{id}")
    public CiModuleDto getCiModule(@PathVariable("id") long id) {
        var cimodule = cimoduleService.getCiModule(id);

        return CiModuleDto.fromCiModule(cimodule);
    }

    @PostMapping("/cimodules")
    public CiModuleDto addCiModule(@RequestBody CiModuleInputDto dto) {
        var cimodule = cimoduleService.addCiModule(dto.toCiModule());
        return CiModuleDto.fromCiModule(cimodule);
    }


    @DeleteMapping("/cimodules/{id}")
    public void deleteCiModule(@PathVariable("id") Long id) {
        cimoduleService.deleteCiModule(id);
    }


    @PutMapping("cimodules/{id}")
    public CiModuleDto updateCiModule(@PathVariable("id") Long id, @RequestBody CiModule cimodule) {
        cimoduleService.updateCiModule(id, cimodule);
        return CiModuleDto.fromCiModule(cimodule);
    }


}
