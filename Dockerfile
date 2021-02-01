#----Archivo dockerfile
#--1 Crear una máquina con java y gradle
#--2 Descargar un proyecto de java CLI de apuntes de citas entre doctores y pacientes
#--3 Compilar proyecto
#----Tamaño final de la imagen: 790 MB------------------
#--------Pablo Núñez-PY--pablonunez81@gmail.com---------

#-----------------------------------------
#Para Construir imagen:
# >docker build -t appointments-java-cli:1 .

#Descargar OS con java y gradle
FROM gradle:jdk15-hotspot AS TEMP_BUILD_IMAGE

#descargar proyecto github de Appoinments
RUN echo "Descargando proyecto de github:"
RUN git clone https://github.com/pablonunez81/Appointments.git Appointments
WORKDIR /home/gradle/Appointments

#compilar javac
RUN echo "compilando:"
RUN gradle build
RUN echo "Compilación lista"

RUN echo "..Para correr imagen: >docker run --rm -it appointments-java-cli:1 java -jar ./build/libs/Appointments-1.0.0.jar"