package Ejercicio_2;

import java.io.Serializable;


/**
 * Esta clase nos servira para crear los refrescos para añadirlos mas tarde a un arrayList
 * Esta clase es serializable ya que los objetos de su tipo se mandaran por la red como bytes
 */
public class Refrescos implements Serializable {

    String nomRefresco; //Es el nombre del refresco.

    /**
     * Constructor por defecto que nos servira para asignarle un nombre aleatorio al refresco.
     */
    public  Refrescos(){
        int num = (int) (Math.random()*8);

        if(num==0){
            this.nomRefresco="Coca-Cola";

        }else if (num==1){
            this.nomRefresco="Fanta";

        }else if (num==2){
            this.nomRefresco="Sprite";

        }else if (num==3){
            this.nomRefresco="Tónica";

        }else if (num==4){
            this.nomRefresco="Nestea";

        }else if (num==5){
            this.nomRefresco="Cerveza";

        }else if (num==6){
            this.nomRefresco="Zumo";

        }else if (num==7){
            this.nomRefresco="Agua";

        }


    }

    /**
     *
     * @return el nombre del refresco.
     */
    public String getNomRefresco() {
        return nomRefresco;
    }


    /**
     * Este metodo nos sirve para asignarle un nombre al refresco
     * @param nomRefresco es el nombre del resfresco
     */
    public void setNomRefresco(String nomRefresco) {
        this.nomRefresco = nomRefresco;
    }


    /**
     *
     * @return el nombre del refresco
     */
    @Override
    public String toString() {
        return "Refresco: "+nomRefresco;
    }
}
