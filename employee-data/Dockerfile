# Use official OpenJDK 21 base image
FROM eclipse-temurin:21-jdk as build

# Set working directory
WORKDIR /app

# Copy Maven wrapper and project files
COPY . .

# Build the application (skip tests if desired)
RUN ./mvnw clean package -DskipTests

# ----------- RUNTIME IMAGE -------------
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=build /app/target/employee-data-0.0.1-SNAPSHOT.jar .

# Expose app port (change if needed)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "employee-data-0.0.1-SNAPSHOT.jar"]