FROM fabric8/java-alpine-openjdk8-jre
VOLUME /tmp
ADD vm-gateway-1.0.0.jar vm-gateway-1.0.0.jar
#RUN bash -c 'touch /*.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/vm-gateway-1.0.0.jar"]
EXPOSE 5550-5650