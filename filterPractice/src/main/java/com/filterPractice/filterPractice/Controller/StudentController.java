package com.filterPractice.filterPractice.Controller;


import com.filterPractice.filterPractice.DTO.RequestDTO;
import com.filterPractice.filterPractice.Entity.Student;
import com.filterPractice.filterPractice.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.OutputStream;
import java.util.List;

@RestController
public class StudentController {

    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("students")
    public ResponseEntity<RequestDTO> createStudent(@Valid @RequestBody RequestDTO student){
        RequestDTO saved = studentService.createStudent(student);

        return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }

    @GetMapping("students/{id}")
    public ResponseEntity<RequestDTO> getStudent(@PathVariable Long id){

        RequestDTO myStudent=studentService.getStudent(id);

        return new ResponseEntity<>(myStudent,HttpStatus.OK);
    }


    @GetMapping("students")
    public ResponseEntity<List<Student>> getALL(){
       List<Student> ourStudent= studentService.getALL();

        return new ResponseEntity<>(ourStudent,HttpStatus.OK);
    }


    @PutMapping("students/{id}")
    public ResponseEntity<Student> updateStudent(@Valid @PathVariable Long id, @RequestBody Student student){

        Student updatedStudent=studentService.updateStudent(id,student);

        return new ResponseEntity<>(updatedStudent,HttpStatus.OK);


    }


    @DeleteMapping("students/{id}")
    public ResponseEntity<Void>  deletedByID( @PathVariable Long id){

        studentService.deltebyid(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }



}
