package com.groupseven.projectglovi.controllers;

import com.groupseven.projectglovi.entities.User;
import com.groupseven.projectglovi.services.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/user")
@Validated
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

}
