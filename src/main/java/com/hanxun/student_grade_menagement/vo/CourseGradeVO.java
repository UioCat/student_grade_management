package com.hanxun.student_grade_menagement.vo;

/**
 * @author han xun
 * Date 2021/6/5 23:42
 * Description:
 */
public class CourseGradeVO {

    /**
     * courseGradeId
     */
    private Long id;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 成绩
     */
    private Double grade;

    /**
     * 课程名
     */
    private String courseName;

    /**
     * 教师名
     */
    private String teacherName;

    public CourseGradeVO() {
    }

    public CourseGradeVO(Long id, String studentName, Double grade) {
        this.id = id;
        this.studentName = studentName;
        this.grade = grade;
    }

    public CourseGradeVO(Long id, String studentName, Double grade, String courseName, String teacherName) {
        this.id = id;
        this.studentName = studentName;
        this.grade = grade;
        this.courseName = courseName;
        this.teacherName = teacherName;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
