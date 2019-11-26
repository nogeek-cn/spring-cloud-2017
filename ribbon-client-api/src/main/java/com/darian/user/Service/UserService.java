package com.darian.user.Service;

import com.darian.user.domain.User;

import java.util.Collection;

/**
 * 用户服务
 * <br>
 * <br>Darian
 **/
public interface UserService {

    /**
     * 保存用户，
     * 成功true;
     * 失败，false
     * <br>Darian
     **/
    boolean sava(User user);

    /**
     * 查询所有的用户对象
     * @return 不会返回<code>Null</code>
     * <br>Darian
     **/
    Collection<User> findAll();
}
