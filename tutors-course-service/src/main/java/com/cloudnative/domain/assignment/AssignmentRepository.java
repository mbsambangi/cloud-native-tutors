package com.cloudnative.domain.assignment;

import org.springframework.data.neo4j.repository.GraphRepository;

public interface AssignmentRepository extends GraphRepository<Assignment> {
}
