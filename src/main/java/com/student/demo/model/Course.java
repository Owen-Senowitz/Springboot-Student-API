package com.student.demo.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private String courseName;
    private int courseNumber;
}
