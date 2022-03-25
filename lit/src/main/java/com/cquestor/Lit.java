package com.cquestor;

import com.cquestor.builder.StudentDirector;
import com.cquestor.entity.Response;
import com.cquestor.entity.Student;
import com.cquestor.exception.EncryptException;
import com.cquestor.exception.HTTPException;
import com.cquestor.util.APIUtil;
import com.cquestor.util.Encrypt;
import com.cquestor.util.RequestUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.LoginException;

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
            String cookie = login("B19041430", "-app5896302");
            Student student = StudentDirector.getStudent(cookie);
            System.out.println(student.toString());
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (EncryptException e) {
            e.printStackTrace();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    /**
     * 登录洛理门户网站获取Cookie
     * 
     * @param username 洛理门户登录账号（学号）
     * @param password 洛理门户登录密码
     * @return Cookie
     * @throws HTTPException    网络连接异常
     * @throws EncryptException 加密异常
     * @throws LoginException   登录异常
     */
    public static String login(String username, String password)
            throws HTTPException, EncryptException, LoginException {
        RequestUtil request = new RequestUtil();
        Response response = null;
        String cookie = "";
        String nextUrl = "";
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
        responseHeader = response.getHeaders();
        for (String cookiePart : responseHeader.get("Set-Cookie")) {
            cookie += cookiePart.split(";")[0] + ";";
        }
        try {
            response = request.doGet(APIUtil.indexUrl, headers);
        } catch (IOException e) {
            throw new HTTPException("请求失败，请检查网络连接！");
        }
        Document doc = Jsoup.parse(response.getText());
        String salt = doc.getElementById("salt").attr("value");
        String execution = doc.getElementsByAttributeValue("name", "execution").first().attr("value");
        String _eventId = doc.getElementsByAttributeValue("name", "_eventId").first().attr("value");
        headers.put("cookie", cookie);
        headers.put("content-type", "application/x-www-form-urlencoded");
        try {
            password = Encrypt.AES(password, salt, "1234567890abcdef");
        } catch (Exception e) {
            // FIXME: 频繁登录可能导致出错，异常未区分
            throw new EncryptException("密码加密错误，可能是学校更新了加密逻辑！");
        }
        String data = String.format("username=%s&password=%s&execution=%s&_eventId=%s", username, password, execution,
                _eventId);
        try {
            response = request.doPost(APIUtil.indexUrl, headers, data);
        } catch (IOException e) {
            throw new HTTPException("请求失败，请检查网络连接！");
        }
        if (response.getCode() == HttpURLConnection.HTTP_OK) {
            throw new LoginException("登录失败，账号密码错误或登录过于频繁！");
        } else {
            nextUrl = response.getHeaders().get("Location").get(0);
            try {
                response = request.doGet(nextUrl, headers);
            } catch (IOException e) {
                throw new HTTPException("请求失败，请检查网络连接！");
            }
            try {
                response = request.doGet(APIUtil.indexLoginRegistryUrl, headers);
            } catch (IOException e) {
                throw new HTTPException("请求失败，请检查网络连接！");
            }
            nextUrl = response.getHeaders().get("Location").get(0);
            try {
                response = request.doGet(nextUrl, headers);
            } catch (IOException e) {
                throw new HTTPException("请求失败，请检查网络连接！");
            }
            nextUrl = response.getHeaders().get("Location").get(0);
            try {
                response = request.doGet(nextUrl, headers);
            } catch (IOException e) {
                throw new HTTPException("请求失败，请检查网络连接！");
            }
            nextUrl = response.getHeaders().get("Location").get(0);
            try {
                response = request.doGet(nextUrl, headers);
            } catch (IOException e) {
                throw new HTTPException("请求失败，请检查网络连接！");
            }
            nextUrl = response.getHeaders().get("Location").get(0);
            try {
                response = request.doGet(nextUrl, headers);
            } catch (IOException e) {
                throw new HTTPException("请求失败，请检查网络连接！");
            }
        }
        return cookie.equals("") ? null : cookie;
    }
}