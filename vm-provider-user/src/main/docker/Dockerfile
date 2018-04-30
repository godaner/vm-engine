FROM java:8
VOLUME /tmp
ADD vm-provider-user-1.0.0.jar *.jar
#RUN bash -c 'touch /*.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/*.jar"]
EXPOSE 7770-7870