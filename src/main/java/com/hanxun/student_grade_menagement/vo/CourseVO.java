package com.hanxun.student_grade_menagement.vo;

import com.hanxun.student_grade_menagement.entity.Course;

/**
 * @author han xun
 * Date 2021/6/5 21:19
 * Description:
 */
public class CourseVO {
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
     * 学院名称
     */
    private String collegeName;

    public CourseVO() {
    }

    public CourseVO(Course course, String collegeName) {
        this.serialNumber = course.getSerialNumber();
        this.courseName = course.getCourseName();
        this.credit = course.getCredit();
        this.collegeName = collegeName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}
