------------------------------springBoot
1.springBoot项目创建方式：
    官网引导；idea的spring init引导创建
    starter启动器概念：本质即pom文件，里面包含了某个服务依赖的jar。
        比如：spring-boot-starter-web
              spring-boot-starter-tomcat
              spring-boot-starter-log4j
              ...
              mytais-springboot-starter

2.不推荐使用jsp，推荐使用模板技术来实现前端动态数据。

3.运行方法：
    运行main方法；
    打jar包，然后java -jar jar包名称。。    前提：必须有main方法。
    打war包，部署到独立的tomcat服务器下。

4.机制：
    SpringApplication类作用：
        启动内嵌tomcat，初始化banner，listener，初始化ApplicationContext容器对象，判断当前classpath下有DispatcherServlet类的话，说明这个是一个springMVC的web项目

    @SpringBootApplication注解作用：扫描特定包下的类作为bean对象，同时根据当前系统环境自定配置内置的bean对象
        @SpringBootConfiguration--@Configuration等价于applicationContext.xml文件,javaConfig形式的ioc配置
        @ComponentScan--等价于<context:componentScan basePackage="">，当前注解basePackage默认没指定，默认是当前类所在包开始扫描
        @EnableAutoConfiguration-->springboot自动配置的注解。
            @AutoConfigurationPackage-->自动配置包，是从@SpintBootApplication注解所在类的包开始扫描。
            @Import(AutoConfigurationImportSelector.class)-->加载META-INF/spring.factories文件，做自动配置

5.thymeleaf：
    引入thymeleaf环境：xmlns:th="http://www.thymeleaf.org"
    常用属性：
        th:href="@{}"
        th:src="@{}"
        th:action="@{}"
        th:text="${}"
        th:utext="${}"
        th:insert="页面名"   th:insert="~{页面名  ::  片段名}"
        th:repalce="页面名"   th:insert="~{页面名  ::  片段名}"
        th:each
        th:if
        th:object,一般与选择表达式一起使用
    常用表达式：
        属性表达式：${}
        链接表达式：@{}
        文档表达式：~{}
        选择表达式：*{}   结合th:object使用

    thymeleaf常用工具对象：
        session
        request
        servletContext
        dates    createNow()   format()
        numbers   保留小数点
        strings










