/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.java.Beans;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean( name= "language")
@SessionScoped
public class LanguageBean implements Serializable{
    String idiomaSeleccion = "es";

    private Map<String, Object> idiomasMap;

    @PostConstruct
    private void inicializar(){
        idiomasMap = new LinkedHashMap<>();
        idiomasMap.put("Español", "es");
        idiomasMap.put("Ingles", "en");
    }

    public Map<String, Object> getListaIdiomas() {
        return idiomasMap;
    }

    public void cambiarIdioma(ValueChangeEvent event) {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(idiomaSeleccion));
    }

    public String getIdiomaSeleccion() {
        return idiomaSeleccion;
    }

    public void setIdiomaSeleccion(String idiomaSeleccion) {
        this.idiomaSeleccion = idiomaSeleccion;
    }
}
