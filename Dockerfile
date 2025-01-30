FROM maven:3.8.4-eclipse-temurin-17 AS builder
 
# Set the working directory inside the container
WORKDIR /app
 
 
RUN ls

# Create a directory for dependencies
RUN mkdir /demo

# Copy the custom JAR file into the container
COPY ./esb-common-util-1.0.0-exec.jar /demo/
# Debug: Verify the file is in the correct location
RUN ls -al /demo
 
# Install the custom JAR into the local Maven repository
RUN mvn install:install-file \
    -Dfile=/demo/esb-common-util-1.0.0-exec.jar \
    -DgroupId=com.bandhanbank \
    -DartifactId=esb-common-util \
    -Dversion=1.0.0 \
    -Dpackaging=jar \
    -DgeneratePom=true \
    -DproxySet=true 
	

RUN ls
# Copy the project source code into the container (adjust the path if needed)
COPY ./ /app/
 
 RUN mvn clean
RUN ls
# Build the project (skipping tests for faster builds)
RUN mvn clean package -DskipTests=true 
 
# Stage 2: Runtime stage
FROM eclipse-temurin:17-jre-alpine
 
# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Debug: Verify the JAR file was copied
RUN ls 
 
# Set the entry point to run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
 
# Expose the application port
EXPOSE 8080
