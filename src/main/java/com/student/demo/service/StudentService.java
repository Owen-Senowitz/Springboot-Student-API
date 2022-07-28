package com.student.demo.service;

import com.student.demo.model.Student;
import com.student.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getStudents() {
        return studentRepo.getStudents();
    }

    public void postStudent(Student student) {
        studentRepo.createStudent(student);
    }

    public void putStudent(Student student) {
        studentRepo.updateStudent(student);
    }

    public ResponseEntity<Void> delteStudent(Student student) {
        try {
            studentRepo.deleteStudent(student);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public Object getStudentByStudentId(Student student) {
        return studentRepo.getStudentByStudentId(student);
    }
}
