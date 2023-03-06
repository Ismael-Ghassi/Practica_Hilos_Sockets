package Ejercicio_2;

/**
 * Esta clase hereda de Thread y nos permitira pedir una cantidad de bebidas al servidor.
 *
 */
public class Cliente extends Thread{


    /**
     * Objeto de tipo monitor que nos permitira llamar
     * al metodo cliente para crear un cliente.
     */
    protected Ejercicio_2.Monitor m;
    protected String numeroBebidas; //Es el numero de bebidas que queremos solicitar.


    /**
     * Constructor por parametros que nos permitira inicializar el objeto monitor e indicar
     * el numero de bebidas que queremos.
     * @param m es el objeto monitor.
     * @param numeroBebidas es el numero de bebidas.
     */
    public Cliente(Ejercicio_2.Monitor m, String numeroBebidas){
        this.m= m;
        this.numeroBebidas=numeroBebidas;
    }


    /**
     * Dentros de este metodo se encuentra la llamada al metodo cliente de la clase
     * monitor al que se le tiene que indicar el numero de bebidas que queremos solicitar.
     * Este metodo sera ejecutado al iniciar el hilo.
     */
    public void run(){

        try {
            m.cliente(numeroBebidas+"  ");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Monitor m = new Monitor(); //Objeto de tipo monitor con el que se inicializara a los clientes.


        String numBebidas=2+""; //Es el numero de bebidas
        Cliente c = new Cliente(m,numBebidas); //Es el cliente 1

        c.start();


        /*
        String numBebidas=1+""; //Es el numero de bebidas
        Cliente c = new Cliente(m,numBebidas); //Es el cliente 1

        c.start(); //Se inicia el hilo

        Thread.sleep(1000); // Usamos sleep para dormir el hilo y que no ocurra el proceso tan rapido.

        String numBebidas2=1+"";//Es el numero de bebidas
        Cliente c2 = new Cliente(m,numBebidas2); //Es el cliente 2

        c2.start(); //Se inicia el hilo
         */

    }
}
