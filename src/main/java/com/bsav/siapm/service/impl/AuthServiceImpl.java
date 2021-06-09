package com.bsav.siapm.service.impl;

import com.bsav.siapm.controller.request.LoginRequest;
import com.bsav.siapm.controller.request.SignUpRequest;
import com.bsav.siapm.controller.responses.JwtResponse;
import com.bsav.siapm.entities.RoleDB;
import com.bsav.siapm.entities.UserDB;
import com.bsav.siapm.model.User;
import com.bsav.siapm.repository.RoleRepository;
import com.bsav.siapm.repository.UserRepository;
import com.bsav.siapm.security.AuthenticationUtil;
import com.bsav.siapm.security.UserDetailsImpl;
import com.bsav.siapm.security.jwt.JwtUtils;
import com.bsav.siapm.service.interfaces.AuthService;
import com.bsav.siapm.utils.Constants;
import com.bsav.siapm.utils.ReturnMessage;
import com.bsav.siapm.utils.SiapmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service("authService")
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("userRepository")
    UserRepository userRepository;

    @Autowired
    @Qualifier("roleRepository")
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    @Qualifier("authenticationUtil")
    private AuthenticationUtil authenticationUtil;

    @Autowired
    JwtUtils jwtUtils;


    @Override
    public JwtResponse authenticateUser(LoginRequest loginRequest) throws SiapmException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getDocument(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        if (!userDetails.isEnabled()) {
            throw new SiapmException(new ReturnMessage(1, "Lo sentimos su usario no se encuentra activo, por favor contacte a su administrador"));
        }

        return new JwtResponse(jwt,
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles.get(0));

    }

    @Override
    public void registerUser(SignUpRequest signUpRequest) throws SiapmException {

        if (userRepository.existsByDocument(signUpRequest.getDocument())) {
            throw new SiapmException(new ReturnMessage(2, "Error: Este nombre de usuario ya está en uso. Elige otro."));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new SiapmException(new ReturnMessage(3, "Error: Este email ya está en uso."));
        }

        UserDB user = new UserDB();
        user.setDocument(signUpRequest.getDocument());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        user.setCreateTime(new Date(System.currentTimeMillis()));
        user.setActive(signUpRequest.isActive());
        user.setCode(signUpRequest.getCode());
        RoleDB role = roleRepository.findByRole(Constants.ERole.ROLE_PROFESSOR)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        user.setRole(role);

        userRepository.save(user);

    }
}
