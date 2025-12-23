package com.cyan.arch.common.api;

/**
 * 不打印异常信息
 *
 * @author cy.Y
 * @since 1.0.0
 */
public class SilentException extends BaseException {


    public SilentException(int code, String msg, String detail) {
        this.code = code;
        this.msg = msg;
        this.detail = detail;
    }

    public SilentException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public SilentException(String msg) {
        this.code = ErrorCode.FAILED.getCode();
        this.msg = msg;
    }

    public SilentException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
    }

    public SilentException(ErrorCode errorCode,String detail) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
        this.detail = detail;
    }

}
