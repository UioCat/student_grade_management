package com.hanxun.student_grade_menagement.entity;

/**
 * @author han xun
 * Date 2021/6/5 12:11
 * Description: 课程教师表（教师对应教的课程）
 */
public class CourseTeacher {

    /**
     * 主键
     */
    private Long id;

    /**
     * 教师id
     */
    private Long teacherId;

    /**
     * 课程id
     */
    private Long courseId;

    public CourseTeacher() {
    }

    public Long getId() {
        return id;
    }

    public CourseTeacher(Long teacherId, Long courseId) {
        this.teacherId = teacherId;
        this.courseId = courseId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
