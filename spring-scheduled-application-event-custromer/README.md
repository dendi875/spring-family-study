### PPT
第15章.pdf

### 视频
116丨通过Spring Cloud Stream访问Kafka.mp4

### 参考文档
* https://docs.spring.io/spring-framework/docs/5.2.2.RELEASE/spring-framework-reference/integration.html#scheduling-annotation-support
* https://docs.spring.io/spring-integration/docs/5.0.5.RELEASE/reference/html/applicationevent.html

### 演示

* 启动 
1. spring-cloud-stream-kafka-waiter-service
2. spring-cloud-stream-kafka-barista-service
3. spring-scheduled-application-event-custromer

* 访问接口

```bash
curl -X POST "http://localhost:8090/customer/order/" \
-H 'Content-Type: application/json' \
-d '{}'
```