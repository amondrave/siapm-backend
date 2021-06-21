package com.bsav.siapm.service.impl;

import com.bsav.siapm.controller.request.SubjectRequest;
import com.bsav.siapm.entities.MicrocurriculumDB;
import com.bsav.siapm.entities.PensumDB;
import com.bsav.siapm.entities.SubjectDB;
import com.bsav.siapm.mappers.SubjectRequestMapper;
import com.bsav.siapm.repository.MicrocurriculumRepository;
import com.bsav.siapm.repository.PensumRepository;
import com.bsav.siapm.repository.SubjectRepository;
import com.bsav.siapm.service.interfaces.SubjectService;
import com.bsav.siapm.utils.ReturnMessage;
import com.bsav.siapm.utils.SiapmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    @Qualifier("subjectRepository")
    SubjectRepository subjectRepository;

    @Autowired
    @Qualifier("microcurriculumRepository")
    MicrocurriculumRepository microcurriculumRepository;

    @Autowired
    @Qualifier("pensumRepository")
    PensumRepository pensumRepository;

    @Override
    public void saveSubject(SubjectRequest subjectRequest, String pensumCode) throws SiapmException {
        try {
            if (!subjectRepository.existsByCode(subjectRequest.getCode())) {
                SubjectDB subjectDB = SubjectRequestMapper.getSubjectDBfromSubjectRequest(subjectRequest);
                MicrocurriculumDB microcurriculumDB = SubjectRequestMapper.getMicrocurriculumDBfromSubjectRequest(subjectRequest);
                PensumDB pensumDB = pensumRepository.findByCode(pensumCode);

                subjectDB.setPensum(pensumDB);
                microcurriculumDB.setSubject(subjectDB);

                subjectRepository.save(subjectDB);
                microcurriculumRepository.save(microcurriculumDB);
            } else {
                throw new SiapmException(new ReturnMessage(HttpStatus.BAD_REQUEST.value(), "Esta asignatura ya existe"));
            }
        } catch (Exception e) {
            throw new SiapmException(e, new ReturnMessage(HttpStatus.BAD_REQUEST.value(), "Ya ha realizado una solicitud previamente"));
        }
    }

}
