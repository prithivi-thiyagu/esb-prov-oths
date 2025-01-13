FROM openjdk:17

WORKDIR /esb-prov-oths

# Copy only the project directory (replace 'myproject' with your actual project directory name)
COPY ./target/*.jar esb-prov-oths.jar

RUN ls

ENTRYPOINT ["java", "-jar", "esb-prov-oths.jar"]

EXPOSE 8090
