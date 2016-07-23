package album;
import musica.Musica;
import java.util.*;

public class Album {
	
	private String artista;
	private String titulo;
	private int lancamento;
	private ArrayList<Musica> musicas = new ArrayList <Musica>();
	private boolean favorito;
	
	//Contrutor com todos os parâmetros
	public Album (String artista, String titulo, int anoLancamento, boolean favorito) throws Exception{
		
		if (artista == null || artista.trim().isEmpty()){
			throw new Exception("Artista do album nao pode ser nulo ou vazio.");
		}
				
		if (anoLancamento <= 1900){
			throw new Exception ("O ano de lancamento do album não pode ser menor que 1900");
		}
		
		
		this.artista = artista;
		this.titulo = titulo;
		this.lancamento = anoLancamento;
		this.favorito = favorito;
		
	}
	
	//Contrutor com apenas três parâmetros
	public Album (String artista, String titulo, int anoLancamento) throws Exception{
		this(artista, titulo, anoLancamento, false);
	
	}

	//SETRS
	public void setFavorito(boolean escolha){
		this.favorito = escolha;
	}
	
	public void setArtista(String artista) throws Exception {
		if (artista == null || artista.trim().isEmpty()){
			throw new Exception("Artista do album nao pode ser nulo ou vazio.");
		}else{
			this.artista = artista;
		}
	}
	
	public void setTitulo(String titulo) throws Exception {
		if (titulo == null || titulo.trim().isEmpty()){
			throw new Exception ("Titulo do album nao pode ser nulo ou vazio.");
		}else{
			this.titulo = titulo;
		}
	}
	
	public void setLancamento(int lancamento) throws Exception {
		if (lancamento < 1900){
			throw new Exception ("O ano de lancamento do album não pode ser menor que 1900");
		}else{
			this.lancamento = lancamento;
		}
	}
	
	// GET DURACAO
	public int getDuracao(){
		int duracao = 0;
		
		for(int i = 0; i < musicas.size(); i++){
			duracao += musicas.get(i).getDuracao();
		}
		return duracao;
	}
	
	//Verifica se é favorito
	public boolean isFavorito(){
		return this.favorito;
	}
	
	//Adiciona Música	
	public boolean addMusica(String titulo, int duracao, String genero){
		
		try{
			Musica novaMusica = new Musica(titulo, duracao, genero);
			musicas.add(novaMusica);
		}catch(Exception exception){
			//exibindo mensagem
			System.out.println(exception.getMessage());
			
		}
		return false;
	}
	
	//Remove Música
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

	
	//retorna um objeto música, apartir da faixa da sua música. 
	public Musica getMusica(int faixa) throws Exception{
		if (faixa <= 0){
			throw new Exception ("A faixa nao pode ser menor ou igual a zero.");
		}else{
			faixa -= 1;   //para o usuário a faixa começa de 1, para o desenvolvedor começa de 0
			for (int i = 0; i < musicas.size(); i ++){
				if (musicas.get(i).getTitulo().equals(musicas.get(faixa).getTitulo())){
					return musicas.get(i);
				}
			}
		return null; 	
		}
		
	}
	
	//retorna um objeto música se existir uma com o respectivo nome 
	public Musica getMusica(String musica) throws Exception{
		if (musica == null || musica.trim().isEmpty()){
			throw new Exception ("O Titulo da musica nao pode ser nulo ou vazio.");
		}else{
			for (int i = 0; i < musicas.size(); i++){
				if(musicas.get(i).getTitulo().equals(musica)){
					return musicas.get(i);
				}
			}
		return null;
		}
	}
	
	
	//GETRS
	public String getArtista() {
		return this.artista;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public int getLancamento() {
		return this.lancamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

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

	public String toString(){
		return String.format("Nome: %s, Artista: %s, Duracao total de %d, %d faixas. ", this.getTitulo(),this.getArtista(),this.getDuracao(),musicas.size());
	}
	
}
