# Stage 1 : Construction avec Maven
FROM maven:3.9-eclipse-temurin-21-alpine AS builder
# Pour (Java 17)
#FROM maven:3.9-eclipse-temurin-17-alpine AS builder

WORKDIR /build

# Copier les fichiers du projet
COPY pom.xml .
COPY src ./src

# Compiler l'application
RUN mvn clean package -DskipTests

# Stage 2 : Runtime
FROM eclipse-temurin:21-jre-alpine
# POUR (Java 17)
#FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copier le JAR depuis l'étape 1
COPY --from=builder /build/target/aba-springboot-v2-1.0.0-SNAPSHOT.jar app.jar

# Exposer le port
EXPOSE 8080

# Santé check
HEALTHCHECK --interval=30s --timeout=3s --start-period=40s --retries=3 \
  CMD java -version

# Lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]