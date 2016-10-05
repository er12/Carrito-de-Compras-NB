package helper;


import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import modelo.Producto;
import java.io.Serializable;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ernesto
 */

public class Tienda implements Serializable {
    
    private static Tienda instancia = null;
    private static int ids = 0;
    private static List<Producto> Carrito;
    private static List<Producto> productosDisponibles;
    private static List<Producto> Comprados;

    
            
    
    private Tienda() {
        
    }
    
    public static Tienda obtenerInstancia(){
        if(instancia == null){
            instancia = new Tienda();
              Carrito = new ArrayList<>();
              productosDisponibles = new ArrayList<>();
              Comprados = new ArrayList<>();
        }
      
        return instancia;
    }
    
    public void insertarProducto(String nombre,String description,int cantidad,double precio)
    {
        productosDisponibles.add(new Producto(ids,nombre,description,cantidad,precio));
        ids++;
        
        
    }

    public List<Producto> getCarrito() {
        return Carrito;
    }

    public void setCarrito(List<Producto> Carrito) {
        this.Carrito = Carrito;
    }

    public List<Producto> getProductosDisponibles() {
        return productosDisponibles;
    }

    public void setProductosDisponibles(List<Producto> productosDisponibles) {
        this.productosDisponibles = productosDisponibles;
    }

    public List<Producto> getComprados() {
        return Comprados;
    }

    public void setComprados(List<Producto> Comprados) {
        this.Comprados = Comprados;
    }
    
    
    
    
    
}
