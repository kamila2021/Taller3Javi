/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;
import Logica.*;
/**
 *
 * @author javie
 */
public class Ciudad {
    private String nomCiudad;
    private ListaEntregas listaEntregas;
    private int cantEntregas;
    private int cantRecibidos;
    

    public Ciudad(String nomCiudad) {
        this.nomCiudad = nomCiudad;
        listaEntregas = new ListaEntregas();
        this.cantEntregas = 0;
        this.cantRecibidos = 0;
    }

    public String getNomCiudad() {
        return nomCiudad;
    }

    public void setNomCiudad(String nomCiudad) {
        this.nomCiudad = nomCiudad;
    }

    public ListaEntregas getListaEntregas() {
        return listaEntregas;
    }

    public void setListaEntregas(ListaEntregas listaEntregas) {
        this.listaEntregas = listaEntregas;
    }

    public int getCantEntregas() {
        return cantEntregas;
    }

    public void setCantEntregas(int cantEntregas) {
        this.cantEntregas = this.cantEntregas + cantEntregas;
    }

    public int getCantRecibidos() {
        return cantRecibidos;
    }

    public void setCantRecibidos(int cantRecibidos) {
        this.cantRecibidos = this.cantRecibidos + cantRecibidos;
    }
    
    
}
