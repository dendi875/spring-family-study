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

* 启动 Kafka 容器
```bash
cd /Users/zhangquan/code/github.com/kafka-docker

docker-compose -f docker-compose-single-broker.yml up
```

1. 启动 spring-cloud-stream-kafka-waiter-service 、spring-cloud-stream-kafka-barista-service 应用

2. 模拟下单、支持、查询，然后看 console 中的消息发送和消费日志

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