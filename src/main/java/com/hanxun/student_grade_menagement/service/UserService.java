package com.hanxun.student_grade_menagement.service;

import com.hanxun.student_grade_menagement.utils.BackMessage;
import com.hanxun.student_grade_menagement.dto.LoginDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface UserService {

    /**
     * 用户登陆
     * @param loginDTO
     * @return
     */
    BackMessage userLoginService(LoginDTO loginDTO, HttpServletRequest request);

}
