package com.example.demo.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface PersonRepository extends JpaRepository<Person,Long>, JpaSpecificationExecutor {

    @Query(value="select * from production ", nativeQuery=true)
    List<Object[]> getProductionsDetails();

}
