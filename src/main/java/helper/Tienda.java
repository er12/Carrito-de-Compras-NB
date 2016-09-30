package helper;


import java.util.ArrayList;
import modelo.Producto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ernesto
 */



public class Tienda {
    
    ArrayList<Producto> Carrito;
    ArrayList<Producto> Tienda;
    ArrayList<Producto> Comprados;

    public Tienda() {
        this.Carrito = new ArrayList<Producto>();
        this.Tienda = new ArrayList<Producto>();
        this.Comprados = new ArrayList<Producto>();
        
    }

    public ArrayList<Producto> getCarrito() {
        return Carrito;
    }

    public void setCarrito(ArrayList<Producto> Carrito) {
        this.Carrito = Carrito;
    }

    public ArrayList<Producto> getTienda() {
        return Tienda;
    }

    public void setTienda(ArrayList<Producto> Tienda) {
        this.Tienda = Tienda;
    }

    public ArrayList<Producto> getComprados() {
        return Comprados;
    }

    public void setComprados(ArrayList<Producto> Comprados) {
        this.Comprados = Comprados;
    }
    
    
    
    
    
}
