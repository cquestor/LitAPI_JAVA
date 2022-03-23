package com.cquestor.builder;

public class StudentDirector {

    public static void getStudent(String cookie) {
        SubStudentBuilder studentBuilder = new SubStudentBuilder(cookie);
        studentBuilder.getIndexPartByCookie();
    }

}
