package com.cyan.arch.common.api;

import com.cyan.arch.common.util.CollUtils;

import java.util.Collection;

/**
 * 断言
 * @author cy.Y
 * @since 1.0.0
 */
public class Assert {
    /**
     *  flag 为true，则抛出异常
     */
    public static void isTrue(boolean flag, BaseException e) {
        if (!flag){
            throw e;
        }
    }

    /**
     * flag 为false，则抛出异常
     */
    public static void isFalse(boolean flag, BaseException e) {
        if (flag){
            throw e;
        }
    }
    /**
     * obj不能为空，否则抛出异常
     */
    public static void notNull(Object obj, BaseException e) {
        if (obj == null){
            throw e;
        }
    }
    /**
     * obj必须为空，否则抛出异常
     */
    public static void isNull(Object obj, BaseException e) {
        if (obj == null){
            throw e;
        }
    }

    /**
     * str不能为空字符串
     */
    public static void notBlank(String str, BaseException e) {
        if (str == null || str.isEmpty()){
            throw e;
        }
    }

    /**
     * str必须为空字符串
     */
    public static void isBlank(String str, BaseException e) {
        if (str == null || str.isEmpty()){
            return;
        }
        throw e;
    }
    /**
     * collection不能为空，否则抛出异常
     */
    public static void notEmpty(Collection<?> collection, BaseException e) {
        if (CollUtils.isEmpty(collection)){
            throw e;
        }
    }

    /**
     * collection必须为空，否则抛出异常
     */
    public static void isEmpty(Collection<?> collection, BaseException e) {
        if (CollUtils.isEmpty(collection)){
            return;
        }
        throw e;
    }
}
