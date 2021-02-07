package youtube;

import java.util.ArrayList;

public class Youtuber {

	String user;
	String nombreReal;
	int edad;
	ArrayList<Video> videosSubidos;
	
	
	public Youtuber(String user, String nombreReal, int edad, ArrayList<Video> videosSubidos) {
		super();
		this.user = user;
		this.nombreReal = nombreReal;
		this.edad = edad;
		this.videosSubidos = videosSubidos;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getNombreReal() {
		return nombreReal;
	}
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public ArrayList<Video> getVideosSubidos() {
		return videosSubidos;
	}
	public void setVideosSubidos(ArrayList<Video> videosSubidos) {
		this.videosSubidos = videosSubidos;
	}
	@Override
	public String toString() {
		return "Youtuber [user=" + user + ", nombreReal=" + nombreReal + ", edad=" + edad + ", videosSubidos="
				+ videosSubidos + "]";
	}
	
}
