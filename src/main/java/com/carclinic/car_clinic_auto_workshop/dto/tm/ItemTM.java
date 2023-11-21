package com.carclinic.car_clinic_auto_workshop.dto.tm;

import javafx.scene.layout.HBox;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ItemTM {
    private String item_id;
    private String model;
    private String description;
    private Double unit_price;
    private int qty_on_hand;
    private HBox btn;
}
