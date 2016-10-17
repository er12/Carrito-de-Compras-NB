package helper;

import java.util.ArrayList;
import src.java.modelo.Producto;
import java.io.Serializable;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import src.java.modelo.Comentario;

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
    private static ArrayList<Producto> Carrito;
    private static ArrayList<Producto> productosDisponibles;
    private static ArrayList<Producto> Comprados;  
    
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
    
    public void insertarProducto(String nombre,String description,int cantidad,double precio,UploadedFile uf){
        Producto p = new Producto(ids,nombre,description,cantidad,precio, uf);
        p.setUpFile(uf);
        
        productosDisponibles.add(p);
        ids++;
    }
    
    public void agregarComentario(int prodID, Comentario c){
        for(Producto p : productosDisponibles ){
            if( prodID == p.getId()){
                p.getComentarios().add(c);
                return;
            }
        }
    }

    public ArrayList<Producto> getCarrito() {
        return Carrito;
    }

    public void setCarrito(ArrayList<Producto> Carrito) {
        this.Carrito = Carrito;
    }

    public ArrayList<Producto> getProductosDisponibles() {
        return productosDisponibles;
    }

    public void setProductosDisponibles(ArrayList<Producto> productosDisponibles) {
        this.productosDisponibles = productosDisponibles;
    }

    public ArrayList<Producto> getComprados() {
        return Comprados;
    }

    public void setComprados(ArrayList<Producto> Comprados) {
        this.Comprados = Comprados;
    }

    public Tienda getInstancia() {
        return instancia;
    }

    public void setInstancia(Tienda instancia) {
        Tienda.instancia = instancia;
    }
    
    
    
}
