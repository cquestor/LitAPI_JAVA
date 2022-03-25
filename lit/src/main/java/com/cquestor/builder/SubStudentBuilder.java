package com.cquestor.builder;

import java.io.IOException;
import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cquestor.entity.Response;
import com.cquestor.util.APIUtil;
import com.cquestor.util.RequestUtil;

public class SubStudentBuilder extends StudentBuilder {
    private String cookie; // 登录Cookie

    public SubStudentBuilder(String cookie) {
        this.cookie = cookie;
    }

    @Override
    public String getIndexPartByCookie() {
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
            e.printStackTrace();
        }
        JSONObject jsonResponse = JSON.parseObject(response.getText());
        return JSON.toJSONString(jsonResponse.get("obj"));
    }

    @Override
    protected String getIndexPartByMemberId(String memberIdAesEncrypt) {
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
            e.printStackTrace();
        }
        JSONObject jsonResponse = JSON.parseObject(response.getText());
        return JSON.toJSONString(jsonResponse.get("obj"));
    }

    @Override
    protected String getReportPart() {
        Response response = null;
        String nextUrl = null;
        RequestUtil request = new RequestUtil();
        HashMap<String, String> headers = new HashMap<>() {
            {
                put("user-agent",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.82Safari/537.36");
                put("content-type", "application/json");
            }
        };
        headers.put("cookie", this.cookie);
        String data = JSON.toJSONString(new HashMap<String, String>() {
            {
                put("pcAccessAppId", "55e5215cf4254ec1aafb0c859c2f4462");
                put("pcAccessCategory", "0");
            }
        });
        try {
            response = request.doPost(
                    "https://sec.lit.edu.cn/webvpn/LjIwNi4xNzAuMjE4LjE2Mi4xNjg=/LjIxMS4xNzUuMTQ4LjE1OC4xNTguMTcwLjk0LjE1Mi4xNTAuMjE2LjEwMi4xOTcuMjA5/portal/myCenter/insertPortalPcAccessIntoRedis?vpn-0",
                    headers, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        headers.remove("content-type");
        try {
            response = request.doGet(
                    "https://sec.lit.edu.cn/webvpn/LjIwNi4xNzAuMjE4LjE2Mg==/LjIwNi4xNjMuMjA1LjE2NC45OS4xNjkuMTQ5LjE1MC45Ni4yMDcuMTYxLjIxNC4xNDUuMjAzLjIwMi4xNjguOTQuMTk4LjE2Ng==/?vpn-0", headers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        nextUrl = response.getHeaders().get("Location").get(0);
        System.out.println(nextUrl);
        return null;
    }
}
