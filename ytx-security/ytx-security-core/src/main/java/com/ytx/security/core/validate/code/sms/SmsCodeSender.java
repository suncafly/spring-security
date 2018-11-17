package com.ytx.security.core.validate.code.sms;

/**
 * ${TODO}
 *
 * @author LiFang
 * @date 2018-11-17 7:06 PM
 * @since
 */
public interface SmsCodeSender {

    void send(String mobile, String code);
}
