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

}
