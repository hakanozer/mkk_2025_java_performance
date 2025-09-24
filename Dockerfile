# Maven ve JDK 17 içeren image
FROM maven:3.9.6-eclipse-temurin-17

# Çalışma dizini
WORKDIR /app

# Proje dosyalarını kopyala
COPY pom.xml .
COPY src ./src

# Maven build
RUN mvn clean package -DskipTests

# Jar dosyasını çalıştır
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
