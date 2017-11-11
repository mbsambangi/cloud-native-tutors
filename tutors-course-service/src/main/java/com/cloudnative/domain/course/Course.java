package com.cloudnative.domain.course;

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
public class Course {

    @GraphId
    private Long Id;

    private String courseId, courseName, courseDescription;

    private Double fee;

    private Integer ageFrom;

    private Integer ageTo;

    public Course(String courseName, String courseId, Double fee) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.fee = fee;
    }
}
