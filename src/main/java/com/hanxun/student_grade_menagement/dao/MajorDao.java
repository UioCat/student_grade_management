package com.hanxun.student_grade_menagement.dao;

import com.hanxun.student_grade_menagement.entity.Major;
import org.apache.ibatis.annotations.Delete;
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
public interface MajorDao {

    /**
     * 根据编号查询专业信息
     * @param serialNumber
     * @return
     */
    Major queryAllBySerialNumber(String serialNumber);

    /**
     * 插入专业
     * @param major
     */
    void insertMsg(Major major);

    /**
     * 删除专业By serialNumber
     */
    void deleteMsgBySerialNumber(String serialNumber);

    /**
     * 更新学院数据
     * @param major
     */
    void updateMsgBySerialNumber(Major major);

    /**
     * 根据学院id查询专业list
     */
    List<Major> queryListByCollegeId(String collegeId);

    @Delete("DELETE FROM tb_major WHERE college_id=#{collegeId}")
    void deleteByCollegeId(String collegeId);

}
