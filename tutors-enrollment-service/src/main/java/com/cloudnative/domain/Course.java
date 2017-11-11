package com.cloudnative.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by msambangi on 11/2/17.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private String courseId;
    private Double fee;
}
