FROM java:8
VOLUME /tmp
ADD vm-provider-movie-1.0.0.jar vm-provider-movie-1.0.0.jar
#RUN bash -c 'touch /*.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/vm-provider-movie-1.0.0.jar"]
EXPOSE 3330-3430