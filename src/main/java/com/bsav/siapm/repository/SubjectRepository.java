package com.bsav.siapm.repository;

import com.bsav.siapm.entities.SubjectDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("subjectRepository")
public interface SubjectRepository extends JpaRepository<SubjectDB, Serializable> {

    boolean existsByCode(String code);

}