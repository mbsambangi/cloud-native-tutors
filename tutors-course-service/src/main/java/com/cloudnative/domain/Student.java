package com.cloudnative.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by msambangi on 11/2/17.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class Student {

    @GraphId
    private Long id;

    private String studentId, guardianId, firstName, lastName;

    public Student(String studentId, String guardianId, String firstName, String lastName) {
        this.studentId = studentId;
        this.guardianId = guardianId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
