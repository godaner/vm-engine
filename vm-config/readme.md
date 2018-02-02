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
    
    
    
#运行config-server
    
    
    
    #1.
        linux:
            # vim /etc/hosts
        windows:
            # 编辑 c:\windows\system32\drivers\etc
        输入==> 127.0.0.1  server01 server02 
    
    #2.
        # nohup java -jar vm-config-1.0.0.jar --spring.profiles.active=config01 >config01.out 2>&1 &
        
        # nohup java -jar vm-config-1.0.0.jar --spring.profiles.active=config02 >config02.out 2>&1 &
    #3.
        http://config01:7777/zk_spring_cloud/vm-provider-user-dev.yml
        
        
    #4.
        可能用到的命令:
        # scp /usr/local/src/a.jar root@120.78.191.94:/usr/local/src
        
        