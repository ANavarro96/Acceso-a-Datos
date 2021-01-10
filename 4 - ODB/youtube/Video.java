package youtube;

import java.util.Date;

public class Video {
	String titulo;
	int visitas;
	Date publicacion;
	int likes;
	int dislikes;
	
	public Video(String titulo, int visitas, Date publicacion, int likes, int dislikes) {
		super();
		this.titulo = titulo;
		this.visitas = visitas;
		this.publicacion = publicacion;
		this.likes = likes;
		this.dislikes = dislikes;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getVisitas() {
		return visitas;
	}
	public void setVisitas(int visitas) {
		this.visitas = visitas;
	}
	public Date getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(Date publicacion) {
		this.publicacion = publicacion;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	@Override
	public String toString() {
		return "Video [titulo=" + titulo + ", visitas=" + visitas + ", publicacion=" + publicacion + ", likes=" + likes
				+ ", dislikes=" + dislikes + "]";
	}
	
	
}
