package musiteca;
import playlist.Playlist;
import album.Album;
import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import musica.Musica;


public class Musiteca {
	private HashSet<Album> meusAlbuns = new HashSet<Album>();
	private HashSet<Album> favoritos = new HashSet<Album>();
	private HashMap <String, Playlist> playlist = new HashMap<String, Playlist>();
	
	
	public Musiteca(){
		
	}
	
	//Adiciona ao Album passando por parametro um object do tipo Album
	public boolean addAlbum(Album newAlbum){
		if (newAlbum != null){
			return meusAlbuns.add(newAlbum);
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
	public boolean contemAlbum (Album otherAlbum){
		for (Album album : this.meusAlbuns){
			if (album.equals(otherAlbum)){
				return true;
			}
		}return false;
	}

	//search for an album with "nameAlbum" 
	//return the album or false, otherwise
	
	public Album getAlbum (String nameAlbum){
		for (Album album : this.meusAlbuns){
			if (album.getTitulo().equalsIgnoreCase(nameAlbum)){
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
			//search for an album in meusAlbuns;
			for (Album album : this.meusAlbuns){
				if (album.getTitulo().equals(nameAlbum)){
					//remove this album
					return meusAlbuns.remove(album);
				}
			}
		return false;
		}
	}
	
	//add music to the specific album with nameAlbum
	public boolean addMusicaToAlbum(String nameAlbum, String nameMusic, int time, String genre){
		if (this.getAlbum(nameAlbum) == null){
			return false;
		}
		else{
			for (Album album : meusAlbuns){
				if(album.getTitulo().equals(nameAlbum)){
					album.addMusica(nameMusic, time, genre);
					return true;
				}
			}return false;
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
	
	public boolean addAosFavoritos(Album otherAlbum){
		if (this.meusAlbuns.contains(otherAlbum) && !(this.favoritos.contains(otherAlbum))){
			return this.favoritos.add(otherAlbum);
		}else{
			return false;
		}
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

	public boolean criaPlaylist(String namePlaylist){
		if (namePlaylist == null || namePlaylist.trim().isEmpty()){
			return false;
		}else{
			for(Map.Entry<String, Playlist> entry: this.playlist.entrySet()){
				if (entry.getKey().equals(namePlaylist)){
					return false;
				}
			}try{
				Playlist newPlaylist = new Playlist(namePlaylist);
				this.playlist.put(namePlaylist, newPlaylist);
				return true;
			}catch(Exception e){
				System.out.println(e.getMessage());
			}return false;
			
		}
	}
	
	public boolean addNaPlaylist (String namePlaylist, String nameAlbum, int track) throws Exception{
		Musica music;
		this.criaPlaylist(namePlaylist);		//cria uma playlist com o namePlaylist
			
		
		if (this.getAlbum(nameAlbum) instanceof Album){
			Album album = (Album) this.getAlbum(nameAlbum);
			
			music = album.getMusica(track);
			if (music != null){
				//add music in playlist namePlaylist
				return this.playlist.get(namePlaylist).addMusic(music);
			}else{
				return false;
			}
		}else{
			return false;
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
	
	public Musica getMusicaFromMeusAlbuns(String nameMusic){
		for (Album album : this.meusAlbuns){
			if (album.contemMusica(nameMusic)){
				try{
					return album.getMusica(nameMusic);
				}catch(Exception exception){
					System.out.println(exception.getMessage());
				}
			}
		}return null;
	}
	
	public boolean contemPlaylist(String namePlaylist){
		for(Map.Entry<String, Playlist> entry: this.playlist.entrySet()){
			if (entry.getKey().equals(namePlaylist)){
				return true;
			}
		}return false;
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
	
	public int getQtdFavoritos(){
		return this.favoritos.size();
	}
	
	public int getTamPlaylist (String namePlaylist){
		if (this.contemPlaylist(namePlaylist)){
			
			
			if (this.contemPlaylist(namePlaylist)){
				for(Map.Entry<String, Playlist> entry: this.playlist.entrySet()){
					if (entry.getKey().equalsIgnoreCase(namePlaylist)){
						return entry.getValue().getTamanho();
					}
				}
			
			}return -1;
		}else{
			return -1;
		}
	}
	
	public boolean contemNaPaylist(String namePlaylist, String nameMusic){
		if (this.contemPlaylist(namePlaylist)){
			return this.playlist.get(namePlaylist).contemMusica(nameMusic);
		}else{
			return false;
		}
	}
}
	
