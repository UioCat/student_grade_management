# student_grade_management
为做数据库无聊作业跟前端小哥狂肝12小时写完的学生选课（成绩）管理系统
# 学生信息管理系统接口文档

[toc]

## 根路径

```
http://192.168.31.30:8080/student_management
```

## 登陆接口

URL, POST

```
/user/login
```

前端发送数据

```json
{
    "account":"99999",
    "password":"99999",
    "type":"admin"
}
```

> type：admin，teacher，student
>
> 教师账号：tec123456
> 教师密码：123456

后端返回数据

```json
{
    "code": 200,
    "message": "请求成功",
    "info": null
}
```

## 新增学院接口

URL, POST

```
/admin/add_college
```

前端发送数据

```json
{
    "serialCollege":"B00000",
    "collegeName":"播音学院",
    "dean":"院长小李"
}
```

后端返回数据

```json
{
    "code": 200,
    "message": "请求成功",
    "info": null
}
```



## 查询学院列表接口

URL, GET

```
/admin/get_college_list
```

前端发送数据

```json
无
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": [        {            "id": null,            "serialCollege": "A99999",            "collegeName": "媒体工程学院",            "dean": "院长小王",            "majorIdArray": null,            "courseIdArray": null        },        {            "id": null,            "serialCollege": "B00000",            "collegeName": "播音学院",            "dean": "院长小李",            "majorIdArray": null,            "courseIdArray": null        }    ]}
```



## 修改学院信息接口

URL, POST

```
/admin/update_college
```

前端发送数据

```json
{    "serialCollege":"B00000",    "collegeName":"播音学院3",    "dean":"院长小李3"}
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": null}
```

## 删除学院接口

URL, POST

```
/admin/delete_college
```

前端发送数据

```json
{    "serialCollege":"B00000"}
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": null}
```



## 新增一个专业接口

URL, POST

```
/admin/add_major
```

前端发送数据

```json
{    "serialNumber":"Major0000122",    "majorName":"电子竞技",    "majorClasses":"这是一个类别",    "collegeId":"A99999"}
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": null}
```



## 查询学院下的专业列表接口

URL, POST

```
/admin/query_major_list
```

前端发送数据

```json
{    "collegeId":"A99999"}
```

> collegeId即为学院编号

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": [        {            "serialNumber": "Major00001",            "majorName": "通讯",            "majorClasses": "这是一个类别",            "collegeName": "媒体工程学院"        },        {            "serialNumber": "Major0000122",            "majorName": "电子竞技",            "majorClasses": "这是一个类别",            "collegeName": "媒体工程学院"        }    ]}
```

## 修改专业信息接口

URL, POST

```
/admin/update_major
```

前端发送数据

```json
{    "serialNumber":"Major0000122",    "majorName":"这是一个测试专业",    "majorClasses":"这是一个测试专业类型"}
```

> majorName和majorClasses如只修改一个，另一个可以传null或者""

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": null}
```

## 删除专业接口

URL, POST

```
/admin/delete_major
```

前端发送数据

```json
{    "serialNumber":"Major0000122"}
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": null}
```

## 新增课程接口

URL, POST

```
/admin/add_course
```

前端发送数据

```json
{    "serialNumber":"COURSE00001",    "courseName":"测试课程名",    "credit":"5.5",     "collegeId":"A99999"}
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": null}
```

## 查询学院下的课程列表接口

URL, POST

```
/admin/query_course
```

前端发送数据

```json
{    "collegeId":"A99999"}
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": [        {            "id": null,            "serialNumber": "COURSE00001",            "courseName": "测试课程名",            "credit": 5.5,            "collegeId": "A99999"        }    ]}
```

## 更新课程信息接口

URL, POST

```
/admin/update_course
```

前端发送数据

```json
{    "serialNumber":"COURSE00001",    "courseName":"测试课程updtae",     "credit":"9"}
```

> 如只更新courseName或credit其中一个，可以另一个为null或""

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": null}
```

## 老师查看可选课程接口

URL, GET

```
/teacher/query_course_list
```

前端发送数据

```json
无
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": [        {            "serialNumber": "COURSE00001",            "courseName": "测试课程名",            "credit": 5.5,            "collegeName": "播音学院2"        },        {            "serialNumber": "COURSE2",            "courseName": "测试课程名2",            "credit": 5.5,            "collegeName": "播音学院2"        },        {            "serialNumber": "COURSE3",            "courseName": "测试课程名2",            "credit": 6.0,            "collegeName": "播音学院2"        }    ]}
```

## 教师选择课程接口

URL, POST

```
/teacher/choose_course
```

前端发送数据

```json
{    "serialNumber":"COURSE00001"}
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": null}
```

## 教师查看已选择的课程接口

URL, Get

```
/teacher/query_choosed
```

前端发送数据

```json
无
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": [        {            "serialNumber": "COURSE00001",            "courseName": "测试课程名",            "credit": 5.5,            "collegeName": "播音学院2"        }    ]}
```

## 教师取消已选择的课程接口

URL, POST

```
/teacher/cancel_course
```

前端发送数据

```json
{    "serialNumber": "COURSE00001"}
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": null}
```

## 学生查看课程-老师列表接口

URL, POST

```
/student/query_course_list
```

前端发送数据

```json
无
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": [        {            "id": 8,            "courseName": "测试课程名",            "teacherName": "小王老师",            "credit": 5.5,            "grade": null        }    ]}
```

## 学生选课接口

URL, GET

```
/student/course_choose
```

前端发送数据

```json
拼接在url后?courseTeacherId=xxxcourseTeacherId为学生查看课程-老师列表中数据的id
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": null}
```

## 教师查询该课程下的学生列表接口

URL, POST

```
/teacher/get_student_list
```

前端发送数据

```json
{    "serialNumber":"COURSE00001"}
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": [        {            "id": 2,            "studentName": "小明",            "grade": null        }    ]}
```

## 教师给学生打分接口 

URL, POST

```
/teacher/mark_grade
```

前端发送数据

```json
{    "id":"2",    "grade":99.5}
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": null}
```

## 学生查看已选课程接口

URL, GET

```
/student/query_choosed_list
```

前端发送数据

```json
无
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": [        {            "id": 2,            "studentName": "小红",            "grade": null,            "courseName": "123123",            "teacherName": "小王老师"        }    ]}
```

> 成绩为null表示教师还未打分，有数字则表示打分后的分数

## 学生取消选课接口

URL, GET

```
/student/retreat_course
```

前端发送数据

```json
?courseTeacherId=xxx该id为已选课程数据的idex:?courseTeacherId=2
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": null}
```

## 查看学生基础信息接口

URL, GET

```
/student/get_msg
```

前端发送数据

```json
无
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": {        "id": 2,        "studentNumber": "stu2222",        "studentName": "小红",        "sex": 1, # sex 1表示男 ，sex 0表示女        "birthYearMonth": "1999-02",        "familyAddress": "浙江杭州",        "majorId": 9,        "password": "12346",        "courseGradeIdArray": null # 忽略    }}
```

## 接口

URL, POST

```
/student/change_password
```

前端发送数据

```json
{    "oldPassword":"123456",    "newPassword":"111111"}
```

后端返回数据

```json
{    "code": 200,    "message": "请求成功",    "info": null}
```

## 
