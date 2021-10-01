package FICHEROS;

import java.io.Serializable;

public class Ciudad implements Serializable {
	
	private String nombre; // Obligamos a que la longitud sea 15
	private Integer numHabitantes;
	private boolean esCapital;
	
	public Ciudad(String nombre, Integer numHabitantes, boolean esCapital) {
		super();
		this.nombre = nombre;
		this.numHabitantes = numHabitantes;
		this.esCapital = esCapital;
	}

	@Override
	public String toString() {
		return "Ciudad [nombre=" + nombre + ", numHabitantes=" + numHabitantes + ", esCapital=" + esCapital + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumHabitantes() {
		return numHabitantes;
	}

	public void setNumHabitantes(Integer numHabitantes) {
		this.numHabitantes = numHabitantes;
	}

	public boolean isEsCapital() {
		return esCapital;
	}

	public void setEsCapital(boolean esCapital) {
		this.esCapital = esCapital;
	}
	
	
	

}
