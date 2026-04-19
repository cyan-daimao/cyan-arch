package com.cyan.arch.common.api;

/**
 * 分页接口
 * @author cy.Y
 * @since 1.0.0
 */
public interface Pageable {
    /**
     * 当前页码
     */
    long current();

    /**
     * 每页大小
     */
    long size();
}
