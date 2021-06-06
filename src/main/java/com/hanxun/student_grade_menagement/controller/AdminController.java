package com.hanxun.student_grade_menagement.controller;

import com.hanxun.student_grade_menagement.dto.UserBaseMessageDTO;
import com.hanxun.student_grade_menagement.entity.College;
import com.hanxun.student_grade_menagement.entity.Course;
import com.hanxun.student_grade_menagement.entity.Major;
import com.hanxun.student_grade_menagement.enums.BackEnum;
import com.hanxun.student_grade_menagement.exception.CustomException;
import com.hanxun.student_grade_menagement.service.AdminService;
import com.hanxun.student_grade_menagement.utils.BackMessage;
import com.hanxun.student_grade_menagement.utils.IData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author han xun
 * Date 2021/6/5 12:53
 * Description: 管理员控制器
 */
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController{

    @Autowired
    private AdminService adminService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 新增一个学院
     * @param college  serialcollege,collegeName,dean
     * @return
     */
    @PostMapping("/add_college")
    public BackMessage addCollege(HttpSession httpSession, @RequestBody College college) {
        this.authentication(httpSession);
        return adminService.addCollegeService(college);
    }

    /**
     * 删除一个学院
     * @param httpSession
     * @param college serialcollege
     * @return
     */
    @PostMapping("/delete_college")
    public BackMessage deletecollege(HttpSession httpSession, @RequestBody College college) {
        this.authentication(httpSession);
        if(college.getSerialCollege() == null) {
            throw new CustomException(BackEnum.DATA_ERROR);
        }
        return adminService.deleteCollegeService(college.getSerialCollege());
    }

    @GetMapping("/get_college_list")
    public BackMessage getcollegeList(HttpSession httpSession) {
        this.authentication(httpSession);
        return adminService.queryCollegeListService();
    }

    /**
     * 修改学院信息
     * @param httpSession
     * @param college collegeName，dean， by serialcollege
     * @return
     */
    @PostMapping("/update_college")
    public BackMessage updatecollege(HttpSession httpSession, @RequestBody College college) {
        this.authentication(httpSession);
        if(college.getSerialCollege() == null) {
            throw new CustomException(BackEnum.DATA_ERROR);
        }
        return adminService.updateCollegeService(college);
    }

    /**
     * 新增一个专业
     * @param httpSession
     * @param major serialNumber, majorName, majorClasses, collegeId（学院编号）
     * @return
     */
    @PostMapping("/add_major")
    public BackMessage addMajor(HttpSession httpSession, @RequestBody Major major) {
        this.authentication(httpSession);
        return adminService.addMajorService(major);
    }

    /**
     * 查询专业列表 By 学院 编号
     * @param httpSession
     * @param major collegeId
     * @return
     */
    @PostMapping("/query_major_list")
    public BackMessage queryMajorList(HttpSession httpSession, @RequestBody Major major) {
        this.authentication(httpSession);
        return adminService.queryMajorListBySerialCollege(major.getCollegeId());
    }

    /**
     * 修改专业信息
     * @param httpSession
     * @param major
     * @return
     */
    @PostMapping("/update_major")
    public BackMessage updateMajor(HttpSession httpSession, @RequestBody Major major) {
        this.authentication(httpSession);
        if(major.getSerialNumber() == null) {
            throw new CustomException(BackEnum.DATA_ERROR);
        }
        if(major.getMajorName().equals("") || major.getMajorName().isEmpty()) {
            major.setMajorName(null);
        }
        if(major.getMajorClasses().equals("") || major.getMajorClasses().isEmpty()) {
            major.setMajorClasses(null);
        }
        return adminService.updateMajor(major);
    }

    /**
     * 根据专业编号修改专业信息
     * @param httpSession
     * @param major
     * @return
     */
    @PostMapping("/delete_major")
    public BackMessage deleteMajor(HttpSession httpSession, @RequestBody Major major) {
        this.authentication(httpSession);
        if(major.getSerialNumber() == null) {
            logger.warn("管理员请求删除专业时，serialNumber数据为空");
            throw new CustomException(BackEnum.DATA_ERROR);
        }
        return adminService.deleteMajorService(major.getSerialNumber());
    }

    /**
     * 添加课程
     * @param httpSession
     * @param course serialNumber, courseName, credit, collegeId
     * @return
     */
    @PostMapping("/add_course")
    public BackMessage addCourse(HttpSession httpSession, @RequestBody Course course) {
        this.authentication(httpSession);
        return adminService.insertCourse(course);
    }

    /**
     * 查看学院下的课程列表
     * @param course  collegeId
     */
    @PostMapping("/query_course")
    public BackMessage queryCourse(HttpSession httpSession, @RequestBody Course course) {
        this.authentication(httpSession);
        if(course.getCollegeId() == null) {
            logger.warn("queryCourse: 查看学院下的课程列表时没有传入collegeId数据");
            throw new CustomException(BackEnum.DATA_ERROR);
        }
        return adminService.queryCourseList(course.getCollegeId());
    }

    /**
     * 更新课程数据
     * @param httpSession
         * @param course serialNumber, courseName, credit
     * @return
     */
    @PostMapping("/update_course")
    public BackMessage updateCourse(HttpSession httpSession, @RequestBody Course course) {
        this.authentication(httpSession);
        return adminService.updateCourse(course);
    }

    /**
     * 删除课程信息
     * @param httpSession
     * @param course serialNumber
     * @return
     */
    @PostMapping("/delete_course")
    public BackMessage deleteCourse(HttpSession httpSession, @RequestBody Course course) {
        this.authentication(httpSession);
        if(course.getSerialNumber() == null) {
            logger.warn("删除课程时，没有传入serialNumber");
            return new BackMessage(BackEnum.DATA_ERROR);
        }
        return adminService.deleteCourse(course.getSerialNumber());
    }

    /**
     * 鉴权
     * @param httpSession
     */
    private void authentication(HttpSession httpSession) {
        UserBaseMessageDTO userBaseMessageDTO = super.getUserBaseMessage(httpSession);
        // todo 可以改成aop
        if(!userBaseMessageDTO.getType().equals(IData.adminType)) {
            throw new CustomException(BackEnum.UNAUTHORIZED);
        }
    }
}
