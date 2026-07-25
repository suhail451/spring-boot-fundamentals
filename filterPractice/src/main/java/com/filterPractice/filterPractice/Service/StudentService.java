package com.filterPractice.filterPractice.Service;


import ch.qos.logback.classic.boolex.StubEventEvaluator;
import com.filterPractice.filterPractice.DTO.RequestDTO;
import com.filterPractice.filterPractice.Entity.Student;
import com.filterPractice.filterPractice.Repository.StudentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

//Create Student

    public RequestDTO createStudent(RequestDTO student){

        Student mystudent=new Student();
        mystudent.setName(student.getName());
        mystudent.setAge(student.getAge());

        Student saved =studentRepo.save(mystudent);
        RequestDTO mydto=new RequestDTO();

        mydto.setName(saved.getName());
        mydto.setAge(saved.getAge());
        mydto.setId((long) saved.getId());


        return mydto;

    }


// Get Student By id
    public RequestDTO getStudent(Long id){

        Student myStudent = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));


        RequestDTO requestDTO=new RequestDTO();

        requestDTO.setId(myStudent.getId());
        requestDTO.setName(myStudent.getName());
        requestDTO.setAge(myStudent.getAge());


        return requestDTO;

    }



    public List<Student> getALL(){

        List<Student>  myList=studentRepo.findAll();
        return myList;


    }

    public Student updateStudent(Long id,Student student){

       Optional<Student> existing =studentRepo.findById(id);

       Student  existingStudent=existing.get();
       existingStudent.setName(student.getName());
       existingStudent.setAge(student.getAge());

        return studentRepo.save(existingStudent);

    }

    public void deltebyid(Long id){

        studentRepo.deleteById(id);

    }


}
