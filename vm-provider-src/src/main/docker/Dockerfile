FROM java:8
VOLUME /tmp
ADD vm-provider-src-1.0.0.jar *.jar
#RUN bash -c 'touch /*.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/*.jar"]
EXPOSE 1-65535