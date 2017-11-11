package com.cloudnative.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentDto {

    private String assignmentName;

    private Long courseId, teacherId;
}
