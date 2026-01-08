package com.cyan.arch.common.api;

/**
 * 业务异常
 *
 * @author cy.Y
 * @since 1.0.0
 */
public class BusinessException extends BaseException {

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String msg, Throwable e) {
        super(msg, e);
    }
}
