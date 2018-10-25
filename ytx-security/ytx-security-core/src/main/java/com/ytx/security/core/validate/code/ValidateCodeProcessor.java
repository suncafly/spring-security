package com.ytx.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * ${TODO}
 *
 * @author LiFang
 * @date 2018-10-25 11:14 PM
 * @since
 */
public interface ValidateCodeProcessor {

    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建校验码
     *
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     *
     * @param servletWebRequest
     * @throws Exception
     */
    void validate(ServletWebRequest servletWebRequest);
}
