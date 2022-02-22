package com.example.demo.ad;

import org.hibernate.mapping.Any;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface ProductionRepository extends JpaRepository<Production,Long>, JpaSpecificationExecutor {

    @Query(value="select * from production ", nativeQuery=true)
    List<Object[]> getProductionsDetails();

}

