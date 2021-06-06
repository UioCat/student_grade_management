package com.hanxun.student_grade_menagement.dto;

/**
 * @author han xun
 * Date 2021/6/5 16:16
 * Description:
 */
public class ChangePasswordDTO {
    private String oldPassword;
    private String newPassword;

    public ChangePasswordDTO() {
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
