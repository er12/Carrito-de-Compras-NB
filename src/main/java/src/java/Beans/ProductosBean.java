package src.java.Beans;


/**
 * Created by edmildimassimo on 9/22/16.
 */
/**
 *
 * @author Ernesto
 */

import helper.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import src.java.modelo.Producto;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.io.FileUtils;
import org.primefaces.event.FileUploadEvent;
import src.java.modelo.Rating;
import org.primefaces.event.RateEvent;
import org.primefaces.model.ByteArrayContent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
//import javax.ejb.EJB;

@ManagedBean(name = "productoBean")
@SessionScoped
public class ProductosBean implements Serializable{
    private List<Producto> productos;
    private int id;
    private int ids = 0;
    private String nombre;
    private String description;
    private int cantidad;
    private double precio;
    private int rating;
    private ArrayList<UploadedFile> files = new ArrayList<>();;
    private Producto producto;
    private List<StreamedContent> listImage = null;
    
    @PostConstruct
    public void init()
    {
        Tienda.obtenerInstancia().getProductosDisponibles().add(new Producto(99,"Arroz","Pimco",2,100));
        
        //Tienda.obtenerInstancia().getProductosDisponibles().get(0).getRatings().add(r);      
    }
    
    public ProductosBean(){
        
        
    }

    public List<Producto> getProductos() {
        return Tienda.obtenerInstancia().getProductosDisponibles();
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
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

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public ArrayList<UploadedFile> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<UploadedFile> files) {
        this.files = files;
    }
    
    
    
    public String agregarProducto(){
        //Crear
        Tienda.obtenerInstancia().insertarProducto(nombre,description,cantidad,precio,files);
        files = new ArrayList<>();
        productos = Tienda.obtenerInstancia().getProductosDisponibles();
        
        return "productosDisponibles?faces-redirect=true";
                
    }
    
    public String addToCart(int pId){
        
        for(Producto p : Tienda.obtenerInstancia().getProductosDisponibles())
        {
            if(p.getId() == pId)
            {
                Tienda.obtenerInstancia().getCarrito().add(p);
                Tienda.obtenerInstancia().getProductosDisponibles().remove(p);
                return null;
            }
        }
        return null;
    }
    /*
    public int totalRatings(Producto producto)
    {
        if(producto.getRatings().isEmpty())
            return 0;
        
        int sum = 0;
        
        for(Rating r : producto.getRatings())
            sum += r.getRating();

        return sum / producto.getRatings().size();
    }
    
    public Integer productoUserRating(Producto p , int UId)
    { 
        for(Rating r : p.getRatings())
        {
            if(r.getID_Usuario() == UId)
                return r.getRating();
        }
        return 0;
    }
    
    public void onrate(RateEvent rateEvent) {
       
        
       
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Evaluacion", ""+((Integer) rateEvent.getRating()).intValue());
      FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Evaluación", "Cancelada");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public boolean rateUserExists(int UId)
    {
        for(Rating r : producto.getRatings())
        {
            if(r.getID_Usuario() == UId)
                return true;
        }
        return false;
    }
    
    public void createRate(int rate, int UId)
    {
        if(rateUserExists(UId)){
            deleteRate(UId);
        }
        
        producto.getRatings().add(new Rating(0,producto.getId(),UId, rate));
        
        
        
    }
    
    public void deleteRate(int UId)
    {
        for(Rating r : producto.getRatings())
        {
            if(r.getID_Usuario() == UId)
            {
                producto.getRatings().remove(r);
                return;
            }
        }
        
    }
    
  */  
    
    //-----------------------------------Upload
    
    public void handleFileUpload(FileUploadEvent event) {
        
        files.add(event.getFile());
        
        /*UploadedFile uploadedFile = (UploadedFile)event.getFile();
        
         //create an InputStream from the uploaded file
        InputStream inputStr = null;
        try {
            inputStr = uploadedFile.getInputstream();
        } catch (IOException e) {
            System.out.println("Error0");
        }

        //create destination File
        String destPath = "C:\\temp\\";
        File destFile = new File(destPath);

        //use org.apache.commons.io.FileUtils to copy the File
        try {                    
            FileUtils.copyInputStreamToFile(inputStr, destFile);
        } catch (IOException e) {
            System.out.println("Error");
        }*/
        FacesMessage message = new FacesMessage("Archivo", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public List<String> getImagenes(Producto p)
    {
        List<String> images = new ArrayList<>();
        
        images.add("arroz.jpg"); 
                
        
        
        listImage = new ArrayList<>();
        for(UploadedFile uf : p.getUpFiles()){
            listImage.add(new DefaultStreamedContent(new ByteArrayInputStream(uf.getContents()), "image/jpg"));
            //listImage.add(uf.getFileName());   
        }
        
        return images;
        
    }
    
            
    
}