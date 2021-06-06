package com.hanxun.student_grade_menagement.service.impl;

import com.hanxun.student_grade_menagement.dao.*;
import com.hanxun.student_grade_menagement.entity.*;
import com.hanxun.student_grade_menagement.enums.BackEnum;
import com.hanxun.student_grade_menagement.exception.CustomException;
import com.hanxun.student_grade_menagement.service.StudentService;
import com.hanxun.student_grade_menagement.utils.BackMessage;
import com.hanxun.student_grade_menagement.vo.CourseGradeVO;
import com.hanxun.student_grade_menagement.vo.StudentQueryCourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author han xun
 * Date 2021/6/5 15:39
 * Description:
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private CourseTeacherDao courseTeacherDao;
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CourseGradeDao courseGradeDao;
    @Autowired
    private StudentDao studentDao;

    @Override
    public BackMessage studentChooseCourseService(Long studentId, Long courseTeacherId) {
        CourseGrade courseGradeForDB = new CourseGrade(studentId, courseTeacherId);
        CourseGrade courseGradeInDB = courseGradeDao.queryByStudentIdAndCourseTeacherId(courseGradeForDB);
        if(courseGradeInDB == null) {
            courseGradeDao.insertMsg(courseGradeForDB);
            return new BackMessage(BackEnum.REQUEST_SUCCESS);
        } else {
            throw new CustomException(BackEnum.REPETITION);
        }
    }

    @Override
    public BackMessage queryCourseList() {

        List<CourseTeacher> courseTeacherList = courseTeacherDao.queryCourseAll();

        List<StudentQueryCourseVO> res = new ArrayList<>(courseTeacherList.size());

        for (CourseTeacher courseTeacher : courseTeacherList) {
            Teacher teacherInDB = teacherDao.queryTeacherById(courseTeacher.getTeacherId());
            Course courseInDB = courseDao.queryAllById(courseTeacher.getCourseId());

            StudentQueryCourseVO studentQueryCourseVO = new StudentQueryCourseVO(
                    courseTeacher.getId(), courseInDB.getCourseName(), teacherInDB.getTeacherName(), courseInDB.getCredit()
            );
            res.add(studentQueryCourseVO);
        }
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS, res);
    }

    @Override
    public BackMessage queryCourseGrade(Long id) {
        List<CourseGrade> courseGradeList = courseGradeDao.queryListByStudentId(id);

        List<StudentQueryCourseVO> res = new ArrayList<>(courseGradeList.size());

        for (CourseGrade courseGrade : courseGradeList) {
            CourseTeacher courseTeacher = courseTeacherDao.queryCourseTeacherById(courseGrade.getCourseTeacherId());

            Teacher teacherInDB = teacherDao.queryTeacherById(courseTeacher.getTeacherId());
            Course courseInDB = courseDao.queryAllById(courseTeacher.getCourseId());

            StudentQueryCourseVO studentQueryCourseVO = new StudentQueryCourseVO(
                    courseTeacher.getId(), courseInDB.getCourseName(), teacherInDB.getTeacherName(),
                    courseInDB.getCredit(), courseGrade.getGrade()
            );
            res.add(studentQueryCourseVO);
        }
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS, res);
    }

    @Override
    public BackMessage queryMsgById(Long id) {
        Student student = studentDao.queryStudentById(id);
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS, student);
    }

    @Override
    public BackMessage retreatCourseService(Long studentId, Long courseTeacherId) {

        CourseGrade courseGrade = courseGradeDao.queryCourseTeacherById(courseTeacherId);
        if(courseGrade == null) {
            throw new CustomException(BackEnum.DATA_ERROR);
        }

        if(courseGrade.getGrade() != null) {
            throw new CustomException(BackEnum.ERROR_CANCEL);
        }

        courseGradeDao.deleteById(courseGrade.getId());
        return new BackMessage(BackEnum.REQUEST_SUCCESS);
    }

    @Override
    public BackMessage updatePassword(Long id, String oldPassword, String newPassword) {
        Student student = new Student();
        student.setId(id);
        student.setPassword(newPassword);
        studentDao.updatePasswordById(student);
        return new BackMessage(BackEnum.REQUEST_SUCCESS);
    }

    @Override
    public BackMessage queryChoosedList(Long studentId) {
        // todo
        List<CourseGrade> courseGradeList = courseGradeDao.queryListByStudentId(studentId);
        List<CourseGradeVO> courseGradeVOS = new ArrayList<>(courseGradeList.size());

        for (CourseGrade courseGrade : courseGradeList) {

            CourseTeacher courseTeacher = courseTeacherDao.queryCourseTeacherById(courseGrade.getCourseTeacherId());
            Course course = courseDao.queryAllById(courseTeacher.getCourseId());
            Teacher teacher = teacherDao.queryTeacherById(courseTeacher.getTeacherId());
            Student student = studentDao.queryStudentById(studentId);

            CourseGradeVO courseGradeVO = new CourseGradeVO(courseGrade.getId(), student.getStudentName(),
                    courseGrade.getGrade(),course.getCourseName(), teacher.getTeacherName());
            courseGradeVOS.add(courseGradeVO);
        }
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS, courseGradeVOS);
    }
}
