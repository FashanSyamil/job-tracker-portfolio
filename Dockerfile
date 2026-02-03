# 1. Use a base image with Java 17
FROM eclipse-temurin:17-jdk-alpine

# 2. Set the working directory inside the cloud computer
WORKDIR /app

# 3. Copy the Maven wrapper and project files
COPY .mvn/ .mvn
COPY mvnw pom.xml

# 4. Convert Windows line endings to Linux (Important for "mvmw")
RUN sed -i 's/\r$//' mvnw
RUN chmod +x mvnw

# 5. Download the dependencies (This layer will be cached)
RUN ./mvnw dependency:go-offline

# 6. Copy the source code
COPY src ./src

# 7. Build the app
RUN ./mvnw clean package -DskipTests

# 8. Run the app
CMD ["java", "-jar", "target/jobtracker-0.0.1-SNAPSHOT.jar"]