package com.hanxun.student_grade_menagement.dto;

/**
 * @author han xun
 * Date 2021/6/5 13:03
 * Description:
 */
public class UserBaseMessageDTO {

    private Long id;
    private String type;

    public UserBaseMessageDTO() {
    }

    public UserBaseMessageDTO(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
