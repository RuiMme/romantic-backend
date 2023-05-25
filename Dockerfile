FROM openjdk:17
LABEL Maintainer="lishaojian" Date="2023/5/25" Description="romantic" Version="1.0.0"
RUN cd /usr/local/&& mkdir app
ADD target/romantic-backend-0.0.1-SNAPSHOT.jar /usr/local/app
WORKDIR /usr/local/app
EXPOSE 8023
ENTRYPOINT ["sh", "-c","java -jar ./romantic-backend-0.0.1-SNAPSHOT.jar"]