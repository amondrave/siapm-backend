package com.bsav.siapm.repository;

import com.bsav.siapm.entities.RequestDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("requestRepository")
public interface RequestRepository extends JpaRepository<RequestDB, Serializable> {

    boolean existsByDocument(String document);

}
