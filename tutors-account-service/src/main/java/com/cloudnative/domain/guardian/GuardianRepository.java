package com.cloudnative.domain.guardian;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by msambangi on 10/26/17.
 */
public interface GuardianRepository extends JpaRepository<Guardian, Long> {

    Optional<Guardian> findById(Long id);
}
