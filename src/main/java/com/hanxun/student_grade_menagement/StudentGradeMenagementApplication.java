package com.hanxun.student_grade_menagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hanxun.student_grade_menagement.dao")
public class StudentGradeMenagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentGradeMenagementApplication.class, args);
    }

}
