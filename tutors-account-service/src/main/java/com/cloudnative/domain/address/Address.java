package com.cloudnative.domain.address;

import com.cloudnative.domain.AuditBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by msambangi on 10/26/17.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address extends AuditBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String streetName1;

    private String streetName2;

    private String city;

    private String county;

    private String state;

    private Integer zipcode;

    private String country;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    public Address(String street1, String street2, String city, String state, Integer zip, AddressType type) {
        this.streetName1 = street1;
        this.streetName2 = street2;
        this.city = city;
        this.state = state;
        this.zipcode = zip;
        this.addressType = type;
    }

}
