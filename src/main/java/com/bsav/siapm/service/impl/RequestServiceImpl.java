package com.bsav.siapm.service.impl;

import com.bsav.siapm.mappers.PensumMapper;
import com.bsav.siapm.mappers.RequestMapper;
import com.bsav.siapm.model.Request;
import com.bsav.siapm.repository.PensumRepository;
import com.bsav.siapm.repository.RequestRepository;
import com.bsav.siapm.service.interfaces.RequestService;
import com.bsav.siapm.utils.ReturnMessage;
import com.bsav.siapm.utils.SiapmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("requestService")
public class RequestServiceImpl implements RequestService {

    @Autowired
    @Qualifier("requestRepository")
    RequestRepository requestRepository;

    @Override
    public void addRequest(Request request) throws SiapmException {
        try{
            if (!requestRepository.existsByDocument(request.getDocument())){
                request.setId(request.getDocument());
                requestRepository.save(RequestMapper.toEntity(request));
            }
        } catch (Exception e){
            throw new SiapmException(e, new ReturnMessage(HttpStatus.BAD_REQUEST.value(), "Ya ha realizado una solicitud previamente"));
        }
    }
}
