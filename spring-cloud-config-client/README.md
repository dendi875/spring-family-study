### PPT
第14章.pdf

### 视频
108丨基于Git的配置中心（下）.mp4

### 参考文档
* https://docs.spring.io/spring-cloud-config/docs/2.2.4.RELEASE/reference/html/#_spring_cloud_config_client

### 演示

1. 以 dev 环境来运行，Program arguments: --spring.profiles.active=dev
2. 使用 postman 创建订单
3. 访问 Actuator, http://localhost:8080/actuator，查看 configprops，查看 orderProperties
4. 修改文件中的值，验证刷新功能，记得 git add 和 git commit
```yaml
# vi ~/code/github.com/spring-cloud-config-repo/waiter-service-dev.yml
order:
    discount: 10
```

