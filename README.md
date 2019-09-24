# EurekaDemo

#### 介绍
Spring Cloud Eureka学习时的入门代码

#### 使用说明

1. 修改hosts，追加如下内容 127.0.0.1    slave1    slave2
2. eureka-server 运行两次，运行时分别在控制台输入 slave1 和 slave2
3. eureka-provider 运行两次，运行时分别在控制台输入两个不同的端口
4. 运行项目顺序是 eureka-server -> eureka-provider -> eureka-invoker -> eureka-test