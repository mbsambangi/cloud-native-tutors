package com.cloudnative.domain.address;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by msambangi on 10/26/17.
 */
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
}
