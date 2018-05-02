FROM java:8
VOLUME /tmp
ADD vm-provider-admin-1.0.0.jar vm-provider-admin-1.0.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/vm-provider-admin-1.0.0.jar"]
EXPOSE 2220-2320