package com.student.demo.model;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int studentNumber;
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String dob;
    private List<Course> courses;
}
