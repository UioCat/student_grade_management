package com.hanxun.student_grade_menagement.entity;

/**
 * @author han xun
 * Date 2021/6/5 11:25
 * Description: 教师实体类
 */
public class Teacher {

    /**
     * 教师id
     */
    private Long id;

    /**
     * 教师编号
     */
    private String account;

    /**
     * 教师名
     */
    private String teacherName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 职称
     */
    private String jobTitle;

    /**
     * 学院id
     */
    private String collegeId;

    /**
     * 教师登陆密码
     */
    private String password;

    public Teacher() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }
}
