package com.bsav.siapm.service.interfaces;

import com.bsav.siapm.model.Pensum;
import com.bsav.siapm.utils.SiapmException;

import java.util.List;

public interface PensumService {

    Pensum getActivePensum() throws SiapmException;

    Pensum getPensum(String code) throws SiapmException;

    void addPensum(Pensum pensum) throws SiapmException;

    List<Pensum> getAllPensums() throws SiapmException;
}
