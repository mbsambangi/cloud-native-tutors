package com.cloudnative.domain.enrollment;

import com.cloudnative.domain.AuditBaseEntity;
import com.cloudnative.domain.Course;
import com.cloudnative.domain.EnrollmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by msambangi on 11/2/17.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Enrollment extends AuditBaseEntity {

    @Id
    private String enrollmentId;

    private String accountNumber;

    private String studentId;

    private EnrollmentStatus enrollmentStatus;

    private Set<Course> courseList = new HashSet<>();

    public Enrollment(String accountNumber, String studentId) {
        this.accountNumber = accountNumber;
        this.studentId = studentId;

        this.enrollmentStatus = EnrollmentStatus.INITIATED;
    }

    public void addCourse(Course course) {
        this.courseList.add(course);
    }
}
