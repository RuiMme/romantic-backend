FROM java:17
ADD romantic-backend-0.0.1-SNAPSHOT romantic.jar
EXPOSE 8023
ENTRYPOINT ["java","-jar","/romantic.jar"]