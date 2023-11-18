package com.carclinic.car_clinic_auto_workshop.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class VehicleDTO {

    private String vclId;
    private String cusId;
    private String vclCategory;
    private String manufacturer;
    private String model;
}
