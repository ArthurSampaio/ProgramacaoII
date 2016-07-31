package musiteca;
import playlist.Playlist;
import album.Album;
import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import musica.Musica;


public class Musiteca {
	static final int FALSE = -1;
	private HashSet<Album> meusAlbuns = new HashSet<Album>();
	private HashSet<Album> favoritos = new HashSet<Album>();
	private HashMap <String, Playlist> playlist = new HashMap<String, Playlist>();
	
	/**
	 * Constructor of class Musiteca
	 */
	public Musiteca(){
		
	}
	
	/**
	 * Add a album in musiteca passed by parameter
	 * @param newAlbum
	 * 		object new Album
	 * @return
	 * 		the success of operation
	 */
	public boolean addAlbum(Album newAlbum){
		if (newAlbum != null){
			return meusAlbuns.add(newAlbum);
		}else{
			return false;
		}
	}
	
	/**
	 * Add a album in musiteca, passed by parameters the artist, title and release year
	 * @param artist
	 * 		name of artist who composed the album
	 * @param title
	 * 		the title of album
	 * @param year
	 * 		release year
	 * @return
	 */
	public boolean addAlbum (String artist, String title, int year){
		try{
			Album newAlbum = new Album (artist, title, year);
			return this.addAlbum(newAlbum);
		}catch(Exception exception){
			System.out.println(exception.getMessage());
			return false;
		}
		
	}
		
	/**
	 * search in musiteca a album otherAlbum
	 * @param otherAlbum
	 * @return
	 * 		the success of operation
	 */
	public boolean contemAlbum (Album otherAlbum){
		for (Album album : this.meusAlbuns){
			if (album.equals(otherAlbum)){
				return true;
			}
		}return false;
	}
	
	/**
	 * search for an album with title "nameAlbum" 
	 * @param nameAlbum
	 * @return
	 * 		return the album or null, otherwise
	 */
	public Album getAlbum (String nameAlbum) throws Exception{
		if (nameAlbum == null || nameAlbum.trim().isEmpty()){
			throw new Exception("O nome do album nao pode ser nulo ou vazio");
		}
		for (Album album : this.meusAlbuns){
			if (album.getTitulo().equalsIgnoreCase(nameAlbum)){
				return album;
			}
		}return null;  
	}
	
	/**
	 * Remove album with name "nameAlbum" in musiteca
	 * @param nameAlbum
	 * @return
	 * @throws Exception
	 */
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
	
	/**
	 * add music to the specific album with nameAlbum
	 * @param nameAlbum
	 * 		the name of album
	 * @param nameMusic
	 * 		the name of music
	 * @param time
	 * 		duration of music
	 * @param genre
	 * 		the genre of music
	 * @return
	 */
	public boolean addMusicaToAlbum(String nameAlbum, String nameMusic, int time, String genre) throws Exception{
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
	
	/**
	 * remove a music to the specific album with nameAlbum
	 * @param nameAlbum
	 * 		the name of album
	 * @param nameMusic
	 * 		the name of music
	 * @return
	 * 		return the success of operation
	 */
	public boolean removeMusicaFromAlbum(String nameAlbum, String nameMusic) throws Exception{
		if (this.getAlbum(nameAlbum) != null){
			Album album = this.getAlbum(nameAlbum);
			return album.removeMusica(nameMusic);
		}else{
			return false;
		}
	}
			
	/**
	 * Add an album in favorites if album exist in musiteca
	 * @param otherAlbum
	 * 		other album
	 * @return
	 * 		the success of operation
	 */
	public boolean addAosFavoritos(Album otherAlbum){
		if (this.meusAlbuns.contains(otherAlbum)){
			return this.favoritos.add(otherAlbum);
		}else{
			return false;
		}
	}
	
	/**
	 * create a new playlist
	 * @param namePlaylist
	 * 		name of new playlist
	 * @return
	 * 		the success of operation
	 * @throws Exception
	 * 		when the namePlaylist is null or empty
	 */
	public boolean criaPlaylist(String namePlaylist){
		if (namePlaylist == null || namePlaylist.trim().isEmpty()){
			return false;
		}else{
			//search for namePlaylist on playlist
			for(Map.Entry<String, Playlist> entry: this.playlist.entrySet()){
				if (entry.getKey().equals(namePlaylist)){
					return false;
				}
			}
			Playlist newPlaylist = new Playlist();
			this.playlist.put(namePlaylist, newPlaylist);
			return true;
		}
	}
	
	/**
	 * Add a music  in playlist with (namePlaylist) since a album with "nameAlbum"
	 * @param namePlaylist
	 * 		name of playlist
	 * @param nameAlbum
	 * 		name of album
	 * @param track
	 * 		track the album "nameAlbum"
	 * @return
	 * 		success of operation
	 * @throws Exception
	 */
	public boolean addNaPlaylist (String namePlaylist, String nameAlbum, int track) throws Exception{
		this.criaPlaylist(namePlaylist);		//create a new playlist				
		if (this.getAlbum(nameAlbum) instanceof Album){
			Album album = (Album) this.getAlbum(nameAlbum);
			
			Musica music = album.getMusica(track);
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
		
	/**
	 * return a music if exist in playlist
	 * return a music if exist in albuns
	 * @param nameMusic
	 * @return
	 * 		return a object Musica or null
	 */
	public Musica getMusicaFromPlaylists(String nameMusic) throws Exception{
		if (nameMusic == null || nameMusic.trim().isEmpty()){
			throw new Exception("Nome da musica não pode ser nulo ou vazio");
		}
		for(Map.Entry<String, Playlist> entry: this.playlist.entrySet()){
			if (entry.getValue().getMusica(nameMusic) != null){
				return entry.getValue().getMusica(nameMusic);
			}
			
		}return null;		
	}
	
	/**
	 * return a music if exist in albuns
	 * @param nameMusic
	 * @return
	 * 		return a object Musica or null
	 */
	public Musica getMusicaFromMeusAlbuns(String nameMusic) throws Exception{
		if (nameMusic == null || nameMusic.trim().isEmpty()){
			throw new Exception("Nome da musica nao pode ser nulo ou vazio");
		}
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
	
	/**
	 * contains playlist with name "namePlaylist"
	 * @param namePlaylist
	 * 		the name of playlist
	 * @return
	 */
	public boolean contemPlaylist(String namePlaylist) throws Exception{
		if (namePlaylist == null || namePlaylist.trim().isEmpty()){
			throw new Exception("Nome da musica não pode ser nulo ou vazio");
		}
		for(Map.Entry<String, Playlist> entry: this.playlist.entrySet()){
			if (entry.getKey().equals(namePlaylist)){
				return true;
			}
		}return false;
	}
	
	/**
	 * remove playlist from musiteca
	 * @param namePlaylist
	 * @return
	 * 		the success of operation
	 */
	public boolean removePlaylist(String namePlaylist) throws Exception{
		if (namePlaylist == null || namePlaylist.trim().isEmpty()){
			throw new Exception("Nome da playlist nao pode ser nulo ou vazio");
		}
		if (this.playlist.containsKey(namePlaylist)){
			this.playlist.remove(namePlaylist);
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Remove a music from playlist
	 * @param playlist
	 * 		name of playlist
	 * @param music
	 * 		name of music
	 * @return
	 * 		the success of playlist
	 */
	public boolean removeMusicaFromPlaylist (String playlist, String music){
		if (this.playlist.containsKey(playlist)){
			return this.playlist.get(playlist).removeMusic(music);
		}else{ 
			return false;
		}
	}
	
	/**
	 * Return a playlist with name playlist
	 * @param namePlaylist
	 * @return
	 * 		object playlist or null
	 */
	public Playlist getPlaylist (String namePlaylist){
		for(Map.Entry<String, Playlist> entry : this.playlist.entrySet()){
			if (entry.getValue().equals(namePlaylist)){
				return entry.getValue();
			}
		}return null;
	}
	
	/**
	 * the size of favoritos
	 * @return
	 * 		return the size of favoritos
	 */
	public int getQtdFavoritos(){
		return this.favoritos.size();
	}
	
	/**
	 * Contains music with name "nameMusic" in a playlist
	 * @param namePlaylist
	 * 		name of playlist
	 * @param nameMusic
	 * 		name of music
	 * @return
	 */
	public boolean contemNaPaylist(String namePlaylist, String nameMusic) throws Exception{
		if (namePlaylist == null || namePlaylist.trim().isEmpty()){
			throw new Exception("O nome da playlist nao pode ser nula ou vazia");
		}
		if (nameMusic == null || nameMusic.trim().isEmpty()){
			throw new Exception("O nome da música nao pode ser nula ou vazia");
		}
		if (this.contemPlaylist(namePlaylist)){
			return this.playlist.get(namePlaylist).contemMusica(nameMusic);
		}else{
			return false;
		}
	}
	
	/**
	 * return the size of playlist with namePlaylist
	 * @param namePlaylist
	 * @return
	 */
	public int getTamPlaylist (String namePlaylist){
		for(Map.Entry<String, Playlist> entry: this.playlist.entrySet()){
			if (entry.getKey().equalsIgnoreCase(namePlaylist)){
				return entry.getValue().getTamanho();
			}
		}return FALSE;
	}

	
	/**
	 * HashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((favoritos == null) ? 0 : favoritos.hashCode());
		result = prime * result + ((meusAlbuns == null) ? 0 : meusAlbuns.hashCode());
		result = prime * result + ((playlist == null) ? 0 : playlist.hashCode());
		return result;
	}
	
	/**
	 * Equals
	 */

	@Override
	/**
	 * this.equals(obj) are true, if the quantity of favorites is equals
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Musiteca){
			Musiteca musiteca = (Musiteca) obj;
			if (this.getQtdFavoritos() == musiteca.getQtdFavoritos()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	

}
	
	
