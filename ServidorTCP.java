package Ejemplo_TCP1;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;


public class ServidorTCP {

	public static void main(String[] args) throws IOException {

		System.out.println("###########################");
		System.out.println("SERVIDOR DE NUMEROS");
		System.out.println("###########################");
		System.out.println("Esperando conexiones...");
		Socket newSocket = null;
		ServerSocket serverSocket = new ServerSocket(5555);
		while (true) // Bucle de conexiones
		{
			try {
				newSocket = serverSocket.accept(); // Acepta conexiones entrantes
				HiloServidorTCP hilo = new HiloServidorTCP(newSocket); // Crea un nuevo hilo con el socket
				hilo.start();
			} catch (Exception ex) {
				serverSocket.close();
				ex.printStackTrace();
			}
		}	

	}

}
