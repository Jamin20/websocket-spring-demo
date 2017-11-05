package com.jamin.login;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Author: 杰明Jamin
 * Date: 2017/11/5 9:17
 */
public class Users {

    public static final Map<String, String> USERS_MAP = new HashMap<String, String>();

    static {
        USERS_MAP.put("admin", "admin");
        USERS_MAP.put("jamin", "jamin");
        USERS_MAP.put("allen", "allen");
        USERS_MAP.put("james", "james");
    }
}
