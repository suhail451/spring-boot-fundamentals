package com.filterPractice.filterPractice.Service;


import ch.qos.logback.classic.boolex.StubEventEvaluator;
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


    public Student createStudent(Student student){

        Student saved =studentRepo.save(student);

        return saved;

    }


    public Student getStudent(Long id){

        Student myStudent=studentRepo.getById(id);

        return myStudent;

    }



    public List<Student> getALL(){

        List<Student>  myList=studentRepo.findAll();
        return myList;


    }

    public Student updateStudent(long id,Student student){

       Optional<Student> existing =studentRepo.findById(id);

       Student  existingStudent=existing.get();
       existingStudent.setName(student.getName());
       existingStudent.setAge(student.getAge());

        return studentRepo.save(existingStudent);

    }

    public void deltebyid(long id){

        studentRepo.deleteById(id);

    }


}
