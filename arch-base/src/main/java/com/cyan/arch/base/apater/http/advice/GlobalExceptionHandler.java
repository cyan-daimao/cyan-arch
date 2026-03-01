package com.cyan.arch.base.apater.http.advice;

import com.cyan.arch.common.api.*;
import com.cyan.arch.common.util.CollUtils;
import com.cyan.arch.common.util.Convert;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

/**
 * 全局异常处理
 *
 * @author cy.Y
 * @since 1.0.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 专门处理 NoHandlerFoundException（404）
    @ExceptionHandler(NoHandlerFoundException.class)
    public Response<?> handleNoHandlerFoundException(HttpServletRequest request, NoHandlerFoundException ex) {
        String requestUri = request.getRequestURI();
        // 区分 favicon.ico 和真实业务接口的 404
        if ("/favicon.ico".equals(requestUri)) {
            log.debug("浏览器请求 favicon.ico 无匹配处理器，忽略");
        } else {
            log.warn("接口 [{}][{}] 不存在（无匹配的处理器）", request.getMethod(), requestUri);
        }
        // 返回标准 404 响应
        return Response.failed(ErrorCode.NOT_FOUND, "接口不存在");
    }

    /**
     * 登陆异常
     */
    @ExceptionHandler(LoginException.class)
    public Response<String> loginException(HttpServletRequest request,HttpServletResponse response, LoginException ex) {
        response.setStatus(Convert.toInteger(ErrorCode.UNAUTHORIZED.getCode()));
        log.error("接口 [{}][{}]: {}", request.getMethod(), request.getRequestURI(), ex.getMessage(), ex);
        return Response.failed(ErrorCode.UNAUTHORIZED, "");
    }

    /**
     * 参数校验失败
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Response<String> handleException(HttpServletRequest request,MissingServletRequestParameterException ex) {
        log.error("接口 [{}][{}]: {}", request.getMethod(), request.getRequestURI(), ex.getMessage(), ex);
        return Response.failed(ErrorCode.VALIDATE_FAILED, "参数%s不能为空".formatted(ex.getParameterName()));
    }

    /**
     * 参数校验失败
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<?> validationErrorHandler(HttpServletRequest request, MethodArgumentNotValidException ex) {
        List<String> errorInformation = ex.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .toList();
        String message = CollUtils.isEmpty(errorInformation) ? "" : errorInformation.getFirst();
        log.error("接口 [{}][{}]: {}", request.getMethod(), request.getRequestURI(), ex.getMessage(), ex);
        return Response.failed(ErrorCode.VALIDATE_FAILED, message);
    }

    @ExceptionHandler(SilentException.class)
    public Response<String> handleBaseException(HttpServletRequest request,SilentException ex) {
        log.error("接口 [{}][{}]: {}", request.getMethod(), request.getRequestURI(), ex.getMessage(), ex);
        return Response.failed(ErrorCode.FAILED, ex.getMsg());
    }

    @ExceptionHandler(BusinessException.class)
    public Response<String> handleBusinessException(HttpServletRequest request, BusinessException ex) {
        log.error("接口 [{}][{}]: {}", request.getMethod(), request.getRequestURI(), ex.getMessage(), ex);
        return Response.failed(ErrorCode.FAILED, ex.getMsg());
    }

    @ExceptionHandler(BaseException.class)
    public Response<?> baseExceptionHandler(HttpServletRequest request, BaseException ex) {
        log.error("接口 [{}][{}]: {}", request.getMethod(), request.getRequestURI(), ex.getMessage(), ex);
        return new Response<>(ex.getCode(), ex.getMsg(), ex.getDetail(), null);
    }

    @ExceptionHandler(Exception.class)
    public Response<?> ExceptionHandler(HttpServletRequest request, Exception ex) {
        log.error("接口 [{}][{}]: {}", request.getMethod(), request.getRequestURI(), ex.getMessage(), ex);
        return new Response<>(ErrorCode.FAILED.getCode(), ex.getMessage(), null, null);
    }
}