package com.yangzhou.intelligent.pojo;

import lombok.Data;

/**
 * 异常类
 */
@Data
public class BizException extends RuntimeException {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;

    public BizException() {
        super();
    }


    public Integer getCode(){
        return this.code;
    }

    public String getmessage(){
        return this.message;
    }

    public BizException(ResultCode resultCode) {
        super(resultCode.message());
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public BizException(ResultCode resultCode, Throwable cause) {
        super(resultCode.message(), cause);
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public BizException(String message) {
        super(message);
        this.code = -1;
        this.message = message;
    }

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BizException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}