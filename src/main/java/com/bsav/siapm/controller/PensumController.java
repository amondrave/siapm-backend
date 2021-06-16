package com.bsav.siapm.controller;

import com.bsav.siapm.service.interfaces.PensumService;
import com.bsav.siapm.utils.SiapmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/pensum")
@CrossOrigin(origins = "*", methods = {GET, POST, DELETE, PATCH, PUT})
public class PensumController {

    @Autowired
    private PensumService pensumService;

    @GetMapping("/active")
    public ResponseEntity getPensum(){
        try {
            return new ResponseEntity(pensumService.getActivePensum(), HttpStatus.OK);
        } catch (SiapmException e) {
            return new ResponseEntity(e.getReturnMessage(), HttpStatus.OK);
        }
    }

}
