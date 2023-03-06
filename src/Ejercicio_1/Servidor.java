package Ejercicio_1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Esta clase ejecutara el metodo 'servidor' de la clase monitor.
 * Esta clase hereda de Thread y asignará un hilo para el servidor
 */
public class Servidor extends Thread {

    /*
    este objeto de tipo Monitor nos servira para llamar
     al metodo servidor y poder arrancar el servidor
     */
    protected Monitor m;


    /**
     * Contructor por parametros que inicializa el objeto de tipo monitor
     * @param m es el objeto monitor
     */
    public Servidor(Monitor m){
        this.m= m;
    }


    /**
     * Dentro de este metodo se encuentra el codigo que se ejecutara al arrancar el hilo.
     */
    public void run(){

        try {
            m.servidor(); //Se llama al metodo servidor de monitor.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }



    public static void main(String[] args) throws InterruptedException {
        /*
        Objeto de tipo monitor que pasaremos por parametros a la clase servidor.
         */
        Monitor m = new Monitor();
        Servidor s = new Servidor(m); //Objeto de tipo servidor

        s.start(); //Se arranca la ejecucion.
    }
}
