## [使用nginx搭建中央web api文档描述服务器()]

[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

Http Web API文档描述服务集成配置、打包、服务化shell，nginx + swagge/ spring-boot/springmvc/embeded jetty

### nginx在整个服务中充当的几个角色

1. api文档统一UI入口
2. 服务提供方代理
3. 统一的跨域配置

### 工程打包部署方案
 
1. swagger-boot:swagger + spring-boot工程
2. swagger-spring:swagger + springmvc + 外部servlet容器
3. swagger-jetty:swagger + springmvc + 嵌入式servlet容器

## nginx配置

- 本地安装好nginx linux yum install nginx/mac brew install nginx
- swagger-ui从nginx/html/swagger拷贝到nginx www root目录
- swagger.conf拷贝到conf.d目录,注意nginx.con中需要include conf.d/*
- 启动nginx
- 输入http://localhost/swagger/index.html

>
    分别监听18888路由到8888服务,监听19999路由到9999服务,10000端口为swagger-ui入口


## swagger-boot

- 启动swagger-boot服务

1. mvn package 生成target/j360-swagger-boot.zip
2. unzip j360-swagger-boot.zip
3. spring-boot服务进行jar打包,启动脚本 bin/service.sh,端口号9999

>
    命令: service.sh start/status/stop/restart/console/

```
mvn package
cd target
service.sh start
```

- 录入
http://localhost:9999/v2/api-docs?group=api

## swagger-spring

serlvet3.0+springmvn零配置web服务

### 启动

1. mvn jetty:run 启动,端口号8888

>
    将war cp到tomcat或者jetty启动


>
    1. swagger-ui相关资料 -> https://github.com/swagger-api/swagger-ui
    2. spring-fox Java API 相关资料 -> https://github.com/springfox/springfox
    3. 其他语言web服务按照swagger规范生成对应的json地址即可


## swagger-jetty

springmvc + embeded jetty方式打包常规restful应用

1. mvn package 生成target/j360-swagger-boot.tar.gz
2. unzip j360-swagger-boot.tar.gz

>
    命令: service.sh start/status/stop/restart/console/

### 打包工具

1. 启动入口
2. 打包格式
3. 应用封装
4. 应用shell服务化