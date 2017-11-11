package com.cloudnative.error;

/**
 * Created by msambangi on 10/26/17.
 */


public class StudentNotFoundException extends Exception {

    private Long studentId;
    public StudentNotFoundException(Long id) {
        super(id + "");
        this.studentId = id;
    }

    public Long getStudentIdId() {
        return this.studentId;
    }

}
