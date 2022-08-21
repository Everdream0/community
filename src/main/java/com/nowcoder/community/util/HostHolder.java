package com.nowcoder.community.util;

import com.nowcoder.community.entity.User;
import org.springframework.stereotype.Component;

/**
 * 让线程去持有用户信息，用于替代session对象
 */
@Component
public class HostHolder {

    private ThreadLocal<User> users = new ThreadLocal<User>();

    public void setUser(User user) {
        users.set(user);
    }

    public User getUser() {
        return users.get();
    }

    public void clear() {
        users.remove();
    }

}
