package com.bsav.siapm.service.interfaces;

import com.bsav.siapm.controller.request.SubjectRequest;
import com.bsav.siapm.utils.SiapmException;

public interface SubjectService {

    void saveSubject(SubjectRequest subjectRequest, String pensumCode) throws SiapmException;

}
