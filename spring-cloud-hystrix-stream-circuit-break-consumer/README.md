### PPT
第13章.pdf

### 视频
102丨如何观察服务熔断.mp4

### 参考文档
* https://docs.spring.io/spring-cloud-netflix/docs/2.2.10.RELEASE/reference/html/#circuit-breaker-hystrix-dashboard

### 演示

* 获取镜像
```bash
docker pull hashicorp/consul
```

* 运行 Consul 容器
```bash
docker run --name consul -d -p 8500:8500 -p 8600:8600/udp hashicorp/consul
```

* 启动 spring-cloud-hystrix-dashboard、spring-cloud-consul-provider、spring-cloud-hystrix-stream-circuit-break-consumer

* 查看 [Actuator Endpoint](http://localhost:8090/actuator) spring-cloud-hystrix-stream-circuit-break-consumer 所暴露的Endpoint
找到 hystrix.stream 这个 Endpoint，把这个 Endpoint 配置到 Dashboard 中

* 访问 Hystrix Dashboard 界面，并配置上一步得到的 hystrix.stream Endpoint
[Hystrix Dashboard](http://localhost:9090/hystrix)

* 访问接口观察 Dashboard 变化
```bash
curl http://localhost:8090/customer/menu
``` 

```bash
curl -X POST http://localhost:8090/customer/order
```

停止 spring-cloud-consul-provider 应用，再访问接口看 Dashboard 变化

* 我们还能使用 Spring Boot 提供的 metrics Endpoint 功能 http://localhost:8090/actuator/metrics，里面它也有一些 hystrix 相关的信息

