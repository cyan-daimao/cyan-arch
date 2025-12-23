package com.cyan.arch.common.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 分页
 *
 * @author cy.Y
 * @since 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Page<T> {
    /**
     * 数据
     */
    private List<T> data;

    /**
     * 当前页
     */
    private long current;

    /**
     * 当前页大小
     */
    private long size;

    /**
     * 总数
     */
    private long total;

    /**
     * 总页数
     */
    private long pageCount;


    /**
     * 获取总页数
     *
     * @param total 总数
     * @param size  当前页大小
     * @return 总页数
     */
    public static long getPageCount(long total, long size) {
        return total % size == 0 ? total / size : total / size + 1;
    }
}
