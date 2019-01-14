package Ejemplo_TCP1;
import java.io.*;
import java.net.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

 // jlayer-1.0.1-1.jar descargar y añadir en classpath para reproducir

public class ClienteTCP {

	public static void main(String[] args) throws IOException {
		Boolean salir = false;
		
	    
	    Integer v;
		String mensaje=null;
		Socket clientSocket = null; // Socket de conexión

		System.out.println("###########################");
		System.out.println("CLIENTE DE NUMEROS");
		System.out.println("###########################");
		try {
			
			clientSocket = new Socket("127.0.0.1", 5555); // Conexión al servidor
			DataInputStream one = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream two = new DataOutputStream(clientSocket.getOutputStream());
		    System.out.println("Conectado al servidor...");
			mensaje = one.readUTF().toString(); 
			System.out.println(mensaje);
			Scanner sc = new Scanner(System.in);
			
			while (!salir) {
				v=sc.nextInt();
				two.writeInt(v); 
				mensaje = one.readUTF().toString(); 
				System.out.println(mensaje);
			}
				System.out.println("Conexión cerrada. ");
				sc.close();
				if (one != null)
					one.close();
				if (two != null)
					two.close();
				
			} catch (Exception ex) {
				ex.printStackTrace();	
			}

			// Cierra conexiones
		    

			if (clientSocket != null)
				clientSocket.close();
			
	}

}
