package playlist;
import musica.Musica;
import album.Album;
import java.util.ArrayList;


public class Playlist {
	private String namePlaylist;
	private ArrayList <Musica> musicas = new ArrayList<Musica>();
	
	public Playlist(String name) throws Exception{
		if (name == null || name.trim().isEmpty()){
			throw new Exception("Nome da playlist nao pode ser nulo ou vazio.");
		}
		else{
			this.namePlaylist = name;
		}
	}
		
	public void setNamePlaylist(String newName){
		this.namePlaylist = newName;
	}
	
	public String getNamePlaylist(){
		return this.namePlaylist;
	}
	
	public boolean addMusic (Musica newMusic){
		return this.musicas.add(newMusic);
	}
	
	public Musica getMusica (String findMusic){
		for (Musica musica : musicas){
			if (musica.getTitulo().equals(findMusic)){
				return musica;
			}
		}return null;
	}
	
}
