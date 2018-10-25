package com.ytx.security.core.properites;

/**
 * web应用配置
 *
 * @author LiFang
 * @date 2018-10-13 8:19 PM
 * @since
 */

public class WebProperties {

    private String loginPage = "/default_login.html";

    private LoginResponseType loginType = LoginResponseType.JSON;


    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginResponseType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginResponseType loginType) {
        this.loginType = loginType;
    }
}
