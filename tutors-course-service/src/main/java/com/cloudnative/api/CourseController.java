package com.cloudnative.api;


import com.cloudnative.domain.course.Course;
import com.cloudnative.domain.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("{id}")
    public ResponseEntity<Course> get(@PathVariable Long id) {
        return ResponseEntity.ok(courseRepository.findOne(id));
    }

    @PostMapping
    public ResponseEntity<Course> post(@RequestBody Course course) {
        Course course1 = courseRepository.save(course);

        URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(course1.getId()).toUri();

        return ResponseEntity.created(uri).body(course1);
    }
}
