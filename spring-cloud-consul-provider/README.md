### PPT
第12章.pdf

### 视频
96丨使用Consul作为服务注册中心.mp4

### 参考文档
* https://github.com/hashicorp/consul/releases/tag/v1.15.0
* https://hub.docker.com/_/consul
* https://docs.spring.io/spring-cloud-consul/docs/2.2.4.RELEASE/reference/html

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

* 通过 DNS 的方式来获取 service 
```bash
dig @127.0.0.1 -p 8600 spring-cloud-consul-provider.service.consul
```