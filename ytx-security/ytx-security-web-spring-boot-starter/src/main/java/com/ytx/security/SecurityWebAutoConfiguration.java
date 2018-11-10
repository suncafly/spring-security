package com.ytx.security;

import com.ytx.security.core.properites.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * ${TODO}
 *
 * @author LiFang
 * @date 2018-10-13 8:40 PM
 * @since
 */
@EnableWebSecurity
@Configuration
@ComponentScan("com.ytx.security")
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityWebAutoConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}