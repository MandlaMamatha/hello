package net.thrymr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

    Long sNo;
    int empId;

    String empName;

    String empEmail;

    LocalDate dateOfJoining;

    LocalDate dateOfBirth;

    String aboutEmployee;

     Long orgId;

}

