package com.groupseven.projectglovi.services.concretes;

import com.groupseven.projectglovi.entities.User;
import com.groupseven.projectglovi.repositories.UserRepository;
import com.groupseven.projectglovi.services.abstracts.UserService;
import com.groupseven.projectglovi.services.dtos.requests.UserRegisterRequest;
import com.groupseven.projectglovi.services.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public void register(UserRegisterRequest request) {
        User user = UserMapper.INSTANCE.userFromRegisterRequest(request);

        userRepository.save(user);
    }
}
