package com.cquestor.util;

/**
 * 各种接口
 */
public class APIUtil {
    // 门户网站首页地址
    public static final String indexUrl = "https://sec.lit.edu.cn/webvpn/LjIwNi4xNzAuMjE4LjE2Mg==/LjIwNy4xNTQuMjE3Ljk2LjE2MS4xNTkuMTY0Ljk3LjE1MS4xOTkuMTczLjE0NC4xOTguMjEy/authserver/login?service=https%3A%2F%2Fsec.lit.edu.cn%2Frump_frontend%2FloginFromCas%2F";

    // 门户网站获取Cookie地址
    public static final String indexCookieUrl = "https://sec.lit.edu.cn/rump_frontend/login/?next=https%3A%2F%2Fsec.lit.edu.cn%2Fwebvpn%2FLjIwNi4xNzAuMjE4LjE2Mi4xNjg%3D%2FLjIxMS4xNzUuMTQ4LjE1OC4xNTguMTcwLjk0LjE1Mi4xNTAuMjE2LjEwMi4xOTcuMjA5%2Fportal%2Fpc%2Flit%2Findex.html";

    // 门户网站登录地址
    public static final String indexLoginUrl = "https://sec.lit.edu.cn/webvpn/LjIwNi4xNzAuMjE4LjE2Mg==/LjIwNy4xNTQuMjE3Ljk2LjE2MS4xNTkuMTY0Ljk3LjE1MS4xOTkuMTczLjE0NC4xOTguMjEy/authserver/login?vpn-0&service=https%3A%2F%2Fsec.lit.edu.cn%2Frump_frontend%2FloginFromCas%2F";

    // 门户网站认证地址
    public static final String indexLoginRegistryUrl = "https://sec.lit.edu.cn/webvpn/LjIwNi4xNzAuMjE4LjE2Mg==/LjIxMS4xNzUuMTQ4LjE1OC4xNTguMTcwLjk0LjE1Mi4xNTAuMjE2LjEwMi4xOTcuMjA5LjE2MC4xNTguOTk=/portal/login/pcLogin?vpn-0";

    // 门户网站退出登录接口
    public static final String logoutUrl = "https://sec.lit.edu.cn/webvpn/LjIwNi4xNzAuMjE4LjE2Mi4xNjg=/LjIxMS4xNzUuMTQ4LjE1OC4xNTguMTcwLjk0LjE1Mi4xNTAuMjE2LjEwMi4xOTcuMjA5/portal/login/logout?vpn-0";

    // 门户网站通过Cookie获取个人信息
    public static final String indexCookieInfo = "https://sec.lit.edu.cn/webvpn/LjIwNi4xNzAuMjE4LjE2Mi4xNjg=/LjIxMS4xNzUuMTQ4LjE1OC4xNTguMTcwLjk0LjE1Mi4xNTAuMjE2LjEwMi4xOTcuMjA5/portal/myCenter/getMemberInfoForCurrentMember?vpn-0";

    // 门户网站通过MemberId获取个人信息
    public static final String indexMemberIdInfo = "https://sec.lit.edu.cn/webvpn/LjIwNi4xNzAuMjE4LjE2Mi4xNjg=/LjIxMS4xNzUuMTQ4LjE1OC4xNTguMTcwLjk0LjE1Mi4xNTAuMjE2LjEwMi4xOTcuMjA5/microapplication/api/v1/index/getStudentByStudentId?vpn-0";

    // Redis操作
    public static final String redisUrl = "https://sec.lit.edu.cn/webvpn/LjIwNi4xNzAuMjE4LjE2Mi4xNjg=/LjIxMS4xNzUuMTQ4LjE1OC4xNTguMTcwLjk0LjE1Mi4xNTAuMjE2LjEwMi4xOTcuMjA5/portal/myCenter/insertPortalPcAccessIntoRedis?vpn-0";

    // 门户网站获取健康上报平台token
    public static final String getTokenFromIndex = "https://sec.lit.edu.cn/webvpn/LjIwNi4xNzAuMjE4LjE2Mg==/LjIwNy4xNTQuMjE3Ljk2LjE2MS4xNTkuMTY0Ljk3LjE1MS4xOTkuMTczLjE0NC4xOTguMjEy/authserver/login?vpn-0&amp;service=http://hmgr.sec.lit.edu.cn/wms/getToken";

    // 健康上报平台获取token
    public static final String getTokenFromReport = "https://sec.lit.edu.cn/webvpn/cookie/?domain=hmgr.sec.lit.edu.cn&path=%2Fweb%2F";

    // 获取健康上报平台基本个人信息
    public static final String getInfoFromReport = "https://sec.lit.edu.cn/webvpn/LjIwNi4xNzAuMjE4LjE2Mg==/LjIwNi4xNjMuMjA1LjE2NC45OS4xNjkuMTQ5LjE1MC45Ni4yMDcuMTYxLjIxNC4xNDUuMjAzLjIwMi4xNjguOTQuMTk4LjE2Ng==/wms/getToken?vpn-0";

    // 教务系统Cookie认证
    public static final String educationCookie = "https://sec.lit.edu.cn/webvpn/LjIwNi4xNzAuMjE4LjE2Mg==/LjIwOC4xNzMuMTQ4LjE1OC4xNTguMTcwLjk0LjE1Mi4xNTAuMjE2LjEwMi4xOTcuMjA5/cas_njjz.aspx?vpn-0";

    // 教务系统获取个人信息
    public static final String educationInfo = "https://sec.lit.edu.cn/webvpn/LjIwNi4xNzAuMjE4LjE2Mg==/LjIwOC4xNzMuMTQ4LjE1OC4xNTguMTcwLjk0LjE1Mi4xNTAuMjE2LjEwMi4xOTcuMjA5/xsxj/Stu_MyInfo_RPT.aspx";

}
