package com.bsav.siapm.controller;

import com.bsav.siapm.model.Pensum;
import com.bsav.siapm.service.interfaces.PensumService;
import com.bsav.siapm.utils.SiapmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/pensum")
@CrossOrigin(origins = "*", methods = {GET, POST, DELETE, PATCH, PUT})
public class PensumController {

    @Autowired
    private PensumService pensumService;

    @GetMapping("/active")
    public ResponseEntity<?> getPensum() {
        try {
            return new ResponseEntity<>(pensumService.getActivePensum(), HttpStatus.OK);
        } catch (SiapmException e) {
            return new ResponseEntity<>(e.getReturnMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPensum(@RequestBody Pensum pensum) {
        try {
            pensumService.addPensum(pensum);
            return new ResponseEntity<>(pensum, HttpStatus.OK);
        } catch (SiapmException e) {
            return new ResponseEntity<>(e.getReturnMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPensums() {
        try {
            return new ResponseEntity<>(pensumService.getAllPensums(), HttpStatus.OK);
        } catch (SiapmException e) {
            return new ResponseEntity<>(e.getReturnMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
