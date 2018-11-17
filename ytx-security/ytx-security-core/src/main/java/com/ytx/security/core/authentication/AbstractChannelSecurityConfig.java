package com.ytx.security.core.authentication;

import com.ytx.security.core.constant.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * ${TODO}
 *
 * @author LiFang
 * @date 2018-11-17 10:31 PM
 * @since
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler ytxAuthenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler ytxAuthenticationFailureHandler;

    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(ytxAuthenticationSuccessHandler)
                .failureHandler(ytxAuthenticationFailureHandler);
    }

}
