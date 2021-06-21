package com.bsav.siapm.service.interfaces;

import com.bsav.siapm.model.Request;
import com.bsav.siapm.utils.Constants;
import com.bsav.siapm.utils.SiapmException;

import java.util.List;

public interface RequestService {
    void addRequest(Request request) throws SiapmException;

    List<Request> getAllRequests() throws SiapmException;

    void changeStatus(String requestId, Constants.Status status) throws SiapmException;
}
