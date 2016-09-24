package modelo;

import java.util.Date;
import java.util.List;

/**
 * Created by edmildimassimo on 9/22/16.
 */
public class Orden {
    private int ID_Orden;
    private int ID_usuario;
    private double totalAPagar;
    private Date fecha;
    private char estado_pago;
    List<Producto> productos;

    public int getID_Orden() {
        return ID_Orden;
    }

    public void setID_Orden(int ID_Orden) {
        this.ID_Orden = ID_Orden;
    }

    public int getID_usuario() {
        return ID_usuario;
    }

    public void setID_usuario(int ID_usuario) {
        this.ID_usuario = ID_usuario;
    }

    public double getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public char getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(char estado_pago) {
        this.estado_pago = estado_pago;
    }
}
