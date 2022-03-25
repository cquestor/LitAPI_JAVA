package com.cquestor.builder;

public abstract class StudentBuilder {

    /**
     * 通过Cookie获取门户网站部分信息
     * @return 门户网站个人信息
     */
    protected abstract String getIndexPartByCookie();

    /**
     * 通过memberId获取门户网站部分信息
     * @param memberIdAesEncrypt memberId（经加密的学号）
     * @return 门户网站个人信息
     */
    protected abstract String getIndexPartByMemberId(String memberIdAesEncrypt);

    protected abstract String getReportPart();
}
