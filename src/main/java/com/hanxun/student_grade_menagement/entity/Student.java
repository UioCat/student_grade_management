package com.hanxun.student_grade_menagement.entity;

/**
 * @author han xun
 * Date 2021/6/5 11:25
 * Description: 学生基础信息
 */
public class Student {

    /**
     * 学生id
     */
    private Long id;

    /**
     * 学生学号，编号（对外显示）
     */
    private String studentNumber;

    /**
     * 学生名
     */
    private String studentName;

    /**
     * 学生性别
     */
    private Byte sex;

    /**
     * 学生出生年月
     */
    private String birthYearMonth;

    /**
     * 学生家庭地址
     */
    private String familyAddress;

    /**
     * 学生专业id，用于查询专业数据
     */
    private Long majorId;

    /**
     * 学生登陆密码
     */
    private String password;

    /**
     * 学生选课成绩id数组
     */
    private String courseGradeIdArray;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getBirthYearMonth() {
        return birthYearMonth;
    }

    public void setBirthYearMonth(String birthYearMonth) {
        this.birthYearMonth = birthYearMonth;
    }

    public String getFamilyAddress() {
        return familyAddress;
    }

    public void setFamilyAddress(String familyAddress) {
        this.familyAddress = familyAddress;
    }

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCourseGradeIdArray() {
        return courseGradeIdArray;
    }

    public void setCourseGradeIdArray(String courseGradeIdArray) {
        this.courseGradeIdArray = courseGradeIdArray;
    }
}
