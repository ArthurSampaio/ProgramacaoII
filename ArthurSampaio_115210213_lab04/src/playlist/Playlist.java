package playlist;
import musica.Musica;
import java.util.HashMap;
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

	public boolean addMusic(String namePlaylist, )
	
	
	public String getNamePlaylist(){
		return this.namePlaylist;
	}
	
	public boolean addMusicFromAlbum ()
}
