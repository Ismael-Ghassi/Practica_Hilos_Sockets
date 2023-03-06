package Ejercicio_4;



public class Main {

    public static void main(String[] args) throws InterruptedException {

        Cerebro_Producto cerebro = new Cerebro_Producto(); //Es el objeto observable

        /**
         * Son los objetos observer que se añadiran al observable
         */
        Organo_Cliente organo = new Organo_Cliente("Corazon");
        Organo_Cliente organo2 = new Organo_Cliente("Riñon");


        /**
         * Añadimos los objetos al observable
         */
        cerebro.addObserver(organo);
        cerebro.addObserver(organo2);


        Thread hilo1 = new Thread(cerebro); //Conversion de Runnable a Thread del objeto observable
        hilo1.start(); //Arrancamos el hilo






        Cerebro_Producto cerebro2 = new Cerebro_Producto(); //Es el objeto observable

        /**
         * Son los objetos observer que se añadiran al observable
         */
        Organo_Cliente organo3 = new Organo_Cliente("Estomago");
        Organo_Cliente organo4 = new Organo_Cliente("Torax");

        /**
         * Añadimos los objetos al observable
         */
        cerebro.addObserver(organo3);
        cerebro.addObserver(organo4);


        Thread hilo2 = new Thread(cerebro2); //Conversion de Runnable a Thread del objeto observable
        hilo2.start(); //Arrancamos el hilo










    }
}
