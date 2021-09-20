FROM jetty
COPY build/libs/ClearSpring-1.0-SNAPSHOT.war /var/lib/jetty/webapps
ENTRYPOINT ["java","-jar","/usr/local/jetty/start.jar"]
