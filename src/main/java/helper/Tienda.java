package helper;

import java.util.ArrayList;
import src.java.modelo.Producto;
import java.io.Serializable;
import org.primefaces.model.UploadedFile;
import src.java.modelo.Comentario;
import src.java.modelo.ProductoComprado;

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
    private static ArrayList<ProductoComprado> Comprados;  
    
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

    public ArrayList<ProductoComprado> getComprados() {
        return Comprados;
    }

    public void setComprados(ArrayList<ProductoComprado> Comprados) {
        this.Comprados = Comprados;
    }

    public Tienda getInstancia() {
        return instancia;
    }

    public void setInstancia(Tienda instancia) {
        Tienda.instancia = instancia;
    }
    
    public boolean agregarProductoACarrito(Producto PAComprar)
    {
        for(Producto pd : productosDisponibles)
        {
            if(PAComprar.getId() == pd.getId())
            {
                if(pd.getCantidad()<1)
                    return false;

                Producto compare = null;
                for(Producto pc : Carrito)
                {
                    if(PAComprar.getId() == pc.getId())
                    {
                        compare = pc;
                        break;
                    }
                    
                }
                if(compare == null)
                {
                    Carrito.add(new Producto(pd.getId(), pd.getNombre(),  null, 1, pd.getPrecio(), null));
                    return true;
                }
                else
                {
                   if(compare.getCantidad() < pd.getCantidad())
                    {
                        compare.setCantidad(compare.getCantidad()+1);
                        return true;
                    }
                    else return false;
                }
                        
            }
        }
        
        
        return false;
        
        
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
    
    public void comprar(int UId)
    {
        for(Producto pc : Carrito)
        {
            for(Producto pd : productosDisponibles)
            {
                if(pc .getId() == pd.getCantidad())
                {
                    pd.setCantidad( pd.getCantidad() - pc.getCantidad());
                    Comprados.add(new ProductoComprado(pd.getId(), pd.getNombre(),pd.getDescription(),pd.getCantidad(),pd.getPrecio()));
                    if (pd.getCantidad() <= 0 )
                    {
                        productosDisponibles.remove(pd);
                    }
                }
                
            }
        }
    }
    
    
}
