package com.cquestor.entity;

public class Student {
    private String id; // 学号
    private String nickname; // 姓名
    private int sex; // 性别
    private String phone; // 手机号
    private String idNumber; // 身份证号码
    private int state; // 学籍状态
    private String lastLoginTime; // 最近一次登录时间
    private String memberIdAesEncrypt; // 加密学号
    private String birthday; // 生日
    private String facultiesCode; // 学院编号
    private String facultiesName; // 学院名
    private String majorCode; // 专业编号
    private String majorName; // 专业名
    private String grade; // 年级
    private String classCode; // 班级编号
    private String className; // 班级名
    private int eductionalSystem; // 学制
    private String category; // 科目

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getMemberIdAesEncrypt() {
        return memberIdAesEncrypt;
    }

    public void setMemberIdAesEncrypt(String memberIdAesEncrypt) {
        this.memberIdAesEncrypt = memberIdAesEncrypt;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getFacultiesCode() {
        return facultiesCode;
    }

    public void setFacultiesCode(String facultiesCode) {
        this.facultiesCode = facultiesCode;
    }

    public String getFacultiesName() {
        return facultiesName;
    }

    public void setFacultiesName(String facultiesName) {
        this.facultiesName = facultiesName;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getEductionalSystem() {
        return eductionalSystem;
    }

    public void setEductionalSystem(int eductionalSystem) {
        this.eductionalSystem = eductionalSystem;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Student [birthday=" + birthday + ", category=" + category + ", classCode=" + classCode + ", className="
                + className + ", eductionalSystem=" + eductionalSystem + ", facultiesCode=" + facultiesCode
                + ", facultiesName=" + facultiesName + ", grade=" + grade + ", id=" + id + ", idNumber=" + idNumber
                + ", lastLoginTime=" + lastLoginTime + ", majorCode=" + majorCode + ", majorName=" + majorName
                + ", memberIdAesEncrypt=" + memberIdAesEncrypt + ", nickname=" + nickname + ", phone=" + phone
                + ", sex=" + sex + ", state=" + state + "]";
    }

}
