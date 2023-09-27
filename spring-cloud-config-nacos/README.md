### PPT
第14章.pdf

### 视频
112丨基于Nacos的配置中心.mp4

### 参考文档
* https://spring.io/projects/spring-cloud-alibaba#learn
* https://spring-cloud-alibaba-group.github.io/github-pages/edgware/spring-cloud-alibaba.html#_spring_cloud_alibaba_nacos_config\
* https://github.com/alibaba/nacos/
* https://github.com/alibaba/spring-cloud-alibaba/wiki/Nacos-config


### 演示

1. 获取镜像
```bash
docker pull hashicorp/consul
```

2. 运行 Consul 容器
```bash
docker run --name consul -d -p 8500:8500 -p 8600:8600/udp hashicorp/consul
```

3. 取nacos镜像
```bash
docker pull nacos/nacos-server:0.9.0
```

4. 运行 Nacos 容器
```bash
docker run --name nacos -d -p 8848:8848 -e MODE=standalonenacos/nacos-server:0.9.0
```

5. 访问Nacos UI 界面（用户密码：nacos），并添加如下配置，使用 Chrome 无痕模式打开，不然报用户密码错误
[Nacos UI](http://localhost:8848/nacos)

相应的配置
Data ID: waiter-service.yaml，注意这里必须要有 .yaml 后缀
内容：
```yaml
order:
 discount: 60
 waiterPrefix: zhangquan-
```

2. 启动 spring-cloud-config-nacos 应用

3. 访问接口观察配置是否生效
```bash
curl -X POST "http://localhost:8888/order/" \
-H 'Content-Type: application/json' \
-d '{
    	"customer":"zq",
    	"items":["latte", "mocha"]
    }'
```

4. 修改 Nacos 中 Data ID 的值，观察是否刷新生效