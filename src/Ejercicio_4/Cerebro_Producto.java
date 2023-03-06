package Ejercicio_4;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


/**
 * Esta clase nos servira para notificar a los organos de que se ha producido una señal usando los metodos
 * heredados de Observable.
 * Estan clase hereda de Runnable por lo tanto, gracias a una conversion a Thread, podremos crear diferentes hilos de
 * observable.
 */
public class Cerebro_Producto extends Observable implements Runnable{

    /**
     * ArrayList de tipo Observer que almacenara a los clientes que esten suscritos.
     */
    private ArrayList<Observer> observer= new ArrayList<>();


    /**
     * Este metodo hace una llamada al metodo que definiremos mas adelante notifyObserver que notificara a los clientes
     * que esten suscritos.
     */
    public void señal(){
        notifyObservers();
    }


    /**
     * Este metodo (de la clase observable) sirve para añadir un observer al arrayList.
     * Este metodo esta sincronizado para garantizar que se añaden de uno en uno.
     * @param observer   an observer to be added.
     */
    public synchronized void  addObserver(Observer observer){

        this.observer.add(observer);
    }


    /**
     * Este metodo notificara a todos los clientes suscritos de que se ha producido un cambio.
     * Es un metodo de la clase onservable.
     */
    public void notifyObservers(){

        if(observer !=null){

            /**
             * Este vucle notificara a todos los clientes suscritos que se encuentren en el arrayList
             */
            for(int i=0; i<this.observer.size();i++){

                /**
                 * Usamos el metodo update de la clase observer para notificar al cliente de un cambio.
                 * Se le pasa por parametros un objeto observable (la clase en si) y un String que le servira para identificar
                 * el tipo de cambio.
                 */
                observer.get(i).update(this,"Organo");
                try {
                    Thread.sleep(300); //Se usa sleep para simular un tiempo en cada notificacion.
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    /**
     * Dentro de este metodo se encuentra el codigo que se ejecutara cuando arranquemos el hilo.
     * Dentro se encuentra una llamada del metodo 'señal' de la misma clase.
     */
    @Override
    public void run() {
        señal();
    }
}
