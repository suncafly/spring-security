package com.ytx.security;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.ytx.security.core.properites.KaptchaProperties;
import com.ytx.security.core.properites.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Properties;

/**
 * ${TODO}
 *
 * @author LiFang
 * @date 2018-10-13 8:40 PM
 * @since
 */
@EnableWebSecurity
@Configuration
@ComponentScan("com.ytx.security")
@EnableConfigurationProperties({SecurityProperties.class, KaptchaProperties.class})
public class SecurityWebAutoConfiguration {

    @Autowired
    private KaptchaProperties kaptchaProperties;

    @Bean(name = "kaptchaProducer")
    public DefaultKaptcha getKaptchaBean() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty(Constants.KAPTCHA_BORDER, kaptchaProperties.getBorder());
        properties.setProperty(Constants.KAPTCHA_BORDER_COLOR, kaptchaProperties.getBorderColor());
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, kaptchaProperties.getTextProducerFontColor());
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, kaptchaProperties.getTextProducerFontSize());
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, kaptchaProperties.getTextProducerFontNames());
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, kaptchaProperties.getTextProducerCharLength());
        properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, kaptchaProperties.getImageWidth());
        properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, kaptchaProperties.getImageHeight());
        properties.setProperty(Constants.KAPTCHA_NOISE_COLOR, kaptchaProperties.getNoiseColor());
        //properties.setProperty(Constants.KAPTCHA_NOISE_IMPL, kaptchaProperties.getNoiseImpl());//去掉干扰线
        properties.setProperty(Constants.KAPTCHA_OBSCURIFICATOR_IMPL, kaptchaProperties.getObscurificatorImpl());//阴影渲染效果
        properties.setProperty(Constants.KAPTCHA_SESSION_KEY, kaptchaProperties.getSessionKey());
        properties.setProperty(Constants.KAPTCHA_SESSION_DATE, kaptchaProperties.getSessionDate());
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}