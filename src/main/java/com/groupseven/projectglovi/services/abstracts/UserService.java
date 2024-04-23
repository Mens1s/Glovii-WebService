package com.groupseven.projectglovi.services.abstracts;

import com.groupseven.projectglovi.services.dtos.requests.UserRegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void register(UserRegisterRequest request);
}
