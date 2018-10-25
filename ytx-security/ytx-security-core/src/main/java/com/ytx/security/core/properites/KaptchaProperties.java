package com.ytx.security.core.properites;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * ${TODO}
 *
 * @author LiFang
 * @date 2018-10-24 9:56 PM
 * @since
 */


@ConfigurationProperties(prefix = "kaptcha")
public class KaptchaProperties {
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
    private String sessionKey;
    private String sessionDate;

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

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
    }
}
