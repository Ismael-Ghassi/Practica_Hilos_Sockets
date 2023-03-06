package Ejercicio_2;

import Ejercicio_1.Monitor;

import java.util.ArrayList;


/**
 * Esta clase ejecutara el metodo 'servidor' de la clase monitor.
 * Esta clase hereda de Thread y asignará un hilo para el servidor
 */
public class Servidor extends Thread{

    protected Ejercicio_2.Monitor m; // Es el objeto de tipo monitor
    protected Maquina maquina; //Es el objeto de tipo maquina


    /**
     * Constructor por parametros que nos sirve para inicializar los objetos de la clase
     * @param m es el objeto monitor
     * @param maquina es el objeto maquina
     */
    public Servidor(Ejercicio_2.Monitor m, Maquina maquina){

        this.m= m;
        this.maquina=maquina;
    }


    /**
     * Dentro de este metodo se encuentra el codigo que ejecutara el hilo.
     * Dentros de este metodo se llamara al metodo servidor de la clase monitor y se le pasara por
     * parametros el objeto maquina inicializado anteriormente.
     */
    public void run(){

        try {
            m.servidor(maquina);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) throws InterruptedException {
        Ejercicio_2.Monitor m = new Ejercicio_2.Monitor(); // Es el objeto monitor

        ArrayList<Refrescos> refrescos = new ArrayList<>(); //ArrayList de refrescos

        /*
        Se declaran los refrescos y se añaden al arrayList
         */
        Refrescos refresco1 = new Refrescos();
        Refrescos refresco2 = new Refrescos();
        refrescos.add(refresco1);
        refrescos.add(refresco2);

        /*
        Se declara un objeto maquina al que se le pasa por parametros el arrayList
        de refrescos.
         */
        Maquina maquina1 = new Maquina(refrescos);

        /*
         Se declara el objeto servidor y se le pasa por parametros el objeto maquina y el objeto monitor
         */
        Servidor s = new Servidor(m,maquina1);

        s.start(); //Se inicia la ejecucion del hilo
    }
}
