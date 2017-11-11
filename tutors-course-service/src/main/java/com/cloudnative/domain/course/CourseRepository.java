package com.cloudnative.domain.course;

import org.springframework.data.neo4j.repository.GraphRepository;

public interface CourseRepository extends GraphRepository<Course> {
}
