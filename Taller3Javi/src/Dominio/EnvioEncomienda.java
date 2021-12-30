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
public class EnvioEncomienda extends Entrega{
    private double largo;
    private double ancho;
    private double profundidad;

    public EnvioEncomienda(double largo, double ancho, double profundidad, double peso, int codigo) {
        super(peso, codigo);
        this.largo = largo;
        this.ancho = ancho;
        this.profundidad = profundidad;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }
    
    @Override
    public double calcularCosto(){
        double volumen = this.largo* this.ancho * this.profundidad;
        double valor = super.getPeso()*volumen*50;
        
        return valor;
    }

    @Override
    public String toString() {
        return "EnvioEncomienda{" + "largo=" + largo + ", ancho=" + ancho + ", profundidad=" + profundidad + '}';
    }
    
}
