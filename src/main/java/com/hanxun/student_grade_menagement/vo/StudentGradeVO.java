package com.hanxun.student_grade_menagement.vo;

/**
 * @author han xun
 * Date 2021/6/5 23:00
 * Description:
 */
public class StudentGradeVO {

    /**
     * courseGradeId
     */
    private Long courseGradeId;


    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 成绩
     */
    private Double grade;

    public StudentGradeVO() {
    }


    public StudentGradeVO(Long courseGradeId, String studentName, Double grade) {
        this.courseGradeId = courseGradeId;
        this.studentName = studentName;
        this.grade = grade;
    }

    public Long getCourseGradeId() {
        return courseGradeId;
    }

    public void setCourseGradeId(Long courseGradeId) {
        this.courseGradeId = courseGradeId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
