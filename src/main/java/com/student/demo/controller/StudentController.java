package com.student.demo.controller;

import com.student.demo.model.Student;
import com.student.demo.service.StudentService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(produces = "application/json")
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "500")
    public ResponseEntity<List<Student>> getStudents() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudents());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping(value = "/id", consumes = "application/json", produces = "application/json")
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "400")
    @ApiResponse(responseCode = "500")
    public ResponseEntity<Object> getStudentByStudentId(@RequestBody Student student) {
        try {
            if (studentService.getStudentByStudentId(student) != null) {
                return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentByStudentId(student));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping(consumes = "application/json")
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "500")
    public ResponseEntity<Void> postStudent(@RequestBody Student student) {
        try {
            studentService.postStudent(student);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping(consumes = "application/json")
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "500")
    public ResponseEntity<Void> putStudent(@RequestBody Student student) {
        try {
            studentService.putStudent(student);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping(consumes = "application/json")
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "500")
    ResponseEntity<Void> deleteStudent(@RequestBody Student student) {
        try {
            studentService.delteStudent(student);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
