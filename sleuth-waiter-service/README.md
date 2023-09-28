### PPT
第16章.pdf

### 视频
119丨使用Spring Cloud Sleuth实现链路追踪.mp4

### 演示

* 启动中间件
1. Mysql
2. Consul
3. RabbitMQ
4. Zipkin

Zipkin 启动
```bash
docker pull openzipkin/zipkin
docker run --name zipkin -d -p 9411:9411 openzipkin/zipkin
```

* 启动应用
1. rabbit-barista-service
2. sleuth-customer-service
3. sleuth-waiter-service

* 打开[Zipkin UI](http://localhost:9411/)


下单：
```bash
curl -X POST "http://localhost:8090/customer/order/" \
-H 'Content-Type: application/json' \
-d '{}'
```