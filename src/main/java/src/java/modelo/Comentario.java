package modelo;

/**
 * Created by edmildimassimo on 9/22/16.
 */
public class Comentario {
    private int ID_Comentario;
    private int ID_Producto;
    private int ID_Autor;
    private String texto;

    public int getID_Comentario() {
        return ID_Comentario;
    }

    public void setID_Comentario(int ID_Comentario) {
        this.ID_Comentario = ID_Comentario;
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public int getID_Autor() {
        return ID_Autor;
    }

    public void setID_Autor(int ID_Autor) {
        this.ID_Autor = ID_Autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
