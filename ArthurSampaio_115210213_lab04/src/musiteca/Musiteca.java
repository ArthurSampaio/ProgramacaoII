package musiteca;
import playlist.Playlist;
import album.Album;
import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import musica.Musica;


public class Musiteca {
	private HashSet<Album> albuns = new HashSet<Album>();
	private ArrayList<Album> favoritos = new ArrayList<Album>();
	private HashMap <String, Playlist> playlist = new HashMap<String, Playlist>();
	
	
	public Musiteca(){
		
	}
	
	//Adiciona ao Album passando por parametro um object do tipo Album
	public boolean addAlbum(Object otherAlbum) throws Exception{
		
		if (otherAlbum == null){
			throw new Exception("Album nao pode ser nulo");
		}
		
		if (otherAlbum instanceof Album){
			Album newAlbum = (Album) otherAlbum;
			albuns.add(newAlbum);
			return true;
		}else{
			return false;
		}
	}
		
	public boolean addAlbum (String artist, String title, int year){
		try{
			Album newAlbum = new Album (artist, title, year);
			return this.addAlbum(newAlbum);
		}catch(Exception exception){
			System.out.println(exception.getMessage());
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
	public boolean removeAlbum (String nameAlbum) throws Exception{
		if (nameAlbum == null || nameAlbum.trim().isEmpty()){
			throw new Exception("Titulo do album nÃ£o pode ser nulo ou vazio.");
		}
		else{
			//search for an album in albuns;
			for (Album album : this.albuns){
				if (album.getTitulo().equals(nameAlbum)){
					//remove this album
					return albuns.remove(album);
				}
			}
		return false;
		}
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
	
	
	public void favoriteAlbum(String nameAlbum) throws Exception{
		if (nameAlbum == null || nameAlbum.trim().isEmpty()){
			throw new Exception("Titulo do album nÃ£o pode ser nulo ou vazio.");
		}else{ 
			if (this.getAlbum(nameAlbum) != null){
			Album album = this.getAlbum(nameAlbum);
			album.setFavorito(true);
			}
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
	
	public ArrayList<Album> getAlbunsFavoritos(){
		return this.favoritos;
	}
	
	public boolean addPlaylist(Object otherPlaylist) throws Exception{
		if (otherPlaylist == null){
			throw new Exception("Playlist nao pode ser nula.");
		}else{ 
			if(otherPlaylist instanceof Playlist){
				Playlist newPlaylist = (Playlist)otherPlaylist;
				if (this.playlist.containsKey(newPlaylist.getNamePlaylist())){
					return false;
				} 
				else{
					String nome = newPlaylist.getNamePlaylist();
					this.playlist.put(nome, newPlaylist);
					return true;
				}
			}else{
				return false;
			}
		}
	}

	public boolean addPlaylist(String namePlaylist) throws Exception{
		if (namePlaylist == null || namePlaylist.trim().isEmpty()){
			throw new Exception("Nome da playlist nao pode ser nulo ou vazio.");
		}else{
			Playlist newPlaylist = new Playlist(namePlaylist);
			return addPlaylist(newPlaylist);
		}
	}
	
	public boolean addMusicaToPlaylist (String namePlaylist, String nameAlbum, int track) throws Exception{
		Playlist foundPlaylist;
		Album album;
		Musica music;
		
		if (namePlaylist == null || namePlaylist.trim().isEmpty()){
			throw new Exception("Nome da playlist nao pode ser nulo ou vazio.");
		}
		
		if (!(this.playlist.containsKey(namePlaylist))){
			try{
				foundPlaylist = new Playlist(namePlaylist);
				this.playlist.put(namePlaylist, foundPlaylist);
			}catch(Exception exception){
				System.out.println(exception.getMessage());
			}
		}
		if (this.getAlbum(nameAlbum) != null){
			album = this.getAlbum(nameAlbum);
			music = album.getMusica(track);
			foundPlaylist = this.playlist.get(namePlaylist);
			if (music != null){
				if (foundPlaylist.addMusic(music)){
					this.playlist.put(namePlaylist, foundPlaylist);
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{ 
			throw new Exception("Album nao pertence ao Perfil especificado");
		}
	}
	
	//search for a music in playlists
	public Musica getMusicaFromPlaylists(String nameMusic){
		for(Map.Entry<String, Playlist> entry: this.playlist.entrySet()){
			if (entry.getValue().getMusica(nameMusic) != null){
				return entry.getValue().getMusica(nameMusic);
			}
			
		}return null;		
	}
	
	public Musica getMusicaFromAlbuns(String nameMusic){
		for (Album album : this.albuns){
			if (album.containsMusic(nameMusic)){
				try{
					return album.getMusica(nameMusic);
				}catch(Exception exception){
					System.out.println(exception.getMessage());
				}
			}
		}return null;
	}
	
	public boolean containsPlaylist(Playlist otherPlaylist){
		if (this.playlist.containsKey(otherPlaylist.getNamePlaylist())){
			return true;
		}else{
			return false;			
		}
	}
	
	public boolean removePlaylist(String namePlaylist){
		if (this.playlist.containsKey(namePlaylist)){
			this.playlist.remove(namePlaylist);
			return true;
		}else{
			return false;
		}
	}
	
	public boolean removeMusicaFromPlaylist (String playlist, String music){
		if (this.playlist.containsKey(playlist)){
			Playlist foundPlaylist = this.playlist.get(playlist);
			return foundPlaylist.removeMusic(music);
		}else{ 
			return false;
		}
	}
	
	public Playlist getPlaylist (String namePlaylist){
		for(Map.Entry<String, Playlist> entry : this.playlist.entrySet()){
			if (entry.getValue().equals(namePlaylist)){
				return entry.getValue();
			}
		}return null;
	}
	
	
	
}
	