package com.hanxun.student_grade_menagement.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hanxun.student_grade_menagement.dao.*;
import com.hanxun.student_grade_menagement.entity.College;
import com.hanxun.student_grade_menagement.entity.Course;
import com.hanxun.student_grade_menagement.entity.CourseGrade;
import com.hanxun.student_grade_menagement.entity.Major;
import com.hanxun.student_grade_menagement.enums.BackEnum;
import com.hanxun.student_grade_menagement.exception.CustomException;
import com.hanxun.student_grade_menagement.service.AdminService;
import com.hanxun.student_grade_menagement.utils.BackMessage;
import com.hanxun.student_grade_menagement.vo.MajorVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @author han xun
 * Date 2021/6/5 13:37
 * Description:
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private CollegeDao collegeDao;
    @Autowired
    private MajorDao majorDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CourseTeacherDao courseTeacherDao;
    @Autowired
    private CourseGradeDao courseGradeDao;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public BackMessage addCollegeService(College college) {
        logger.info(JSONObject.toJSONString(college));
        College collegeInDB = collegeDao.queryCollegeBySerialCollege(college.getSerialCollege());
        if(collegeInDB != null) {
            throw new CustomException(BackEnum.REPETITION);
        }
        if(college.getSerialCollege() == null || college.getSerialCollege().equals("") ||
            college.getCollegeName() == null || college.getCollegeName().equals("") ||
            college.getDean() == null || college.getDean().equals("")) {
            logger.warn("新增学院数据的时 传入数据错误");
            throw new CustomException(BackEnum.DATA_ERROR);
        }
        collegeDao.insertCollege(college);
        return new BackMessage(BackEnum.REQUEST_SUCCESS);
    }

    @Override
    public BackMessage deleteCollegeService(String serialCollege) {

        collegeDao.deleteCollege(serialCollege);
        courseDao.deleteCourseByCollegeId(serialCollege); //删除对应的课程
        majorDao.deleteByCollegeId(serialCollege); //删除对应的专业
        return new BackMessage(BackEnum.REQUEST_SUCCESS);
    }

    @Override
    public BackMessage queryCollegeListService() {
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS, collegeDao.queryCollegeList());
    }

    @Override
    public BackMessage updateCollegeService(College college) {
        collegeDao.updateCollege(college);
        return new BackMessage(BackEnum.REQUEST_SUCCESS);
    }

    @Override
    public BackMessage addMajorService(Major major) {

        Major majorInDB = majorDao.queryAllBySerialNumber(major.getSerialNumber());
        if(majorInDB != null) {
            // 查重
            return new BackMessage(BackEnum.REPETITION);
        }
        majorDao.insertMsg(major);
        majorInDB = majorDao.queryAllBySerialNumber(major.getSerialNumber());

        College collegeInDB = collegeDao.queryCollegeBySerialCollege(major.getCollegeId()); //查询学院信息

        if(collegeInDB == null) {
            logger.warn("新增专业时传入的学院编号对应的学院不存在");
            throw new CustomException(BackEnum.DATA_ERROR);
        }

        College collegeForDB = new College();
        collegeForDB.setSerialCollege(collegeInDB.getSerialCollege());
        collegeForDB.setMajorIdArray(assemblyString(collegeInDB.getMajorIdArray(), majorInDB.getId()));
        collegeDao.updateCollege(collegeForDB);
        // 更新学院的专业数据

        return new BackMessage(BackEnum.REQUEST_SUCCESS);
    }

    @Override
    public BackMessage deleteMajorService(String serialNumber) {
        Major majorInDB = majorDao.queryAllBySerialNumber(serialNumber);
        majorDao.deleteMsgBySerialNumber(serialNumber);

        College collegeInDB = collegeDao.queryCollegeBySerialCollege(majorInDB.getCollegeId());
        String newMajorIdArray = deleteString(collegeInDB.getMajorIdArray(),majorInDB.getId());

        College collegeForDB = new College();
        collegeForDB.setSerialCollege(collegeInDB.getSerialCollege());
        collegeForDB.setMajorIdArray(newMajorIdArray);
        collegeDao.updateCollege(collegeForDB);

        return new BackMessage(BackEnum.REQUEST_SUCCESS);
    }

    @Override
    public BackMessage queryMajorListBySerialCollege(String serialcollege) {
        List<Major> majorList = majorDao.queryListByCollegeId(serialcollege);
        List<MajorVO> res = new ArrayList<>(majorList.size());
        try {
            for (Major major : majorList) {
                College college = collegeDao.queryCollegeBySerialCollege(serialcollege);
                MajorVO majorVO = new MajorVO(major, college.getCollegeName());
                res.add(majorVO);
            }

            return new BackMessage<>(BackEnum.REQUEST_SUCCESS, res);
        } catch (NullPointerException e) {
            logger.warn("查询专业列表时，传入的serialcollege错误");
            throw new CustomException(BackEnum.DATA_ERROR);
        }
    }

    @Override
    public BackMessage updateMajor(Major major) {
        majorDao.updateMsgBySerialNumber(major);
        return new BackMessage(BackEnum.REQUEST_SUCCESS);
    }

    @Override
    public BackMessage insertCourse(Course course) {
        Course findingCourse = courseDao.queryCourseBySerialNumber(course.getSerialNumber());
        if(findingCourse != null) {
            logger.warn("insertCourse 学院数据重复");
            return new BackMessage(BackEnum.REPETITION);
        }
        College collegeInDB = collegeDao.queryCollegeBySerialCollege(course.getCollegeId());
        if(collegeInDB == null) {
            logger.warn("insertCourse 传入学院编号错误");
            return new BackMessage(BackEnum.DATA_ERROR);
        }
        courseDao.insertMsg(course);
        Course courseInDB = courseDao.queryCourseBySerialNumber(course.getSerialNumber());

        String newArray = this.assemblyString(collegeInDB.getCourseIdArray(),courseInDB.getId());
        College collegeForDB = new College();
        collegeForDB.setSerialCollege(course.getCollegeId());
        collegeForDB.setCourseIdArray(newArray);
        collegeDao.updateCollege(collegeForDB);

        return new BackMessage(BackEnum.REQUEST_SUCCESS);
    }

    @Override
    public BackMessage queryCourseList(String collegeId) {
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS, courseDao.queryCourseListByCollegeId(collegeId));
    }

    @Override
    public BackMessage deleteCourse(String serialNumber) {
        Course courseInDB = courseDao.queryCourseBySerialNumber(serialNumber);
        courseDao.deleteCourseBySerialNumber(serialNumber); //删除数据

        College collegeInDB = collegeDao.queryCollegeBySerialCollege(courseInDB.getCollegeId());
        String newArray = deleteString(collegeInDB.getCourseIdArray(), courseInDB.getId());

        College collegeForDB = new College();
        collegeForDB.setSerialCollege(collegeInDB.getSerialCollege());
        collegeForDB.setCourseIdArray(newArray);
        collegeDao.updateCollege(collegeForDB);

        // todo 删除教师选课以及学生选课信息，或者进行保护
        return new BackMessage(BackEnum.REQUEST_SUCCESS);
    }

    @Override
    public BackMessage updateCourse(Course course) {
        courseDao.updateCourseBySerialNumber(course);
        return new BackMessage(BackEnum.REQUEST_SUCCESS);
    }



    /**
     * 组装数据
     * @param array
     * @param id
     * @return
     */
    private String assemblyString(String array, Long id) {
        if(array == null || array.equals("") || array.isEmpty()) {
            return id.toString();
        } else {
            return array + "," + id.toString();
        }
    }

    /**
     * 删除其中的id数据
     * @param array
     * @param id
     * @return
     */
    private String deleteString(String array, Long id) {
        if(array == null || array.equals("") || array.isEmpty()) {
            throw new CustomException(BackEnum.DATA_ERROR);
        }
        String[] idArray = array.split(",");
        StringBuilder stringBuilder = new StringBuilder();
        for (String item : idArray) {
            if(item.equals(id.toString())) {
                continue;
            } else {
                if(!stringBuilder.toString().equals("") && !stringBuilder.toString().isEmpty()) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(item);
            }
        }
        return stringBuilder.toString();
    }
}
