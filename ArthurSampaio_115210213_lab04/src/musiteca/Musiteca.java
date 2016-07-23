package musiteca;
import playlist.Playlist;
import album.Album;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.HashMap;


public class Musiteca {
	private HashSet<Album> albuns = new HashSet<Album>();
	private ArrayList<Album> favoritos = new ArrayList<Album>();
	private HashMap <String, Playlist> playlist = new HashMap<String, Playlist>();
	
	public Musiteca(){
		
	}
	
	//Adiciona ao Album
	public boolean addAlbum(Object otherAlbum){
		if (otherAlbum instanceof Album){
			Album newAlbum = (Album) otherAlbum;
			albuns.add(newAlbum);
			return true;
		}else{
			return false;
		}
	}
		
	//pesquisa no album se há otherAlbum 
	public boolean containsAlbum (Object otherAlbum){
		if (otherAlbum instanceof Album){
			return albuns.contains(otherAlbum);
		}else{
			return false;		
		}
	}

	//search for an album with "nameAlbum" 
	//return the album or false, otherwise
	public Album getAlbum (String nameAlbum){
		for (Album album : this.albuns){
			if (album.getTitulo().equals(nameAlbum)){
				return album;
			}
		}return null;  
	}
	
	//remove do album
	public boolean removeAlbum (String nameAlbum){
		//search for an album in albuns;
		for (Album album : this.albuns){
			if (album.getTitulo().equals(nameAlbum)){
				//remove this album
				return albuns.remove(album);
			}
		}return false;
	}
	
	//add music to the specific album with nameAlbum
	public boolean addMusicaToAlbum(String nameAlbum, String nameMusic, int time, String genre){
		if (this.getAlbum(nameAlbum) != null){
			Album album = this.getAlbum(nameAlbum);
			return album.addMusica(nameMusic, time, genre);
		}else{
			return false; 
		}
	}
	
	//remove a music to the specific album with nameAlbum
	public boolean removeMusicaFromAlbum(String nameAlbum, String nameMusic){
		if (this.getAlbum(nameAlbum) != null){
			Album album = this.getAlbum(nameAlbum);
			return album.removeMusica(nameMusic);
		}else{
			return false;
		}
	}
	
	
	public void favoriteAlbum(String nameAlbum){
		if (this.getAlbum(nameAlbum) != null){
			Album album = this.getAlbum(nameAlbum);
			album.setFavorito(true);
		}
	}
	
	public void unfavoriteAlbum(String nameAlbum){
		if (this.getAlbum(nameAlbum) != null){
			Album album = this.getAlbum(nameAlbum);
			album.setFavorito(false);
		}
	}
	
	public void MakeTheFavorites(){
		//make a for each in albuns 
		for (Album album : this.albuns){
			if (album.isFavorito()){
				this.favoritos.add(album);
			}
		}
	}
	
	public ArrayList getAlbunsFavoritos(){
		return this.favoritos;
	}
	
	public boolean addPlaylist(Object otherPlaylist){
		if (otherPlaylist instanceof Playlist){
			Playlist newPlaylist = (Playlist)otherPlaylist;
			if (this.playlist.containsKey(newPlaylist)){
				return false;				
			}else{
				playlist.put(newPlaylist.getNamePlaylist(), newPlaylist);
				return true;
			}
		}else{
			return false;
		}
	}
	
	public boolean addMusicaToPlaylist(String namePlaylist, String nameAlbum, int track)
	
}
	