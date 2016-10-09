package src.java.Beans;


/**
 * Created by edmildimassimo on 9/22/16.
 */
/**
 *
 * @author Ernesto
 */

import helper.*;
import modelo.Producto;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//import javax.ejb.EJB;

@ManagedBean(name = "productoBean")
@SessionScoped
public class ProductosBean implements Serializable{
    private List<Producto> productos;
    private int id;
    private int ids = 0;
    private String nombre;
    private String description;
    private int cantidad;
    private double precio;

    public ProductosBean(){
         
        //Tienda.obtenerInstancia().getTienda().add(new Producto(99,"Arroz","Pimco",2,100));
        
    }

    public List<Producto> getProductos() {
        return Tienda.obtenerInstancia().getProductosDisponibles();
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String agregarProducto(){
        Tienda.obtenerInstancia().insertarProducto(nombre,description,cantidad,precio);
        //productos.add(new Producto(ids,nombre,description,cantidad,precio));
        productos = Tienda.obtenerInstancia().getProductosDisponibles();
        //productos.add(new Producto(ids,nombre,description,cantidad,precio));
        //Tienda.obtenerInstancia().setTienda(productos);
        return "productosDisponibles?faces-redirect=true";
                
    }
    
    public String addToCart(int pId){
        
        for(Producto p : Tienda.obtenerInstancia().getProductosDisponibles())
        {
            if(p.getId() == pId)
            {
                Tienda.obtenerInstancia().getCarrito().add(p);
                Tienda.obtenerInstancia().getProductosDisponibles().remove(p);
                return null;
            }
        }
        
        return null;
                
    }
    
}