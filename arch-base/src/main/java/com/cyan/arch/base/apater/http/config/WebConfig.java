package com.cyan.arch.base.apater.http.config;

import com.cyan.arch.base.apater.http.filter.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    // 关键3：注入 Spring 管理的 LoginInterceptor Bean（而非手动 new）
    private final LoginInterceptor loginInterceptor;

    // 构造器注入拦截器
    public WebConfig(@Lazy LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**") // 匹配需要跨域的路径
                .allowedOrigins("*") // 允许的源
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .exposedHeaders("*")
                .maxAge(3600); // 预检请求缓存时间（秒）
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/health",
                        "/login",
                        "/rpc/**"
                );
    }
}