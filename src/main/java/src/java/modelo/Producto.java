package modelo;

/**
 * Created by Ernesto on 21-Sep-16.
 */
public class Producto {

    private int id;
    private String nombre;
    private String description;
    private int cantidad;
    private double precio;
    //Imagen

    public Producto(){}

    public Producto(int id, String nombre, String description, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.description = description;
        this.cantidad = cantidad;
        this.precio = precio;
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
}
