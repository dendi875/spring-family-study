### PPT
第14章.pdf

### 视频
115丨通过Spring Cloud Stream访问RabbitMQ.mp4

### 参考文档
* https://docs.spring.io/spring-cloud-stream/docs/1.0.x/reference/html/binder-specific-configuration.html
* https://spring.io/projects/spring-cloud-stream

### 演示

* 获取镜像
```bash
docker pull hashicorp/consul
```

* 运行 Consul 容器
```bash
docker run --name consul -d -p 8500:8500 -p 8600:8600/udp hashicorp/consul
```

* 获取 rabbitmq 镜像
```bash
docker pull rabbitmq:3.7-management
```

* 启动 rabbitmq 容器
```bash
docker run --name rabbitmq -d -p 5672:5672 -p 15672:15672 \
-e RABBITMQ_DEFAULT_USER=spring -e RABBITMQ_DEFAULT_PASS=spring \
rabbitmq:3.7-management
```

* 访问 [RabbitMQ 管理界面](http://localhost:15672)

账号密码：spring/spring


2. 启动 spring-cloud-stream-rabbitmq-waiter-service 、spring-cloud-stream-rabbitmq-barista-service 应用

3. 模拟下单、支持、查询，然后看 console 中的消息发送和消费日志

下单：
```bash
curl -X POST "http://localhost:8888/order/" \
-H 'Content-Type: application/json' \
-d '{
    	"customer":"zq",
    	"items":["latte", "mocha"]
    }'
```

支付：
```bash
curl -X PUT "http://localhost:8888/order/1" \
-H 'Content-Type: application/json' \
-d '{
    	"state":"PAID"
    }'
```


查询：
```bash
curl -X GET "http://localhost:8888/order/1"
```