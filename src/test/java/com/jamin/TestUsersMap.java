package com.jamin;

import com.jamin.login.Users;
import org.junit.Test;

import java.util.Map;

/**
 * Description:
 * Author: 杰明Jamin
 * Date: 2017/11/5 9:30
 */
public class TestUsersMap {

    @Test
    public void testGetMap() {
        for (Map.Entry<String, String> entry : Users.USERS_MAP.entrySet()) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
    }
}
