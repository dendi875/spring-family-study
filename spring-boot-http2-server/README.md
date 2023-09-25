### PPT
第10章.pdf

### 视频
81丨如何配置容器支持 HTTP-2（下）.mp4

### 参考文档
* https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/html/howto-embedded-web-servers.html#howto-configure-http2

### 前提条件
* Java >= JDK 9
* Tomcat >= 9.0.0
* Spring Boot 不⽀持 h2c，需要先配置 SSL

### 配置项
* server.http2.enabled


### 客户端 HTTP/2 ⽀持
HTTP 库选择
* OkHttp（ com.squareup.okhttp3:okhttp:3.14.0 ）
    * OkHttpClient
* RestTemplate 配置
    * OkHttp3ClientHttpRequestFactory
    
### 访问
```bash
 zhangquan@dendi875  zhangquan  curl -k -I https://localhost:8443/coffee/1
HTTP/1.1 200
Content-Type: application/json;charset=UTF-8
Content-Length: 154
Date: Sat, 23 Sep 2023 08:04:47 GMT
```