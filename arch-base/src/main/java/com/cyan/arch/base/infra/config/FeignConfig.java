package com.cyan.arch.base.infra.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author cy.Y
 * @since 1.0.0
 */
@Configuration
@EnableFeignClients(basePackages = "com.cyan")
public class FeignConfig {
}
