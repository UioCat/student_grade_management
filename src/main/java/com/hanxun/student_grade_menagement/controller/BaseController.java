package com.hanxun.student_grade_menagement.controller;

import com.hanxun.student_grade_menagement.dto.UserBaseMessageDTO;
import com.hanxun.student_grade_menagement.enums.BackEnum;
import com.hanxun.student_grade_menagement.exception.CustomException;

import javax.servlet.http.HttpSession;

/**
 * @author han xun
 * Date 2021/6/5 13:02
 * Description: 基础控制器
 */
public class BaseController {

    /**
     * 获得用户基础信息
     * @param httpSession session
     * @return id, type
     */
    protected UserBaseMessageDTO getUserBaseMessage(HttpSession httpSession) {
        try {
            String[] strings = httpSession.getAttribute("id").toString().split(",");
            Long id = Long.parseLong(strings[0]);
            String type = strings[1];
            return new UserBaseMessageDTO(id, type);
        }catch (NullPointerException e) {
            e.printStackTrace();
            throw new CustomException(BackEnum.UNAUTHORIZED);
        }
    }
}
