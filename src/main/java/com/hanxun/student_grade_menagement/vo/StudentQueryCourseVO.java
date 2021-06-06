package com.hanxun.student_grade_menagement.vo;

/**
 * @author han xun
 * Date 2021/6/5 15:43
 * Description:
 */
public class StudentQueryCourseVO {

    private Long id;
    private String courseName;
    private String teacherName;
    private Double credit;
    private Double grade;

    public StudentQueryCourseVO() {
    }

    public StudentQueryCourseVO(Long id, String courseName, String teacherName, Double credit) {
        this.id = id;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.credit = credit;
    }

    public StudentQueryCourseVO(Long id, String courseName, String teacherName, Double credit, Double grade) {
        this.id = id;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.credit = credit;
        this.grade = grade;
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
