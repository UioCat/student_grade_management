package com.hanxun.student_grade_menagement.dao;

import com.hanxun.student_grade_menagement.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author han xun
 * Date 2021/6/5 12:55
 * Description:
 */
@Mapper
@Component
public interface TeacherDao {

    /**
     * 根据教师账号查询 id， 密码
     */
    @Select("SELECT id,password FROM tb_teacher WHERE account=#{account}")
    Teacher queryTeacherByAccount(String account);

    /**
     * 根据id查询*
     */
    @Select("SELECT * FROM tb_teacher WHERE id=#{id}")
    Teacher queryTeacherById(Long id);
}
