package com.darian.user.service;

import com.darian.user.Service.UserService;
import com.darian.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * <br>
 * <br>Darian
 **/
@Service
public class UserServiceProxy implements UserService {

    private static final String PROVIDER_SERVER_URL_PREFIX =
            "http://user-service-provider/";

    /**
     * 通过restTemplate远程调用
     * <br>Darian
     **/
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public boolean sava(User user) {
//        User userReturn = restTemplate.postForObject(
//                PROVIDER_SERVER_URL_PREFIX + "/user/save",
//                user,
//                User.class);
        User userReturn = restTemplate.getForObject(
                PROVIDER_SERVER_URL_PREFIX + "/user/save?id=" + user.getId() + "&name=" + user.getName(),
                User.class
        );
        return userReturn != null;
    }

    @Override
    public Collection<User> findAll() {
        return restTemplate.getForObject(
                PROVIDER_SERVER_URL_PREFIX + "/user/list",
                Collection.class
        );

    }
}
