FROM eclipse-temurin:17-jdk AS build

WORKDIR /app/backend
COPY ["apc-1-main/laundry-management-system - Copy/backend", "/app/backend"]

RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre

WORKDIR /app
COPY --from=build /app/backend/target/laundry-management-system-1.0.0.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
