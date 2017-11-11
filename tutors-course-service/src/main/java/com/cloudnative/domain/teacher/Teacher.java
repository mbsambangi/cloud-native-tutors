package com.cloudnative.domain.teacher;

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
public class Teacher {

    @GraphId
    private Long id;

    private String teacherId, firstName, lastName;

    public Teacher(String teacherId, String firstName, String lastName) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
