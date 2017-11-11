package com.cloudnative.domain.payment;

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
public class Payment extends AuditBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bankNumber;
    private String routingNumber;

    private String cardNumber;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    public Payment(String bankNumber, String routingNumber) {
        this.bankNumber = bankNumber;
        this.routingNumber = routingNumber;
        this.paymentType = PaymentType.BANK;
    }

    public Payment(String cardNumber) {
        this.cardNumber = cardNumber;
        this.paymentType = PaymentType.CREDITCARD;
    }
}
