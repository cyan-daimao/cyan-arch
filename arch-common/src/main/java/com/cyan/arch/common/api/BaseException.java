package com.cyan.arch.common.api;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础异常
 *
 * @author daimao
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {


    protected long code;

    protected String msg;

    protected String detail;


    public BaseException(String msg) {
        super(msg);
        this.code = ErrorCode.FAILED.getCode();
        this.msg = msg;
    }


    public BaseException(String msg, Throwable e) {
        super(msg, e);
        this.code = ErrorCode.FAILED.getCode();
        this.msg = msg;
    }

    public BaseException(ErrorCode errorCode, Throwable e) {
        super(errorCode.getMessage(), e);
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
    }

    public BaseException(ErrorCode errorCode, String detail, Throwable e) {
        super(errorCode.getMessage(), e);
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
        this.detail = detail;
    }

    public BaseException() {
    }
}