package com.ytx.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * ${TODO}
 *
 * @author LiFang
 * @date 2018-10-25 5:15 PM
 * @since
 */
public interface ValidateCodeGenerator {
    ValidateCode generate(ServletWebRequest request);
}
