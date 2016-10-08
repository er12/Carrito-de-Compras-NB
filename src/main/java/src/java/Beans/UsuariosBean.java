package src.java.Beans;

import src.java.modelo.Usuario;

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
    private int cantUsuarios=0;
    private List<Usuario> usuariosRegistrados;
    private int id;
    private String nombreUsuario;
    private String contrasena;
    private boolean isAdmin;
    private boolean NewisAdmin;
    private boolean logeado;
    
    @PostConstruct
    public void init(){
         Usuario admin = new Usuario();
         usuariosRegistrados = new ArrayList<Usuario>();
         admin.setId(1);
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

    public boolean isNewisAdmin() {
        return NewisAdmin;
    }

    public void setNewisAdmin(boolean NewisAdmin) {
        this.NewisAdmin = NewisAdmin;
    }
    
    

    public String agregarUsuario(){
        Usuario nuevo = new Usuario();
        nuevo.setId(usuariosRegistrados.size() + 1);
        nuevo.setNombreUsuario(nombreUsuario);
        nuevo.setContrasena(contrasena);
        nuevo.setAdmin(isAdmin);
        usuariosRegistrados.add(nuevo);
        return "productosDisponibles?faces-redirect=true";
    }

    public String borrarUsuario(){
        logeado = false;
        
        //TODO: queseto?
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
                isAdmin = true;
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
        usuariosRegistrados.add(new Usuario(cantUsuarios, nombreUsuario, contrasena, NewisAdmin));
        cantUsuarios++;
    }
}