package com.filterPractice.filterPractice.Controller;


import com.filterPractice.filterPractice.Entity.Student;
import com.filterPractice.filterPractice.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.OutputStream;
import java.util.List;

@Controller
public class StudentController {

    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student saved = studentService.createStudent(student);

        return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }

    @GetMapping("student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id){

        Student myStudent=studentService.getStudent(id);

        return new ResponseEntity<>(myStudent,HttpStatus.OK);
    }


    @GetMapping("student")
    public ResponseEntity<List<Student>> getALL(){
       List<Student> ourStudent= studentService.getALL();

        return new ResponseEntity<>(ourStudent,HttpStatus.OK);
    }


    @PutMapping("student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id,@RequestBody Student student){

        Student updatedStudent=studentService.updateStudent(id,student);

        return new ResponseEntity<>(updatedStudent,HttpStatus.CREATED);


    }


    @DeleteMapping("student/{id}")
    public ResponseEntity<String>  deletedByID(@PathVariable long id, OutputStream outputStream){

        studentService.deltebyid(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }



}
