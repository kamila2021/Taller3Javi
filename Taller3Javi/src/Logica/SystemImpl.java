/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import Dominio.Ciudad;

/**
 *
 * @author javie
 */
public class SystemImpl implements Interface {

    private List<Ciudad> listaCiudades;
    private List<Cliente> listaClientes;
    private ListaEntregas listaEntregas;

    public SystemImpl() {
        listaCiudades = new ArrayList<Ciudad>();
        listaClientes = new LinkedList<Cliente>();
        listaEntregas = new ListaEntregas();
    }

    //ESTE HAY QUE CAMBIARLO. ES EL BUSCARUSUARIO PARA INICIARSESION
    @Override
    public String buscarUsuario(String rut) {
        /*       String salida = "";
        Persona usuario = listaPersonas.buscarCorreo(correo);
        if (usuario != null && usuario instanceof Profesor) {
            salida = "Profesor"; //Cliente
        } else if (usuario != null && usuario instanceof Alumno) {
                salida = "Alumno";
            
        }else{
            salida ="Admin";
                }
        return salida;*/
        return "a";
    }

    //  Entregas por tipo: se debe desplegar por pantalla las entregas por tipo con su valor cobrado.
    @Override
    public String obtenerEntregasPorTipo() {
        return listaEntregas.toStringeEntregasPorTipo();
    }

    @Override
    public String obtenerEntregasPorLocalizacion() {
        String salida = "";

        for (int i = 0; i < listaCiudades.size(); i++) {
            Ciudad ciudad = listaCiudades.get(i);
            salida = salida + "\n" + ciudad.getNomCiudad() + "realizó" + ciudad.getCantEntregas() + "envíos y recibió " + ciudad.getCantRecibidos() + "envíos.";
        }
        return salida;
    }

    @Override
    public String obtenerEntregasPorCliente() {
        String salida = "";
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            salida = salida + "\n" + cliente.getListaEntregasRealizadas().toString();
        }
        return salida;
    }//no dice que cosas de las entregas desplegar

    /**
     * A function to obtain the profits in the system
     *
     * @param
     * @return A string with a profits in the system
     */
    public String ganancias() {
        String salida = "";
        double valor = 0;
        double Total = 0;
        for (Ciudad ciudad : listaCiudades) {
            salida += ciudad.getNomCiudad() + "\n";
            valor = 0;
            for (int i = 0; i < ciudad.getListaEntregas().getSize(); i++) {
                valor += ciudad.getListaEntregas().getElemento(i).getValor();
            }
            salida += "Valor por ciudad: " + valor;
            Total += valor;

        }
        salida += "Valor total" + Total;
        return salida;
    }

//se obtienen todas las entregas del cliente enviados y recibido

    public String obtenerEntregasCliente(String rut) {
        String salida = "";
        for (Cliente cliente : listaClientes) {
            if ((cliente.getRutCliente().equals(rut))) {

                for (int i = 0; cliente.getListaEntregasRealizadas().size > i; i++) {//get size para tener el tamano es como el getCant

                    salida += "Entregas: " + cliente.getListaEntregasRealizadas().getElemento(i);
                }
            } else {
                throw new NullPointerException("El cliente no posee entregas");
            }
        }
        return salida;

    }
    /**
     * A function to obtain the list of all deliverys in the system
     *
     * @param
     * @return A string with a list with all deliverys in the system
     */
    public String entregasTotales() {
        String salida = "";
        for (Cliente cliente : listaClientes) {
            for (int i = 0; i < cliente.getListaEntregasRealizadas().getSize(); i++) {
                Entrega entrega = listaEntregas.getElemento(i);
                salida += cliente.getRutCliente() + " " + " " + entrega.getCodigo();
            }
        }
        return salida;
    }
    @Override //Si la dejamos como void mejor
    public boolean ingresarCiudad(String nombreCiudad) {//AGREGARLOZALIZACION A ARRAYLIST
        boolean salida = true;
        Ciudad nuevaCiudad = new Ciudad(nombreCiudad);
        listaCiudades.add(nuevaCiudad);//add(Ciudad nuevaCiudad);//.add(new Ciudad(nombreCiudad));
        return salida;
    }

    @Override
    public boolean ingresarCliente(String rutCliente, String nomCliente, String apCliente, double saldoCliente, String ciudadOrigen) {
        Cliente nuevoCliente = new Cliente(rutCliente, nomCliente, apCliente, saldoCliente);
        for (int i = 0; i < listaCiudades.size(); i++) {
            if ((listaCiudades.get(i).getNomCiudad()).equals(ciudadOrigen)) {
                nuevoCliente.setCiudad(listaCiudades.get(i));
                return true;
            }
        }
        listaClientes.add(nuevoCliente);
        return false;
    }
/**
     * A function to add balance to a user
     *
     * @param rut, saldo
     * @return true if the balance was entered to the account of the user and
     * false if is not
     */
    public boolean anadirSaldo(String rut, int saldo) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getRutCliente().equals(rut)) {
                double saldoActual = cliente.getSaldoCliente();
                cliente.getSaldoCliente(saldoActual + saldo);
                return true;
            }
        }
        return false;
    }
    @Override
    public String obtenerlista() {

        return (listaClientes.toString());
    }

    @Override
    public boolean ingresarEnvioDocumento(double peso, double grosor, int codigo, String rutR, String rutD) {
        Entrega nuevaEntrega = new EnvioDocumento(grosor, peso, codigo);
        boolean ingreso = false;
        listaEntregas.insertarPrimer(nuevaEntrega);

        for (int i = 0; i < listaClientes.size(); i++) {
            if ((listaClientes.get(i).getRutCliente()).equals(rutR)) {
                Cliente clienteR = listaClientes.get(i);
                clienteR.getListaEntregasRealizadas().insertarPrimer(nuevaEntrega);
                clienteR.getCiudad().setCantEntregas(1);
                clienteR.getCiudad().getListaEntregas().insertarPrimer(nuevaEntrega);
                ingreso = true;

                nuevaEntrega.setRemitente(clienteR);
            }
            if ((listaClientes.get(i).getRutCliente()).equals(rutD)) {
                Cliente clienteD = listaClientes.get(i);
                clienteD.getCiudad().getListaEntregas().insertarPrimer(nuevaEntrega);
                clienteD.getListaEntregasRecibidas().insertarPrimer(nuevaEntrega);
                clienteD.getCiudad().setCantRecibidos(1);

                nuevaEntrega.setDestinatario(clienteD);
            } else {
                ingreso = false;
            }
        }
        return ingreso;

        /*se agregó la entrega a la listaEntregas,la entrega a la listaEntregasRecibidas del rutDestinatario y
    agregar la entrega a la listaEntregasEnviadas del rutRemitente*///agregar la entrega a ciudad
    }

    @Override
    public boolean ingresarEnvioEncomienda(double peso, double largo, double ancho, double grosor, int codigo, String rutR, String rutD) {
        Entrega nuevaEntrega = new EnvioEncomienda(largo, ancho, grosor, peso, codigo);
        boolean ingreso = false;
        listaEntregas.insertarPrimer(nuevaEntrega);

        for (int i = 0; i < listaClientes.size(); i++) {
            if ((listaClientes.get(i).getRutCliente()).equals(rutR)) {
                Cliente clienteR = listaClientes.get(i);
                clienteR.getListaEntregasRealizadas().insertarPrimer(nuevaEntrega);
                clienteR.getCiudad().setCantEntregas(1);
                clienteR.getCiudad().getListaEntregas().insertarPrimer(nuevaEntrega);
                ingreso = true;

                nuevaEntrega.setRemitente(clienteR);
            }
            if ((listaClientes.get(i).getRutCliente()).equals(rutD)) {
                Cliente clienteD = listaClientes.get(i);
                clienteD.getCiudad().getListaEntregas().insertarPrimer(nuevaEntrega);
                clienteD.getListaEntregasRecibidas().insertarPrimer(nuevaEntrega);
                clienteD.getCiudad().setCantRecibidos(1);

                nuevaEntrega.setDestinatario(clienteD);
            } else {
                ingreso = false;
            }
        }
        return ingreso;
    }

    @Override
    public boolean ingresarEnvioValija(String tipoBolso, double peso, int codigo, String rutR, String rutD) {
        Entrega nuevaEntrega = new EnvioValija(tipoBolso, peso, codigo);
        boolean ingreso = false;
        listaEntregas.insertarPrimer(nuevaEntrega);

        for (int i = 0; i < listaClientes.size(); i++) {
            if ((listaClientes.get(i).getRutCliente()).equals(rutR)) {
                Cliente clienteR = listaClientes.get(i);
                clienteR.getListaEntregasRealizadas().insertarPrimer(nuevaEntrega);
                clienteR.getCiudad().setCantEntregas(1);
                clienteR.getCiudad().getListaEntregas().insertarPrimer(nuevaEntrega);
                ingreso = true;

                nuevaEntrega.setRemitente(clienteR);
            }
            if ((listaClientes.get(i).getRutCliente()).equals(rutD)) {
                Cliente clienteD = listaClientes.get(i);
                clienteD.getCiudad().getListaEntregas().insertarPrimer(nuevaEntrega);
                clienteD.getListaEntregasRecibidas().insertarPrimer(nuevaEntrega);
                clienteD.getCiudad().setCantRecibidos(1);

                nuevaEntrega.setDestinatario(clienteD);
            } else {
                ingreso = false;
            }
        }
        return ingreso;
    }

    @Override
    public boolean inicioSesión(String rut) {
        return false;
    }

    @Override
    public boolean realizarEnvio(String rut, String rutDestinatario, double montoEncomienda, double montoPagado) {
        return false;
    }

    @Override
    public boolean recargarSaldo(double monto) {
        return false;
    }

    @Override
    public String obtenerEntregas(String rut) {
        return null;
    }

}
