package com.cyan.arch.base.apater.http.filter;

import com.cyan.employee.client.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RequestContext {

    /**
     * 员工信息
     */
    private EmployeeDTO employee;

    /**
     * Token信息
     */
    private String token;
}