package com.techiteasy.techiteasy.Dtos;

import com.techiteasy.techiteasy.model.CiModule;

public class CiModuleInputDto {

    public String type;
    public String name;
    public Double price;

    public CiModule toCiModule() {

        var ciModule = new CiModule();

        ciModule.setType(type);
        ciModule.setName(name);
        ciModule.setPrice(price);

        return ciModule;
    }
}
