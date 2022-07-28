package com.student.demo.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.demo.model.DataSetup;
import com.student.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo {

    @Autowired
    DataSetup dataSetup;

    public List<Student> getStudents() {
        return dataSetup.getStudentList();
    }

    public void createStudent(Student student) {
        dataSetup.getStudentList().add(student);
    }

    public void updateStudent(Student student) {
        for (int i = 0; i < dataSetup.getStudentList().size(); i++) {
            if (dataSetup.getStudentList().get(i).getStudentNumber() == student.getStudentNumber()) {
                dataSetup.getStudentList().remove(i);
                dataSetup.getStudentList().add(student);
            }
        }
    }

    public void deleteStudent(Student student) {
        for (int i = 0; i < dataSetup.getStudentList().size(); i++) {
            if (dataSetup.getStudentList().get(i).getStudentNumber() == student.getStudentNumber()) {
                dataSetup.getStudentList().remove(i);
            }
        }
    }

    public Object getStudentByStudentId(Student student) {
        for (int i = 0; i < dataSetup.getStudentList().size(); i++) {
            if (dataSetup.getStudentList().get(i).getStudentNumber() == student.getStudentNumber()) {
                return dataSetup.getStudentList().get(i);
            }
        }
        return null;
    }
}
