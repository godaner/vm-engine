# vm-engine
## *涉及技术
    * centos => 7.x --linux服务器
    * jdk => 1.8 --java development kit
    * git => 2.10.2
    * springboot => 1.5.7.RELEASE --开箱即用
    * springcloud => Dalston.SR3 --分布式成套解决方案
        -- eureka --服务注册中心
        -- config --配置中心
        -- feign --服务调用
        -- hystrix --熔断机制
        -- ribbon --负载均衡 
        -- zuul --请求转发
        -- bus --数据总线
    * rabbitmq => 3.6.12-1 --消息队列
    * redis => 4.0.2 --高速缓存
    * mysql =>5.6.33
    * docker => 18.03.1-ce --容器
    * docker-compose => 1.9.0 --容器编排
    * docker-maven-plugin => 0.4.13 --maven-docker插件
    * 阿里云内网互通
    * 阿里云远程镜像仓库
    * ws集群 -- 利用rabbitmq实现ws集群
    * 注：具体可查询pom.xml

## *模块介绍
### vm-auth-admin
    依赖：管理员权限相关模块
### vm-auth-redis
    依赖：为权限管理提供redis支持
### vm-auth-user
    依赖：用户权限相关模块
### vm-base
    依赖：基础模块，提供例如：工具，共同常量等
### vm-config
    依赖：公共配置
### vm-controller-helper
    依赖：为controller层提供aop服务：日志打印，异常捕获等
### vm-dao
    依赖：提供基础dao功能
### vm-global-remote-config
    依赖：配置中心配置获取
### vm-mq
    依赖：mq支持
### vm-config-server
    微服务：配置中心
### vm-eureka
    微服务：注册中心
### vm-gateway
    微服务：网关
### vm-provider-admin
    微服务：管理员相关微服务
### vm-provider-movie
    微服务：电影相关微服务
### vm-provider-src
    微服务：文件服务器
### vm-provider-user
    微服务：用户相关微服务
### vm-provider-ws
    微服务：支持websocket集群







