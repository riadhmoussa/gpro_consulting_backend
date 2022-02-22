package com.example.demo.chaine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface ChaineRepository extends JpaRepository<Chaine,Long>, JpaSpecificationExecutor {


}
