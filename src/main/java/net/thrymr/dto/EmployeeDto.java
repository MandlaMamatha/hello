package net.thrymr.dto;


import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
@Data
@ToString
public class EmployeeDto {

    private  Long sNo;
    private int empId;
    private String empName;
    private String empEmail;
    private LocalDate dateOfJoining;
    private  LocalDate dateOfBirth;
    private String aboutEmployee;
    private Long orgId;

}
