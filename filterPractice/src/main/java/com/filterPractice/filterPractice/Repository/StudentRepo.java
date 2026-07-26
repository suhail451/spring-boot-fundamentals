package com.filterPractice.filterPractice.Repository;


import com.filterPractice.filterPractice.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {


    public boolean existsByNameAndAge(String name,int age);
    public boolean existsByNameAndAgeAndIdNot(String name,int age,Long id);

}
