package com.hanxun.student_grade_menagement.dao;

import com.hanxun.student_grade_menagement.entity.CourseGrade;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author han xun
 * Date 2021/6/5 12:54
 * Description:
 */
@Mapper
@Component
public interface CourseGradeDao {

    /**
     * 插入信息
     */
    void insertMsg(CourseGrade courseGrade);

    /**
     * 更新成绩
     * @param courseGrade
     */
    void updateGrade(CourseGrade courseGrade);

    /**
     * 查询是否重复
     * @param courseGrade
     */
    CourseGrade queryByStudentIdAndCourseTeacherId(CourseGrade courseGrade);

    /**
     * 查询学生选课list
     * @param id 学生id
     */
    List<CourseGrade> queryListByStudentId(Long id);

    /**
     * 查询数据by id
     * @param courseTeacherId
     * @return *
     */
    @Select("SELECT * FROM tb_course_grade WHERE course_teacher_id=#{courseTeacherId}")
    List<CourseGrade> queryByCourseTeacherId(Long courseTeacherId);

    @Delete("DELETE FROM tb_course_grade WHERE id=#{id}")
    void deleteById(Long id);


    @Select("SELECT *  FROM tb_course_grade WHERE id=#{id}")
    CourseGrade queryCourseTeacherById(Long id);
}
