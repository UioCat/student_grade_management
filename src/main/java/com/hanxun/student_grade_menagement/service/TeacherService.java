package com.hanxun.student_grade_menagement.service;

import com.hanxun.student_grade_menagement.utils.BackMessage;

/**
 * @author han xun
 * Date 2021/6/5 15:01
 * Description:
 */
public interface TeacherService {

    /**
     * 教师选择课程
     * @param teacherId
     * @param courseSerialNumber
     * @return
     */
    BackMessage chooseCourseService(Long teacherId, String courseSerialNumber);

    /**
     * 根据教师id，查询选择的课程
     * @param teacherId
     * @return
     */
    BackMessage queryChoosedCourse(Long teacherId);

    /**
     * 教师取消选课
     * @param teacherId
     * @param serialNumber
     * @return
     */
    BackMessage cancelChooseCourse(Long teacherId, String serialNumber);

    /**
     * 查看可选课程list
     * @param teacherId
     * @return
     */
    BackMessage queryCourseList(Long teacherId);

    /**
     * 查询该课程下的学生列表
     * @param teacherId serialNumber
     * @return
     */
    BackMessage queryStudentList(Long teacherId, String serialNumber);

    /**
     * 给学生打分
     * @return
     */
    BackMessage markGrade(Long id, Double grade);
}
