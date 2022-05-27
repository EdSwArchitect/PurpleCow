FROM jetty:10.0.9-jdk11-amazoncorretto

RUN java -jar ${JETTY_HOME}/start.jar --create-startd
RUN java -jar ${JETTY_HOME}/start.jar --add-module=server,http,deploy
RUN java -jar ${JETTY_HOME}/start.jar --add-to-startd=http

COPY target/PurpleCow.war /var/lib/jetty/webapps

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/usr/local/jetty/start.jar"]
