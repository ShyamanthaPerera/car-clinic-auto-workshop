package com.carclinic.car_clinic_auto_workshop.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class AppointmentDTO {
    private String appointmentId;
    private String customerId;
    private String vehicleId;
    private String slotId;
    private String date;
    private String time;
    private String issue;
}
