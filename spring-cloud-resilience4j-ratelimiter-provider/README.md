### PPT
第13章.pdf

### 视频
104丨使用Resilience4j实现服务限流（上）.mp4

### 参考文档
* https://github.com/resilience4j/resilience4j

### 演示

* 获取镜像
```bash
docker pull hashicorp/consul
```

* 运行 Consul 容器
```bash
docker run --name consul -d -p 8500:8500 -p 8600:8600/udp hashicorp/consul
```

* 启动 spring-cloud-resilience4j-ratelimiter-provider

* 调用接口，第5次就触发了限流等待
```bash
curl 'http://localhost:8080/coffee/?name=mocha'
```

* 查看 Actuator Endpoint
http://localhost:8080/actuator  中的 ratelimiterevents