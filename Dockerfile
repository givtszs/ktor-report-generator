# ---- Build stage ----
FROM gradle:8.10.2-jdk21 AS build
WORKDIR /app

# Cache dependencies first
COPY build.gradle.kts settings.gradle.kts gradle.properties ./
COPY gradle ./gradle
RUN gradle build --no-daemon || return 0

# Copy sources and build
COPY . .
RUN gradle installDist --no-daemon

# ---- Run stage ----
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy build from gradle installDist
COPY --from=build /app/build/install/* .

# Create a data folder for SQLite database
RUN mkdir -p /data
VOLUME ["/data"]

# Expose Ktor default port
EXPOSE 8080

# Environment defaults (can be overridden in docker-compose)
ENV DB_NAME=database.db
ENV DB_PATH=/data
ENV HOST=0.0.0.0
ENV PORT=8080

# Run the app
CMD ["bin/report-generator"]
