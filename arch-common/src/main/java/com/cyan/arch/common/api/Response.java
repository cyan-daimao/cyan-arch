package com.cyan.arch.common.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 响应参数
 *
 * @author cy.Y
 * @since  1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Response<T> {
    /**
     * 状态码
     */
    private long code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;
    /**
     * 追踪id
     */
    private String traceId;


    /**
     * 创建一个成功的响应
     *
     * @return 返回一个响应
     */
    public static <T> Response<T> success() {
        return new Response<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), null, null);
    }

    /**
     * 创建一个成功的响应
     *
     * @param data 返回值
     * @return 返回一个响应
     */
    public static <T> Response<T> success(T data) {
        return new Response<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), data, null);
    }

    /**
     * 创建一个失败的响应
     *
     * @param responseCode 响应代码
     * @param msg          错误信息
     * @return 响应
     */
    public static <T> Response<T> failed(ErrorCode responseCode, String msg) {
        return new Response<>(responseCode.getCode(), msg, null, null);
    }

}
