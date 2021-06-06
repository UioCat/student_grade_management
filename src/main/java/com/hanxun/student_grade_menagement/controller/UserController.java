package com.hanxun.student_grade_menagement.controller;

import com.hanxun.student_grade_menagement.service.UserService;
import com.hanxun.student_grade_menagement.utils.BackMessage;
import com.hanxun.student_grade_menagement.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author han xun
 * Date 2021/6/5 12:56
 * Description:
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 用户登陆接口
     * @param request
     * @param loginDTO account，password
     */
    @PostMapping("/login")
    public BackMessage userLogin(HttpServletRequest request, @RequestBody LoginDTO loginDTO) {
        return userService.userLoginService(loginDTO, request);
    }
}
