package com.cyan.arch.common.api;

/**
 * 登陆异常
 * @author cy.Y
 * @since 1.0.0
 */
public class LoginException extends BaseException {

    public LoginException(String msg) {
        super(msg);
    }

    public LoginException(String msg, Throwable e) {
        super(msg, e);
    }
}
