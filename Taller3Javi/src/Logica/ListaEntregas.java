/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Dominio.*;
/**
 *
 * @author javie
 */
public class ListaEntregas {
    private NodoEntrega first;
    private NodoEntrega last;
 public int size;
    public ListaEntregas() {
        first = null;
        last = null;
         size =0;
    }
    
    public void insertarPrimer(Entrega entrega){
        //inserta como primer elemento de la lista
        NodoEntrega nuevoNodoEntrega = new NodoEntrega(entrega);
        
        if(first == null){
            last = nuevoNodoEntrega;
            nuevoNodoEntrega.setPrev(last);
            nuevoNodoEntrega.setNext(last);
            first = nuevoNodoEntrega;
        }
        else{
            nuevoNodoEntrega.setNext(first);
            nuevoNodoEntrega.setPrev(last);
            first.setPrev(nuevoNodoEntrega);
            last.setNext(nuevoNodoEntrega);
            first = nuevoNodoEntrega;
        }
    }
    public Entrega getElemento(int i) {
        NodoEntrega current = this.first;
        for (int pos = 0; pos < i; pos++) {
            current = current.getNext();
        }
        if (current != null) {
            return current.getEntrega();
        }
        return null;
    }
     public int getSize() {
        return size;
    }
    //ITERAR SI
    //BUSCAR
    //ELIMINAR

    @Override
    public String toString() {
        String salida = "\nlistado de entregas\n";
        if(last != null){
            NodoEntrega current = first;
            do{
                salida =salida+ current.getEntrega().toString() +"\n";
                current = current.getNext();
            }while(current != first);
        }
        return salida;
    }
    
    public String toStringeEntregasPorTipo(){
        String salidaD = "\nListado de entregas por tipo\n Entregas de Documento";
        String salidaE = "\n Entregas de Encomienda";
        String salidaV = "\n Entregas de Valija";
        
        if(last != null){
            NodoEntrega current = first;
            do{
                if((current.getEntrega()) instanceof EnvioDocumento){
                salidaD = salidaD + "\n Código: " + current.getEntrega().getCodigo() + "   Valor cobrado: " + current.getEntrega().calcularCosto();
                }
                
                else if((current.getEntrega()) instanceof EnvioEncomienda){
                salidaE = salidaE + "\n Código: " + current.getEntrega().getCodigo() + "   Valor cobrado: " + current.getEntrega().calcularCosto();
                }
                else if((current.getEntrega()) instanceof EnvioValija) {
                salidaV = salidaV + "\n Código: " + current.getEntrega().getCodigo() + "   Valor cobrado: " + current.getEntrega().calcularCosto();
                }
                
                current = current.getNext();
            }while(current != first);
        }
        return (salidaD + salidaE + salidaV);
    }

   

    
    
    public NodoEntrega getFirst() {
        return first;
    }

    public void setFirst(NodoEntrega first) {
        this.first = first;
    }

    public NodoEntrega getLast() {
        return last;
    }

    public void setLast(NodoEntrega last) {
        this.last = last;
    }
    
    
    
}
