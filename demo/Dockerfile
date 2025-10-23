# Imagen base con JDK
FROM eclipse-temurin:21.0.8_9-jdk

# Puerto que expone la aplicación
EXPOSE 8080

# Directorio de trabajo
WORKDIR /root

# Copiar archivos necesarios para Maven
COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root

# Dar permisos de ejecución al wrapper de Maven
RUN chmod +x /root/mvnw

# Descargar dependencias sin ejecutar la compilación completa
RUN ./mvnw dependency:go-offline

# Copiar el código fuente
COPY ./src /root/src

# Construir la aplicación
RUN ./mvnw clean install -DskipTests

# Levantar la aplicación al iniciar el contenedor
ENTRYPOINT ["java","-jar","/root/target/demo-0.0.1-SNAPSHOT.jar"]