#应用和数据获取映射规则
### 名词代表：
    application:spring.application.name
    label:git上的分支名
    profile:文件名
    
### 获取git上的资源信息遵循如下规则：
    /{application}/{profile}[/{label}]
    /{application}-{profile}.yml
    /{label}/{application}-{profile}.yml
    /{application}-{profile}.properties
    /{label}/{application}-{profile}.properties
    
    
### 例如：
    http://localhost:7777/zk_spring_cloud/vm-config-eureka-dev.yml