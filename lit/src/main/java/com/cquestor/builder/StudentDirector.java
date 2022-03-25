package com.cquestor.builder;

import java.util.concurrent.CompletableFuture;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cquestor.entity.Student;

public class StudentDirector {

    /**
     * 获取Student类，包含各项学生信息
     * 
     * @param cookie 登录Cookie
     * @return 学生类
     */
    public static Student getStudent(String cookie) {
        SubStudentBuilder studentBuilder = new SubStudentBuilder(cookie);
        CompletableFuture<Student> futures = CompletableFuture.supplyAsync(() -> {
            Student student = new Student();
            String studentInfoByCookie = studentBuilder.getIndexPartByCookie();
            JSONObject jsonInfo = JSON.parseObject(studentInfoByCookie);
            student.setId(jsonInfo.get("memberId").toString());
            student.setNickname(jsonInfo.get("memberNickname").toString());
            student.setSex(jsonInfo.get("memberSex").toString().equals("1") ? 1 : 0);
            student.setPhone(jsonInfo.get("memberPhone").toString());
            student.setIdNumber(jsonInfo.get("memberIdNumber").toString());
            student.setState(jsonInfo.get("memberState").toString().equals("1") ? 1 : 0);
            student.setLastLoginTime(jsonInfo.get("lastLoginTime").toString());
            student.setMemberIdAesEncrypt(jsonInfo.get("memberIdAesEncrypt").toString());
            return student;
        }).thenApply((student) -> {
            String studentInfoByMemberId = studentBuilder.getIndexPartByMemberId(student.getMemberIdAesEncrypt());
            JSONObject jsonInfo = JSON.parseObject(studentInfoByMemberId);
            student.setBirthday(jsonInfo.get("studentBirthday").toString());
            student.setFacultiesCode(jsonInfo.get("studentFacultiesCode").toString());
            student.setFacultiesName(jsonInfo.get("studentFacultiesName").toString());
            student.setMajorCode(jsonInfo.get("studentMajor").toString());
            student.setMajorName(jsonInfo.get("studentMajorName").toString());
            student.setGrade(jsonInfo.get("studentGrade").toString());
            student.setClassCode(jsonInfo.get("studentClassCode").toString());
            student.setClassName(jsonInfo.get("studentClassName").toString());
            student.setEductionalSystem(Integer.parseInt(jsonInfo.get("studentEductionalSystme").toString()));
            student.setCategory(jsonInfo.get("studentCategory").toString());
            return student;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            // TODO: 获取健康上报部分信息
            return "";
        }), (indexPart, reportPart) -> {
            // TODO: 合并门户网站信息和健康上报信息
            return indexPart;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            // TODO: 获取教务系统部分信息
            return "";
        }), (abovePart, educationPart) -> {
            // TODO: 合并所有信息
            return abovePart;
        });
        return futures.join();
    }

}
