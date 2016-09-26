/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.java.Beans;

import java.awt.event.ActionEvent;
import java.io.IOException;
import modelo.Usuario;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Ernesto
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {
     private String nombreUsuario;
    private String contrasena;
    private boolean logeado;

    public LoginBean()
    {
        
    }
    
    public LoginBean(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isLogeado() {
        return logeado;
    }

    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }
    
    
    
    public String iniciarSesion() {
     
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
         
        if (nombreUsuario != null && nombreUsuario.equals("admin") && contrasena != null
            && contrasena.equals("admin")) {
            loggedIn = true;
            logeado = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido ", nombreUsuario);
            return "productosDisponibles";
        } else {
            loggedIn = false;
            logeado = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Credenciales inválidos" );
        }
        
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        return null;
       
  }
     public String cerrarSesion() {
     
        logeado = false;
        System.out.println("logeado es :"+ logeado);
        return "index.xhtml";
             
  }
    
}
