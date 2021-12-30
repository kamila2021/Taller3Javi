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
public class Cliente {
    private String rutCliente;
    private String nomCliente;
    private String apCliente;
    private double saldoCliente;
    private Ciudad ciudad;
    private ListaEntregas listaEntregasRealizadas;
    private ListaEntregas listaEntregasRecibidas;

    public Cliente(String rutCliente, String nomCliente, String apCliente, double saldoCliente) {
        this.rutCliente = rutCliente;
        this.nomCliente = nomCliente;
        this.apCliente = apCliente;
        this.saldoCliente = saldoCliente;
        ciudad = null;
        listaEntregasRealizadas = new ListaEntregas();
        listaEntregasRecibidas = new ListaEntregas();
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getApCliente() {
        return apCliente;
    }

    public void setApCliente(String apCliente) {
        this.apCliente = apCliente;
    }

    public double getSaldoCliente() {
        return saldoCliente;
    }

    public void setSaldoCliente(double saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public ListaEntregas getListaEntregasRealizadas() {
        return listaEntregasRealizadas;
    }

    public void setListaEntregasRealizadas(ListaEntregas listaEntregasRealizadas) {
        this.listaEntregasRealizadas = listaEntregasRealizadas;
    }

    public ListaEntregas getListaEntregasRecibidas() {
        return listaEntregasRecibidas;
    }

    public void setListaEntregasRecibidas(ListaEntregas listaEntregasRecibidas) {
        this.listaEntregasRecibidas = listaEntregasRecibidas;
    }

    


    
}
