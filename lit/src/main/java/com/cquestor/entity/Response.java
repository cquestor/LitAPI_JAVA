package com.cquestor.entity;

import java.util.List;
import java.util.Map;

/**
 * HTTP响应类
 */
public class Response {
    private int code; // 请求状态
    private String url; // 请求地址
    private Map<String, List<String>> headers; // 响应头
    private String text; // 响应信息

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
