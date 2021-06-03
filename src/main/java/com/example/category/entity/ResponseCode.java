package com.example.category.entity;

import org.springframework.stereotype.Component;

/**
 * @author zrj
 * @date 2021/6/2
 * @since V1.0
 **/
@Component
public class ResponseCode {
    private String successCode = "200";

    private String errorCode = "500";

    private String authErrorCode = "300";

    public String getSuccessCode() {
        return successCode;
    }

    public void setSuccessCode(String successCode) {
        this.successCode = successCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getAuthErrorCode() {
        return authErrorCode;
    }

    public void setAuthErrorCode(String authErrorCode) {
        this.authErrorCode = authErrorCode;
    }
}
