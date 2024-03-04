package com.bca.spring.crud.learningspringwithpostgresql.Controller;

import com.bca.spring.crud.learningspringwithpostgresql.Model.Employees;
import com.bca.spring.crud.learningspringwithpostgresql.Model.Student;
import com.bca.spring.crud.learningspringwithpostgresql.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {
    @Autowired
    studentRepository sr;

    @PostMapping("/student")
    public ResponseEntity<Object> insertStudent(@RequestBody Student student){
        try{
            Student insertStudent = sr.insert(student);
            return ResponseEntity.ok(insertStudent);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudent(){
        try {
            List<Student> students =  sr.displayStudent();
            if(students != null){
                return ResponseEntity.ok(students);
            }
            else{
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Long id){
        sr.deleteStudentById(id);
    }



}
