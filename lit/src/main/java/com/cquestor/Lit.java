package com.cquestor;

import com.cquestor.exception.HTTPException;
import com.cquestor.util.APIUtil;
import com.cquestor.util.RequestUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LitAPI
 *
 */
public class Lit {
    /**
     * 项目图标
     * 
     * @param args 系统参数
     */
    public static void main(String[] args) {
        System.out.println("   __________  __  _______________________  ____");
        System.out.println("  / ____/ __ \\/ / / / ____/ ___/_  __/ __ \\/ __ \\");
        System.out.println(" / /   / / / / / / / __/  \\__ \\ / / / / / / /_/ /");
        System.out.println("/ /___/ /_/ / /_/ / /___ ___/ // / / /_/ / _, _/ ");
        System.out.println("\\____/\\___\\_\\____/_____//____//_/  \\____/_/ |_|");

        try {
            login("", "");
        } catch (HTTPException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String login(String username, String password) throws HTTPException {
        RequestUtil request = new RequestUtil();
        String cookie = "";
        HashMap<String, Object> response = null;
        Map<String, List<String>> responseHeader = null;
        HashMap<String, String> headers = new HashMap<String, String>() {
            {
                put("User-Agent",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.74 Safari/537.36");
            }
        };
        try {
            response = request.doGet(APIUtil.indexCookieUrl, headers);
        } catch (IOException e) {
            throw new HTTPException("请求失败，请检查网络连接！");
        }
        responseHeader = (Map<String, List<String>>) response.get("header");
        for (String cookiePart : responseHeader.get("Set-Cookie")) {
            cookie += cookiePart.split(";")[0] + ";";
        }
        try {
            response = request.doGet(APIUtil.indexUrl, headers);
        } catch (IOException e) {
            throw new HTTPException("请求失败，请检查网络连接！");
        }
        Document doc = Jsoup.parse((String) response.get("header"));
        return cookie.equals("") ? null : cookie;
    }
}