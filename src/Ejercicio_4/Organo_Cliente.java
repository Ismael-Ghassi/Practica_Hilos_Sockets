package Ejercicio_4;

import java.util.Observable;
import java.util.Observer;

/**
 * Esta clase emitira un mensaje cada vez que se produzca un cambio en el observable donde
 * este suscrita.
 */
public class Organo_Cliente implements Observer {


    private String tipoOrgano; //Es el nombre del organo


    /**
     * Constructor por parametros que inicializa el objeto con un nombre
     * @param tipoOrgano es el nombre del organo
     */
    public Organo_Cliente(String tipoOrgano) {
        this.tipoOrgano = tipoOrgano;
    }


    /**
     *
     * @return el nombre del organo
     */
    public String getTipoOrgano() {
        return tipoOrgano;
    }

    /**
     * Este metodo nos permite darle un nombre al organo
     * @param tipoOrgano es el nombre del organo
     */
    public void setTipoOrgano(String tipoOrgano) {
        this.tipoOrgano = tipoOrgano;
    }


    /**
     * metodo de la interfaz observer que se ejecutara cada vez que se produzca un cambio
     * en el observable donde estemos suscritos.
     * @param o     the observable object.
     * @param arg   an argument passed to the {@code notifyObservers}
     *                 method.
     */
    @Override
    public void update(Observable o, Object arg) {

        if(((String)arg).equals("Organo")){
            System.out.println("La señal se ha mandado al "+tipoOrgano);
        }
    }
}
