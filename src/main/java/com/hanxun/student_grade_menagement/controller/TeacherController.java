package com.hanxun.student_grade_menagement.controller;

import com.hanxun.student_grade_menagement.dto.UserBaseMessageDTO;
import com.hanxun.student_grade_menagement.entity.Course;
import com.hanxun.student_grade_menagement.entity.CourseGrade;
import com.hanxun.student_grade_menagement.service.TeacherService;
import com.hanxun.student_grade_menagement.utils.BackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author han xun
 * Date 2021/6/5 12:53
 * Description: 教师信息控制器
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController extends BaseController {

    @Autowired
    TeacherService teacherService;

    /**
     * 教师选择要教的课
     * @param course serialNumber
     * @return
     */
    @PostMapping("/choose_course")
    public BackMessage chooseCourse(HttpSession httpSession, @RequestBody Course course) {
        Long id = authenticationAndGetId(httpSession);
        return teacherService.chooseCourseService(id, course.getSerialNumber());
    }

    /**
     * 老师查询自己已经选择的课程
     * @param httpSession
     * @return
     */
    @GetMapping("/query_choosed")
    public BackMessage queryChoosedCourseList(HttpSession httpSession) {
        Long id = authenticationAndGetId(httpSession);
        return teacherService.queryChoosedCourse(id);
    }

    /**
     * 老师取消自己选的课
     * @param httpSession serialNumber
     * @return
     */
    @PostMapping("/cancel_course")
    public BackMessage cancelCourse(HttpSession httpSession, @RequestBody Course course) {
        Long id = authenticationAndGetId(httpSession);
        return teacherService.cancelChooseCourse(id, course.getSerialNumber());
    }

    /**
     * 查询可选的课
     * @param httpSession
     * @return
     */
    @GetMapping("/query_course_list")
    public BackMessage queryCourseList(HttpSession httpSession) {
        Long id = authenticationAndGetId(httpSession);
        return teacherService.queryCourseList(id);
    }

    /**
     * 查询课程对应的学生列表
     * @param httpSession
     * @param course serialNumber
     * @return
     */
    @PostMapping("/get_student_list")
    public BackMessage getStudentList(HttpSession httpSession, @RequestBody Course course) {
        Long id = authenticationAndGetId(httpSession);
        return teacherService.queryStudentList(id, course.getSerialNumber());
    }

    /**
     * 给学生进行打分
     * @param httpSession
     * @param courseGrade id, grade
     * @return
     */
    @PostMapping("/mark_grade")
    public BackMessage markGrade(HttpSession httpSession, @RequestBody CourseGrade courseGrade) {
        Long id = authenticationAndGetId(httpSession);
        return teacherService.markGrade(courseGrade.getId(), courseGrade.getGrade());
    }

    public Long authenticationAndGetId(HttpSession httpSession) {
        UserBaseMessageDTO userBaseMessageDTO = super.getUserBaseMessage(httpSession);
        return userBaseMessageDTO.getId();
//        return 1L;
    }
}
