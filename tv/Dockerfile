# Set the working directory in the container

FROM openjdk:17-jdk-slim

# Copy the JAR file into the container
COPY ./target/tv-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application listens on (change if needed)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]

LABEL "com.tv.tv"="=MusicalityAndEfile"
LABEL com.tv.tv="foo"
LABEL version="1.0"
LABEL description="In our new website, we're a growing commission based service advertiser, who take pride in history, and musicality."