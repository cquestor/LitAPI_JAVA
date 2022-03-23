package com.cquestor.builder;

import java.io.IOException;
import java.util.HashMap;

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
        System.out.println(response.getText());
        return null;
    }

    @Override
    protected String getIndexPartByMemberId() {
        // TODO Auto-generated method stub
        return null;
    }
}
