package com.hanxun.student_grade_menagement.dao;

import com.hanxun.student_grade_menagement.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author han xun
 * Date 2021/6/5 12:54
 * Description:
 */
@Mapper
@Component
public interface AdminDao {

    /**
     * 根据账号查询id和密码
     * @param account
     * @return
     */
    @Select("SELECT id,password FROM tb_admin WHERE account=#{account}")
    Admin queryAdminByAccount(String  account);
}
