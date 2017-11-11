package com.cloudnative.domain.guardian;

import com.cloudnative.domain.AuditBaseEntity;
import com.cloudnative.domain.account.Account;
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
public class Guardian extends AuditBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    public Guardian(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Guardian(String firstName, String lastName, String email, String phoneNumber, Account account) {
        this(firstName, lastName, email, phoneNumber);
        this.account = account;
    }
}
