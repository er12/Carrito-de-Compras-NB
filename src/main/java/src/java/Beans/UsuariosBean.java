package src.java.Beans;

import modelo.Usuario;
import java.util.Locale;

import java.util.Iterator;
import javax.faces.event.ActionEvent;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;


/**
 * Created by edmildimassimo on 9/22/16.
 */
@ManagedBean(name = "usuariosBean")
@SessionScoped
public class UsuariosBean implements Serializable {
    private String retorno = null;
    private int cantUsuarios = 0;
    private List<Usuario> usuariosRegistrados;
    private int id;
    private String nombreUsuario;
    private String contrasena;
    private boolean isAdmin;
    private boolean newIsAdmin;
    private boolean logeado;
    
    @PostConstruct
    public void init(){
         Usuario admin = new Usuario();
         usuariosRegistrados = new ArrayList<Usuario>();
         admin.setId(0);
         admin.setAdmin(true);
         admin.setContrasena("admin");
         admin.setNombreUsuario("admin");
         usuariosRegistrados.add(admin);
         cantUsuarios++;
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

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isLogeado() {
        return logeado;
    }

    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }
    
    


    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public int getCantUsuarios() {
        return cantUsuarios;
    }

    public void setCantUsuarios(int cantUsuarios) {
        this.cantUsuarios = cantUsuarios;
    }

    public boolean isNewIsAdmin() {
        return newIsAdmin;
    }

    public void setNewIsAdmin(boolean newIsAdmin) {
        this.newIsAdmin = newIsAdmin;
    }
    
    

    public String agregarUsuario(){
        Usuario nuevo = new Usuario();
        nuevo.setId(cantUsuarios);
        nuevo.setNombreUsuario(nombreUsuario);
        nuevo.setContrasena(contrasena);
        nuevo.setAdmin(isAdmin);
        usuariosRegistrados.add(nuevo);
        return "productosDisponibles?faces-redirect=true";
    }

    public String borrarUsuario(){
        logeado = false;
        
        //TODO: 
        for(Usuario i : usuariosRegistrados){
            if(i.getId() == id){
                usuariosRegistrados.remove(i);
            }
        }
        return "index?faces-redirect=true";
    }

    public String verificarUsuario(){
         RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        
        
        for(Usuario i : usuariosRegistrados){
            if(nombreUsuario.equals(i.getNombreUsuario()) && contrasena.equals(i.getContrasena())){
                logeado = true;
                loggedIn = true;
                isAdmin = i.isAdmin();
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido ", nombreUsuario);
                context.addCallbackParam("loggedIn", loggedIn);
                return "productosDisponibles?faces-redirect=true";
            }
        }
        
         logeado = false;
         message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Credenciales inválidos" );
      
            FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        return null;
       
    }
    
    
    public void crearUsuario()
    {
        if(usernameIsValid(nombreUsuario)){
            usuariosRegistrados.add(new Usuario(cantUsuarios, nombreUsuario, contrasena, newIsAdmin));
            cantUsuarios++;
            addMessage("Usuario creado!");
        }
        addMessage("Nombre de usuario ya existe!");
    }
    
    public String goHome(){
        return "productosDisponibles?faces-redirect=true";
    }
    
     public void eliminar(int DelId) {
        
        Iterator<Usuario> i = usuariosRegistrados.iterator();
        while (i.hasNext()) {
           Usuario u = i.next(); // must be called before you can call i.remove()
           if(u.getId() == DelId)
           {
               i.remove();
               addMessage("Usuario eliminado!");
               return;
           }
        }
        addMessage("Usuario no eliminado!");   
    }
    
    public boolean usernameIsValid(String user)
    {
        for(Usuario u : usuariosRegistrados)
        {
            if(u.getNombreUsuario().equals(user))
                return false;
        }
        return true;
    }
     
    public void addMessage(String summary) {
       FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
       FacesContext.getCurrentInstance().addMessage(null, message);
    }
}