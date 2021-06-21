package com.bsav.siapm.mappers;

import com.bsav.siapm.controller.request.SubjectRequest;
import com.bsav.siapm.entities.MicrocurriculumDB;
import com.bsav.siapm.entities.SubjectDB;

public class SubjectRequestMapper {

    public static SubjectDB getSubjectDBfromSubjectRequest(SubjectRequest subjectRequest) {
        return new SubjectDB(
                subjectRequest.getCode(),
                subjectRequest.getName(),
                subjectRequest.getSemester(),
                subjectRequest.getCredits()
                );
    }

    public static MicrocurriculumDB getMicrocurriculumDBfromSubjectRequest(SubjectRequest subjectRequest) {
        SubjectDB subjectDB = getSubjectDBfromSubjectRequest(subjectRequest);
        return new MicrocurriculumDB(
                subjectDB.getCode(),
                subjectRequest.getContent(),
                subjectRequest.getBibliography(),
                subjectRequest.getDocument()
        );
    }

}
