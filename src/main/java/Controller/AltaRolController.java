/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.RolFacadeLocal;
import Model.Rol;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Jose Maria
 */

@Named
@ViewScoped
public class AltaRolController implements Serializable {
    
    private Rol rol;
    
    @EJB
    private RolFacadeLocal rolEJB;
    
    
    @PostConstruct
    public void init(){
        
        rol = new Rol();
    }
    
    public void insertarRol(){
        
         try{
            rolEJB.create(rol);
            System.out.println(rol.getRol()+ " insertado correctamente");
        } catch(Exception e){
            
            System.out.println("Error al insertar rol en la base de datos "+ e.getMessage());
        }
         
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public RolFacadeLocal getRolEJB() {
        return rolEJB;
    }

    public void setRolEJB(RolFacadeLocal rolEJB) {
        this.rolEJB = rolEJB;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.rol);
        hash = 29 * hash + Objects.hashCode(this.rolEJB);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AltaRolController other = (AltaRolController) obj;
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        if (!Objects.equals(this.rolEJB, other.rolEJB)) {
            return false;
        }
        return true;
    }
    
    
    
}
