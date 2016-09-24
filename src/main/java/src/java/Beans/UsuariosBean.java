package src.java.Beans;

import modelo.Usuario;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by edmildimassimo on 9/22/16.
 */
@ManagedBean(name = "usuariosBean")
@SessionScoped
public class UsuariosBean implements Serializable {
    private String retorno = null;
    private List<Usuario> usuariosRegistrados;
    private int id;
    private String nombreUsuario;
    private String contrasena;
    private boolean admin;

    public UsuariosBean(){
        Usuario admin = new Usuario();
        usuariosRegistrados = new ArrayList<Usuario>();
        admin.setId(1);
        admin.setAdmin(true);
        admin.setContrasena("admin");
        admin.setNombreUsuario("admin");
        usuariosRegistrados.add(admin);
    }

    public List<Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    public void setUsuariosRegistrados(List<Usuario> usuariosRegistrados) {
        this.usuariosRegistrados = usuariosRegistrados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }


    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public String agregarUsuario(){
        Usuario nuevo = new Usuario();
        nuevo.setId(usuariosRegistrados.size() + 1);
        nuevo.setNombreUsuario(nombreUsuario);
        nuevo.setContrasena(contrasena);
        nuevo.setAdmin(admin);
        usuariosRegistrados.add(nuevo);
        return retorno;
    }

    public String borrarUsuario(){
        for(Usuario i : usuariosRegistrados){
            if(i.getId() == id){
                usuariosRegistrados.remove(i);
            }
        }
        return retorno;
    }

    public String verificarUsuario(){
        for(Usuario i : usuariosRegistrados){
            if(nombreUsuario == i.getNombreUsuario() && contrasena == i.getContrasena()){
                return "productos";
            }
        }
        return retorno;
    }
}