package com.hanxun.student_grade_menagement.dto;

/**
 * @author han xun
 * Date 2021/6/5 12:57
 * Description:
 */
public class LoginDTO {
    private String account;
    private String password;
    private String type;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
