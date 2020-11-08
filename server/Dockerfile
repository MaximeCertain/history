FROM maven:3.5-jdk-11 as buildstage

COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package


FROM adoptopenjdk/openjdk11:alpine-jre

COPY --from=build /usr/src/app/target/helloworld-1.0.0-SNAPSHOT.jar /usr/app/helloworld-1.0.0-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/helloworld-1.0.0-SNAPSHOT.jar"]





#------
#==============================================================================================



#FROM adoptopenjdk/openjdk11:alpine-jre
#ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar

#COPY ${JAR_FILE} app.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","app.jar"]