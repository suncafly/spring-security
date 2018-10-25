package com.ytx.security.config;

import com.ytx.security.core.constant.SecurityConstants;
import com.ytx.security.core.properites.SecurityProperties;
import com.ytx.security.core.validate.code.filter.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * ${TODO}
 *
 * @author LiFang
 * @date 2018-10-13 8:40 PM
 * @since
 */
@EnableWebSecurity
@Configuration
//@AutoConfigureAfter(SecurityWebAutoConfiguration.class)
public abstract class AbstractSecurityWebConfigurationAdapter extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private AuthenticationSuccessHandler ytxAuthenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler ytxAuthenticationFailureHandler;
    @Autowired
    private ValidateCodeFilter validateCodeFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(ytxAuthenticationSuccessHandler)
                .failureHandler(ytxAuthenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require", "/authentication/form", "/kaptcha/get",
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*",
                        securityProperties.getWeb().getLoginPage()).permitAll()
                .anyRequest()
                .authenticated()
                .and().csrf().disable();
    }
}