package com.cloudnative.domain.teacher;

import org.springframework.data.neo4j.repository.GraphRepository;

public interface TeacherRepository extends GraphRepository<Teacher> {
}
