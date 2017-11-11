package com.cloudnative.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by msambangi on 10/26/17.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
