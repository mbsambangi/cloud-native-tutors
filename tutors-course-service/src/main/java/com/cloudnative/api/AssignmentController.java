package com.cloudnative.api;

import com.cloudnative.domain.assignment.Assignment;
import com.cloudnative.domain.assignment.AssignmentRepository;
import com.cloudnative.domain.assignment.AssignmentService;
import com.cloudnative.dto.AssignmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("v1/assignments")
public class AssignmentController {

    @Autowired
    AssignmentService assignmentService;

    @Autowired
    AssignmentRepository assignmentRepository;

    @GetMapping(value = "{id}")
    public ResponseEntity<Assignment> get(@PathVariable Long id) {
        return ResponseEntity.ok(assignmentRepository.findOne(id));
    }

    @PostMapping
    public ResponseEntity<Assignment> post(@RequestBody AssignmentDto assignmentDto) {
        Assignment assignment = assignmentService.create(assignmentDto.getAssignmentName(), assignmentDto.getCourseId(), assignmentDto.getTeacherId());

        URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("{id}").buildAndExpand(assignment.getId()).toUri();

        return ResponseEntity.created(uri).body(assignment);
    }
}
