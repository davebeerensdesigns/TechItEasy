package com.techiteasy.techiteasy.Dtos;

import com.techiteasy.techiteasy.model.RemoteController;

public class RemoteControllerInputDto {

    public String compatibleWith;
    public String batteryType;
    public String name;
    public String brand;
    public Double price;
    public Integer originalStock;

    public RemoteController toRemoteController() {

        var remotecontroller = new RemoteController();

        remotecontroller.setCompatibleWith(compatibleWith);
        remotecontroller.setBatteryType(batteryType);
        remotecontroller.setName(name);
        remotecontroller.setBrand(brand);
        remotecontroller.setPrice(price);
        remotecontroller.setOriginalStock(originalStock);

        return remotecontroller;
    }
}
