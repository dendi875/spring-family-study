### PPT
第14章.pdf

### 视频
107丨基于Git的配置中心（上）.mp4

### 参考文档
* https://docs.spring.io/spring-cloud-config/docs/2.2.4.RELEASE/reference/html/#_spring_cloud_config_server

### 演示

* 获取镜像
```bash
docker pull hashicorp/consul
```

* 运行 Consul 容器
```bash
docker run --name consul -d -p 8500:8500 -p 8600:8600/udp hashicorp/consul
```

* 新建一个本地git仓库，不需要推送到github上
```bash
mkdir ~/code/github.com/spring-cloud-config-repo
git init
```

* 写入配置
```yaml
#vim waiter-service.yml
order:
	discount: 80
	waiterPrefix: zhangquan-
```

* 提交配置
```bash
git add .
git commit "init"
```

* 配置 application.application.properties 中的 spring.cloud.config.server.git.uri

* 启用 spring-cloud-config-server，并访问配置
```bash
curl http://localhost:8888/waiter-service.yml
```

增加 profile 文件
```yaml
#vim waiter-service-dev.yml
order:
	discount: 60
```
访问配置
```bash
curl http://localhost:8888/waiter-service-dev.yml
curl http://localhost:8888/waiter-service/dev
```

