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
public class EnvioValija extends Entrega{
    private String tipoBolso;

    public EnvioValija(String tipoBolso, double peso, int codigo) {
        super(peso, codigo);
        this.tipoBolso = tipoBolso;
    }

    public String getTipoBolso() {
        return tipoBolso;
    }

    public void setTipoBolso(String tipoBolso) {
        this.tipoBolso = tipoBolso;
    }
    
    @Override
    public double calcularCosto(){
        double precioMaterial = 0;
        if((this.tipoBolso).equals("Cuero")){
            precioMaterial = 200;
        }
        else if((this.tipoBolso).equals("Plastico")){
            precioMaterial = 150;
        }
        else{
            precioMaterial = 100;
        }
        double valor = precioMaterial *super.getPeso()*150;
        
        return valor;
    }

    @Override
    public String toString() {
        return "EnvioValija{" + "tipoBolso=" + tipoBolso + '}';
    }
    
    
}
