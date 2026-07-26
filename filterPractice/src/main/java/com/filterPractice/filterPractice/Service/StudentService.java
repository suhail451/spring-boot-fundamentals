package com.filterPractice.filterPractice.Service;

import com.filterPractice.filterPractice.DTO.RequestDTO;
import com.filterPractice.filterPractice.DTO.ResponseDTO;
import com.filterPractice.filterPractice.Entity.Student;
import com.filterPractice.filterPractice.GlobalException.DuplicateUpdate;
import com.filterPractice.filterPractice.GlobalException.NameAlreadyExist;
import com.filterPractice.filterPractice.GlobalException.StudentNotFound;
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

    public ResponseDTO createStudent(RequestDTO student){


        if(studentRepo.existsByNameAndAge(student.getName(),student.getAge())){
            throw new NameAlreadyExist(student.getName()+" Already Exist");
        }

        Student mystudent=new Student();
        mystudent.setName(student.getName());
        mystudent.setAge(student.getAge());


        Student saved =studentRepo.save(mystudent);
        ResponseDTO mydto=new ResponseDTO();

        mydto.setName(saved.getName());
        mydto.setAge(saved.getAge());
        mydto.setId(saved.getId());


        return mydto;

    }


// Get Student By id
    public ResponseDTO getStudent(Long id){

        Student myStudent = studentRepo.findById(id)
                .orElseThrow(() ->
                        new StudentNotFound("Student Not Found"));



        ResponseDTO responseDTO=new ResponseDTO();

        responseDTO.setId(myStudent.getId());
        responseDTO.setName(myStudent.getName());
        responseDTO.setAge(myStudent.getAge());


        return responseDTO;

    }


// Get ALL

    public List<ResponseDTO> getALL(){

        List<Student>  myList=studentRepo.findAll();

        return myList.stream()
                .map(student -> {
                    ResponseDTO responseDTO=new ResponseDTO();
                    responseDTO.setId(student.getId());
                    responseDTO.setName(student.getName());
                    responseDTO.setAge(student.getAge());
                    return responseDTO;

                }).toList();


    }

//    Update

    public ResponseDTO updateStudent(Long id,RequestDTO student){

        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new StudentNotFound("Student Not Found"));
        if (studentRepo.existsByNameAndAgeAndIdNot(
                student.getName(),
                student.getAge(),
                id)) {

            throw new DuplicateUpdate(
                    "A student with the same name and age already exists.");
        }
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());

        Student saved = studentRepo.save(existingStudent);

        ResponseDTO responseDTO=new ResponseDTO();
        responseDTO.setId(saved.getId());
        responseDTO.setName(saved.getName());
        responseDTO.setAge(saved.getAge());

        return responseDTO;


    }

    public void deleteById(Long id){

        studentRepo.deleteById(id);

    }


}
