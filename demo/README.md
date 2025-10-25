# Proyecto Spring Boot + Docker
Este proyecto es una aplicación Spring Boot que puede ejecutarse localmente o dentro de un contenedor Docker.  

## Descripción de la aplicacion
* El proyecto consiste en una aplicacion de ejemplo que expone un servicio en el puerto 8080.  
* Se entrega con Dockerfile y docker-compose.yml para facilitar su despliegue sin preocuparse por dependencias locales.
* En el proyecto, dentro de la carpeta src/main/java, se creó un paquete llamado controller, donde se encuentra el archivo PersonaController.java. Este archivo es el encargado de gestionar las solicitudes HTTP y controlar la URL que carga la aplicación, mostrando el formulario al usuario.  
* Dentro de la carpeta src/main/java, además del paquete controller, se creó un paquete llamado model, donde se encuentra el archivo Persona.java. Este archivo define la estructura de los datos que maneja la aplicación, representando la entidad Persona con sus atributos correspondientes.
* Dentro de la carpeta src/main/resources/templates se creó un subdirectorio llamado error, donde se encuentran los archivos 404.html y 500.html. Estos archivos son páginas HTML personalizadas que se muestran cuando ocurre un error en la aplicación, permitiendo un manejo más amigable de los errores de tipo 404 (Página no encontrada) y 500 (Error interno del servidor).
* Dentro de la carpeta src/main/resources/templates se encuentra el archivo personas.html, que contiene el formulario que se mostrará al usuario. Esta plantilla HTML es procesada por Thymeleaf y permite renderizar dinámicamente la interfaz de la aplicación en el navegador.

## Descripcion del docker
* Imagen: Se utiliza eclipse-temurin:21.0.8_9-jdk como imagen base, que incluye el JDK 21, necesario para compilar y ejecutar la aplicación Java.
* Exposición del puerto: Se expone el puerto 8080 con la instrucción EXPOSE 8080, que es el puerto donde la aplicación Spring Boot estará disponible dentro del contenedor.
* Directorio de trabajo: Se establece /root como directorio de trabajo dentro del contenedor (WORKDIR /root).
* Copiado de archivos para Maven: pom.xml, .mvn y mvnw se copian al contenedor para poder descargar dependencias y construir la aplicación. Se da permiso de ejecución al wrapper de Maven con chmod +x /root/mvnw.
* Descarga de dependencias: La instrucción RUN ./mvnw dependency:go-offline descarga todas las dependencias necesarias sin ejecutar la compilación completa, acelerando la construcción de la imagen.
* Copiado del código fuente: Se copia el código de la carpeta src al contenedor (COPY ./src /root/src).
* Construcción de la aplicación: Se ejecuta RUN ./mvnw clean install -DskipTests para compilar la aplicación y generar el archivo .jar, omitiendo los tests para agilizar la construcción.
* Ejecución de la aplicación: Con ENTRYPOINT ["java","-jar","/root/target/demo-0.0.1-SNAPSHOT.jar"], el contenedor inicia automáticamente la aplicación Spring Boot al arrancar.

## Pasos para ejecutar a travez del contenedor
* Abrir el Docker Desktop que esta instalado en la pc
* Abres una terminal 
* En la terminal ingresas el siguente comando: docker run -p 8080:8080 spring-api-image que indica la ruta y la imagen que se le asigno
* Abrir el navegador y en el buscador pongo: localhost:8080/personas y ahi aparecera la aplicacion que se creo 

## Ruta del repositorio:
https://github.com/Daniel-0209/Investigacion_Proyecto
