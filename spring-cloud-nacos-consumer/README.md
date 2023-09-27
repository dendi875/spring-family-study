### PPT
第12章.pdf

### 视频
97丨使用Nacos作为服务注册中心.mp4

### 参考文档
* https://spring.io/projects/spring-cloud-alibaba
* https://spring-cloud-alibaba-group.github.io/github-pages/edgware/spring-cloud-alibaba.htm
* https://github.com/alibaba/nacos/
* https://hub.docker.com/r/nacos/nacos-server

### 演示

* 获取nacos镜像
```bash
docker pull nacos/nacos-server:0.9.0
```

* 运行 Nacos 容器
```bash
docker run --name nacos -d -p 8848:8848 -e MODE=standalone nacos/nacos-server:0.9.0
```

* 访问Nacos UI 界面，使用 Chrome 无痕模式打开，不然报用户密码错误
[Nacos UI](http://localhost:8848/nacos)

用户密码：nacos