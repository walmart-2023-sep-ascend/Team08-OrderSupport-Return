FROM openjdk:11
EXPOSE 9701
ADD target/support-service-2.0.0.jar support-service-2.0.0.jar
ENTRYPOINT [ "java","-jar","/support-service.jar" ]
