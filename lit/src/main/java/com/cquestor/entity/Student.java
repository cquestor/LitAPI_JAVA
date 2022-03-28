package com.cquestor.entity;

public class Student {
    private String id; // 学号
    private String nickname; // 姓名
    private int sex; // 性别
    private int age; // 年龄
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
    private String nativeAddress; // 家庭住址
    private String localAddress; // 学校住址
    private String instructorName; // 辅导员姓名
    private String nation; // 名族
    private String outlook; // 政治面貌
    private String origin; // 生源地
    private String imagePath; // 照片

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getNativeAddress() {
        return nativeAddress;
    }

    public void setNativeAddress(String nativeAddress) {
        this.nativeAddress = nativeAddress;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getOutlook() {
        return outlook;
    }

    public void setOutlook(String outlook) {
        this.outlook = outlook;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", birthday=" + birthday + ", category=" + category + ", classCode=" + classCode
                + ", className=" + className + ", eductionalSystem=" + eductionalSystem + ", facultiesCode="
                + facultiesCode + ", facultiesName=" + facultiesName + ", grade=" + grade + ", id=" + id + ", idNumber="
                + idNumber + ", imagePath=" + imagePath + ", instructorName=" + instructorName + ", lastLoginTime="
                + lastLoginTime + ", localAddress=" + localAddress + ", majorCode=" + majorCode + ", majorName="
                + majorName + ", memberIdAesEncrypt=" + memberIdAesEncrypt + ", nation=" + nation + ", nativeAddress="
                + nativeAddress + ", nickname=" + nickname + ", origin=" + origin + ", outlook=" + outlook + ", phone="
                + phone + ", sex=" + sex + ", state=" + state + "]";
    }

}
