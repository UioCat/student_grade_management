package com.hanxun.student_grade_menagement.dao;

import com.hanxun.student_grade_menagement.entity.Course;
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
public interface CourseDao {

    /**
     * 根据学院编号查询课程list
     * @param collegeId
     * @return
     */
    List<Course> queryCourseListByCollegeId(String collegeId);

    /**
     * 插入一条数据
     * @param course
     */
    void insertMsg(Course course);

    /**
     * 更新课程数据 By serialNumber
     * @param course
     */
    void updateCourseBySerialNumber(Course course);

    /**
     * 删除课程信息By serialNumber
     * @param serialNumber
     */
    void deleteCourseBySerialNumber(String serialNumber);

    /**
     * 根据serialNumber查询 课程信息
     * @param serialNumber
     * @return *
     */
    Course queryCourseBySerialNumber(String serialNumber);

    /**
     * 根据idlist 查询课程列表
     * @param idList
     * @return
     */
    List<Course> queryCourseListByIdList(List<Long> idList);

    /**
     * 查询课程的所有数据
     * @param id
     * @return
     */
    @Select("SELECT * FROM tb_course WHERE id=#{id}")
    Course queryAllById(Long id);

    /**
     * 根据学院编号删除课程（学院删除了）
     */
    @Delete("DELETE FROM tb_course WHERE college_id=#{collegeId}")
    void deleteCourseByCollegeId(String collegeId);

}
