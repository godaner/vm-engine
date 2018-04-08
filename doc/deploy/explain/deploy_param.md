运行环境：

	* jdk 1.8.x
	* springboot 1.4.5.RELEASE
	* springcloud Camden.SR6
	* centos 7.x

运行参数：
#1.
    linux:
        # vim /etc/hosts
    windows:
        # 编辑 c:\windows\system32\drivers\etc
    输入==> 127.0.0.1  server01 server02 

#2.
    # nohup java -jar vm-eureka-1.0.0.jar --spring.profiles.active=eureka01 -Xms64m -Xmx128m -Xmn48m >eureka01.out 2>&1 &
     
#3.
    http://eureka01:1111
    
    
#4.
    可能用到的命令:
    # scp /usr/local/src/a.jar root@120.78.191.94:/usr/local/src
    # systemctl stop firewalld.service  关闭防火墙

jvm参数：

	-Xms64m -Xmx128m -Xmn48m
	-XX:MaxMetaspaceSize=48m 
	-XX:CompressedClassSpaceSize=8m 
	-Xss256k 
	-XX:InitialCodeCacheSize=4m 
	-XX:ReservedCodeCacheSize=8m 
	-XX:MaxDirectMemorySize=16m

解释：

    -Xms – JVM启动时的初始堆大小
    -Xmx – 最大堆大小
    -Xmn - 年轻代的大小，其余的空间是老年代
    Thread Stacks ：所有运行的线程的空间。可以使用 -Xss 参数设置最大线程大小。
    Metaspace ： 它替代了 PermGem（Java 7中是JVM堆的一部分）。在 Metaspace 中，通过应用程序加载所有类和方法。看看Spring Cloud 包含的包数量，我们不会在这里节省大量的内存。可以通过设置 -XX:MetaspaceSize 和 -XX:MaxMetaspaceSize 参数来管理 Metaspace 大小。
    Code Cache ： 这是由 JIT（即时）编译器编译为本地代码的本机代码（如JNI）或 Java 方法的空间。最大大小设置 -XX:ReservedCodeCacheSize 参数。
    Compressed Class Space ： 使用 -XX：CompressedClassSpaceSize 设置为压缩类空间保留的最大内存。
    Direct NIO Buffers


nohup java -jar vm-eureka-1.0.0.jar --spring.profiles.active=prod00 -Xms64m -Xmx128m -Xmn48m >eureka00.out 2>&1 &
nohup java -jar vm-config-server-1.0.0.jar --spring.profiles.active=prod -Xms24m -Xmx64m -Xmn24m >config00.out 2>&1 &
nohup java -jar vm-gateway-1.0.0.jar --spring.profiles.active=prod00 -Xms64m -Xmx128m -Xmn48m >gateway00.out 2>&1 &
nohup java -jar vm-provider-src-1.0.0.jar --spring.profiles.active=prod -Xms64m -Xmx128m -Xmn48m >src00.out 2>&1 &
nohup java -jar vm-provider-admin-1.0.0.jar --spring.profiles.active=prod -Xms64m -Xmx128m -Xmn48m >admin00.out 2>&1 &
nohup java -jar vm-provider-user-1.0.0.jar --spring.profiles.active=prod -Xms64m -Xmx128m -Xmn48m >user00.out 2>&1 &
nohup java -jar vm-provider-movie-1.0.0.jar --spring.profiles.active=prod -Xms64m -Xmx128m -Xmn48m >movie00.out 2>&1 &

