### PPT
第13章.pdf

### 视频
102丨如何观察服务熔断.mp4

### 参考文档
* https://docs.spring.io/spring-cloud-netflix/docs/2.2.10.RELEASE/reference/html/#circuit-breaker-hystrix-dashboard
* https://docs.spring.io/spring-cloud-netflix/docs/2.2.10.RELEASE/reference/html/#turbine

### 演示

* 获取镜像
```bash
docker pull hashicorp/consul
```

* 运行 Consul 容器
```bash
docker run --name consul -d -p 8500:8500 -p 8600:8600/udp hashicorp/consul
```

* 启动 spring-cloud-hystrix-dashboard、spring-cloud-consul-provider、spring-cloud-hystrix-stream-circuit-break-consumer、spring-cloud-hystrix-turbine


* 访问 turbine 

http://localhost:9000/turbine.stream?cluster=spring-cloud-hystrix-stream-circuit-break-consumer

复制 url 到 hystrix-dashboard 中

* 访问 Hystrix Dashboard 界面，并配置上一步得到的 hystrix.stream Endpoint
[Hystrix Dashboard](http://localhost:9090/hystrix)

* 访问接口观察 Dashboard 变化
```bash
curl http://localhost:8090/customer/menu
``` 

```bash
curl -X POST http://localhost:8090/customer/order
```

