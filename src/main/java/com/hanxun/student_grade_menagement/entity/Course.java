package com.hanxun.student_grade_menagement.entity;

/**
 * @author han xun
 * Date 2021/6/5 11:25
 * Description: 课程信息
 */
public class Course {

    /**
     * 课程id
     */
    private Long id;

    /**
     * 课程编号（对外暴露）
     */
    private String serialNumber;

    /**
     * 课程名
     */
    private String courseName;

    /**
     * 学分
     */
    private Double credit;

    /**
     * 学院编号
     */
    private String collegeId;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }
}
