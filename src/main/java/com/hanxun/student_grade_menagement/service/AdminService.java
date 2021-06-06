package com.hanxun.student_grade_menagement.service;

import com.hanxun.student_grade_menagement.entity.College;
import com.hanxun.student_grade_menagement.entity.Course;
import com.hanxun.student_grade_menagement.entity.Major;
import com.hanxun.student_grade_menagement.utils.BackMessage;

/**
 * @author han xun
 * Date 2021/6/5 13:35
 * Description:
 */
public interface AdminService {

    /**
     * 新增一个学院
     * @param college
     * @return
     */
    BackMessage addCollegeService(College college);

    /**
     * 删除一个学院
     * @param serialcollege
     * @return
     */
    BackMessage deleteCollegeService(String serialcollege);

    /**
     * 查询所有学院
     * @return list<college>
     */
    BackMessage queryCollegeListService();

    /**
     * 修改学院信息
     * @param college by serialcollege
     */
    BackMessage updateCollegeService(College college);

    /**
     * 新增专业
     * @param major
     * @return
     */
    BackMessage addMajorService(Major major);

    /**
     * 删除一个专业
     * @param serialNumber
     * @return
     */
    BackMessage deleteMajorService(String serialNumber);

    /**
     * 查询学院下的专业列表
     * @param serialcollege
     * @return
     */
    BackMessage queryMajorListBySerialCollege(String serialcollege);

    /**
     * 更新专业数据
     */
    BackMessage updateMajor(Major major);

    /**
     * 新增课程信息
     * @param
     * @return
     */
    BackMessage insertCourse(Course course);

    /**
     * 根据学院查询课程
     * @param serialcollege
     * @return
     */
    BackMessage queryCourseList(String serialcollege);

    /**
     * 删除课程
     * @param serialNumber
     * @return
     */
    BackMessage deleteCourse(String serialNumber);

    /**
     * 更新课程
     * @param course
     * @return
     */
    BackMessage updateCourse(Course course);


}
