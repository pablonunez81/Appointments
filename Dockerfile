#FROM adoptopenjdk:11-jre-openj9
#FROM adoptopenjdk:11-jre-hotspot
FROM adoptopenjdk:14.0.2_12-jdk-openj9-0.21.0
#RUN mkdir /opt/app
#WORKDIR /opt/app
#copiamos archivo compilado y ejecutamos
#COPY Prueba01.jar /opt/app
#CMD ["java", "-jar", "/opt/app/Prueba01.jar"]
#-----------------------------------------
#Para Construir:
# >docker build -t prueba02:20210128 .
#Para ejecutar:
# docker run --rm -v "$(pwd):/opt/app" -w /opt/app prueba02:20210128 javac src/App.java | java src/App.java
