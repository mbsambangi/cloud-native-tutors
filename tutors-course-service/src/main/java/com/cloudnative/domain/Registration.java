package com.cloudnative.domain;

import com.cloudnative.domain.assignment.Assignment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by msambangi on 11/2/17.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class Registration {

    @GraphId
    private long id;

    @Relationship(type = "CONTAINS_COURSE")
    private Set<Assignment> assignmentSet = new HashSet<>();

    @Relationship(type = "REGISTERED_TO")
    private Student student;

    private RegistrationStatus registrationStatus;

    public Registration(Set<Assignment> assignmentSet, Student student, RegistrationStatus registrationStatus) {
        this.assignmentSet = assignmentSet;
        this.student = student;
        this.registrationStatus = registrationStatus;
    }

}
