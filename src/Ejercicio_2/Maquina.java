package Ejercicio_2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta clase representa una maquina expendedora.
 * Esta clase es serializable ya que se mandan objetos de su tipo por la red.
 */
public class Maquina implements Serializable {

    /**
     * ArrayList de tipo refresco donde se almacenaran los refrescos
     * con los que cuenta la maquina.
     */
    ArrayList<Refrescos> refrescos;


    /**
     * Constructor por parametros donde se inicializara el arrayList de refrescos.
     * @param refrescos es el arrayList de refrescos
     */
    public Maquina(ArrayList<Refrescos> refrescos) {
        this.refrescos = refrescos;
    }


    /**
     *
     * @return el arrayList de refrescos.
     */
    public ArrayList<Refrescos> getRefrescos() {
        return refrescos;
    }


    /**
     * Inicializa el arrayList de refrescos
     * @param refrescos es el arrayList de refrescos
     */
    public void setRefrescos(ArrayList<Refrescos> refrescos) {
        this.refrescos = refrescos;
    }


    /**
     *
     * @return la cantidad de refrescos.
     */
    public int cantidadRefrescos(){
        return refrescos.size();
    }
}
