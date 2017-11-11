package com.cloudnative.api;


import com.cloudnative.domain.teacher.Teacher;
import com.cloudnative.domain.teacher.TeacherRepository;
import org.bouncycastle.jcajce.provider.symmetric.TEA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/teachers")
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping(value = "{id}")
    public ResponseEntity<Teacher> get(@PathVariable Long id) {
        return ResponseEntity.ok(teacherRepository.findOne(id));
    }

    @PostMapping
    public ResponseEntity<Teacher> post(@RequestBody Teacher teacher) {
        Teacher teacher1 = teacherRepository.save(teacher);

        URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(teacher1.getId()).toUri();

        return ResponseEntity.created(uri).body(teacher1);
    }
}
