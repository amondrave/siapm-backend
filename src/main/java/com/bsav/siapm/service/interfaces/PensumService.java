package com.bsav.siapm.service.interfaces;

import com.bsav.siapm.model.Pensum;
import com.bsav.siapm.utils.SiapmException;

public interface PensumService {

    Pensum getActivePensum() throws SiapmException;

    void addPensum(Pensum pensum) throws SiapmException;

}
