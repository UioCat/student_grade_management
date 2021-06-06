package com.hanxun.student_grade_menagement.vo;

import com.hanxun.student_grade_menagement.entity.Major;

/**
 * @author han xun
 * Date 2021/6/5 20:07
 * Description:
 */
public class MajorVO {

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
     * 学院名
     */
    private String collegeName;

    public MajorVO() {
    }

    public MajorVO(Major major, String collegeName) {
        this.serialNumber = major.getSerialNumber();
        this.majorName = major.getMajorName();
        this.majorClasses = major.getMajorClasses();
        this.collegeName = collegeName;
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

    public String getcollegeName() {
        return collegeName;
    }

    public void setcollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}
