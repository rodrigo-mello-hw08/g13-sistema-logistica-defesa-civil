# Etapa 1: build
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /build

# Copia o pom.xml e arquivos necessários para resolver dependências primeiro
COPY pom.xml .
COPY src ./src

# Faz o build do projeto, ignorando os testes
RUN mvn clean package -DskipTests

# Etapa 2: imagem final
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copia o JAR compilado da etapa anterior
COPY --from=builder /build/target/*.jar app.jar

# Expõe a porta da aplicação
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]