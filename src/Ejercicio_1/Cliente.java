package Ejercicio_1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


/**
 * Esta clase ejecutara el metodo 'cliente' de la clase monitor.
 * Esta clase hereda de Thread y asignará un hilo para el cliente
 */
public class Cliente extends Thread{

    /*
    este objeto de tipo Monitor nos servira para llamar
     al metodo cliente y poder crear un cliente.
     */
    protected Monitor m;


    /**
     * Contructor por parametros que inicializa el objeto de tipo monitor
     * @param m es el objeto monitor
     */
    public Cliente(Monitor m){
        this.m= m;
    }


    /**
     * Dentro de este metodo se encuentra el codigo que se ejecutara al arrancar el hilo
     */
    public void run(){

        try {
            m.cliente(); //Se llama al metodo cliente de monitor.

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Monitor m = new Monitor();//Objeto de tipo monitor que se le pasara a todos los clientes por parametros


        //Se iniciliza a los clientes y se les pasa por parametros el objeto de tipo monitor
        Cliente c = new Cliente(m);
        Cliente c2 = new Cliente(m);
        Cliente c3 = new Cliente(m);
        Cliente c4 = new Cliente(m);


        /**
         * Se ejecutan los clientes.
         * Se ha usado Thread para poder visualizar el proceso de peticiones.
         */
        c.start();
        Thread.sleep(1000);
        c2.start();
        Thread.sleep(1000);
        c3.start();
        Thread.sleep(1000);
        c4.start();
    }

}
