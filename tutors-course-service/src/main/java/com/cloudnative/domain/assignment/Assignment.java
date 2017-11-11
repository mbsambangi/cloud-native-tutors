package com.cloudnative.domain.assignment;

import com.cloudnative.domain.course.Course;
import com.cloudnative.domain.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Created by msambangi on 11/2/17.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class Assignment {

    @GraphId
    private Long id;

    private String assignmentName;

    @Relationship(type = "COURSE_TYPE", direction = "OUTGOING")
    private Course course;

    @Relationship(type = "TOUGHT_BY", direction = "OUTGOING")
    private Teacher teacher;

    private AssignmentStatus assignmentStatus;

    public Assignment(String assignmentName, Course course, Teacher teacher, AssignmentStatus assignmentStatus) {
        this.assignmentName = assignmentName;
        this.course = course;
        this.teacher = teacher;
        this.assignmentStatus = assignmentStatus;
    }
}
