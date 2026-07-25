package com.filterPractice.filterPractice.Service;

import com.filterPractice.filterPractice.DTO.RequestDTO;
import com.filterPractice.filterPractice.Entity.Student;
import com.filterPractice.filterPractice.Repository.StudentRepo;

import org.springframework.stereotype.Service;

import java.util.List;


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
        mydto.setId(saved.getId());


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


// Get ALL

    public List<RequestDTO> getALL(){

        List<Student>  myList=studentRepo.findAll();

        return myList.stream()
                .map(student -> {
                    RequestDTO requestDTO=new RequestDTO();
                    requestDTO.setId(student.getId());
                    requestDTO.setName(student.getName());
                    requestDTO.setAge(student.getAge());
                    return requestDTO;

                }).toList();


    }

    public RequestDTO updateStudent(Long id,RequestDTO student){

        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());

        Student saved = studentRepo.save(existingStudent);

        RequestDTO requestDTO=new RequestDTO();
        requestDTO.setId(saved.getId());
        requestDTO.setName(saved.getName());
        requestDTO.setAge(saved.getAge());

        return requestDTO;


    }

    public void deltebyid(Long id){

        studentRepo.deleteById(id);

    }


}
