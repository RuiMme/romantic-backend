FROM openjdk:11
LABEL Maintainer="lishaojian" Date="2023/5/25" Description="romantic" Version="1.0.0"
ADD target/romantic-backend-0.0.1-SNAPSHOT romantic.jar
EXPOSE 8023
ENTRYPOINT ["java","-jar","/romantic.jar"]