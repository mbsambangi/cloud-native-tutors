package com.cloudnative.domain.assignment;

import com.cloudnative.domain.course.Course;
import com.cloudnative.domain.course.CourseRepository;
import com.cloudnative.domain.teacher.Teacher;
import com.cloudnative.domain.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {

    @Autowired
    AssignmentRepository assignmentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TeacherRepository teacherRepository;

    public Assignment create(String assignmentName, Long courseId, Long teacherId) {
        Course course = courseRepository.findOne(courseId);
        Teacher teacher = teacherRepository.findOne(teacherId);

        Assignment assignment = new Assignment(assignmentName, course, teacher, AssignmentStatus.ASSIGNED);

        return assignmentRepository.save(assignment);
    }
}
