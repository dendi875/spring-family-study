### PPT
第10章.pdf

### 视频
80丨如何配置容器支持 HTTP-2（上）.mp4

### 参考文档
* https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/html/howto-embedded-web-servers.html

### 生成证书文件

#### 命令：
```bash
keytool \
-genkey \
-alias 别名 \
-storetype 仓库类型 \
-keyalg 算法 \
-keysize ⻓度 \
-keystore ⽂件名 \ 
-validity 有效期
```

#### 说明
• 仓库类型，JKS、JCEKS、PKCS12 等 
• 算法，RSA、DSA 等 
• ⻓度，例如 2048

#### 运行：
```bash
cd ~

keytool -genkey -alias springbucks -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore springbucks.p12 -validity 365
```

```bash
输入密钥库口令: spring
再次输入新口令:spring
您的名字与姓氏是什么?
  [Unknown]:  zq
您的组织单位名称是什么?
  [Unknown]:  zq
您的组织名称是什么?
  [Unknown]:  zq
您所在的城市或区域名称是什么?
  [Unknown]:  Shang Hai
您所在的省/市/自治区名称是什么?
  [Unknown]:  Shang Ha
该单位的双字母国家/地区代码是什么?
  [Unknown]:  CN
CN=zq, OU=zq, O=zq, L=Shang Hai, ST=Shang Ha, C=CN是否正确?
  [否]:  Y
```

#### 复制证书到应用里
```bash
zhangquan@dendi875  zhangquan  cp springbucks.p12 ~/code/github.com/spring-family-study/spring-boot-ssl-server/src/main/resources
zhangquan@dendi875  zhangquan  cp springbucks.p12 ~/code/github.com/spring-family-study/spring-boot-ssl-client/src/main/resources
```

#### 配置
客户端 HTTPS ⽀持
配置 HttpClient （ >= 4.4 ） 
• SSLContextBuilder 构造 SSLContext
• setSSLHostnameVerifier(new NoopHostnameVerifier())
配置 RequestFactory 
• HttpComponentsClientHttpRequestFactory
• setHttpClient()

#### 访问
```bash
curl -k -v https://localhost:8443/coffee/1
```
