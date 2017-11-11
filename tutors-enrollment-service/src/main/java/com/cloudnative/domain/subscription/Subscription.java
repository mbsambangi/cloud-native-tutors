package com.cloudnative.domain.subscription;

import com.cloudnative.domain.Address;
import com.cloudnative.domain.AuditBaseEntity;
import com.cloudnative.domain.SubscriptionStatus;
import com.cloudnative.domain.enrollment.Enrollment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msambangi on 11/2/17.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Subscription extends AuditBaseEntity {

    @Id
    private String subscriptionId;

    private String guardianId;

    private List<Enrollment> enrollments = new ArrayList<Enrollment>();

    private Address billingAddress;

    private SubscriptionStatus subscriptionStatus;

    public Subscription(String guardianId, Address billingAddress) {
        this.guardianId = guardianId;
        this.billingAddress = billingAddress;
        this.subscriptionStatus = SubscriptionStatus.CREATED;
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollment.setAccountNumber(this.guardianId);
        enrollments.add(enrollment);
    }

}
