package com.ytx.security.core.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * ${TODO}
 *
 * @author LiFang
 * @date 2018-10-25 3:20 PM
 * @since
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
