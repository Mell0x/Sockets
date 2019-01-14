package Ejemplo_TCP1;
import java.io.*;
import java.net.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

 // jlayer-1.0.1-1.jar descargar y añadir en classpath para reproducir

public class ClienteTCP {

	public static void main(String[] args) throws IOException {
		Boolean exit = false;
		
	    
	    Integer v;
		String message=null;
		Socket clientSocket = null; // Socket de conexión

		System.out.println("###########################");
		System.out.println("CLIENTE DE NUMEROS");
		System.out.println("###########################");
		try {
			
			clientSocket = new Socket("127.0.0.1", 5555); // Conexión al servidor
			DataInputStream one = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream two = new DataOutputStream(clientSocket.getOutputStream());
		    System.out.println("Connected to the server...");
			message = one.readUTF().toString(); 
			System.out.println(message);
			Scanner sc = new Scanner(System.in);
			
			while (!salir) {
				v=sc.nextInt();
				two.writeInt(v); 
				message = one.readUTF().toString(); 
				System.out.println(message);
			}
				System.out.println("Connection closed. ");
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
