package com.nowcoder.community.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {
    /**
     * 从当前请求的所有cookie中获取为name的cookie
     *
     * @param request 请求
     * @param name cookie名字
     * @return
     */
    public static String getValue(HttpServletRequest request, String name) {
        if (request == null || name == null) {
            throw new IllegalArgumentException("参数为空!");
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

}
