package com.techiteasy.techiteasy.Dtos;

import com.techiteasy.techiteasy.model.RemoteController;

public class RemoteControllerDto {

    public Long id;
    public String compatibleWith;
    public String batteryType;
    public String name;
    public String brand;
    public Double price;
    public Integer originalStock;

    public static RemoteControllerDto fromRemoteController(RemoteController remotecontroller){

        var dto = new RemoteControllerDto();

        dto.id = remotecontroller.getId();
        dto.compatibleWith = remotecontroller.getCompatibleWith();
        dto.batteryType = remotecontroller.getBatteryType();
        dto.name = remotecontroller.getName();
        dto.brand = remotecontroller.getBrand();
        dto.price = remotecontroller.getPrice();
        dto.originalStock = remotecontroller.getOriginalStock();

        return dto;
    }
}