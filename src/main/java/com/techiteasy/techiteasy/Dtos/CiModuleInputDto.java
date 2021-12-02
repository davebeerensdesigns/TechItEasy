package com.techiteasy.techiteasy.Dtos;

import com.techiteasy.techiteasy.model.CiModule;

public class CiModuleInputDto {

    public String type;
    public String name;

    public Double price;

    public CiModule toCiModule() {

        var cimodule = new CiModule();

        cimodule.setType(type);
        cimodule.setName(name);
        cimodule.setPrice(price);

        return cimodule;
    }
}
