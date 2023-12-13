FROM openjdk:11
EXPOSE 9701
ADD target/support-service.jar support-service.jar
ENTRYPOINT [ "java","-jar","/osupport-service.jar" ]
