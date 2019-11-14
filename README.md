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
3.[thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)

4.[Spring boot](https://docs.spring.io/spring-boot/docs/2.2.0.RC1/reference/htmlsingle/)

5.[spring-web](https://docs.spring.io/spring/docs/5.0.3.RELEASE/spring-framework-reference/web.html#spring-web)

6.[flyway, 数据库版本管理工具,要运行 mvn 指令需以管理员方式打开IDEA](https://flywaydb.org/getstarted/firststeps/maven)

7.[Lombok,简化getter，setter等方法](https://projectlombok.org/)

8.[MyBatis,数据库的增删改查](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/index.html)

9.[MyBatis Generator](https://mybatis.org/generator)

10. PostMan

11.[jQuery](https://api.jquery.com)

## 功能实现
#### 连接到 mysql 数据库
在application.properties文件中添加
```
spring.datasource.url=jdbc:mysql://localhost:3306/community?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&serverTimezone=Asia/Shanghai
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
#### flyway的依赖信息
```
<plugin>
	<groupId>org.flywaydb</groupId>
	<artifactId>flyway-maven-plugin</artifactId>
	<version>5.2.4</version>
    <configuration>
		<url>jdbc:mysql://localhost:3306/community?serverTimezone=Asia/Shanghai</url>
		<user>root</user>
		<password>root</password>
	</configuration>
</plugin>
```
配置信息, 添加在 application.properties 文件中
```
#flyway
#打开flyway
flyway.enabled=true
flyway.encoding=utf-8
#sql文件存放位置
flyway.locations=classpath:db/migration
#版本记录表格
flyway.table=schemas_version
flyway.baseline-on-migrate=true
flyway.validate-on-migrate=false
```
#### MyBatis Generator
```
<plugin>
          <groupId>org.mybatis.generator</groupId>
          <artifactId>mybatis-generator-maven-plugin</artifactId>
          <version>1.3.7</version>
        </plugin>
然后在终端运行以下命令：
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```
#### 自动部署
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```
在setting里compiler，勾选 build project automatically，然后按 Crtl + shift + alt + ？ 选择registry，勾选compiler.automake.allow.when.app.running

在chrome中安装LiveReload插件，可免除手动刷新的步骤
## 包的作用
Controller: 处理页面的跳转等任务

DTO：传输层

interceptor: 拦截器，通过token判断登陆信息

mapper：对数据表中的数据进行增删改查操作

model：与数据表对应的类

provider：

resources.db.migration: flyway的sql文件，对数据库进行操作

resources.templates：存储html文件

## 一些说明

