package com.hanxun.student_grade_menagement.entity;

/**
 * @author han xun
 * Date 2021/6/5 11:29
 * Description:
 */
public class Major {

    /**
     * 专业id
     */
    private Long id;

    /**
     * 专业编号（对外显示）
     */
    private String serialNumber;

    /**
     * 专业名称
     */
    private String majorName;

    /**
     * 专业类别
     */
    private String majorClasses;

    /**
     * 学院编号（用于反查学院）
     */
    private String collegeId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorClasses() {
        return majorClasses;
    }

    public void setMajorClasses(String majorClasses) {
        this.majorClasses = majorClasses;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }
}
