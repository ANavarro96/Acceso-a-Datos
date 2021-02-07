package aad.mongodb;

public class Alumno {
	String nombre;
	int edad;
	double media;
	
	public Alumno(String nombre, int edad, double media) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.media = media;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", media=" + media + "]";
	}
	
	
	
	
	
}
