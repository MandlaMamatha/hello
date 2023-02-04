package net.thrymr.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long addressId;
    int floorNo;
    @Column(nullable = false)
    String landmark;
    @Column(nullable = false)
    String city;
    @Column(nullable = false)
    String state;
    @Column(nullable = false)
    String country;


}
