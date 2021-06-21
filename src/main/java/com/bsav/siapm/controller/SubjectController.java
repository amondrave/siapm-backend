package com.bsav.siapm.controller;

import com.bsav.siapm.controller.request.SubjectRequest;
import com.bsav.siapm.model.Request;
import com.bsav.siapm.service.interfaces.RequestService;
import com.bsav.siapm.service.interfaces.SubjectService;
import com.bsav.siapm.storage.StorageService;
import com.bsav.siapm.utils.ReturnMessage;
import com.bsav.siapm.utils.SiapmException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/subject")
@CrossOrigin(origins = "*", methods = {GET, POST, DELETE, PATCH, PUT})
public class SubjectController {

    @Autowired
    @Qualifier("uploadService")
    private StorageService storageService;

    @Autowired
    private SubjectService subjectService;


    @PostMapping("{pensumCode}")
    public ResponseEntity<?> saveRequest(
            @RequestParam("document") MultipartFile document,
            @RequestParam("data") String data,
            @PathVariable String pensumCode
    ) {
        SubjectRequest subject;
        String documentName;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            subject = objectMapper.readValue(data, SubjectRequest.class);

            storageService.store(document);
            documentName = document.getOriginalFilename();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        subject.setDocument(documentName);

        try {
            subjectService.saveSubject(subject, pensumCode);
        } catch (SiapmException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ReturnMessage(200, "La asignatura fue guardada exitosamente"), HttpStatus.OK);
    }

}
