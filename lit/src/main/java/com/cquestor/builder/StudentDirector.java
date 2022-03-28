package com.cquestor.builder;

import java.util.concurrent.CompletableFuture;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cquestor.entity.Student;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class StudentDirector {

    /**
     * 获取Student类，包含各项学生信息
     * 
     * @param cookie 登录Cookie
     * @param token  健康上报平台token
     * @return 学生类
     */
    public static Student getStudent(String cookie, String token) {
        Student student = new Student();
        CompletableFuture<String> tasks = CompletableFuture.supplyAsync(() -> {
            // 通过Cookie获取门户网站学生信息
            SubStudentBuilder studentBuilder = new SubStudentBuilder(cookie, token);
            String result = studentBuilder.getIndexPartByCookie();
            return result;
        }).thenApply(lastResult -> {
            // 通过memberId获取门户网站部分信息
            SubStudentBuilder studentBuilder = new SubStudentBuilder(cookie, token);
            JSONObject jsonInfo = JSON.parseObject(lastResult);
            String result = studentBuilder.getIndexPartByMemberId(jsonInfo.getString("memberIdAesEncrypt"));
            JSONObject jsonNow = JSON.parseObject(result);
            for (String key : jsonNow.keySet()) {
                jsonInfo.put(key, jsonNow.getString(key));
            }
            return JSON.toJSONString(jsonInfo);
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            // 获取健康上报平台信息
            SubStudentBuilder studentBuilder = new SubStudentBuilder(cookie, token);
            String result = studentBuilder.getReportPart();
            return result;
        }), (indexPart, reportPart) -> {
            // 合并个人信息
            JSONObject jsonIndex = JSON.parseObject(indexPart);
            JSONObject jsonReport = JSON.parseObject(reportPart);
            for (String key : jsonReport.keySet()) {
                jsonIndex.put(key, jsonReport.get(key));
            }
            return JSON.toJSONString(jsonIndex);
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            // 获取教务系统个人信息
            SubStudentBuilder studentBuilder = new SubStudentBuilder(cookie, token);
            String result = studentBuilder.getEducationPart();
            Document doc = Jsoup.parse(result);
            Element table = doc.getElementsByTag("table").get(0);
            String nation = table.getElementsByTag("tr").get(4).getElementsByTag("td").get(3).text();
            String outlook = table.getElementsByTag("tr").get(5).getElementsByTag("td").get(3).text();
            String origin = table.getElementsByTag("tr").get(14).getElementsByTag("td").get(3).text();
            String imagePath = table.getElementsByTag("img").get(0).attr("src");
            JSONObject jsonResult = new JSONObject() {
                {
                    put("nation", nation);
                    put("outlook", outlook);
                    put("origin", origin);
                    put("imagePath", imagePath);
                }
            };
            return JSON.toJSONString(jsonResult);
        }), (abovePart, educationPart) -> {
            // 合并信息
            JSONObject aboveJson = JSON.parseObject(abovePart);
            JSONObject nowJson = JSON.parseObject(educationPart);
            for (String key : nowJson.keySet()) {
                aboveJson.put(key, nowJson.get(key));
            }
            return JSON.toJSONString(aboveJson);
        });
        JSONObject jsonResult = JSON.parseObject(tasks.join());
        student.setId(jsonResult.getString("memberId"));
        student.setNickname(jsonResult.getString("memberNickname"));
        student.setSex(jsonResult.getString("sex").equals("1") ? 1 : 0);
        student.setAge(jsonResult.getIntValue("age"));
        student.setPhone(jsonResult.getString("mobile"));
        student.setIdNumber(jsonResult.getString("memberIdNumber"));
        student.setState(jsonResult.getString("memberState").equals("1") ? 1 : 0);
        student.setLastLoginTime(jsonResult.getString("lastLoginTime"));
        student.setMemberIdAesEncrypt(jsonResult.getString("memberIdAesEncrypt"));
        student.setBirthday(jsonResult.getString("studentBirthday"));
        student.setFacultiesCode(jsonResult.getString("studentFacultiesCode"));
        student.setFacultiesName(jsonResult.getString("studentFacultiesName"));
        student.setMajorCode(jsonResult.getString("studentMajor"));
        student.setMajorName(jsonResult.getString("studentMajorName"));
        student.setGrade(jsonResult.getString("studentGrade"));
        student.setClassCode(jsonResult.getString("studentClassCode"));
        student.setClassName(jsonResult.getString("studentClassName"));
        student.setEductionalSystem(jsonResult.getIntValue("studentEductionalSystme"));
        student.setCategory(jsonResult.getString("studentCategory"));
        student.setNativeAddress(jsonResult.getString("nativePlaceAddress"));
        student.setLocalAddress(jsonResult.getString("localAddress"));
        student.setNation(jsonResult.getString("nation"));
        student.setOutlook(jsonResult.getString("outlook"));
        student.setOrigin(jsonResult.getString("origin"));
        student.setImagePath(jsonResult.getString("imagePath"));
        return student;
    }

}
