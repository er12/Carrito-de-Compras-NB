/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.java.Beans;

import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import modelo.Usuario;
import modelo.Producto;

/**
 *
 * @author edmildimassimo
 */
public class CarritoBean {
    private List<Producto> productos;
    private int id;
    private String nombre;
    private String description;
    private int cantidad;
    private double precio;
    private Usuario usuario;
    
    
    @EJB
    private ProductosBean almacen;

    public CarritoBean() {
    }

    /**
     * @return the productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public double getTotal()
    {
        double sum = 0;
        for(Producto p : productos)
            sum += p.getPrecio();
        return sum;
    }
    
    public String agregarProducto(int id){
        
        for (Iterator<Producto> iter = almacen.getProductos().listIterator(); iter.hasNext(); ) 
        {
            Producto p = iter.next(); 
        
            if(p.getId() == id)
            {
                Producto dummy = new Producto(id, p.getNombre(), null, 0, p.getPrecio());
            
                almacen.getProductos().remove(p);
                productos.add(dummy);
                return "";
                
            }
        }
        
        return null;
    }
}
