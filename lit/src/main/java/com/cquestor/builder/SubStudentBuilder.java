package com.cquestor.builder;

import java.io.IOException;
import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cquestor.entity.Response;
import com.cquestor.exception.HTTPException;
import com.cquestor.util.APIUtil;
import com.cquestor.util.RequestUtil;

public class SubStudentBuilder extends StudentBuilder {
    private String cookie; // 登录Cookie
    private String token; // 健康上报平台token

    public SubStudentBuilder(String cookie, String token) {
        this.cookie = cookie;
        this.token = token;
    }

    @Override
    public String getIndexPartByCookie() throws HTTPException {
        RequestUtil request = new RequestUtil();
        Response response = null;
        HashMap<String, String> headers = new HashMap<String, String>() {
            {
                put("user-agent",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.82 Safari/537.36");
            }
        };
        headers.put("cookie", this.cookie);
        try {
            response = request.doPost(APIUtil.indexCookieInfo, headers, null);
        } catch (IOException e) {
            throw new HTTPException("请求失败，请检查网络连接！");
        }
        JSONObject jsonResponse = JSON.parseObject(response.getText());
        return JSON.toJSONString(jsonResponse.get("obj"));
    }

    @Override
    protected String getIndexPartByMemberId(String memberIdAesEncrypt) throws HTTPException {
        RequestUtil request = new RequestUtil();
        Response response = null;
        HashMap<String, String> headers = new HashMap<String, String>() {
            {
                put("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
                put("user-agent",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.82 Safari/537.36");
            }
        };
        headers.put("cookie", this.cookie);
        String data = String.format("studentId=%s", memberIdAesEncrypt);
        try {
            response = request.doPost(APIUtil.indexMemberIdInfo, headers, data);
        } catch (IOException e) {
            throw new HTTPException("请求失败，请检查网络连接！");
        }
        JSONObject jsonResponse = JSON.parseObject(response.getText());
        return JSON.toJSONString(jsonResponse.get("obj"));
    }

    @Override
    protected String getReportPart() throws HTTPException {
        // FIXME: 家庭住址省市编码转换
        Response response = null;
        RequestUtil request = new RequestUtil();
        HashMap<String, String> headers = new HashMap<>() {
            {
                put("user-agent",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.82 Safari/537.36");
            }
        };
        headers.put("cookie", this.cookie);
        headers.put("token", this.token);
        try {
            response = request.doGet(APIUtil.getInfoFromReport, headers);
        } catch (IOException e) {
            throw new HTTPException("请求失败，请检查网络连接！");
        }
        JSONObject jsonResponse = JSON.parseObject(response.getText());
        jsonResponse = JSON.parseObject(JSON.toJSONString(jsonResponse.get("data")));
        String url = String.format(
                "https://sec.lit.edu.cn/webvpn/LjIwNi4xNzAuMjE4LjE2Mg==/LjIwNi4xNjMuMjA1LjE2NC45OS4xNjkuMTQ5LjE1MC45Ni4yMDcuMTYxLjIxNC4xNDUuMjAzLjIwMi4xNjguOTQuMTk4LjE2Ng==/wms/getInstructor?vpn-0&amp;teamId=%s&amp;organizationName=%s&amp;userOrganizationId=%s",
                jsonResponse.getString("teamId"), jsonResponse.getString("organizationName"),
                jsonResponse.getString("userOrganizationId"));
        try {
            response = request.doGet(url, headers);
        } catch (IOException e) {
            throw new HTTPException("请求失败，请检查网络连接！");
        }
        JSONObject jsonInfo = JSON.parseObject(response.getText());
        jsonInfo = JSON.parseObject(JSON.toJSONString(jsonInfo.get("data")));
        for (String key : jsonInfo.keySet()) {
            jsonResponse.put(key, jsonInfo.get(key));
        }
        return JSON.toJSONString(jsonResponse);
    }

    @Override
    protected String getEducationPart() throws HTTPException {
        Response response = null;
        RequestUtil request = new RequestUtil();
        HashMap<String, String> headers = new HashMap<>() {
            {
                put("user-agent",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.82 Safari/537.36");
            }
        };
        headers.put("cookie", this.cookie);
        try {
            response = request.doGet(APIUtil.educationInfo, headers, "GBK");
        } catch (IOException e) {
            throw new HTTPException("请求失败，请检查网络连接！");
        }
        return response.getText();
    }
}
