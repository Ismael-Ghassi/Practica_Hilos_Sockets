package Ejercicio_1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


/**
 * En esta clase se encuentran los metodos para arrancar el servidor y a los clientes.
 */
public class Monitor {


    /**
     * Gracias a este metodo podemos crear un cliente que realizara una peticion al servidor.
     * @throws InterruptedException
     */
    public void cliente() throws InterruptedException {
        try {


                Socket clienteS = new Socket(); //Es el socket para el cliente.

            /**
             * Se crea un objeto de tipo 'InetSocketAddress' y se le asigna una ip y un puerto que
             * deben ser los mismos que en el servidor.
             */
            InetSocketAddress iddr = new InetSocketAddress("192.168.56.1", 5555);
                clienteS.connect(iddr); //Se conecta al cliente al servidor


                InputStream is = clienteS.getInputStream(); //Nos servira para leer los mendajes de sevidor.
                OutputStream os = clienteS.getOutputStream(); //Nos servira para mandar mensaje al servidor.


                String peticion = "Cliente conectado correctamente. Peticion para el servidor.";
                os.write(peticion.getBytes()); //Se manda el mensaje al servidor convertido en bytes.



                byte [] respuesta = new byte[38]; //Array de byte donde se almacenara la respuesta del servidor
                is.read(respuesta); //Se lee la respuesta de servidor
                String res = new String(respuesta, StandardCharsets.UTF_8); //Se pasa el array de bytes a String.

                System.out.println(res); //Mensaje por pantalla de la respuesta del servidor



                clienteS.close(); //Se cierra el cliente


        }catch (IOException e){
            System.err.println(e);
            System.err.println("Error 1");
        }
    }


    /**
     * Gracias a este metodo podemos crear y arrancar un servidor que nunca dejara de escuchar.
     * Este metodo esta sincronizado para garantizar que las peticiones se realizan una por una.
     * @throws InterruptedException
     */
    public synchronized void servidor() throws InterruptedException {

        try {


                ServerSocket servidorSS = new ServerSocket(); //Este objeto nos servira para crear el servidor.

                /**
                 * Se crea un objeto de tipo 'InetSocketAddress' y se le asigna una ip y un puerto para poder
                 * identificar al servidor en la red.
                 */
                InetSocketAddress addr = new InetSocketAddress("192.168.56.1", 5555);
                servidorSS.bind(addr); //Se le asigna al servidor su direccion

                Socket newSocket; //Se crea un Socket para poder recibir y enviar mensajes al cliente


                System.out.println("Servidor escuchando");

                int contadorPeticiones=1; //Nos servira para saber cual es el numero de la peticion


                while (true) {

                    newSocket = servidorSS.accept(); //A partir de este punto el servidor empieza a aceptar peticiones.

                    InputStream is = newSocket.getInputStream(); //Nos servira para leer los mendajes de cliente.
                    OutputStream os = newSocket.getOutputStream(); //Nos servira para mandar mensaje al cliente.

                    byte[] peticion = new byte[59]; //Array de byte donde se almacenara la peticion del cliente
                    is.read(peticion); //Se lee la peticion
                    String mensaje = new String(peticion, StandardCharsets.UTF_8); //Convertimos la peticion en String
                    System.out.println(mensaje); //Mensaje por pantalla de la peticion

                    /**
                     * Se le devuelve al cliente un mensaje donde se le facilita el numero de su peticion.
                     */
                    String devolver="Conexion correcta. Tu peticion es la "+contadorPeticiones;
                    os.write(devolver.getBytes());
                    contadorPeticiones++; //aumenta el contador de peticiones
                    newSocket.close(); //Se cierra la conexion con el cliente
                }


        }catch(IOException e){
                System.err.println(e);
                System.out.println("Error 2");
            }

    }
    }

