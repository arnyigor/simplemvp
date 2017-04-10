package com.arny.mvp.oldlogin;

public class LoginAPI {
    private final String LOGIN = "test";
    private final String PASS = "123456";
    public boolean authSuccess(String login,String pass) {
        return LOGIN.equals(login) && PASS.equals(pass);
    }
}