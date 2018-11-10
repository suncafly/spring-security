package com.ytx.security.core.validate.code.image;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.ytx.security.core.properites.SecurityProperties;
import com.ytx.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.image.BufferedImage;

/**
 * ${TODO}
 *
 * @author LiFang
 * @date 2018-10-25 5:19 PM
 * @since
 */
public class ImageCodeGenerator implements ValidateCodeGenerator{

    private Producer kaptchaProducer;

    private SecurityProperties securityProperties;

    @Override
    public ImageCode generate(ServletWebRequest request) {
        String capText = kaptchaProducer.createText();
        BufferedImage bi = kaptchaProducer.createImage(capText);
        return new ImageCode(bi, capText, securityProperties.getCode().getImage().getExpireIn());
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    public void setKaptchaProducer(Producer kaptchaProducer) {
        this.kaptchaProducer = kaptchaProducer;
    }
}