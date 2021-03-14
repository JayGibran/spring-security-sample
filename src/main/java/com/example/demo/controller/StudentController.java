package com.example.demo.controller;

import com.example.demo.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> students = Arrays.asList(
            new Student(1, "John Carter"),
            new Student(2, "Maggy Simpson"),
            new Student(3, "Anna Smith")
    );

    @GetMapping(path="/{studentId}")
    public Student getStudent(@PathVariable Integer studentId){
            return students
                    .stream()
                    .filter(student -> student.getStudentId() == studentId)
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Student " + studentId + " student does not exist"));
    }

}
