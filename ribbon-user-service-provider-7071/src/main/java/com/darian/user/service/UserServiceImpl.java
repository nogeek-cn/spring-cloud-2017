package com.darian.user.service;

import com.darian.user.Service.UserService;
import com.darian.user.domain.User;
import com.darian.user.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.Configuration;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * {@link UserService}
 * <br>
 * <br>Darian
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean sava(User user) {
        return userRepository.sava(user);
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }
}
