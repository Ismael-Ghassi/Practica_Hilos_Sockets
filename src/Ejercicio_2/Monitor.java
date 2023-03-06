package Ejercicio_2;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


/**
 * En esta clase se encuentran los metodos para arrancar el servidor y los clientes.
 */
public class Monitor {


    /**
     * Gracias a este metodo podremos crear a un cliente que realizara una peticion con
     * una cantidad especifica de bebidas.
     * @param numRefrescos es el cantidad de bebidas.
     * @throws InterruptedException
     */
    public void cliente(String numRefrescos) throws InterruptedException {
        try {


            Socket clienteS = new Socket(); //Es el socket para el cliente.

            /**
             * Se crea un objeto de tipo 'InetSocketAddress' y se le asigna una ip y un puerto que
             * deben ser los mismos que en el servidor.
             */
            InetSocketAddress iddr = new InetSocketAddress("192.168.56.1", 5555);
            clienteS.connect(iddr); //Se conecta al cliente al servidor

            /**
             * El objeto is sirve para poder leer los objetos que se reciben del servidor
             */
            ObjectInputStream is = new ObjectInputStream(clienteS.getInputStream());
            OutputStream os = clienteS.getOutputStream(); //Para poder mandar mensajes al servidor


            String peticion = numRefrescos; //Es la peticion con el numero de refrescos.
            os.write(peticion.getBytes()); //Se mada la peticion al servidor


            /**
             * Dentro de este vucle se leen los refrescos devueltos por el servidor
             */
            for(int i =0; i<Integer.parseInt(numRefrescos.substring(0,1));i++){
                Refrescos refresco = (Refrescos) is.readObject();
                System.out.println(refresco.toString());
            }

            clienteS.close(); //se cierra la conexion


        }catch (IOException e){
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * este metodo nos servira crear y arrancar el servidor.
     * El servidor no se cerrara hasta que se quede sin refrescos
     * Este metodo esta sincronizado para evitar que varios clientes accedan a el.
     * @param maquina es la maquina que se administrara con el servidor
     * @throws InterruptedException
     */
    public synchronized void servidor(Maquina maquina) throws InterruptedException {

        try {


            ServerSocket servidorSS = new ServerSocket(); //Este objeto nos servira para arrancar el servidor.

            /**
             * Se crea un objeto de tipo 'InetSocketAddress' y se le asigna una ip y un puerto para poder
             * identificar al servidor en la red.
             */
            InetSocketAddress addr = new InetSocketAddress("192.168.56.1", 5555);
            servidorSS.bind(addr); //Se le asigna al servidor su direccion

            Socket newSocket; //Se crea un Socket para poder recibir y enviar mensajes al cliente
            System.out.println("Servidor escuchando");


            /**
             * cantidad es la cantidad de resfrescos que tiene la maquina.
             * En un principio se inicializa llamando al metodo cantidadResfrescos de la clase
             * maquina.
             */
            int cantidad= maquina.cantidadRefrescos();
            while (true) {


                System.out.println("La cantidad es: "+cantidad);


                newSocket = servidorSS.accept(); //A partir de este punto el servidor empieza a aceptar peticiones.

                InputStream is = newSocket.getInputStream(); //Nos servira para poder recibir mensajes
                ObjectOutputStream os = new ObjectOutputStream(newSocket.getOutputStream()); //Para poder mandar objetos

                byte[] peticion = new byte[25]; //Array de byte donde se almacenara la peticion del cliente
                is.read(peticion); //Se lee la peticion
                String mensaje = new String(peticion, StandardCharsets.UTF_8); //Convertimos la peticion en String
                System.out.println(mensaje); //Mensaje por pantalla de la peticion


                /*
                Este objeto int almacena la cantidad de refrescos solicitada por el cliente.
                Esta cantidad se extrae del mensaje recibido por el cliente.
                 */
                int cantidadSolicitada = Integer.parseInt(mensaje.substring(0,1));



                //Si la cantidad solicitada supera a la existente
                if(cantidadSolicitada>cantidad){
                    System.err.println("Cantidad solicitada supera a la existente");

                    for(int i=0;i< maquina.cantidadRefrescos();i++){
                        os.writeObject(maquina.getRefrescos().get(i)); //Manda el objeto
                        cantidad--; //disminuye la cantidad existente
                    }

                    newSocket.close();
                    servidorSS.close();

                //Si la cantidad solicitada es menor o igual que la existente.
                }else if (cantidadSolicitada<=cantidad){
                    for(int i=0;i<cantidadSolicitada;i++){
                        os.writeObject(maquina.getRefrescos().get(i)); //Manda el objeto
                        cantidad--; //disminuye la cantidad existente
                    }
                    newSocket.close();
                }


                //Si la cantidad restante es 0 se emite un mensaje y se cierra el servidor
                if(cantidad==0){
                    System.out.println("No quedan mas refrescos");
                    newSocket.close();
                    servidorSS.close();

                }


            }


        }catch(IOException e){
            System.err.println(e);
        }

    }
}
