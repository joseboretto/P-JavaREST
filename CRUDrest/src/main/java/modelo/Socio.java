/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * 0- Agregamos dependecias al pom.xml del framework de persistencia y el conector a la bd
 * 1-Creamos la clase, como siempre, el el contructor debemos sacar el id
 * 2-Agregamos la etiqueta @Entity y solucionamos todos los errores en amarillo que nos tira (id y Unidad de persistencia)
 * 3-Le inidcamos que el id es autogenerado @GeneratedValue(strategy = GenerationType.IDENTITY)
 * 4-Vamos a Otras fuentes/src/main/resources/meta-inf/PERSITENCE.XML , ahi agregamos: la propiedad de crear tabla y LA CLASE QUE QUIERO PERSISTIR
 * 5-Creamos el servlet, new RestfullWebservice from entity
 * 6- Agregamos las dependencias al pom.xml
 * 7- Borramos el faced ya que vamos a utilizar nuestro gestor
 * 8- Modificamos el servlet segun las funciones que neceite
 * 9- Si queremos cambiar el formato de de l json creamos JsonMoxyConfigurationContextResolver

*/
@Entity
@XmlRootElement
public class Socio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int telefono;

    public Socio() {
    }

    public Socio(int id, String nombre, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
}
