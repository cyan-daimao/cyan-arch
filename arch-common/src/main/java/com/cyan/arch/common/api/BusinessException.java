package com.cyan.arch.common.api;

/**
 *  业务异常
 * @author cy.Y
 * @since 1.0.0
 */
public class BusinessException extends BaseException{

    public BusinessException(String msg) {
        this.code = ErrorCode.FAILED.getCode();
        this.msg = msg;
    }

}
