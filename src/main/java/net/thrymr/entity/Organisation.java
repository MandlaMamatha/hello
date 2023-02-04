package net.thrymr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;


//Organisation - Name, description, contact number, contact email, about company
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organisation")
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orgId;

    @Column(nullable = false)
    String orgName;
    @Column(unique = true)
    String orgEmail;
    @Column(nullable = false)
    long contactNumber;
    @Column(columnDefinition = "TEXT",nullable = false)
    String description;
    @Column(columnDefinition = "TEXT")
    String aboutCompany;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "addressId")
    Address address;

    @JsonIgnore
    @OneToMany
    List<Employee> empDataList;

}
