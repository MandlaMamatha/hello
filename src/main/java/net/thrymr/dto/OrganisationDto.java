package net.thrymr.dto;


import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class OrganisationDto {

    private   Long orgId;
    private   String orgName;
    private   String orgEmail;
    private long contactNumber;
    private String description;
    private String aboutCompany;
    private AddressDto address;

//    public OrganisationDto(Long orgId) {
//        this.orgId = orgId;
//    }
}
