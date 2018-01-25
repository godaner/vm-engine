#1.
    linux:vi /etc/hosts
    windows:编辑 c:\windows\system32\drivers\etc
    ==> 127.0.0.1  eureka01 eureka02

#2.
    nohup java -jar vm-eureka.jar --spring.profiles.active=eureka01 > eureka01.out &
     
    nohup java -jar vm-eureka.jar --spring.profiles.active=eureka02 > eureka02.out &
#3.
    http://eureka01:8761