package perfil;

import album.Album;
import musica.Musica;
import musiteca.Musiteca;
import playlist.Playlist;

public class Perfil {
	private String name;
	private Musiteca musiteca;
	
	public Perfil(String name) throws Exception {
		if(name == null || name.trim().isEmpty()){
			throw new Exception("Nome do perfil não pode ser nulo ou vazio");
		}else{
			this.name = name;
			musiteca = new Musiteca();
		}
	}

	public boolean addAlbum(Album newAlbum) {
		try{
			return musiteca.addAlbum(newAlbum);
		}catch(Exception e){
			System.out.println("Erro ao adicionar o album na sua musiteca pessoal");
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean addAlbum(String artist, String title, int year) throws Exception{
		try{
			return musiteca.addAlbum(artist, title, year);
		}catch(Exception e){
			System.out.println("Erro ao adicionar o album na sua musiteca pessoal");
			System.out.println(e.getMessage());
			return false;
		}
	}

	
	public boolean contemAlbum(Album otherAlbum) {
		return musiteca.contemAlbum(otherAlbum);
	}

	public Album getAlbum(String nameAlbum) throws Exception {
		try{
			return musiteca.getAlbum(nameAlbum);
		}catch(Exception e){
			System.out.println("Erro: Nao foi possível recuperar o album");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public boolean removeAlbum(String nameAlbum) throws Exception {
		try{
			return musiteca.removeAlbum(nameAlbum);
		}catch(Exception e){
			System.out.println("Erro ao remover o album");
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean addMusicaToAlbum(String nameAlbum, String nameMusic, int time, String genre) throws Exception {
		try{
			return musiteca.addMusicaToAlbum(nameAlbum, nameMusic, time, genre);
		}catch(Exception e){
			System.out.println("Erro ao adicionar música no album");
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean removeMusicaFromAlbum(String nameAlbum, String nameMusic) throws Exception{
		try{
			return musiteca.removeMusicaFromAlbum(nameAlbum, nameMusic);
		}catch(Exception e){
			System.out.println("Erro ao remover música do album");
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean addAosFavoritos(Album otherAlbum) {
		return musiteca.addAosFavoritos(otherAlbum);
	}

	public boolean criaPlaylist(String namePlaylist) {
		return musiteca.criaPlaylist(namePlaylist);
	}

	public boolean addNaPlaylist(String namePlaylist, String nameAlbum, int track) throws Exception {
		try{
			return musiteca.addNaPlaylist(namePlaylist, nameAlbum, track);
		}catch(Exception e){
			System.out.println("Erro ao adicionar musica na playlist a partir do album.");
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Musica getMusicaFromPlaylists(String nameMusic) throws Exception {
		try{
			return musiteca.getMusicaFromPlaylists(nameMusic);
		}catch(Exception e){
			System.out.println("Erro ao recuperar a musica apartir das playlists");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Musica getMusicaFromMeusAlbuns(String nameMusic) throws Exception{
		try{
			return musiteca.getMusicaFromMeusAlbuns(nameMusic);
		}catch(Exception e){
			System.out.println("Erro ao recuperar a musica apartir dos albuns");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public boolean contemPlaylist(String namePlaylist) throws Exception {
		try{
			return musiteca.contemPlaylist(namePlaylist);
		}catch(Exception e){
			System.out.println("Erro ao verificar a existencia da playlist");
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean removePlaylist(String namePlaylist) throws Exception {
		try{
			return musiteca.removePlaylist(namePlaylist);
		}catch(Exception e){
			System.out.println("Erro ao remover playlist da musiteca");
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean removeMusicaFromPlaylist(String playlist, String music) {
		return musiteca.removeMusicaFromPlaylist(playlist, music);
	}

	public Playlist getPlaylist(String namePlaylist) {
		return musiteca.getPlaylist(namePlaylist);
	}

	public int getQtdFavoritos() {
		return musiteca.getQtdFavoritos();
	}

	public boolean contemNaPaylist(String namePlaylist, String nameMusic) throws Exception{
		try{ 
			return musiteca.contemNaPaylist(namePlaylist, nameMusic);
		}catch(Exception e){
			System.out.println("Erro ao verificar se a musica estar na playlist");
			System.out.println(e.getMessage());
			return false;
		}
	}

	public int getTamPlaylist(String namePlaylist) {
		return musiteca.getTamPlaylist(namePlaylist);
	}

	
}

