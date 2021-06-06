package com.hanxun.student_grade_menagement.dao;

import com.hanxun.student_grade_menagement.entity.College;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author han xun
 * Date 2021/6/5 12:54
 * Description:
 */
@Mapper
@Component
public interface CollegeDao {

    /**
     * 新增一个学院
     * @param college
     */
    void insertCollege(College college);

    /**
     * 删除一个学院by serialcollege
     * @param serialcollege
     */
    void deleteCollege(String serialcollege);

    /**
     * 更新学院数据 by serialcollege
     * @param college
     */
    void updateCollege(College college);

    /**
     * 查询学院列表
     * @return
     */
    List<College> queryCollegeList();

    /**
     * 根据编号查询学院
     * @return
     */
    College queryCollegeBySerialCollege(String serialcollege);
}
