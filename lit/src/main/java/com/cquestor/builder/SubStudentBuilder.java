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
}
