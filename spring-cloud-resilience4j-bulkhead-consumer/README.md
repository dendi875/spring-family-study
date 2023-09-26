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

* 启动 spring-cloud-consul-provider、spring-cloud-resilience4j-bulkhead-consumer

* 访问接口
```bash
curl http://localhost:8090/customer/menu
``` 

```bash
curl -X POST http://localhost:8090/customer/order
```

* 使用 wrk 进行并发测试
```bash
wrk -t10 -c30 -d3s --latency http://localhost:8090/customer/menu
```

访问 http://localhost:8090/actuator ，观察 circuitbreakerevents 的输出