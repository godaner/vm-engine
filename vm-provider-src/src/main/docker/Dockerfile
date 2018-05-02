FROM wrlennon/alpine-java8-jre
VOLUME /tmp
ADD vm-provider-src-1.0.0.jar vm-provider-src-1.0.0.jar
#RUN bash -c 'touch /*.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/vm-provider-src-1.0.0.jar"]
EXPOSE 4440-4540