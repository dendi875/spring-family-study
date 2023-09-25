### PPT
第3章.pdf

### 视频
21丨让MyBatis更好用的那些工具：MyBatis Generator.mp4

### 运行 MyBatis 生成器
1. 删除 com/zq./springmybatisgenerator/model 目录
2. 删除 com/zq/springmybatisgenerator/mapper 目录
3. 删除 src/main/resources/mapper/com

### 使用注意
1. `generatorConfig.xml`文件中的标签是有顺序的
2. 多 module项目时, `targetProject="./module名称/src/main/java"`
   javaModelGenerator  sqlMapGenerator javaClientGenerator配置的三个targetProject路径都需要更改
3. 在运行前resources里创建一下mapper目录，也就是目标目录需要先存在

### 参考
* https://github.com/abel533/Mapper/wiki/4.1.mappergenerator