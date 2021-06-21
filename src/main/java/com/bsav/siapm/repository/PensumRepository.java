package com.bsav.siapm.repository;

import com.bsav.siapm.entities.PensumDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("pensumRepository")
public interface PensumRepository extends JpaRepository<PensumDB, Serializable> {

    List<PensumDB> findByActiveTrue();

    PensumDB getByCode(String code);
}