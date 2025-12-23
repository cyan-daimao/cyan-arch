package com.cyan.arch.common.mapstruct;

import com.cyan.arch.common.util.Convert;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author cy.Y
 * @since 1.0.0
 */
public class MapstructConvert {
    public Long toLong(Object obj) {
        return Convert.toLong(obj);
    }

    public Integer toInteger(Object obj) {
        return Convert.toInteger(obj);
    }

    public String toString(Object obj) {
        return Convert.toStr(obj);
    }

    public LocalDateTime toLocalDateTime(String obj) {
        return Convert.parse(obj);
    }

    public Date toDate(String obj){
        return Convert.toDate(obj);
    }
}
