package com.cloudnative.domain.payment;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by msambangi on 10/26/17.
 */
public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long>    {
}
