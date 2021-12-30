/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author javie
 */
public class EnvioDocumento extends Entrega {
    private double grosor;

    public EnvioDocumento(double grosor, double peso, int codigo) {
        super(peso,codigo);
        this.grosor = grosor;
    }

    public double getGrosor() {
        return grosor;
    }

    public void setGrosor(double grosor) {
        this.grosor = grosor;
    }
    
    @Override
    public double calcularCosto(){
        double valor = super.getPeso()*this.grosor*100;
        return valor;
    }

    @Override
    public String toString() {
        return "EnvioDocumento{" + "grosor=" + grosor + '}';
    }
    
}
