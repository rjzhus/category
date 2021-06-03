package com.example.category.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zrj
 * @date 2021/6/2
 * @since V1.0
 **/
@Component
public class Response<T> {

    private static ResponseCode responseCode;
    /**
     * 提示消息
     */
    private String message;

    /**
     * 具体返回的数据
     */
    private T data;

    /**
     * 状态码
     */
    private String code;

    private Response(String code, String message, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    private Response(String code, String msg) {
        this.message = msg;
        this.code = code;
    }

    @Autowired
    public Response(ResponseCode responseCode) {
        Response.responseCode = responseCode;
    }

    /**
     * 返回成功Response对象
     *
     * @param successMessage 成功提示信息
     * @param data           需要返回的数据
     * @return 成功信息
     */
    public static <T> Response<T> createSuccessResponse(String successMessage, T data) {
        return new Response<>( responseCode.getSuccessCode(), successMessage, data );
    }


    /**
     * 返回错误Response对象
     *
     * @param errorMessage 错误信息
     * @return 错误信息
     */
    public static <T> Response<T> createErrorResponse(String errorMessage) {
        return new Response<>( responseCode.getErrorCode(), errorMessage );
    }

    public Response() {
    }

    /**
     * 返回未登录状态码
     *
     * @param message 提示信息
     * @return Response
     */
    public static <T> Response<T> createUnLoginResponse(String message) {
        return new Response<>( responseCode.getAuthErrorCode(), message );
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
