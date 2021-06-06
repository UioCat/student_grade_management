package com.hanxun.student_grade_menagement.service;

import com.hanxun.student_grade_menagement.utils.BackMessage;

/**
 * @author han xun
 * Date 2021/6/5 15:17
 * Description:
 */
public interface StudentService {

    /**
     * 学生选课
     * @return
     */
    BackMessage studentChooseCourseService(Long studentId, Long courseTeacherId);

    /**
     * 查看学生选课列表
     * @return
     */
    BackMessage queryCourseList();

    /**
     * 学生查询已选的课以及成绩
     * @return
     */
    BackMessage queryCourseGrade(Long id);

    /**
     * 根据学生id查询学生基础信息
     * @return
     */
    BackMessage queryMsgById(Long id);

    /**
     * 取消选课
     * @param studentId 学生id
     * @param courseTeacherId courseTeacherId
     * @return
     */
    BackMessage retreatCourseService(Long studentId, Long courseTeacherId);

    /**
     * 修改学生密码
     * @return
     */
    BackMessage updatePassword(Long id, String oldPassword, String newPassword);

    /**
     * 学生查看自己已选课程
     * @param studentId 学生id
     * @return
     */
    BackMessage queryChoosedList(Long studentId);
}
