FROM fabric8/java-alpine-openjdk8-jre
VOLUME /tmp
ADD vm-config-server-1.0.0.jar vm-config-server-1.0.0.jar
#RUN bash -c 'touch /*.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/vm-config-server-1.0.0.jar"]
EXPOSE 6660-6760