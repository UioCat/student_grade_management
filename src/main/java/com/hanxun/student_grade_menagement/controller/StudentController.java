package com.hanxun.student_grade_menagement.controller;

import com.hanxun.student_grade_menagement.dto.ChangePasswordDTO;
import com.hanxun.student_grade_menagement.service.StudentService;
import com.hanxun.student_grade_menagement.utils.BackMessage;
import com.hanxun.student_grade_menagement.dto.UserBaseMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author han xun
 * Date 2021/6/5 12:52
 * Description: 学生信息控制器
 */
@RestController
@RequestMapping("/student")
public class StudentController extends BaseController {

    @Autowired
    private StudentService studentService;

    /**
     * 查询课程-老师 列表
     * @return
     */
    @GetMapping("/query_course_list")
    public BackMessage queryCourseTeacherList(HttpSession httpSession) {
        authenticationAndGetId(httpSession);
        return studentService.queryCourseList();
    }

    /**
     * 学生选择课程
     * @return
     */
    @GetMapping("/course_choose")
    public BackMessage chooseCourse(HttpSession httpSession, @RequestParam("courseTeacherId") Long id) {
        Long studentId = authenticationAndGetId(httpSession);
        return studentService.studentChooseCourseService(studentId, id);
    }

    /**
     * 查看已选课程
     * @param httpSession
     * @return
     */
    @GetMapping("/query_choosed_list")
    public BackMessage queryChoosedList(HttpSession httpSession) {
        Long studentId = authenticationAndGetId(httpSession);
        return studentService.queryChoosedList(studentId);
    }

    /**
     * 取消选课
     * @return
     */
    @GetMapping("/retreat_course")
    public BackMessage retreatCourse(HttpSession httpSession, @RequestParam("courseTeacherId") Long id) {
        Long studentId = authenticationAndGetId(httpSession);
        return studentService.retreatCourseService(studentId, id);
    }

    @GetMapping("/get_msg")
    public BackMessage getStudentMsg(HttpSession httpSession) {
        Long studentId = authenticationAndGetId(httpSession);
        return studentService.queryMsgById(studentId);
    }

    @PostMapping("/change_password")
    public BackMessage changePassword(HttpSession httpSession, @RequestBody ChangePasswordDTO changePasswordDTO) {
        Long studentId = authenticationAndGetId(httpSession);
        return studentService.updatePassword(studentId, changePasswordDTO.getOldPassword(), changePasswordDTO.getNewPassword());
    }

    private Long authenticationAndGetId(HttpSession httpSession) {
        UserBaseMessageDTO userBaseMessageDTO = super.getUserBaseMessage(httpSession);
        return userBaseMessageDTO.getId();
    }
}
