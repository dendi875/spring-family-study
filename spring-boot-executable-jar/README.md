### PPT
第10章.pdf

### 视频
83丨了解可执行 Jar 背后的秘密.mp4

### 参考文档
* https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/html/executable-jar.html
* https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/html/deployment-install.html#deployment-script-customization-conf-file

### 演示
* 使用 maven 打包成 jar 文件
```bash
cd ~/code/github.com/spring-family-study/spring-boot-executable-jar
mvn clean install -Dmaven.test.skip=true
```
* 查看主要内容
```bash
cd target

unzip -l  spring-boot-executable-jar-0.0.1-SNAPSHOT.jar
...
META-INF/MANIFEST.MF
...
org/springframework/boot/loader/JarLauncher.class
...
BOOT-INF/classes/
...
BOOT-INF/lib/
...
```

* 查看头文件内容
```bash
unzip -p spring-boot-executable-jar-0.0.1-SNAPSHOT.jar META-INF/MANIFEST.MF

...
Main-Class: org.springframework.boot.loader.JarLauncher
Start-Class: com.zq.springcloudnacosprovider.SpringBootExecutableJarApp
...
...
```

* 创建配置文件
```bash
vi spring-boot-executable-jar.conf

JAVA_OPTS="-Xmx1024m -Xms1024m -Xmn384m"
```

* 直接运行可执行的jar文件
```bash
target  cd ..

spring-boot-executable-jar  mv target/spring-boot-executable-jar-0.0.1-SNAPSHOT.jar ./spring-boot-executable-jar.jar

spring-boot-executable-jar  ./spring-boot-executable-jar.jar
```

* 验证配置文件中的JVM参数
```bash
jps -lv
```

* less zip里的shell内容
```bash
spring-boot-executable-jar  less spring-boot-executable-jar.jar
```