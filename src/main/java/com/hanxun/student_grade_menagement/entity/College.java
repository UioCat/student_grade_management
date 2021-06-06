package com.hanxun.student_grade_menagement.entity;

/**
 * @author han xun
 * Date 2021/6/5 11:25
 * Description: 学院实体类
 */
public class College {

    /**
     * 主键
     */
    private Long id;

    /**
     * 学院编号（对外显示）
     */
    private String serialCollege;

    /**
     * 学院名
     */
    private String collegeName;

    /**
     * 院长名
     */
    private String dean;

    /**
     * 专业id数组
     */
    private String majorIdArray;

    /**
     * 课程id数组
     */
    private String courseIdArray;


    public College() {
    }

    public String getCourseIdArray() {
        return courseIdArray;
    }

    public void setCourseIdArray(String courseIdArray) {
        this.courseIdArray = courseIdArray;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialCollege() {
        return serialCollege;
    }

    public void setSerialCollege(String serialCollege) {
        this.serialCollege = serialCollege;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }

    public String getMajorIdArray() {
        return majorIdArray;
    }

    public void setMajorIdArray(String majorIdArray) {
        this.majorIdArray = majorIdArray;
    }
}
