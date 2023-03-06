package Ejercicio_3;

import java.awt.image.ImageObserver;
import java.util.Observable;
import java.util.Observer;


/**
 * Esta clase nos servira para notificar a los organos de que se ha producido una señal usando los metodos
 * heredados de Observable.
 */
public class Cerebro_Producto extends Observable {


    private Observer observer; //Objeto observer que se inicializara mas tarde


    /**
     * Este metodo hace una llamada al metodo que definiremos mas adelante notifyObserver que notificara al cliente
     * que este suscrito.
     */
    public void señal(){
        notifyObservers();
    }


    /**
     * Este metodo (de la clase observable) sirve para inicializar el objeto observer de la clase.
     * @param observer   an observer to be added.
     */
    public void addObserver(Observer observer){
        this.observer= observer;
    }


    /**
     * Metodo de la clase observable que notificara a todos los clientes que esten suscritos
     */
    public void notifyObservers(){

        if(observer !=null){ //si es distinto a null entra al if.

            /**
             * Usamos el metodo update de la clase observer para notificar al cliente de un cambio.
             * Se le pasa por parametros un objeto observable (la clase en si) y un String que le servira para identificar
             * el tipo de cambio.
             */
            observer.update(this,"Organo");
        }
    }
}
