package com.cloudnative.api;

import com.cloudnative.domain.student.Student;
import com.cloudnative.domain.student.StudentRepository;
import com.cloudnative.error.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("v1/students")
public class StudentsController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<?> options() {
        return ResponseEntity.ok().allow(HttpMethod.GET, HttpMethod.DELETE, HttpMethod.HEAD, HttpMethod.OPTIONS, HttpMethod.POST, HttpMethod.PUT).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(this.studentRepository.findOne(id));
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<Student> post(@RequestBody Student student) {
        Student student1 = studentRepository.save(student);

        URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(student1.getId()).toUri();

        return ResponseEntity.created(uri).body(student1);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Student> put(@PathVariable Long id, @RequestBody Student student) throws StudentNotFoundException {
    return studentRepository.findById(id).map(existing -> {
            student.setCreatedAt(existing.getCreatedAt());
            Student student1 = this.studentRepository.save(student);
            URI selfLink = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().toUriString());
            return ResponseEntity.created(selfLink).body(student1);
        }).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) throws StudentNotFoundException {
        return this.studentRepository.findById(id).map(g -> {
            studentRepository.delete(id);
            return ResponseEntity.noContent().build();
        }).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.HEAD)
    ResponseEntity<?> head(@PathVariable Long id) throws StudentNotFoundException {
        return this.studentRepository.findById(id).map(exists -> ResponseEntity.noContent().build()).orElseThrow(() -> new StudentNotFoundException(id));
    }


}
