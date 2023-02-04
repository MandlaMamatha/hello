package net.thrymr.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long sNo;

    @Column(unique = true)
    int empId;
    @Column(nullable = false)
    String empName;
    @Column(nullable = false)
     String empEmail;
    @Column(nullable = false)
    LocalDate dateOfJoining;
    @Column(nullable = false)
    LocalDate dateOfBirth;
    @Column(columnDefinition = "TEXT")
    String aboutEmployee;
     Long orgId;

}
