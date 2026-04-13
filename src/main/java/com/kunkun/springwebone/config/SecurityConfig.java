package com.kunkun.springwebone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

// 这是一个配置类
@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 1. 必须禁用 CSRF，否则 POST 请求会被拒绝
                .csrf(csrf -> csrf.disable())

                // 2. 开启跨域支持（配合下方的 CorsFilter Bean）
                .cors(cors -> cors.configure(http))

                // 3. 放行所有请求，防止自动跳转到 /login 页面
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                );

        return http.build();
    }

    // 4. 配置跨域过滤器
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true); // 允许 Cookie
        config.addAllowedOriginPattern("*"); // 允许所有来源
        config.addAllowedHeader("*"); // 允许所有 Header
        config.addAllowedMethod("*"); // 允许所有方法 (GET, POST)

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
