# HystrixDemo

#### 介绍
Spring Cloud Hystrix 学习时的代码

#### 使用说明

1. 运行项目顺序是 eureka-server -> eureka-provider -> eureka-invoker -> hystrix-dashboard
2. 输入 http://localhost:8082/hystrix
3. 在监控地址中输入 http://localhost:9000/actuator/hystrix.stream
4. 运行 eureka-test 的 TestFeignClient ，然后观察监控