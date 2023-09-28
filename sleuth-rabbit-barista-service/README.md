### PPT
第16章.pdf

### 视频
120丨如何追踪消息链路.mp4

### 演示

* 启动中间件
1. Mysql
2. Consul
3. RabbitMQ
4. Zipkin

Zipkin 启动
```bash
docker pull openzipkin/zipkin

docker run --name rabbit-zipkin -d -p 9411:9411 \
--link rabbitmq -e RABBIT_ADDRESSES=rabbitmq:5672 \
-e RABBIT_USER=spring -e RABBIT_PASSWORD=spring openzipkin/zipkin
```

* 启动应用
1. sleuth-rabbit-barista-service
2. sleuth-customer-service
3. sleuth-waiter-service

* 打开[Zipkin UI](http://localhost:9411/)


下单：
```bash
curl -X POST "http://localhost:8090/customer/order/" \
-H 'Content-Type: application/json' \
-d '{}'
```