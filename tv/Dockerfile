# Set the working directory in the container
FROM openjdk:17-jdk-slim

WORKDIR /tv

# Copy the JAR file into the container
COPY tv-0.0.1-SNAPSHOT.jar tv-0.0.1-SNAPSHOT.jar

# Expose the port your application listens on (change if needed)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
