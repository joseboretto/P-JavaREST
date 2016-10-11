/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Socio;

/**
 *
 * @author jose
 */
public class GestorSocio {
    EntityManagerFactory factory; 
    EntityManager em;
    public GestorSocio() {
        //debe tener el mismo nombre que esta en persistence.xml
        factory = Persistence.createEntityManagerFactory("com.mycompany_CRUDrest_war_1.0-SNAPSHOTPU");
        em = factory.createEntityManager();
    }
    
   public Socio getSocio(int id){
        Socio s = em.find(Socio.class, id);
        return s;
    }
    
    public List listarSocios(){
        List<Socio> listaSocios = em.createQuery("Select s from Socio s", Socio.class).getResultList();
        return listaSocios;
    }
    
    public boolean registrarSocio(Socio socio){
        em.getTransaction().begin();
        em.persist(socio);
        em.getTransaction().commit();
        return true;    
    }
    
    public boolean eliminarSocio(int id){
        Socio s =  getSocio(id);
        em.getTransaction().begin();
        em.remove(s);
        em.getTransaction().commit();
        return true;
    }
    
    public boolean actualizarSocio(Socio s){
        em.merge(s);
        return true;
    }
}
