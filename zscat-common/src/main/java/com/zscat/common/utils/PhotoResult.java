package com.zscat.common.utils;

/**
 * 上传图片的响应体
 * FILE: com.bootdo.blog.domain.PhotoResult.java
 * MOTTO:  不积跬步无以至千里,不积小流无以至千里
 * AUTHOR: ZSCAT
 * DATE: 2017/4/21
 * TIME: 22:20
 */
public class PhotoResult {

    private int success;    //成功标准 0失败 1成功
    private String url;     //图片url
    private String message; //错误信息

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
