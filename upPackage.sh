# 打包上传脚本
mvn clean install -Dmaven.test.skip=true
mv ./target/student_grade_menagement-1.0.0.war ./target/student_grade_management.war
scp ./target/student_grade_management.war root@116.62.4.111:/usr/java/apache-tomcat-9.0.33/webapps