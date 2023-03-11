# Use an OpenJDK Runtime as a parent image
FROM openjdk:17-oracle
# Add Maintainer Info
LABEL maintainer="abderraouf.ayadi1990@gmail.com"
# Define environment variables
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
JAVA_OPTS=""
# Set the working directory to /app
WORKDIR /app
# Copy the executable into the container at /app
COPY target/gateway-0.0.1-SNAPSHOT.jar gateway-0.0.1-SNAPSHOT.jar

# Make port 9999 available to the world outside this container
EXPOSE 9999
# Run app.jar when the container launches
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/gateway-0.0.1-SNAPSHOT.jar"]