package com.cloudnative.domain.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by msambangi on 10/26/17.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findById(Long id);
}
