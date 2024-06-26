package com.groupseven.projectglovi.controllers;

import com.groupseven.projectglovi.services.abstracts.AuthService;
import com.groupseven.projectglovi.services.dtos.requests.UserLoginRequest;
import com.groupseven.projectglovi.services.dtos.requests.UserRegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid UserRegisterRequest request){

        Set<Integer> idList = new HashSet<>();
        idList.add(1);

        request.setBalls(idList);
        request.setCars(idList);
        request.setRackets(idList);
        System.out.println(request);
        authService.register(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody @Valid UserLoginRequest request){
        return authService.login(request);
    }
}
