package com.cyan.arch.common.util;

/**
 * @author cy.Y
 * @since 1.0.0
 */
public class StrUtils {

    private StrUtils(){

    }

    /**
     * 字符串不为空
     *
     * @param str 字符串
     * @return 字符串是否不为空
     */
    public static boolean isNotBlank(CharSequence str) {
        return str != null && !str.isEmpty();
    }

    /**
     * 字符串为空
     *
     * @param str 字符串
     * @return 字符串是否为空
     */
    public static boolean isBlank(CharSequence str) {
        return !isNotBlank(str);
    }

    /**
     * 判断是否为数字
     *
     * @param str 字符串
     * @return 是否为数字
     */
    public static boolean isNumber(String str) {
        return str.matches("^[-+]?\\d*\\.?\\d+$");
    }
}