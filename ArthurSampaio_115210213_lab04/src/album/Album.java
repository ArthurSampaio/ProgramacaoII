package album;
import musica.Musica;
import java.util.*;

public class Album {
	
	private String artista;
	private String titulo;
	private int lancamento;
	private ArrayList<Musica> musicas = new ArrayList <Musica>();
	private boolean favorito;

	/**
	 * Constructor of class Album
	 * @param artista
	 * 		name of artist who composed the album	
	 * @param titulo
	 * 		the title of algum
	 * @param anoLancamento
	 * 		release year of album 
	 * @param favorito
	 * 		if the album is the favorite of the client
	 * @throws Exception
	 * 		when strings are null or empty, and release year is <= 1900
	 */
	public Album (String artista, String titulo, int anoLancamento, boolean favorito) throws Exception{
		
		if (artista == null || artista.trim().isEmpty()){
			throw new Exception("Artista do album nao pode ser nulo ou vazio.");
		}
		
		if (titulo == null || titulo.trim().isEmpty()){
			throw new Exception ("Titulo do album nao pode ser nulo ou vazio.");
		}
				
		if (anoLancamento <= 1900){
			throw new Exception ("Ano de lancamento do album nao pode ser inferior a 1900.");
		}
		
		
		this.artista = artista;
		this.titulo = titulo;
		this.lancamento = anoLancamento;
		this.favorito = favorito;
		
	}
	
	/**
	 * constructor with 3 parameters 
	 @param artista
	 * 		name of artist who composed the album	
	 * @param titulo
	 * 		the title of algum
	 * @param anoLancamento
	 * 		release year of album 
	 */
	public Album (String artista, String titulo, int anoLancamento) throws Exception{
		this(artista, titulo, anoLancamento, false);
	}

	/**
	 * change the value "favorite"
	 * @param escolha
	 */
	public void setFavorito(boolean escolha){
		this.favorito = escolha;
	}
	
	/**
	 * change the name of artist 
	 * @param artista
	 * 		new name of artist
	 * @throws Exception
	 */
	public void setArtista(String artista) throws Exception {
		if (artista == null || artista.trim().isEmpty()){
			throw new Exception("Artista do album nao pode ser nulo ou vazio.");
		}else{
			this.artista = artista;
		}
	}
	
	/**
	 * change the title of album
	 * @param titulo
	 * 		new title
	 * @throws Exception
	 * 		when title is null or empty
	 */
	public void setTitulo(String titulo) throws Exception {
		if (titulo == null || titulo.trim().isEmpty()){
			throw new Exception ("Titulo do album nao pode ser nulo ou vazio.");
		}else{
			this.titulo = titulo;
		}
	}
	/**
	 * change the value of release year
	 * @param lancamento
	 * 		new release year
	 * @throws Exception
	 * 		if year <= 1900
	 */
	public void setLancamento(int lancamento) throws Exception {
		if (lancamento < 1900){
			throw new Exception ("Ano de lancamento do album nao pode ser inferior a 1900.");
		}else{
			this.lancamento = lancamento;
		}
	}
	
	/**
	 * return the all duration of album
	 * @return 
	 * 		album's duration
	 */
	public int getDuracaoTotal(){
		int duracao = 0;
		
		for(int i = 0; i < musicas.size(); i++){
			duracao += musicas.get(i).getDuracao();
		}
		return duracao;
	}
	
	/**
	 * checks if album is favorite
	 * @return
	 */
	public boolean isFavorito(){
		return this.favorito;
	}
	
	/**
	 * Add music on the album. Receive the title, time and genre of new music
	 * @param titulo
	 * 		title of new music
	 * @param duracao
	 * 		time of new music
	 * @param genero
	 * 		genre of music
	 * @return
	 */
	public boolean addMusica(String titulo, int duracao, String genero){
		
		try{
			Musica novaMusica = new Musica(titulo, duracao, genero);
			return musicas.add(novaMusica);
			
		}catch(Exception exception){
			//exibindo mensagem
			System.out.println(exception.getMessage());
			
		}
		return false;
	}
	
	/**
	 * Add music on the album. Receive the object musica
	 * @param newMusic
	 * 		new object musica
	 * @return
	 */
	public boolean adicionaMusica(Musica newMusic){
		if (newMusic != null){
			return musicas.add(newMusic);
		}else{
			return false;
		}
	}
	
	/**
	 * Remove a music, if exist, on the album
	 * @param tituloMusica
	 * 		title of music it will be removed on the album
	 * @return
	 */
	public boolean removeMusica(String tituloMusica){
		if (tituloMusica == null || tituloMusica.trim().isEmpty()){
			return false;
		}
		else {
			for (int i = 0; i < musicas.size(); i++){
				if (musicas.get(i).getTitulo().equals(tituloMusica)){
					musicas.remove(i);
					return true;
				}
			}
			return false;
		}	
	}
	
	/**
	 * return a music since a track of album
	 * @param faixa
	 * 		number of track
	 * @return
	 * @throws Exception
	 * 		if track <= 0
	 */
	public Musica getMusica(int faixa) throws Exception{
		faixa -= 1;
		if (faixa < 0){
			throw new Exception ("A faixa nao pode ser menor ou igual a zero.");
		}else{
			  //para o usuário a faixa começa de 1, para o desenvolvedor começa de 0
			for (int i = 0; i < musicas.size(); i ++){
				if (musicas.get(i).getTitulo().equals(musicas.get(faixa).getTitulo())){
					return musicas.get(i);
				}
			}
		return null; 	
		}
		
	}
	
	/**
	 * //return an object of type Music with your title "titleMusic"
	 * @param titleMusic
	 * 		title of the music
	 * @return
	 */
	public Musica getMusica(String titleMusic){
		for (Musica music : this.musicas){
			if (music.getTitulo().equals(titleMusic)){
				return music;
			}
		}return null;
	}
		
	/**
	 * return the name of artist
	 * @return
	 * 		return a string with name
	 */
	public String getArtista() {
		return this.artista;
	}

	/**
	 * return the title of the album
	 * @return
	 */
	public String getTitulo() {
		return this.titulo;
	}

	/**
	 * return the release year of album
	 * @return
	 */
	public int getLancamento() {
		return this.lancamento;
	}

	/**
	 * Hash Code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	/**
	 * Equals 
	 */
	@Override
	public boolean equals(Object outroObjeto) {
		if (outroObjeto instanceof Album){
			Album outroAlbum = (Album)outroObjeto;
			if (outroAlbum.getTitulo().equals(this.titulo) && outroAlbum.getArtista().equals(this.artista)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	/**
	 * String representation of album
	 */
	public String toString(){
		String toString; 
		int counter = 0;
		toString = this.getTitulo()+", "+this.getArtista() + "(" + this.getLancamento() + ")";
		for (Musica music : this.musicas){
			counter += 1;
			toString += "\n" + counter + ". " + music.getTitulo() + "(" + music.getGenero() +  	"-" + music.getDuracao() +
				"minutos)";
		}
		return toString;
	}
	
	/**
	 * Contain music "nameMusic" in the album? 
	 * @param nameMusic
	 * @return
	 */
	public boolean contemMusica(String nameMusic){
		for (Musica musica : musicas){
			if (musica.getTitulo().equals(nameMusic)){
				return true;
			}
		}return false;
	}
	
	/**
	 * Remove a music since a track	
	 * @param track
	 * @return
	 */
	public boolean removeMusica (int track){
		track -= 1;
		if (track < musicas.size()){
			musicas.remove(track);
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * return the quantity of tracks on the album 
	 * @return
	 */
	public int quantidadeFaixas (){
		return musicas.size();
	}
}
