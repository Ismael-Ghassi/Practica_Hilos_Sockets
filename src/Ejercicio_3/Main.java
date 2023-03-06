package Ejercicio_3;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        Cerebro_Producto cerebro = new Cerebro_Producto(); //Es el observable

        Organo_Cliente organo = new Organo_Cliente("Corazon"); // Es el observer

        cerebro.addObserver(organo); //suscribimos el observer al obervable
        cerebro.señal(); //Producimos un cambio en el observable



    }
}
