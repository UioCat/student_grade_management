package com.hanxun.student_grade_menagement.dao;

import com.hanxun.student_grade_menagement.entity.CourseTeacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author han xun
 * Date 2021/6/5 12:54
 * Description:
 */
@Mapper
@Component
public interface CourseTeacherDao {

    /**
     * 新增一条教师选择数据
     * @param courseTeacher
     */
    void insertMsg(CourseTeacher courseTeacher);

    /**
     * 教师取消该选择
     */
    void deleteCourseTeacher(CourseTeacher courseTeacher);

    /**
     * 根据教师id查询教师的选择
     * @return
     */
    List<CourseTeacher> queryCourseByTeacherId(Long teacherId);

    /**
     * 根据课程id查看 选择该课程的教师
     * @param courseId
     * @return
     */
    List<CourseTeacher> queryCourseByCourseId(Long courseId);

    /**
     * 查询所有的课程-老师
     * @return
     */
    @Select("SELECT * FROM tb_course_teacher")
    List<CourseTeacher> queryCourseAll();

    /**
     * 根据ID 查询所有数据
     * @param id
     * @return *
     */
    @Select("SELECT * FROM tb_course_teacher WHERE id=#{id}")
    CourseTeacher queryCourseTeacherById(Long id);

    /**
     * 根据teacherId和courseId查询id
     * @return id
     */
    Long queryCourseTeacherByIdAndCourseId(CourseTeacher courseTeacher);
}
