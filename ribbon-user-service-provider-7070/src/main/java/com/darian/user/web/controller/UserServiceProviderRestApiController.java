package com.darian.user.web.controller;

import com.darian.user.Service.UserService;
import com.darian.user.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * <br>{@link UserService}
 * <br>Darian
 **/
@RestController
public class UserServiceProviderRestApiController {

    private final Logger log = LoggerFactory.getLogger(UserServiceProviderRestApiController.class);

    @Autowired
    private UserService userService;

    /**
     * @param user 请求“name”的数据
     * 如果保存成功，返回 {@link User}
     * 否则返回null
     * <br>Darian
     **/
//    @PostMapping("/user/save")
    @GetMapping("user/save")
    public User saveUser(User user) {
        if (userService.sava(user)) {
            log.info("userService 服务方：保存用户成功！" + user);
            return user;
        } else {
            return null;
        }
    }

    /**
     * 罗列所有用户的数据
     * <br>Darian
     **/
    @GetMapping("/user/list")
    public Collection<User> list(){
        return userService.findAll();
    }

}
