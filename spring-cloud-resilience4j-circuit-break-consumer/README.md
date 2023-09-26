### PPT
第13章.pdf

### 视频
103丨使用Resilience4j实现服务熔断.mp4

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

* 启动 spring-cloud-consul-provider、spring-cloud-resilience4j-circuit-break-consumer

* 访问接口
```bash
curl http://localhost:8090/customer/menu
``` 

```bash
curl -X POST http://localhost:8090/customer/order
```

* 查看 actuator 中 circuit 中的输出

1. 访问 http://localhost:8090/actuator 进行 curl 调用，观察 circuitbreakerevents 的输出
2. 停止 spring-cloud-consul-provider，再进行 curl 调用，再观察 circuitbreakerevents 输出