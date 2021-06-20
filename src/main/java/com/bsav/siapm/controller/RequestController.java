package com.bsav.siapm.controller;

import com.bsav.siapm.model.Request;
import com.bsav.siapm.service.interfaces.RequestService;
import com.bsav.siapm.storage.StorageService;
import com.bsav.siapm.utils.ReturnMessage;
import com.bsav.siapm.utils.SiapmException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/request")
@CrossOrigin(origins = "*", methods = {GET, POST, DELETE, PATCH, PUT})
public class RequestController {

    @Autowired
    @Qualifier("uploadService")
    private StorageService storageService;

    @Autowired
    private RequestService requestService;

    @PostMapping
    public ResponseEntity<?> getRequest(
            @RequestParam("receipt") MultipartFile receipt,
            @RequestParam("certificate") MultipartFile certificate,
            @RequestParam("data") String request
    ) {
        Request data;
        String receiptFileName;
        String certificateFileName;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            data = objectMapper.readValue(request, Request.class);

            storageService.store(receipt);
            receiptFileName = receipt.getOriginalFilename();
            storageService.store(certificate);
            certificateFileName = certificate.getOriginalFilename();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        data.setReceipt(receiptFileName);
        data.setCertificate(certificateFileName);

        try {
            requestService.addRequest(data);
        } catch (SiapmException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ReturnMessage(200, "La operación finalizó satisfactoriamente"), HttpStatus.OK);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
