#1.
    linux:
        # vim /etc/hosts
    windows:
        # 编辑 c:\windows\system32\drivers\etc
    输入==> 127.0.0.1  eureka01 eureka02

#2.
    # nohup java -jar vm-eureka-1.0.0.jar --spring.profiles.active=eureka01 >eureka01.out 2>&1 &
     
    # nohup java -jar vm-eureka-1.0.0.jar --spring.profiles.active=eureka02 >eureka02.out 2>&1 &
#3.
    http://eureka01:1111
    
    
#4.
    可能用到的命令:
    # scp /usr/local/src/a.jar root@120.78.191.94:/usr/local/src
    # systemctl stop firewalld.service  关闭防火墙
    
#5.application.yml
    #禁用eureka注册自己
    eureka:
      client:
        fetch:
          registry: false
        register-with-eureka: false
    #启动保护机制
    eureka:
      server:
        enable-self-preservation: true
    #eureka集群名
    spring:
      application:
        name: vm-eureka-cluster
    #通过spring.profiles.active=[eureka01|eureka02]激活
    --- #eureka01
    spring:
      profiles: eureka01
    server:
      port: 1111
    eureka:
      instance:
        hostname: eureka01
      client:
        service-url:
          default-zone: http://eureka02:1112/eureka
    security:
      basic:
        enabled: true
      user:
        name: godaner
        password: ZK19951217.
    
    --- #eureka02
    spring:
      profiles: eureka02
    server:
      port: 1112
    eureka:
      instance:
        hostname: eureka02
      client:
        service-url:
          default-zone: http://eureka01:1111/eureka
    security:
      basic:
        enabled: true
      user:
        name: godaner
        password: ZK19951217.
    