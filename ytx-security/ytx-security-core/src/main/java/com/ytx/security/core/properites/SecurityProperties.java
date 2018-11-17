package com.ytx.security.core.properites;

import com.ytx.security.core.constant.SecurityConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ${TODO}
 *
 * @author LiFang
 * @date 2018-10-13 8:18 PM
 * @since
 */


@ConfigurationProperties(prefix = "ytx.security")
public class SecurityProperties {

    private final SecurityProperties.WebProperties web = new SecurityProperties.WebProperties();

    private final SecurityProperties.ValidateCodeProperties code = new SecurityProperties.ValidateCodeProperties();


    public WebProperties getWeb() {
        return web;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    /**
     * web应用配置
     */
    public static class WebProperties {

        private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;

        private LoginResponseType loginType = LoginResponseType.JSON;

        private int rememberMeSeconds = 3600;

        public String getLoginPage() {
            return loginPage;
        }

        public void setLoginPage(String loginPage) {
            this.loginPage = loginPage;
        }

        public LoginResponseType getLoginType() {
            return loginType;
        }

        public void setLoginType(LoginResponseType loginType) {
            this.loginType = loginType;
        }

        public int getRememberMeSeconds() {
            return rememberMeSeconds;
        }

        public void setRememberMeSeconds(int rememberMeSeconds) {
            this.rememberMeSeconds = rememberMeSeconds;
        }
    }


    /**
     * 验证码
     */
    public static class ValidateCodeProperties {

        private final SecurityProperties.ValidateCodeProperties.ImageCodeProperties image = new SecurityProperties.ValidateCodeProperties.ImageCodeProperties();

        private final SecurityProperties.ValidateCodeProperties.SmsCodeProperties sms = new SecurityProperties.ValidateCodeProperties.SmsCodeProperties();

        public ImageCodeProperties getImage() {
            return image;
        }

        public SmsCodeProperties getSms() {
            return sms;
        }

        /**
         * image validate
         */
        public static class ImageCodeProperties {

            private int expireIn = 60;
            private String url;
            private String border;
            private String borderColor;
            private String textProducerFontColor;
            private String textProducerFontSize;
            private String textProducerFontNames;
            private String textProducerCharLength;
            private String imageWidth;
            private String imageHeight;
            private String noiseColor;
            private String noiseImpl;
            private String obscurificatorImpl;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getBorder() {
                return border;
            }

            public void setBorder(String border) {
                this.border = border;
            }

            public String getBorderColor() {
                return borderColor;
            }

            public void setBorderColor(String borderColor) {
                this.borderColor = borderColor;
            }

            public String getTextProducerFontColor() {
                return textProducerFontColor;
            }

            public void setTextProducerFontColor(String textProducerFontColor) {
                this.textProducerFontColor = textProducerFontColor;
            }

            public String getTextProducerFontSize() {
                return textProducerFontSize;
            }

            public void setTextProducerFontSize(String textProducerFontSize) {
                this.textProducerFontSize = textProducerFontSize;
            }

            public String getTextProducerFontNames() {
                return textProducerFontNames;
            }

            public void setTextProducerFontNames(String textProducerFontNames) {
                this.textProducerFontNames = textProducerFontNames;
            }

            public String getTextProducerCharLength() {
                return textProducerCharLength;
            }

            public void setTextProducerCharLength(String textProducerCharLength) {
                this.textProducerCharLength = textProducerCharLength;
            }

            public String getImageWidth() {
                return imageWidth;
            }

            public void setImageWidth(String imageWidth) {
                this.imageWidth = imageWidth;
            }

            public String getImageHeight() {
                return imageHeight;
            }

            public void setImageHeight(String imageHeight) {
                this.imageHeight = imageHeight;
            }

            public String getNoiseColor() {
                return noiseColor;
            }

            public void setNoiseColor(String noiseColor) {
                this.noiseColor = noiseColor;
            }

            public String getNoiseImpl() {
                return noiseImpl;
            }

            public void setNoiseImpl(String noiseImpl) {
                this.noiseImpl = noiseImpl;
            }

            public String getObscurificatorImpl() {
                return obscurificatorImpl;
            }

            public void setObscurificatorImpl(String obscurificatorImpl) {
                this.obscurificatorImpl = obscurificatorImpl;
            }


            public int getExpireIn() {
                return expireIn;
            }

            public void setExpireIn(int expireIn) {
                this.expireIn = expireIn;
            }
        }

        /**
         * sms validate
         */
        public static class SmsCodeProperties {

            private int length = 6;
            private int expireIn = 60;

            private String url;

            public int getLength() {
                return length;
            }
            public void setLength(int lenght) {
                this.length = lenght;
            }
            public int getExpireIn() {
                return expireIn;
            }
            public void setExpireIn(int expireIn) {
                this.expireIn = expireIn;
            }
            public String getUrl() {
                return url;
            }
            public void setUrl(String url) {
                this.url = url;
            }

        }
    }
}
