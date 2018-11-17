package com.ytx.security.core.validate.code.sms;

/**
 * ${TODO}
 *
 * @author LiFang
 * @date 2018-11-17 7:05 PM
 * @since
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机" + mobile + "发送短信验证码" + code);
    }
}
