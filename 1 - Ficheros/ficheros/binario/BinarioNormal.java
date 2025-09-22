package ficheros.binario;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinarioNormal {
	
	public static void main(String args[])  {
		
		// Con estas clases escribiremos datos en binario
		FileOutputStream fout;
		DataOutputStream dout;
				
				
		// Con estas clases leeremos de los datos en binario
		FileInputStream fin;
		DataInputStream din = null;
		
		try {
			fout = new FileOutputStream("superheroes.dat");
			dout = new DataOutputStream(fout);
			
			dout.writeUTF("Thor");
			dout.writeInt(2018);
			
			dout.writeUTF("Spiderman");
			dout.writeInt(2021);
			
			dout.close();
			
			fin = new FileInputStream("superheroes.dat");
			din = new DataInputStream(fin);
			
			//�C�mo sabremos cuando hemos llegado al final del fichero??
			String nombre = din.readUTF();
			while(nombre != null) {
				
				System.out.println(nombre);
				System.out.println(din.readInt());
				nombre = din.readUTF();
				
			}
			
			
			
		} 
		catch (EOFException e) {
			// TODO Auto-generated catch block
			System.out.println("Ya hemos acabado!");
				try {
					din.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
