FROM maven:3.6.3-openjdk-11-slim AS builder

# Defina o diretório de trabalho como a raiz do projeto
WORKDIR /app

# Copie o arquivo pom.xml para o diretório atual
COPY ./pom.xml .

# Baixe as dependências do Maven (isso será em cache se o pom.xml não mudar)
RUN mvn dependency:go-offline

# Copie o restante dos arquivos do projeto para o diretório atual
COPY ./src ./src

# Compile o projeto Maven
RUN mvn package

# Use uma imagem JRE mínima para executar o aplicativo
FROM openjdk:11-jre-slim

# Defina o diretório de trabalho como a raiz do aplicativo
WORKDIR /app

# Copie o arquivo JAR gerado pelo Maven da etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Comando para iniciar o aplicativo quando o contêiner for iniciado
CMD ["java", "-jar", "app.jar"]


