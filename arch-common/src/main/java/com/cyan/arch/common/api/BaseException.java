package com.cyan.arch.common.api;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础异常
 * @author daimao
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {


    protected long code;

    protected String msg;

    protected String detail;

    public BaseException(int code, String msg, String detail) {
        this.code = code;
        this.msg = msg;
        this.detail = detail;
    }

    public BaseException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseException(String msg) {
        this.code = ErrorCode.FAILED.getCode();
        this.msg = msg;
    }

    public BaseException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
    }

    public BaseException(ErrorCode errorCode,String detail) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
        this.detail = detail;
    }

    public BaseException() {
    }
}