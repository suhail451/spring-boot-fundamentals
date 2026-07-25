package com.filterPractice.filterPractice.Controller;


import com.filterPractice.filterPractice.Entity.Student;
import com.filterPractice.filterPractice.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
