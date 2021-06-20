package com.bsav.siapm.service.interfaces;

import com.bsav.siapm.model.Request;
import com.bsav.siapm.utils.SiapmException;

public interface RequestService {
    void addRequest(Request request) throws SiapmException;
}
