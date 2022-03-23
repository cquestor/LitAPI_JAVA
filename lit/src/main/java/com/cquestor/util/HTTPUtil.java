package com.cquestor.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;

import com.cquestor.entity.Response;

public abstract class HTTPUtil {
    /**
     * 获取请求连接
     * 
     * @param requestUrl 请求地址
     * @param headers    请求头
     * @return 请求连接
     * @throws IOException 连接异常
     */
    protected abstract HttpURLConnection getConnection(String requestUrl, HashMap<String, String> headers)
            throws IOException;

    /**
     * 添加请求信息
     * 
     * @param connection  请求连接
     * @param requestData 请求信息
     * @throws IOException 获取输出流异常
     */
    protected abstract void setRequestData(HttpURLConnection connection, String requestData) throws IOException;

    /**
     * 读取响应信息
     * 
     * @param connection 请求连接
     * @return 响应信息
     * @throws IOException 获取输入流异常
     */
    protected abstract String getResponse(HttpURLConnection connection) throws IOException;

    /**
     * 发送GET请求
     * 
     * @param requestUrl 请求地址
     * @param headers    请求头
     * @return 响应类，包含请求URL(url)、状态码(code)、响应头(header)、响应信息(text)
     * @throws IOException 请求异常
     */
    protected abstract Response doGet(String requestUrl, HashMap<String, String> headers)
            throws IOException;

    /**
     * 发送POST请求
     * 
     * @param requestUrl  请求地址
     * @param headers     请求头
     * @param requestData 请求信息
     * @return 响应类，包含请求URL(url)、状态码(code)、响应头(header)、响应信息(text)
     * @throws IOException 请求异常
     */
    protected abstract Response doPost(String requestUrl, HashMap<String, String> headers,
            String requestData) throws IOException;

}
