package com.darian.user.respository;

import com.darian.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <br>用户的仓储模型
 * <br>Darian
 **/
@Repository
public class UserRepository {

    private static ConcurrentHashMap<Long, User> USER_REPOSTORY =
            new ConcurrentHashMap<>();

    private static final AtomicLong idGenerator =
            new AtomicLong(0);

    static {
        long id1 = idGenerator.incrementAndGet();
        USER_REPOSTORY.putIfAbsent(id1, new User(id1, "darian-id1"));

        long id2 = idGenerator.incrementAndGet();
        USER_REPOSTORY.putIfAbsent(id2, new User(id2, "darian-id2"));

        long id3 = idGenerator.incrementAndGet();
        USER_REPOSTORY.putIfAbsent(id3, new User(id3, "darian-id3"));
    }

    public boolean sava(User user) {
        long id = idGenerator.incrementAndGet();
        user.setId(id);
        /**
         * 数据库需要查询是否查询,事务的控制
         * 存在的时候就不会再存了
         **/
        return USER_REPOSTORY.putIfAbsent(id, user) == null;

    }


    public Collection<User> findAll() {
        return USER_REPOSTORY.values();
    }
}