package com.techiteasy.techiteasy.Dtos;

import com.techiteasy.techiteasy.model.CiModule;

public class CiModuleDto {

    public Long id;
    public String type;
    public String name;
    public Double price;

    public static CiModuleDto fromCiModule(CiModule cimodule){

        var dto = new CiModuleDto();

        dto.id = cimodule.getId();
        dto.type = cimodule.getType();
        dto.name = cimodule.getName();
        dto.price = cimodule.getPrice();

        return dto;
    }
}
