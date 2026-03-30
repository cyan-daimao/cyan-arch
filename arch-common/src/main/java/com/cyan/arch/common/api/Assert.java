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
     * 断言
     */
    public static void isTrue(boolean flag, BaseException e) {
        if (!flag){
            throw e;
        }
    }

    /**
     * 断言
     */
    public static void isFalse(boolean flag, BaseException e) {
        if (flag){
            throw e;
        }
    }
    /**
     * 断言
     */
    public static void notNull(Object obj, BaseException e) {
        if (obj == null){
            throw e;
        }
    }

    /**
     * 断言
     */
    public static void notBlank(String str, BaseException e) {
        if (str == null || str.isEmpty()){
            throw e;
        }
    }

    /**
     * 断言
     */
    public static void notEmpty(Collection<?> collection, BaseException e) {
        if (CollUtils.isEmpty(collection)){
            throw e;
        }
    }
    /**
     * 断言
     */
    public static void isTrue(boolean flag, String msg) {
        if (!flag){
            throw new SilentException(msg);
        }
    }

    /**
     * 断言
     */
    public static void isFalse(boolean flag, String msg) {
        if (flag){
            throw new SilentException(msg);
        }
    }
    /**
     * 断言
     */
    public static void notNull(Object obj, String msg) {
        if (obj == null){
            throw new SilentException(msg);
        }
    }

    /**
     * 断言
     */
    public static void notBlank(String str, String msg) {
        if (str == null || str.isEmpty()){
            throw new SilentException(msg);
        }
    }

    /**
     * 断言
     */
    public static void notEmpty(Collection<?> collection,String msg) {
        if (CollUtils.isEmpty(collection)){
            throw new SilentException(msg);
        }
    }
}
