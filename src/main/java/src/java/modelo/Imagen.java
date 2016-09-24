package modelo;

/**
 * Created by edmildimassimo on 9/22/16.
 */
public class Imagen {
    private int ID_Imagen;
    private int ID_Producto;
    private String imagen;

    public int getID_Imagen() {
        return ID_Imagen;
    }

    public void setID_Imagen(int ID_Imagen) {
        this.ID_Imagen = ID_Imagen;
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
