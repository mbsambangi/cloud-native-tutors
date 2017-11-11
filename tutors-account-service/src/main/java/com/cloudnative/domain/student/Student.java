package com.cloudnative.domain.student;

import com.cloudnative.domain.AuditBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by msambangi on 10/26/17.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends AuditBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String grade;
    private Date dateOfBirth;
    private String school;

    @Enumerated(EnumType.STRING)
    private GenderType genderType;

    private Student(String firstName, String lastName, String grade, Date dateOfBirth, GenderType genderType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.dateOfBirth = dateOfBirth;
        this.genderType = genderType;
    }

}
