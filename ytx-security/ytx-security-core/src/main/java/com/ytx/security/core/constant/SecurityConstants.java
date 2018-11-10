package com.ytx.security.core.constant;

/**
 * ${TODO}
 *
 * @author LiFang
 * @date 2018-10-25 5:01 PM
 * @since
 */
public class SecurityConstants {

    /**
     * 默认的用户名密码登录请求处理url
     */
    public static final String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authentication/form";

    /**
     * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
     */
    public static final String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";

    /**
     * 默认的处理验证码的url前缀
     */
    public static final String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";

    /**
     * 当请求需要身份认证时，默认跳转的url
     *
     */
    public static final String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";

    /**
     * 默认登录页面
     *
     */
    public static final String DEFAULT_LOGIN_PAGE_URL = "/default_login.html";
}
