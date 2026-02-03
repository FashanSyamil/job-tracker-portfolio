# --- Stage 1: Build the App (Using a pre-installed Maven image) ---
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copy all files
COPY . .

# Build the app (skipping the wrapper script entirely)
RUN mvn clean package -DskipTests

# --- Stage 2: Run the App (Using a lightweight Java image) ---
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy the JAR file from Stage 1
# Note: make sure the name 'jobtracker' matches your artifactId
COPY --from=build /app/target/jobtracker-0.0.1-SNAPSHOT.jar app.jar

# Run it
ENTRYPOINT ["java","-jar","app.jar"]