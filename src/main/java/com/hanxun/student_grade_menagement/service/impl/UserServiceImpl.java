package com.hanxun.student_grade_menagement.service.impl;

import com.hanxun.student_grade_menagement.dao.AdminDao;
import com.hanxun.student_grade_menagement.dao.StudentDao;
import com.hanxun.student_grade_menagement.dao.TeacherDao;
import com.hanxun.student_grade_menagement.entity.Admin;
import com.hanxun.student_grade_menagement.entity.Student;
import com.hanxun.student_grade_menagement.entity.Teacher;
import com.hanxun.student_grade_menagement.enums.BackEnum;
import com.hanxun.student_grade_menagement.exception.CustomException;
import com.hanxun.student_grade_menagement.service.UserService;
import com.hanxun.student_grade_menagement.utils.BackMessage;
import com.hanxun.student_grade_menagement.utils.IData;
import com.hanxun.student_grade_menagement.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author han xun
 * Date 2021/6/5 13:01
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private AdminDao adminDao;


    @Override
    public BackMessage userLoginService(LoginDTO loginDTO, HttpServletRequest request) {
        if(loginDTO.getType() == null) {
            throw new CustomException(BackEnum.DATA_ERROR);
        }

        if(IData.adminType.equals(loginDTO.getType())) {
            Admin adminInDB = adminDao.queryAdminByAccount(loginDTO.getAccount());
            if(adminInDB == null) {
                // 用户不存在
                return new BackMessage(BackEnum.NO_USER);
            }
            if(adminInDB.getPassword().equals(loginDTO.getPassword())) {
                // 密码一致
                request.getSession().setAttribute("id", adminInDB.getId() + "," + IData.adminType);
                return new BackMessage(BackEnum.REQUEST_SUCCESS);
            }
            return new BackMessage(BackEnum.PWD_ERROR);
        } else if(IData.teaType.equals(loginDTO.getType())) {
            Teacher teacherInDB = teacherDao.queryTeacherByAccount(loginDTO.getAccount());
            if(teacherInDB == null) {
                // 用户不存在
                return new BackMessage(BackEnum.NO_USER);
            }
            if(teacherInDB.getPassword().equals(loginDTO.getPassword())) {
                request.getSession().setAttribute("id", teacherInDB.getId() + "," + IData.teaType);
                return new BackMessage(BackEnum.REQUEST_SUCCESS);
            }
            return new BackMessage(BackEnum.PWD_ERROR);
        } else if(IData.stuType.equals(loginDTO.getType())){
            Student studentInDB = studentDao.queryStudentByStudentNumber(loginDTO.getAccount());
            if(studentInDB == null) {
                // 用户不存在
                return new BackMessage(BackEnum.NO_USER);
            }
            if(studentInDB.getPassword().equals(loginDTO.getPassword())) {
                request.getSession().setAttribute("id", studentInDB.getId() + "," + IData.stuType);
                return new BackMessage(BackEnum.REQUEST_SUCCESS);
            }
            return new BackMessage(BackEnum.PWD_ERROR);
        } else {
            throw new CustomException(BackEnum.DATA_ERROR);
        }
    }
}
