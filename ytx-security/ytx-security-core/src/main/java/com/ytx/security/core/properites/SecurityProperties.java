package com.ytx.security.core.properites;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ${TODO}
 *
 * @author LiFang
 * @date 2018-10-13 8:18 PM
 * @since
 */


@ConfigurationProperties(prefix = "ytx.security")
public class SecurityProperties {

    private WebProperties web = new WebProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();


    public WebProperties getWeb() {
        return web;
    }

    public void setWeb(WebProperties web) {
        this.web = web;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }
}
