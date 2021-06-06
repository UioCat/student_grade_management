package com.hanxun.student_grade_menagement.entity;

/**
 * @author han xun
 * Date 2021/6/5 11:57
 * Description: 学生课程成绩表(学生选课表）
 */
public class CourseGrade {

    /**
     * 主键
     */
    private Long id;

    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 对应的 课程-教师 id
     */
    private Long courseTeacherId;

    /**
     * 成绩
     */
    private Double grade;

    public CourseGrade(Long studentId, Long courseTeacherId) {
        this.studentId = studentId;
        this.courseTeacherId = courseTeacherId;
    }

    public CourseGrade() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseTeacherId() {
        return courseTeacherId;
    }

    public void setCourseTeacherId(Long courseTeacherId) {
        this.courseTeacherId = courseTeacherId;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

}
