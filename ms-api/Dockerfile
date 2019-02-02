FROM openjdk:8-jre-alpine
EXPOSE 8080
VOLUME /tmp
ARG JAR_FILE
ARG APP_NAME
ARG APP_VERSION
ADD ${JAR_FILE} app.jar
ENV XMS_OPTS=64M
ENV XMX_OPTS=128M
ENTRYPOINT java -jar /app.jar -Xms$XMS_OPTS -Xmx$XMX_OPTS -Djava.security.egd=file:/dev/./urandom