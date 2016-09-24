package modelo;

/**
 * Created by edmildimassimo on 9/22/16.
 */
public class Rating {
    private int ID_Rating;
    private int ID_Producto;
    private int ID_Usuario;
    private float rating;

    public int getID_Rating() {
        return ID_Rating;
    }

    public void setID_Rating(int ID_Rating) {
        this.ID_Rating = ID_Rating;
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
