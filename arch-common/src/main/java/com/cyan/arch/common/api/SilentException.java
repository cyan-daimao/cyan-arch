package com.cyan.arch.common.api;

/**
 * 不打印异常信息
 *
 * @author cy.Y
 * @since 1.0.0
 */
public class SilentException extends BaseException {


    public SilentException(String msg) {
        super(msg);
    }

    public SilentException(String msg, Throwable e) {
        super(msg, e);
    }

}
