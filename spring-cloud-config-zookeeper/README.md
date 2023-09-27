### PPT
第14章.pdf

### 视频
109丨基于Zookeeper的配置中心.mp4

### 参考文档
* https://docs.spring.io/spring-cloud-zookeeper/docs/2.2.3.RELEASE/reference/html/#spring-cloud-zookeeper-discovery

### 演示

* 获取镜像
```bash
docker pull hashicorp/consul
```

* 运行 Consul 容器
```bash
docker run --name consul -d -p 8500:8500 -p 8600:8600/udp hashicorp/consul
```

*  [启动 zookeeper](https://zhangquan.me/2023/04/09/zookeeper-jia-gou-yu-ji-qun-an-zhuang/)

* 创建相应的 znode 并写入值
```bash
[zk: 127.0.0.1:2181(CONNECTED) 1] create /config
Created /config
[zk: 127.0.0.1:2181(CONNECTED) 2] create /config/waiter-service
Created /config/waiter-service
[zk: 127.0.0.1:2181(CONNECTED) 3] create /config/waiter-service/order.discount 60
Created /config/waiter-service/order.discount
[zk: 127.0.0.1:2181(CONNECTED) 4] get /config/waiter-service/order.discount
60
```

* 启动应用 spring-cloud-config-zookeeper

* 访问接口观察配置是否生效
```bash
curl -X POST "http://localhost:8888/order/" \
-H 'Content-Type: application/json' \
-d '{
    	"customer":"zq",
    	"items":["latte", "mocha"]
    }'
```

* 修改 zookeeper 中的值，观察是否刷新生效
```bash
set /config/waiter-service/order.discount 1
```