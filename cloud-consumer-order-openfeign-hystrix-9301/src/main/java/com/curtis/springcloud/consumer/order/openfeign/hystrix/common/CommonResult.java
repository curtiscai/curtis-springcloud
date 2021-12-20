package com.curtis.springcloud.consumer.order.openfeign.hystrix.common;

public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    public CommonResult() {
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public static <T> CommonResult success(Integer code, String message, T data) {
        CommonResult<T> commonResult = new CommonResult(code, message, data);
        return commonResult;
    }

    public static CommonResult fail(Integer code, String message) {
        CommonResult commonResult = new CommonResult(code, message);
        return commonResult;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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
}
