package aad.mongodb;

import java.util.ArrayList;

public class Curso {
	String nombre;
	int numero_clases;
	ArrayList<Alumno> lista_alumnos;
	
	
	public Curso(String nombre, int numero_clases, ArrayList<Alumno> lista_alumnos) {
		super();
		this.nombre = nombre;
		this.numero_clases = numero_clases;
		this.lista_alumnos = lista_alumnos;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumero_clases() {
		return numero_clases;
	}
	public void setNumero_clases(int numero_clases) {
		this.numero_clases = numero_clases;
	}
	public ArrayList<Alumno> getLista_alumnos() {
		return lista_alumnos;
	}
	public void setLista_alumnos(ArrayList<Alumno> lista_alumnos) {
		this.lista_alumnos = lista_alumnos;
	}


	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + ", numero_clases=" + numero_clases + ", lista_alumnos=" + lista_alumnos
				+ "]";
	}
	
	
	
	

}
