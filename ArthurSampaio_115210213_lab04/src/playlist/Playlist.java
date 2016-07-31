package playlist;
import musica.Musica;
import album.Album;
import java.util.ArrayList;


public class Playlist {
	private ArrayList <Musica> musicas = new ArrayList<Musica>();
	
	/**
	 * Constructor of class Playlist
	 */
	public Playlist(){}
		
	/**
	 * add music in playlist
	 * @param newMusic
	 * 		newMusic with type Musica
	 * @return
	 * 		the success of operation
	 */
	public boolean addMusic (Musica newMusic){
		return this.musicas.add(newMusic);
	}

	/**
	 * return a music in playlist from name
	 * @param findMusic
	 * @return
	 */
	public Musica getMusica (String findMusic){
		for (Musica musica : musicas){
			if (musica.getTitulo().equals(findMusic)){
				return musica;
			}
		}return null;
	}
	
	/**
	 * remove a music from name 
	 * @param nameMusic
	 * @return
	 * 		the success of operation
	 */
	public boolean removeMusic(String nameMusic){
		for (Musica musica : musicas){
			if (musica.getTitulo().equals(nameMusic)){
				musicas.remove(musica);
			}
		}return false;
	}
	
	/**
	 * return the size of playlist
	 * @return
	 * 		the size of playlist
	 */
	public int getTamanho(){
		return musicas.size();
	}
	
	/**
	 * Contains music from your name
	 * @param nameMusic
	 * 		if contains, return true
	 * @return
	 */
	public boolean contemMusica (String nameMusic){
		for (Musica musica : this.musicas){
			if (musica.getTitulo().equalsIgnoreCase(nameMusic)){
				return true;
			}
		}
		return false;
	}
	
}
