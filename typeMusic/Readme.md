# TypeMusic-App
Aplicación desarrollada con spring-boot 2.7.5, la cual se encarga de crear y obtener laos tipos de los estilos musicales.

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

## Requerimientos

Para construir y deplegar la aplicación se necesita tener instalado:

- [JDK 11](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3.8.6](https://maven.apache.org)

## Compilar y deplegar aplicación en ambiente local

Para desplegar la aplicación en ambiente local, se debe compilar con el siguiente comando.

```shell
mvn clean -U install
```
Posteriormente para desplegar la aplicación debe dirigir a la carpeta target y ejecutar el siguiente comando:

```shell
java -jar poll-0.0.1-SNAPSHOT
```
## Ruta Swagger
Para ver la documentación Swagger se debe acceder a la ruta :

```shell
http://localhost:8081/swagger-ui/index.html
```

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.