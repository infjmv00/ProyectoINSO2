/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.ProveedorFacadeLocal;
import Model.Proveedor;
import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;
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
public class AltaProveedorController implements Serializable {
    
     
     private static final Logger LOG = Logger.getLogger(AltaProveedorController.class.getName());
     private Proveedor proveedor;
     
     @EJB
     private ProveedorFacadeLocal proveedorEJB;
     
     
     @PostConstruct
     public void init(){
         
         proveedor = new Proveedor();
         
         
     }
    
     
     public void insertarProveedor(){
          try{
            proveedorEJB.create(proveedor);
            System.out.println(proveedor.getNombre()+ " insertado correctamente");
        } catch(Exception e){
            
            System.out.println("Error al insertar proveedor en la base de datos "+ e.getMessage());
        }
         
     }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public ProveedorFacadeLocal getProveedorEJB() {
        return proveedorEJB;
    }

    public void setProveedorEJB(ProveedorFacadeLocal proveedorEJB) {
        this.proveedorEJB = proveedorEJB;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.proveedor);
        hash = 71 * hash + Objects.hashCode(this.proveedorEJB);
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
        final AltaProveedorController other = (AltaProveedorController) obj;
        if (!Objects.equals(this.proveedor, other.proveedor)) {
            return false;
        }
        if (!Objects.equals(this.proveedorEJB, other.proveedorEJB)) {
            return false;
        }
        return true;
    }
       
     
   
    
}
