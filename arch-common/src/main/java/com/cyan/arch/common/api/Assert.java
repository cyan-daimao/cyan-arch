package com.cyan.arch.common.api;

/**
 * @author cy.Y
 * @since 1.0.0
 */
public class Assert {
    /**
     * 断言
     */
    public static void isTrue(boolean flag, BaseException e) {
        if (flag){
            throw e;
        }
    }
}
