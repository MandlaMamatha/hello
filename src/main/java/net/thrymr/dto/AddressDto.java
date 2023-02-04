package net.thrymr.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AddressDto {

    private Long addressId;
    private  int floorNo;
    private  String landmark;
    private String city;
    private String state;
    private String country;
}
