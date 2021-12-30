/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.IOException;
//import ucn.ArchivoEntrada;
//import ucn.Registro;
//import ucn.StdIn;
//import ucn.StdOut;
import java.util.Scanner;
import java.io.BufferedReader;
//import java.io.BufferedWriter; //SI ES QUE NO HAY QUE SOBREESCRIBIR NO TENEMOS QUE USAR ESTE??
import java.io.FileReader;
//import java.io.FileWriter;  //SI ES QUE NO HAY QUE SOBREESCRIBIR NO TENEMOS QUE USAR ESTE??

/**
 *
 * @author javie
 */
public class Taller3Javi {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args)throws Exception {
        Interface sistema = new SystemImpl();
        leerLocalizacion(sistema);
        leerCliente(sistema);
        leerEntregas(sistema);
        menu(sistema);
        
        
    }
    
    public static void leerLocalizacion(Interface sistema)throws IOException{
         BufferedReader arch = new BufferedReader(new FileReader("localización.txt"));
            String linea;
            
            while ((linea = arch.readLine()) != null) {
                String[] elementos = linea.split(",");
                String nomCiudad = elementos[0];
                boolean salida = sistema.ingresarCiudad(nomCiudad);//AGREGARCIUDAD A ARRAYLIST
            }
        
    }
    
    public static void leerCliente(Interface sistema)throws IOException{
        try (BufferedReader arch = new BufferedReader(new FileReader("Cliente.txt"))) {
            String linea;
            
            while ((linea = arch.readLine()) != null) {
                String[] elementos = linea.split(",");
                String rut = elementos[0];
                String nombre = elementos[1];
                String apellido = elementos[2];
                Double saldo = Double.parseDouble(elementos[3]);
                String ciudadOrigen = elementos[4];
                boolean salida = sistema.ingresarCliente(rut, nombre, apellido, saldo, ciudadOrigen);
            }
        }
    }
    
    public static void leerEntregas(Interface sistema)throws IOException{
        try (BufferedReader arch = new BufferedReader(new FileReader("Entregas.txt"))) {
            String linea;
            
            while ((linea = arch.readLine()) != null) {
                String[] elementos = linea.split(",");
                int codigoEntrega = Integer.parseInt(elementos[0]);
                String tipoEntrega = elementos[1];
                String rutRemitente = elementos[2];
                String rutDestinatario = elementos[3];
                
                switch(tipoEntrega){
                    case "D":
                        Double pesoKGD = (Double.parseDouble(elementos[4]))/1000;
                        Double grosorCMD = (Double.parseDouble(elementos[5]))/10;
                        boolean salida = sistema.ingresarEnvioDocumento(pesoKGD,grosorCMD,codigoEntrega,rutRemitente,rutDestinatario);
                        //double peso,double grosor,double codigo
                        break;
                        
                    case "E":
                        Double pesoKGE = (Double.parseDouble(elementos[4]))/1000;
                        Double largoME = (Double.parseDouble(elementos[5]))/100;
                        Double anchoME = (Double.parseDouble(elementos[6]))/100;
                        Double profundidadME = (Double.parseDouble(elementos[7]))/100;
                        
                        break;
                        
                    case "V":
                        String material = elementos[4];
                        Double pesoKGV = (Double.parseDouble(elementos[5]))/1000;
                        
                        break;
                }
                
            }
        }
    }
    
    public static void obtenerOpcionesCliente(){
        System.out.println("");
        System.out.println("[1]: Realizar una entrega");
        System.out.println("[2]: Recargar saldo");
        System.out.println("[3]: Ver tus entregas");
        System.out.println("[4]: Salir");
        System.out.println("");
    }
    
    public static void obtenerOpcionesAdmin(){
        System.out.println("");
        System.out.println("[1]: Ver entregas por tipo");
        System.out.println("[2]: Ver entregas por localización");
        System.out.println("[3]: Ver entregas por cliente");
        System.out.println("[4]: Ver registro de ganancias");
        System.out.println("[5]: Salir");
        System.out.println("");
    }
    
    public static void menu(Interface sistema)throws IOException{
        Scanner entrada = new Scanner(System.in);
        int opcion;
        int opcion1;
        String rut;
        String estado;
        
        System.out.println("BIENVENIDO");
        System.out.println("1-Iniciar Sesion");
        System.out.println("2-Salir del sistema");
        System.out.println();
        
        do{
            System.out.print("Ingrese una opcion: ");
            opcion1 = Integer.parseInt(entrada.nextLine());
        }while(opcion1 <=0 || opcion1 >2);
        
        
        while(opcion1!=2){
            //ACÁ PEDIR RUT y verificar si está o no. Si no está se debe mostrar la
            //opción para crear un nuevo cliente con dicho Rut
            System.out.print("Ingrese su rut: ");
            rut = entrada.nextLine();
            estado = "Admin";
            
            
            switch(estado){
                case "Cliente":
                    obtenerOpcionesCliente();
                    do {
                        System.out.print("ingrese opcion: " );
                        opcion = Integer.parseInt(entrada.nextLine());
                    }while(opcion <=0 || opcion >4);
        
                    while(opcion != 4) {
                        switch(opcion) {
                            case 1:
                                realizarUnaEntrega(sistema);
                                break;
                            case 2:
                                recargarSaldoCliente(sistema);
                                break;
                            case 3:
                                obtenerEntregasCliente(sistema);
                                break;
                        }
                        obtenerOpcionesCliente();
        
                        do{
                            System.out.print("ingrese opcion: " );
                            opcion = Integer.parseInt(entrada.nextLine());
                        }while(opcion <=0 || opcion >4);
                    }
                    opcion=5;
                    
                
                
                case "Admin":
                    obtenerOpcionesAdmin();
                    do {
                        System.out.print("ingrese opcion: " );
                        opcion = Integer.parseInt(entrada.nextLine());
                    }while(opcion <=0 || opcion >5);
        
                    while(opcion != 5) {
                        switch(opcion) {
                            case 1:
                                System.out.println(sistema.obtenerEntregasPorTipo());
                                break;
                            case 2:
                                System.out.println(sistema.obtenerEntregasPorLocalizacion());
                                break;
                            case 3:
                                System.out.println(sistema.obtenerEntregasPorCliente());
                                System.out.println(sistema.obtenerlista());
                                break;
                            case 4:
                                System.out.println(sistema.obtenerRegistroDeGanancias());
                                break;
                        }
                        obtenerOpcionesAdmin();
        
                        do{
                            System.out.print("ingrese opcion: " );
                            opcion = Integer.parseInt(entrada.nextLine());
                        }while(opcion <=0 || opcion >5);
                    }
                    
                    
            }
            
            System.out.println("1-Iniciar Sesion");
            System.out.println("2-Salir del sistema");
            System.out.println();
            
            do{
                System.out.print("Ingrese una opcion: ");
                opcion1 = Integer.parseInt(entrada.nextLine());
            }while(opcion1 <=0 || opcion1 >2);
            
        }
        //llamar a sobreEscribirArchivos
    }
    
    
    public static void sobreEscribirArchivos(Interface sistema)throws IOException{
    //sobreescribir archivo Cliente.txt y Entregas.txt con clientes y envios nuevos
    }
    
    private static void realizarUnaEntrega(Interface sistema) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void recargarSaldoCliente(Interface sistema) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void obtenerEntregasCliente(Interface sistema) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}