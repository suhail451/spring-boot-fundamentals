package com.filterPractice.filterPractice.Controller;


import com.filterPractice.filterPractice.DTO.RequestDTO;
import com.filterPractice.filterPractice.DTO.ResponseDTO;
import com.filterPractice.filterPractice.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("students")
    public ResponseEntity<ResponseDTO> createStudent(@Valid @RequestBody RequestDTO student){
        ResponseDTO saved = studentService.createStudent(student);

        return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }

    @GetMapping("students/{id}")
    public ResponseEntity<ResponseDTO> getStudent(@PathVariable Long id){

        ResponseDTO myStudent=studentService.getStudent(id);

        return new ResponseEntity<>(myStudent,HttpStatus.OK);
    }


    @GetMapping("students")
    public ResponseEntity<List<ResponseDTO>> getALL(){
       List<ResponseDTO> ourStudent= studentService.getALL();

        return new ResponseEntity<>(ourStudent,HttpStatus.OK);
    }


    @PutMapping("students/{id}")
    public ResponseEntity<ResponseDTO> updateStudent(@Valid @PathVariable Long id, @RequestBody RequestDTO student){

        ResponseDTO updatedStudent=studentService.updateStudent(id,student);

        return new ResponseEntity<>(updatedStudent,HttpStatus.OK);


    }


    @DeleteMapping("students/{id}")
    public ResponseEntity<Void>  deletedByID( @PathVariable Long id){

        studentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }



}
