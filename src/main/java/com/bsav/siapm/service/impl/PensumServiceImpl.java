package com.bsav.siapm.service.impl;

import com.bsav.siapm.entities.PensumDB;
import com.bsav.siapm.mappers.PensumMapper;
import com.bsav.siapm.mappers.RequestMapper;
import com.bsav.siapm.model.Pensum;
import com.bsav.siapm.repository.PensumRepository;
import com.bsav.siapm.service.interfaces.PensumService;
import com.bsav.siapm.utils.ReturnMessage;
import com.bsav.siapm.utils.SiapmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("pensumService")
public class PensumServiceImpl implements PensumService {

    @Autowired
    @Qualifier("pensumRepository")
    PensumRepository pensumRepository;

    @Override
    public Pensum getActivePensum() throws SiapmException {

        List<PensumDB> pensumsDB;

        try {
            pensumsDB = pensumRepository.findByActiveTrue();
        } catch (Exception e) {
            throw new SiapmException(e, new ReturnMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        }

        List<Pensum> pensums = new ArrayList<>();

        pensumsDB.forEach(pensumDB -> pensums.add(PensumMapper.toModel(pensumDB)));

        if (pensums.size() < 1){
            throw new SiapmException(null, new ReturnMessage(HttpStatus.BAD_REQUEST.value(), "No hay pensum activo"));
        }

        return pensums.get(0);
    }

    @Override
    public void addPensum(Pensum pensum) throws SiapmException {

        try{
            if (!pensumRepository.existsById(pensum.getCode())){
                pensumRepository.save(PensumMapper.toEntity(pensum));
            } else {
                throw new SiapmException(new ReturnMessage(HttpStatus.BAD_REQUEST.value(), "Este pensum ya existe"));
            }
        } catch (Exception e){
            throw new SiapmException(e, new ReturnMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        }

    }

    @Override
    public List<Pensum> getAllPensums() throws SiapmException {
        try {
            return pensumRepository.findAll().stream().map(PensumMapper::toModel).collect(Collectors.toList());
        } catch (Exception e) {
            throw new SiapmException(e, new ReturnMessage(HttpStatus.BAD_REQUEST.value(), "Ha ocurrido un error obteniendo los pensum"));
        }
    }
}
