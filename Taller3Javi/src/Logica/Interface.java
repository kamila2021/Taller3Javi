/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author javie
 */
public interface Interface {
    public String buscarUsuario(String rut);
    public boolean ingresarCliente(String rutCliente,String nomCliente,String apCliente,double saldoCliente,String Ciudad);
    public boolean ingresarCiudad(String nomCiudad);
    public boolean ingresarEnvioDocumento(double peso,double grosor,int codigo,String rutRemitente,String rutDestinatario);
    public boolean ingresarEnvioEncomienda(double peso,double largo,double ancho,double grosor,int codigo,String rutRemitente,String rutDestinatario);
    public boolean ingresarEnvioValija(String tipoBolso,double peso,int codigo,String rutR,String rutD);
    public boolean inicioSesión(String rut);
    public boolean realizarEnvio(String rut,String rutDestinatario,double montoEncomienda,double montoPagado);
    public boolean recargarSaldo (double monto);
    public String obtenerEntregas (String rut);
    public String obtenerEntregasPorTipo ();
    public String obtenerEntregasPorLocalizacion ();
    public String obtenerEntregasPorCliente ();
    public String obtenerRegistroDeGanancias ();
    public String obtenerlista();
}
