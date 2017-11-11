package com.cloudnative.domain.account;

import com.cloudnative.domain.AuditBaseEntity;
import com.cloudnative.domain.address.Address;
import com.cloudnative.domain.payment.Payment;
import com.cloudnative.domain.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by msambangi on 10/26/17.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account extends AuditBaseEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String accountId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Student> students = new HashSet();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Address> addresses = new HashSet();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Payment> payments = new HashSet();

    public Account(String accountId) {
        this.accountId = accountId;
    }
}
