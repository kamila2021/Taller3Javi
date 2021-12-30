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
public abstract class Entrega {
    private double peso;
    private int codigo;
    private Cliente remitente;
    private Cliente destinatario;
      protected double valor;
    public Entrega(double peso, int codigo) {
        this.peso = peso;
        this.codigo = codigo;
        remitente = null;
        destinatario = null;
        this.valor = 0;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getRemitente() {
        return remitente;
    }

    public void setRemitente(Cliente remitente) {
        this.remitente = remitente;
    }

    public Cliente getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Cliente destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public String toString() {
        return "Entrega{" + "peso=" + peso + ", codigo=" + codigo + ", remitente=" + remitente + ", destinatario=" + destinatario + '}';
    }
    
    
    
    abstract public double calcularCosto();
}
