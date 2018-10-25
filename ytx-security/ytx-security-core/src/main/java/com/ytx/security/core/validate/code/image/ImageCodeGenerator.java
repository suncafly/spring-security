package com.ytx.security.core.validate.code.image;

import com.google.code.kaptcha.Producer;
import com.ytx.security.core.properites.SecurityProperties;
import com.ytx.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.image.BufferedImage;

/**
 * ${TODO}
 *
 * @author LiFang
 * @date 2018-10-25 5:19 PM
 * @since
 */
@Component("imageValidateCodeGenerator")
public class ImageCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private Producer kaptchaProducer;
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ImageCode generate(ServletWebRequest request) {
        String capText = kaptchaProducer.createText();
        BufferedImage bi = kaptchaProducer.createImage(capText);
        return new ImageCode(bi, capText, securityProperties.getCode().getImage().getExpireIn());
    }
}