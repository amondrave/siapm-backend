package com.bsav.siapm.repository;

import com.bsav.siapm.entities.MicrocurriculumDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("microcurriculumRepository")
public interface MicrocurriculumRepository extends JpaRepository<MicrocurriculumDB, Serializable> {
}
