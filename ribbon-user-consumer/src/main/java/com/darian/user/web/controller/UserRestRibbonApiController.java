package com.darian.user.web.controller;

import com.darian.user.Service.UserService;
import com.darian.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


/**
 * <br>用户服务Rest APi
 * <br>Darian
 **/
@RestController
public class UserRestRibbonApiController {

    @Autowired
    private UserService userService;

    /**
     * @param user 请求“name”的数据
     * 如果保存成功，返回 {@link User}
     * 否则返回null
     * <br>Darian
     **/
    //    @PostMapping("/user/save")
    @GetMapping("/user/save") // Get 方便测试
    public User saveUser(User user) {
//        User user = new User();
//        user.setName(name);
        if (userService.sava(user)) {
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
