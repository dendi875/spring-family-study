### PPT
第14章.pdf

### 视频
111丨基于Consul的配置中心.mp4

### 参考文档
* https://docs.spring.io/spring-cloud-consul/docs/2.2.4.RELEASE/reference/html/#spring-cloud-consul-config

### 演示

* 获取镜像
```bash
docker pull hashicorp/consul
```

* 运行 Consul 容器
```bash
docker run --name consul -d -p 8500:8500 -p 8600:8600/udp hashicorp/consul
```

1. 访问[Consul UI](http://localhost:8500/)，并创建相应的配置
```yaml
# config/waiter-service/data
order:
 discount: 60
 waiterPrefix: zhangquan-
```

2. 启动 spring-cloud-config-consul 应用

3. 访问接口观察配置是否生效
```bash
curl -X POST "http://localhost:8888/order/" \
-H 'Content-Type: application/json' \
-d '{
    	"customer":"zq",
    	"items":["latte", "mocha"]
    }'
```

4. 修改 Consul 中 config/waiter-service/data 的值，观察是否刷新生效