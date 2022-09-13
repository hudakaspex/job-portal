package com.job.portal.Jobportal.Security.controllers;

import com.job.portal.Jobportal.Security.models.UserPortal;
import com.job.portal.Jobportal.Security.models.dto.LoginReqDto;
import com.job.portal.Jobportal.Security.models.dto.LoginResDto;
import com.job.portal.Jobportal.Security.models.dto.RegisterReqDto;
import com.job.portal.Jobportal.Security.services.UserService;
import com.job.portal.Jobportal.Security.utlis.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public UserController(
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil,
            UserService userService,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResDto> login(@Valid @RequestBody LoginReqDto user) {
        var userData = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        try {
            this.authenticationManager.authenticate(userData);
        } catch (BadCredentialsException err) {
            log.error(err.getMessage());
            throw new BadCredentialsException(err.getMessage());
        }

        var token = this.jwtUtil.generateToken(user.getUsername());
        return ResponseEntity.ok(new LoginResDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity<UserPortal> register(@Valid @RequestBody RegisterReqDto registerReqDto) {
        //encode password
        registerReqDto.setPassword(passwordEncoder.encode(registerReqDto.getPassword()));
        var createdUser = this.userService.create(registerReqDto);
        //response ok when success
        return ResponseEntity.ok(createdUser);
    }
}
