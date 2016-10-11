/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import gestor.GestorSocio;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Socio;

/**
 *
 * @author jose
 */
@Stateless
@Path("socios")
public class SocioFacadeREST {
    //MEJORES PRACTICAS PARA APIS
    // https://blog.philipphauer.de/restful-api-design-best-practices/
//    http://howtodoinjava.com/jersey/jax-rs-jersey-moxy-json-example/
      //COMO PORBARLo?
    //http://www.iminfo.in/post/post-json-postman-rest-client-chrome
    GestorSocio gs;

    public SocioFacadeREST() {
        gs = new GestorSocio();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Socio create(Socio entity) {
        //fomato del json
//        {
//            "socio": {
//              "nombre": "prueba",
//              "telefono": 7887
//            }
//        }
        gs.registrarSocio(entity);
        //pruebo que este en la bd
        return gs.getSocio(entity.getId());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Socio find(@PathParam("id") Integer id) {
        return gs.getSocio(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Socio> findAll() {
        return gs.listarSocios();

    }

    @GET
    @Path("ping")
    @Produces(MediaType.APPLICATION_JSON)
    public String ping() {
        System.out.println("RESTful Service 'MessageService' is running ==> ping");
        return "received ping on " + new Date().toString();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Socio findRange(Socio s) {
        gs.actualizarSocio(s);
        return gs.getSocio(s.getId());
    }


    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        gs.eliminarSocio(id);
    }

   


}
