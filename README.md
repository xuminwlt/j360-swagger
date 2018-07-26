## 使用nginx搭建中央api文档描述服务器

>
    swagger-ui相关资料 -> https://github.com/swagger-api/swagger-ui
    
    
### nginx在整个服务中充当的几个角色

1. api文档统一UI入口
2. 服务提供方代理
3. 统一的跨域配置

## nginx配置

- 本地安装好nginx linux yum install nginx/mac brew install nginx
- swagger-ui从nginx/html/swagger拷贝到nginx www root目录
- swagger.conf拷贝到conf.d目录,注意nginx.con中需要include conf.d/*
- 启动nginx
- 输入http://localhost/swagger/index.html

## swagger-boot

- 启动swagger-boot服务

spring-boot服务进行jar打包,使用 service.sh start/status/stop/restart/console/

```
mvn package
cd target
service.sh start
```

- 录入
http://localhost:9999/v2/api-docs?group=api

## swagger-spring

- serlvet3.0零配置服务






