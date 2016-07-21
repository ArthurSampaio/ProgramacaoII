package album;
import musica.Musica;
import java.util.*;

public class Album {
	
	private String artista;
	private String titulo;
	private int lancamento;
	private ArrayList<Musica> musicas = new ArrayList();
	
	public Album (String artista, String titulo, int anoLancamento){
		this.artista = artista;
		this.titulo = titulo;
		this.lancamento = anoLancamento;
	
	}


	public String getArtista() {
		return artista;
	}


	public void setArtista(String artista) {
		this.artista = artista;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public int getLancamento() {
		return lancamento;
	}


	public void setLancamento(int lancamento) {
		this.lancamento = lancamento;
	}
	
	
	
}
