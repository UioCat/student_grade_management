package com.hanxun.student_grade_menagement.entity;

/**
 * @author han xun
 * Date 2021/6/5 12:26
 * Description: 管理员基础信息
 */
public class Admin {

    private Integer id;
    private String account;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}
