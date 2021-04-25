package com.bsav.siapm.controller;

import com.bsav.siapm.controller.request.LoginRequest;
import com.bsav.siapm.controller.request.SignUpRequest;
import com.bsav.siapm.controller.responses.JwtResponse;
import com.bsav.siapm.entities.Role;
import com.bsav.siapm.entities.User;
import com.bsav.siapm.repository.RoleRepository;
import com.bsav.siapm.repository.UserRepository;
import com.bsav.siapm.security.AuthenticationUtil;
import com.bsav.siapm.security.UserDetailsImpl;
import com.bsav.siapm.security.jwt.JwtUtils;
import com.bsav.siapm.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
public class AuthController {
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

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getDocument(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        if (!userDetails.isEnabled()) {
            return ResponseEntity.ok("Lo sentimos su usario no se encuentra activo, por favor contacte a su administrador");
        }

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles.get(0)));
    }

    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {


        if (userRepository.existsByDocument(signUpRequest.getDocument())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Este nombre de usuario ya está en uso. Elige otro.");
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Este email ya está en uso.");
        }

        User user = new User();
        user.setDocument(signUpRequest.getDocument());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        user.setCreateTime(new Date(System.currentTimeMillis()));
        user.setActive(signUpRequest.isActive());
        user.setCode(signUpRequest.getCode());
        Role role = roleRepository.findByRole(Constants.ERole.ROLE_PROFESSOR)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        user.setRole(role);


        userRepository.save(user);

        return ResponseEntity.ok("Usuario registrado satisfactoriamente, por favor contacte a su administrador para que su usuario sea activado");
    }
}
