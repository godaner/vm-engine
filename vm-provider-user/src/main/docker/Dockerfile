FROM fabric8/java-alpine-openjdk8-jre
VOLUME /tmp
ADD vm-provider-user-1.0.0.jar vm-provider-user-1.0.0.jar
#RUN bash -c 'touch /*.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/vm-provider-user-1.0.0.jar"]
EXPOSE 7770-7870