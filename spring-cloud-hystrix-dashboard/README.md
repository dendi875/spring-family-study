### PPT
第12章.pdf

### 视频
101丨使用Hystrix 实现服务熔断（下）.mp4

### 参考文档
* https://docs.spring.io/spring-cloud-commons/docs/2.2.4.RELEASE/reference/html/#spring-cloud-circuit-breaker
* https://docs.spring.io/spring-cloud-openfeign/docs/2.2.10.RELEASE/reference/html/#spring-cloud-feign-hystrix
* https://docs.spring.io/spring-cloud-netflix/docs/2.2.10.RELEASE/reference/html/#circuit-breaker-spring-cloud-circuit-breaker-with-hystrix
* https://github.com/Netflix/Hystrix/wiki/Configuration

### 演示

* 获取镜像
```bash
docker pull hashicorp/consul
```

* 运行 Consul 容器
```bash
docker run --name consul -d -p 8500:8500 -p 8600:8600/udp hashicorp/consul
```

* 启动 spring-cloud-hystrix-circuit-break-consumer 应用，但不启动 spring-cloud-consul-provider

* 访问Consul UI 界面
[Consul UI](http://localhost:8500/)

1. 通过 post 访问 http://localhost:8090/customer/menu 接口
2. 启动 spring-cloud-consul-provider
3. 通过 post 访问 http://localhost:8090/customer/menu 接口，能够返回正常结果

