# Arquitectura REST con JAVA

[logo]: http://www.codingpedia.org/wp-content/uploads/2014/05/Rest-Demo-Diagram.png "Logo Title Text 2"
![alt text][logo]

### Lectura previa recomendada
* JPA: http://www.vogella.com/tutorials/JavaPersistenceAPI/article.html
* Jersey: http://www.codingpedia.org/ama/tutorial-rest-api-design-and-implementation-in-java-with-jersey-and-spring/
* Moxy JSON: http://howtodoinjava.com/jersey/jax-rs-jersey-moxy-json-example/
* Postman (para probar): http://www.iminfo.in/post/post-json-postman-rest-client-chrome
* Mejores practicas: https://blog.philipphauer.de/restful-api-design-best-practices/



### Dependencias
* Servidor de apliaciones: **Tomcat**
* Base de datos: **Derby/MySql**
* Gestión de dependencias: **Maven**
* Framework de persitencia: **EclipseLink**
* Implementación REST en java: **Jersey**


### Pasos

1. Instalar: Servidor de aplicaciones y base de datos.
2. Ir a Netbeans, Nuevo proyecto> Maven > Aplicacion web
3. Ubicamos el pom.xml y agregamos las siguientes dependencias , vamos al proyecto y selecionamos Compilar dependencias, esto va a descargar todas las librerias que necesitamos
4. Hacemos 3 paquetes: gestor, modelo, servlet
5. En modelo creamos una clase JAVA como siempre.Debemos sacar el id del constructor
6. Agregamos la etiqueta @Entity y solucionamos todos los errores en amarillo que nos tira (id y Unidad de persistencia), aca nos guia para poner el String de conexion
7. Le inidcamos que el id es autogenerado:
```
 @GeneratedValue(strategy = GenerationType.IDENTITY)
```
8. Vamos a Otras fuentes/src/main/resources/meta-inf/PERSITENCE.XML , ahi agregamos: la propiedad de crear tabla y LA CLASE QUE QUIERO PERSISTIR
```
<property name="eclipselink.ddl-generation" value="create-tables
<property name="eclipselink.ddl-generation.output-mode" value="database"/>
```
```
</properties>
        <class>modelo.TU_CLASE_JAVA</class>
    </persistence-unit>
    ```
9. Creamos el servlet, Nuevo> RestfullWebservice from entity

10.  Borramos el facade ya que vamos a utilizar nuestro gestor
11.  Modificamos el servlet segun las funciones que neceitemos, en cada metodo debo llamar al gestor.
12. queremos cambiar el formato del JSON creamos
```
JsonMoxyConfigurationContextResolver.java
```

