package com.cyan.arch.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cy.Y
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum ErrorCode implements ResponseCode{

    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(400, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    private final long code;

    private final String message;

}