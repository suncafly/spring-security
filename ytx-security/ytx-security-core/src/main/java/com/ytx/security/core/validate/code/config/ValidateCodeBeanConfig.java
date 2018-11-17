package com.ytx.security.core.validate.code.config;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.ytx.security.core.properites.SecurityProperties;
import com.ytx.security.core.validate.code.ValidateCodeGenerator;
import com.ytx.security.core.validate.code.image.ImageCodeGenerator;
import com.ytx.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.ytx.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * ${TODO}
 *
 * @author LiFang
 * @date 2018-11-10 9:18 PM
 * @since
 */
@Configuration
public class ValidateCodeBeanConfig {

    private final SecurityProperties securityProperties;

    @Autowired
    public ValidateCodeBeanConfig(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Bean
    @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
    @Autowired
    public ValidateCodeGenerator imageValidateCodeGenerator(Producer kaptchaProducer) {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setKaptchaProducer(kaptchaProducer);
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(name = "kaptchaProducer")
    public Producer kaptchaProducer(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(initKaptchaConfig());
        return defaultKaptcha;
    }

    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }

    private Config initKaptchaConfig() {
        Properties properties = new Properties();
        Config config = new Config(properties);
        if (!securityProperties.getCode().getImage().getBorder().isEmpty()) {
            properties.setProperty(Constants.KAPTCHA_BORDER, securityProperties.getCode().getImage().getBorder());
        }

        if (!securityProperties.getCode().getImage().getBorderColor().isEmpty()) {
            properties.setProperty(Constants.KAPTCHA_BORDER_COLOR, securityProperties.getCode().getImage().getBorderColor());
        }


        if (!securityProperties.getCode().getImage().getTextProducerFontColor().isEmpty()) {
            properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, securityProperties.getCode().getImage().getTextProducerFontColor());
        }

        if (!securityProperties.getCode().getImage().getTextProducerFontSize().isEmpty()) {
            properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, securityProperties.getCode().getImage().getTextProducerFontSize());
        }


        if (!securityProperties.getCode().getImage().getTextProducerFontNames().isEmpty()) {
            properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, securityProperties.getCode().getImage().getTextProducerFontNames());
        }


        if (!securityProperties.getCode().getImage().getTextProducerCharLength().isEmpty()) {
            properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, securityProperties.getCode().getImage().getTextProducerCharLength());
        }


        if (!securityProperties.getCode().getImage().getImageWidth().isEmpty()) {
            properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, securityProperties.getCode().getImage().getImageWidth());
        }

        if (!securityProperties.getCode().getImage().getImageHeight().isEmpty()) {
            properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, securityProperties.getCode().getImage().getImageHeight());
        }

        if (!securityProperties.getCode().getImage().getNoiseColor().isEmpty()) {
            properties.setProperty(Constants.KAPTCHA_NOISE_COLOR, securityProperties.getCode().getImage().getNoiseColor());
        }

        if (!securityProperties.getCode().getImage().getObscurificatorImpl().isEmpty()) {
            properties.setProperty(Constants.KAPTCHA_OBSCURIFICATOR_IMPL, securityProperties.getCode().getImage().getObscurificatorImpl());//阴影渲染效果
        }
        //properties.setProperty(Constants.KAPTCHA_NOISE_IMPL, kaptchaProperties.getNoiseImpl());//去掉干扰线
        //properties.setProperty(Constants.KAPTCHA_SESSION_KEY, kaptchaProperties.getSessionKey());
        //properties.setProperty(Constants.KAPTCHA_SESSION_DATE, kaptchaProperties.getSessionDate());
        return config;
    }
}
