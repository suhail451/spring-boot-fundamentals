package com.filterPractice.filterPractice.Repository;

import com.filterPractice.filterPractice.Entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepo extends JpaRepository<RegisterEntity,Long> {

     RegisterEntity findByName(String username);

}
