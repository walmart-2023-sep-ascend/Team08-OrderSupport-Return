FROM openjdk:17
EXPOSE 9702
ADD target/order-return.jar order-return.jar 
ENTRYPOINT [ "java","-jar","/order-return.jar" ]
