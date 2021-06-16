package com.bsav.siapm.mappers;

import com.bsav.siapm.entities.MicrocurriculumDB;
import com.bsav.siapm.model.Microcurriculum;

public class MicrocurriculumMapper {
    public static Microcurriculum toEntity(MicrocurriculumDB microcurriculumDB) {
        return new Microcurriculum(
                microcurriculumDB.getId(),
                microcurriculumDB.getContent(),
                microcurriculumDB.getBibliography(),
                microcurriculumDB.getDocument()
        );
    }
}