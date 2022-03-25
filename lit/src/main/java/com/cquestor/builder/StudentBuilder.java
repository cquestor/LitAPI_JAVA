package com.cquestor.builder;

public abstract class StudentBuilder {

    protected abstract String getIndexPartByCookie();

    protected abstract String getIndexPartByMemberId(String memberIdAesEncrypt);
}
