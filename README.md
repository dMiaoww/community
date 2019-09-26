# Miaomiao Community
A Community Demo

## 工具  
1.[前端页面：boot strap](https://v3.bootcss.com/components/#navbar)

2.[调用 GitHub 的账号登陆论坛](https://developer.github.com/apps/building-oauth-apps/)

3.[OkHttp](https://square.github.io/okhttp/)  
```
<!--通过maven添加依赖,3.3.0为版本号-->
<dependency>
  <groupId>com.squareup.okhttp3</groupId>
  <artifactId>okhttp</artifactId>
  <version>3.3.0</version>
</dependency>
```
3.[thymeleaf](https://www.jianshu.com/p/5bbac20348ec)
4.[Spring boot](https://spring.io/guides/gs/spring-boot/)

## 功能实现
#### 连接到 mysql 数据库
在application.properties文件中添加
```
spring.datasource.url=jdbc:mysql://localhost:3306/community?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&serverTimezone=GMT
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
