package ficheros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class BinarioObjetos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ciudad zgz = new Ciudad("Zaragoza",600000,true);
		Ciudad utebo = new Ciudad("Utebo",20000,false);
		
		// Con estas clases ESCRIBIMOS objetos directamente
		FileOutputStream fout;
		ObjectOutputStream oout;
		
		
		// Con estas clases LEEMOS objetos directamente
		FileInputStream fin;
		ObjectInputStream oin;
		try {
			fout = new FileOutputStream("ciudades.dat");
			
			oout = new ObjectOutputStream(fout);

			oout.writeObject(zgz); oout.writeObject(utebo);
			
			oout.close();
			
			fin = new FileInputStream("ciudades.dat");
			oin = new ObjectInputStream(fin);
			
			System.out.println(oin.readObject().toString()); // Leemos el primer objeto; el cursor apunta al segundo
			System.out.println(oin.readObject().toString()); // Leemos el primer objeto; el cursor apunta al segundo
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


