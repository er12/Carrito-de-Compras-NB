package src.java.Beans;

/**
 * Created by edmildimassimo on 9/22/16.
 */
/**
 *
 * @author Ernesto
 */

import modelo.Producto;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "productoBean")
@SessionScoped
public class ProductosBean implements Serializable{
    private List<Producto> productos;
    private int id;
    private String nombre;
    private String description;
    private int cantidad;
    private double precio;

    public ProductosBean(){
        productos = new ArrayList<Producto>();
    }

    public List<Producto> getProductos() {
        return productos;
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
        Producto nuevo = new Producto();
        nuevo.setId(id);
        nuevo.setCantidad(cantidad);
        nuevo.setDescription(description);
        nuevo.setNombre(nombre);
        nuevo.setPrecio(precio);
        productos.add(nuevo);
        return null;
    }
    
}
