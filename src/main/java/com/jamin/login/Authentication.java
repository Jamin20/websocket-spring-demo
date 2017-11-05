package com.jamin.login;

import javax.security.auth.Subject;
import java.security.Principal;

/**
 * Description:
 * Author: 杰明Jamin
 * Date: 2017/11/5 8:39
 */
public class Authentication implements Principal {

    private String name;

    public Authentication(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }
}
