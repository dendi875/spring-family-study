### PPT
第15章.pdf

### 视频
117丨SpringBucks实战项目进度小结.mp4

### 演示

* 启动中间件
1. Mysql
2. Consul
3. RabbitMQ

* 启动应用
1. rabbit-barista-service 
2. busy-waiter-service
3. maven 打包 lazy-customer-service 并指定端口运行
```bash
mvn clean package -Dmaven.test.skip=true

cd target

java -jar lazy-customer-service-0.0.1-SNAPSHOT.jar --server.port=8090

java -jar lazy-customer-service-0.0.1-SNAPSHOT.jar --server.port=8091
```


下单：
```bash
curl -X POST "http://localhost:8090/customer/order/" \
-H 'Content-Type: application/json' \
-d '{}'
```