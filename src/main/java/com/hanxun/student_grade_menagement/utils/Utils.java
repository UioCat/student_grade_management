package com.hanxun.student_grade_menagement.utils;

import com.hanxun.student_grade_menagement.dao.CollegeDao;
import com.hanxun.student_grade_menagement.entity.Course;
import com.hanxun.student_grade_menagement.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author han xun
 * Date 2021/6/5 21:31
 * Description:
 */
@Component
public class Utils {

    @Autowired
    CollegeDao collegeDao;

    public List<CourseVO> CourseToCourseVO(List<Course> courseList) {
        List<CourseVO> res = new ArrayList<>(courseList.size());
        for (Course course : courseList) {
            String collegeName = collegeDao.queryCollegeBySerialCollege(course.getCollegeId()).getCollegeName();
            CourseVO courseVO = new CourseVO(course, collegeName);
            res.add(courseVO);
        }
        return res;
    }

    public List<CourseVO> CourseToCourseVO(List<Course> courseList, String collegeName) {
        List<CourseVO> res = new ArrayList<>(courseList.size());
        for (Course course : courseList) {
            CourseVO courseVO = new CourseVO(course, collegeName);
            res.add(courseVO);
        }
        return res;
    }
}
