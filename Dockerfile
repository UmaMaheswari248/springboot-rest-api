FROM anapsix/alpine-java
MAINTAINER uma maheswari
WORKDIR /app
COPY springboot-rest-api-1.0.0.jar /app
CMD ["java","-jar","/app/springboot-rest-api-1.0.0.jar"]
