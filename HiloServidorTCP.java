package Ejemplo_TCP1;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.io.IOException;

import java.net.Socket;


public class HiloServidorTCP extends Thread {
	
	Socket socket = null; // IP + Puerto

	public HiloServidorTCP(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		
		
		// Cada vez que se inicia el hilo, recibe una conexión 
	        Integer n;
	        Integer adivina =5;
	        boolean salir = false;
			try {
				DataInputStream uno = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				dos.writeUTF("Hola amigo. Enviame un numero");	
	            while (!salir ) {
	            	n=uno.readInt();
	            	if (n > adivina) {
	            			dos.writeUTF("El número " + n +" es mayor");
	            	}
	            		else if (n < adivina) {
	            			dos.writeUTF("El número " + n +" es mayor");
	            		}	
	            		else {	
	            		dos.writeUTF("Has adivinado el número era 5");
	            		salir = true;
	            		}
	            	}
	            		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
			
		try {
			if (socket != null)
				socket.close(); // Cierra socket
		;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
			System.out.println("Conexion cerrada.");
			System.out.println("#####################################");
			}
}
