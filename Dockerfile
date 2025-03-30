FROM openjdk:21-slim

# Cria um volume para dados temporários
VOLUME /tmp

# Copia o script wait-for-it e garante permissões de execução
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# Define o argumento para o arquivo JAR gerado
ARG JAR_FILE=target/challenge.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["/wait-for-it.sh", "mysql:3306", "-t", "30", "--", "java", "-jar", "/app.jar"]