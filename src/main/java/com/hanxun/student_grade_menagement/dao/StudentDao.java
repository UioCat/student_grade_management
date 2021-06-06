package com.hanxun.student_grade_menagement.dao;

import com.hanxun.student_grade_menagement.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author han xun
 * Date 2021/6/5 12:55
 * Description:
 */
@Component
@Mapper
public interface StudentDao {

    /**
     * 根据账号查询密码和id
     * @param studentNumber
     * @return
     */
    @Select("SELECT id, password FROM tb_student WHERE student_number=#{studentNumber}")
    Student queryStudentByStudentNumber(String studentNumber);

    /**
     * 根据id查询全部数据
     * @param id
     * @return
     */
    @Select("SELECT * FROM tb_student WHERE id=#{id}")
    Student queryStudentById(Long id);


    void updatePasswordById(Student student);
}
