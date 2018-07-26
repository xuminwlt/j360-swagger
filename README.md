使用nginx搭建中央api文档描述服务器

nginx在整个服务中充当的几个角色

1. api文档统一UI入口
2. 服务提供方代理
3. 统一的跨域配置

## nginx配置

- swagger-ui从nginx/html/swagger拷贝到nginx root地址
- swagger.conf拷贝到conf.d目录
- 启动nginx
- 输入localhost/swagger/index.html

## swagger-boot

- 启动swagger-boot服务
```
mvn package
cd target
service.sh start
```

- 录入
http://localhost:9999/v2/api-docs?group=api

## swagger-spring






