### PPT
第10章.pdf

### 视频
84丨如何将 Spring Boot 应用打包成 Docker 镜像文件.mp4

### 参考文档
* https://github.com/spotify/dockerfile-maven
* https://spring.io/guides/topicals/spring-boot-docker/


### 演示
* 新建 Dockerfile 文件

* 使用maven插件构建docker镜像
```bash
spring-boot-docker-demo  mvn clean package -Dmaven.test.skip=true
```

出现如下错误，需要登录上docker hub账号：
`[ERROR] Failed to execute goal com.spotify:dockerfile-maven-plugin:1.4.10:build (default) on project spring-boot-docker-demo: Could not build image: Head "https://registry-1.docker.io/v2/library/java/manifests/8": Get "https://auth.docker.io/token?account=dendi875&scope=repository%3Alibrary%2Fjava%3Apull&service=registry.docker.io": EOF -> [Help 1]`
```bash
docker login
```

* 查看镜像
```bash
docker images
```

* 运行容器
```bash
docker images -adocker run --name spring-boot-docker-demo -d -p 8080:8080 spring-boot-docker-demo/spring-boot-docker-demo:0.0.1-SNAPSHOT
```

* 查看日志
```bash
docker logs -f spring-boot-docker-demo
```

* 测试接口
```bash
curl http://localhost:8080/coffee/1
```