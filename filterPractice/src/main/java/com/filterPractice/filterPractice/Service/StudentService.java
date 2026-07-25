package com.filterPractice.filterPractice.Service;


import ch.qos.logback.classic.boolex.StubEventEvaluator;
import com.filterPractice.filterPractice.Entity.Student;
import com.filterPractice.filterPractice.Repository.StudentRepo;
import org.springframework.stereotype.Service;

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

}
