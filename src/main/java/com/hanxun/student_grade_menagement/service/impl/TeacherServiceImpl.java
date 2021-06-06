package com.hanxun.student_grade_menagement.service.impl;

import com.hanxun.student_grade_menagement.dao.*;
import com.hanxun.student_grade_menagement.entity.*;
import com.hanxun.student_grade_menagement.enums.BackEnum;
import com.hanxun.student_grade_menagement.exception.CustomException;
import com.hanxun.student_grade_menagement.service.TeacherService;
import com.hanxun.student_grade_menagement.utils.BackMessage;
import com.hanxun.student_grade_menagement.utils.Utils;
import com.hanxun.student_grade_menagement.vo.CourseGradeVO;
import com.hanxun.student_grade_menagement.vo.CourseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author han xun
 * Date 2021/6/5 15:04
 * Description:
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    CourseDao courseDao;
    @Autowired
    CourseTeacherDao courseTeacherDao;
    @Autowired
    CollegeDao collegeDao;
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    Utils utils;
    @Autowired
    CourseGradeDao courseGradeDao;
    @Autowired
    StudentDao studentDao;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public BackMessage chooseCourseService(Long teacherId, String courseSerialNumber) {
        Course course = courseDao.queryCourseBySerialNumber(courseSerialNumber);
        if(course == null) {
            logger.warn("chooseCourseService 根据课程编号查询课程数据为null");
            throw new CustomException(BackEnum.DATA_ERROR);
        }
        Long courseTeacherInDB = courseTeacherDao.queryCourseTeacherByIdAndCourseId(new CourseTeacher(teacherId, course.getId()));
        if(courseTeacherInDB != null) {
            logger.warn("chooseCourseService 教师重复选择课程");
            throw new CustomException(BackEnum.REPETITION_COURSE);
        }
        CourseTeacher courseTeacher = new CourseTeacher(teacherId, course.getId());
        courseTeacherDao.insertMsg(courseTeacher);
        return new BackMessage(BackEnum.REQUEST_SUCCESS);
    }

    @Override
    public BackMessage queryChoosedCourse(Long teacherId) {
        List<CourseTeacher> courseTeacherList = courseTeacherDao.queryCourseByTeacherId(teacherId);

        if(courseTeacherList == null || courseTeacherList.size() == 0) {
            return new BackMessage<>(BackEnum.REQUEST_SUCCESS, new ArrayList<>());
        }

        List<Long> courseIdList = courseTeacherList.stream().map(
                CourseTeacher::getCourseId).collect(Collectors.toList()
        );
        List<Course> courseList = courseDao.queryCourseListByIdList(courseIdList);

        List<CourseVO> courseVOList;
        courseVOList = utils.CourseToCourseVO(courseList);

        return new BackMessage<>(BackEnum.REQUEST_SUCCESS, courseVOList);
    }

    @Override
    public BackMessage cancelChooseCourse(Long teacherId, String serialNumber) {
        Course course = courseDao.queryCourseBySerialNumber(serialNumber);
        if(course == null) {

            throw new CustomException(BackEnum.DATA_ERROR);
        }
        Long courseId = course.getId();
        courseTeacherDao.deleteCourseTeacher(new CourseTeacher(teacherId, courseId));
        return new BackMessage(BackEnum.REQUEST_SUCCESS);
    }

    @Override
    public BackMessage queryCourseList(Long teacherId) {
        Teacher teacherInDB = teacherDao.queryTeacherById(teacherId);
        List<Course> list = courseDao.queryCourseListByCollegeId(teacherInDB.getCollegeId());
        // todo 进行保护，发现该教师的学院被删除，则进行提示

        String collegeName = collegeDao.queryCollegeBySerialCollege(teacherInDB.getCollegeId()).getCollegeName();
        List<CourseVO> courseVOList = utils.CourseToCourseVO(list, collegeName);
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS, courseVOList);
    }


    @Override
    public BackMessage queryStudentList(Long teacherId,  String serialNumber) {

        Course course = courseDao.queryCourseBySerialNumber(serialNumber);
        if(course == null) {
            logger.warn("queryStudentList course == null");
            throw new CustomException(BackEnum.DATA_ERROR);
        }
        Long id = courseTeacherDao.queryCourseTeacherByIdAndCourseId(new CourseTeacher(teacherId, course.getId()));
        List<CourseGrade> courseGradeList = courseGradeDao.queryByCourseTeacherId(id);

        List<CourseGradeVO> res = new ArrayList<>(courseGradeList.size());

        for (CourseGrade courseGrade : courseGradeList) {

            Student student = studentDao.queryStudentById(courseGrade.getStudentId());

            CourseGradeVO courseGradeVO = new CourseGradeVO(courseGrade.getId(), student.getStudentName(), courseGrade.getGrade());
            res.add(courseGradeVO);
        }

        return new BackMessage<>(BackEnum.REQUEST_SUCCESS, res);
    }

    @Override
    public BackMessage markGrade(Long id, Double grade) {
        if(id == null || grade == null) {
            logger.warn("markGrade 传入数据为null");
            throw new CustomException(BackEnum.DATA_ERROR);
        }
        CourseGrade courseGrade = new CourseGrade();
        courseGrade.setId(id);
        courseGrade.setGrade(grade);

        courseGradeDao.updateGrade(courseGrade);
        return new BackMessage(BackEnum.REQUEST_SUCCESS);
    }
}
