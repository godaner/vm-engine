1.
    vi /etc/hosts ==> 127.0.0.1  eureka01 eureka02



2.
    java -jar vm-eureka.jar --spring.profiles.active=eureka01 

    java -jar vm-eureka.jar --spring.profiles.active=eureka02 
3.
    http://eureka01:8761