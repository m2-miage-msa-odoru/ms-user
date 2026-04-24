# ══════════════════════════════════════════════
# Stage 1 — BUILD
# ══════════════════════════════════════════════
FROM maven:3.9-eclipse-temurin-21-alpine AS build

WORKDIR /app

# Copie des fichiers POM pour profiter du cache Docker
COPY pom.xml ./pom.xml
COPY rest-api/pom.xml ./rest-api/pom.xml
COPY server/pom.xml ./server/pom.xml

# Téléchargement des dépendances (en cache tant que les POM ne changent pas)
RUN mvn dependency:go-offline -q

# Copie du code source
COPY rest-api/src ./rest-api/src
COPY server/src ./server/src

# Construction de l'application
RUN mvn clean package -DskipTests -q

# ══════════════════════════════════════════════
# Stage 2 — RUNTIME
# ══════════════════════════════════════════════
FROM eclipse-temurin:21-jre-alpine AS runtime

WORKDIR /app

LABEL maintainer="fello.miage" \
      service="user-service" \
      version="0.0.1-SNAPSHOT"

# Création d'un utilisateur non-root pour la sécurité
RUN addgroup -S odoru && \
    adduser -S odoru -G odoru && \
    mkdir -p /app/config && \
    chown -R odoru:odoru /app

# Copie du JAR depuis l'étape de build
COPY --from=build --chown=odoru:odoru /app/server/target/user-service.jar app.jar

# Exposition du port
EXPOSE 8081

# Utilisateur non-root
USER odoru

# Configuration JVM optimisée pour les conteneurs
ENTRYPOINT ["java", \
            "-XX:+UseContainerSupport", \
            "-XX:MaxRAMPercentage=75.0", \
            "-XX:+ExitOnOutOfMemoryError", \
            "-Djava.security.egd=file:/dev/./urandom", \
            "-Dspring.cloud.config.import-check.enabled=false", \
            "-jar", \
            "app.jar"]