package com.cyan.arch.common.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 分页参数
 * @author cy.Y
 * @since 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Pagination {
    /**
     * 当前页
     */
    private long current;

    /**
     * 当前页大小
     */
    private long size;

}
