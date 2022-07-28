package com.student.demo.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSetup implements CommandLineRunner {
    List<Student> studentList = new ArrayList<>();
    List<Course> courseList = new ArrayList<>();

    public List<Course> getCourseList() {
        courseList.add(new Course("CSCI", 1000));
        return courseList;
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

    @Override
    public void run(String... args) throws Exception {
        Student student = new Student(1, "john.doe", "password123", "john.doe@email.com", "john", "doe", "12/15/2000", this.getCourseList());
        studentList.add(student);
    }
}
