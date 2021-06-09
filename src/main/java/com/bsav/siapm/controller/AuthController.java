package com.bsav.siapm.controller;

import com.bsav.siapm.controller.request.LoginRequest;
import com.bsav.siapm.controller.request.SignUpRequest;
import com.bsav.siapm.controller.responses.JwtResponse;
import com.bsav.siapm.service.interfaces.AuthService;
import com.bsav.siapm.utils.SiapmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws SiapmException {
        JwtResponse jwtResponse = authService.authenticateUser(loginRequest);
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) throws SiapmException {
        authService.registerUser(signUpRequest);
        return ResponseEntity.ok("Usuario registrado satisfactoriamente, por favor contacte a su administrador para que su usuario sea activado");
    }
}
