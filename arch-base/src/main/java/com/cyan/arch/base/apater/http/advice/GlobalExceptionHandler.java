package com.cyan.arch.base.apater.http.advice;

import com.cyan.arch.common.api.*;
import com.cyan.arch.common.util.CollUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Response<String> handleException(MissingServletRequestParameterException e) {
        return Response.failed(ErrorCode.VALIDATE_FAILED, "参数%s不能为空".formatted(e.getParameterName()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<?> validationErrorHandler(HttpServletRequest request, MethodArgumentNotValidException ex) {
        List<String> errorInformation = ex.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .toList();
        String message = CollUtils.isEmpty(errorInformation) ? "" : errorInformation.getFirst();
        return Response.failed(ErrorCode.VALIDATE_FAILED, message);
    }

    @ExceptionHandler(SilentException.class)
    public Response<String> handleBaseException(SilentException ex) {
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