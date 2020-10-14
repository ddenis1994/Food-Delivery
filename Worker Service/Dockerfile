FROM gradle as BUILD
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN gradle build

FROM openjdk:15-alpine
COPY --from=BUILD /usr/src/app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]




