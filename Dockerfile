FROM openjdk:17
EXPOSE 8181
ADD target/order-history-tracker.jar order-history-tracker.jar
ENTRYPOINT [ "java","-jar","/order-history-tracker.jar" ]
