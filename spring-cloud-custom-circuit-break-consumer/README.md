### PPT
第12章.pdf

### 视频
100丨使用Hystrix 实现服务熔断（上）.mp4

### 参考文档
* https://docs.spring.io/spring-cloud-commons/docs/2.2.4.RELEASE/reference/html/#spring-cloud-circuit-breaker
* https://www.martinfowler.com/bliki/CircuitBreaker.html

### 演示

* 获取镜像
```bash
docker pull hashicorp/consul
```

* 运行 Consul 容器
```bash
docker run --name consul -d -p 8500:8500 -p 8600:8600/udp hashicorp/consul
```

* 访问Consul UI 界面
[Consul UI](http://localhost:8500/)

* 启动 spring-cloud-custom-circuit-break-consumer，但不启动 spring-cloud-consul-provider
1. 通过 post 访问 http://localhost:8090/customer/menu 接口，访问到第四次时触发断路保护返回null

* 启动 spring-cloud-consul-provider
1. 通过 post 访问 http://localhost:8090/customer/menu 接口，能够返回正常结果

