package com.ytx.security.core.validate.code;

import com.ytx.security.core.constant.SecurityConstants;

/**
 * ${TODO}
 *
 * @author LiFang
 * @date 2018-10-25 5:03 PM
 * @since
 */
public enum ValidateCodeType {

    /**
     * 图片验证码
     */
    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };

    /**
     * 校验时从请求中获取的参数的名字
     *
     * @return
     */
    public abstract String getParamNameOnValidate();
}
