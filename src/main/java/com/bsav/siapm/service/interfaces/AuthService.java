package com.bsav.siapm.service.interfaces;

import com.bsav.siapm.controller.request.LoginRequest;
import com.bsav.siapm.controller.request.SignUpRequest;
import com.bsav.siapm.controller.responses.JwtResponse;
import com.bsav.siapm.entities.UserDB;
import com.bsav.siapm.model.User;
import com.bsav.siapm.security.UserDetailsImpl;
import com.bsav.siapm.utils.SiapmException;

public interface AuthService {

    JwtResponse authenticateUser(LoginRequest loginRequest) throws SiapmException;

    void registerUser(SignUpRequest signUpRequest) throws SiapmException;

}
