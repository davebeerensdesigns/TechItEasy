package com.techiteasy.techiteasy.Dtos;

import com.techiteasy.techiteasy.model.CiModule;

public class CiModuleDto {

    public Long id;
    public String type;
    public String name;
    public Double price;

    public static CiModuleDto fromCiModule(CiModule ciModule){

        var dto = new CiModuleDto();

        dto.id = ciModule.getId();
        dto.type = ciModule.getType();
        dto.name = ciModule.getName();
        dto.price = ciModule.getPrice();

        return dto;
    }
}
