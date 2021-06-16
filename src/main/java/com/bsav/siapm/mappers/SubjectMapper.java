package com.bsav.siapm.mappers;

import com.bsav.siapm.entities.GroupDB;
import com.bsav.siapm.entities.MicrocurriculumDB;
import com.bsav.siapm.entities.SubjectDB;
import com.bsav.siapm.model.Group;
import com.bsav.siapm.model.Microcurriculum;
import com.bsav.siapm.model.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectMapper {

    public static Subject toEntity(SubjectDB subjectDB) {
        return new Subject(
                subjectDB.getCode(),
                subjectDB.getName(),
                subjectDB.getSemester(),
                subjectDB.getCredits(),
                subjectDB.getPrerequisites(),
                subjectDB.getPrecredits(),
                subjectDB.getElective(),
                mapMicrocurriculums(subjectDB.getMicrocurriculums()),
                mapGroups(subjectDB.getGroups())
        );
    }

    private static List<Group> mapGroups(List<GroupDB> groups) {
        List<Group> gs = new ArrayList<>();
        groups.forEach(g -> gs.add(GroupMapper.toEntity(g)));
        return gs;
    }

    private static List<Microcurriculum> mapMicrocurriculums(List<MicrocurriculumDB> microcurriculums) {
        List<Microcurriculum> ms = new ArrayList<>();
        //microcurriculums.forEach(m -> ms.add(MicrocurriculumMapper.toEntity(m)));
        return ms;
    }
}
