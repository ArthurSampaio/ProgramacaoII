package musica;

public class Musica {
	
	private String titulo; 
	private int duracao;
	private String genero;
	
	/**
	 * Constructor of class Musica
	 * @param musTitulo
	 * 		title of music
	 * @param musDuracao
	 * 		duration time of music
	 * @param musGenero
	 * 		genre of music
	 * @throws Exception
	 * 		when title and genre are null or empty, and time <= 0
	 */
	public Musica (String musTitulo, int musDuracao, String musGenero) throws Exception{
		if (musTitulo == null || musTitulo.trim().isEmpty()){
			throw new Exception("Titulo da musica nao pode ser nulo ou vazio.");
		}
		
		if (musDuracao <= 0){
			throw new Exception("Duracao da musica nao pode ser negativa.");
		}
		
		if (musGenero == null || musGenero.trim().isEmpty()){
			throw new Exception("Genero da musica nao pode ser nulo ou vazio.");
		}
		
		this.titulo = musTitulo;
		this.duracao = musDuracao;
		this.genero = musGenero;
	}

	/**
	 * return the title of music
	 * @return title of music
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * change the title of music
	 * @param titulo
	 * 		new title
	 * @throws Exception
	 * 		when title is null or empty
	 */
	public void setTitulo(String titulo) throws Exception {
		if (titulo == null || titulo.trim().isEmpty()){
			throw new Exception("Titulo da musica nao pode ser nulo ou vazio.");
		}else{
			this.titulo = titulo;
		}
	}

	/**
	 * return the duration of music in minutes (integer)
	 * @return	duration time
	 */
	public int getDuracao() {
		return duracao;
	}

	/**
	 * change the duration time of music
	 * @param duracao
	 * 		new duration of music, 
	 * @throws Exception
	 * 		new duration <= 0
	 */
	public void setDuracao(int duracao) throws Exception {
		if (duracao <= 0){
			throw new Exception("Duracao da musica nao pode ser negativa.");
		}else{ 
		this.duracao = duracao;
		}
	}

	/**
	 * return the genre of music
	 * @return genre m
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * change the genre of music
	 * @param genero
	 * 		new genre
	 * @throws Exception
	 * 		when new genre is empty or null
	 */
	public void setGenero(String genero) throws Exception {
		if (genero == null || genero.trim().isEmpty()){
			throw new Exception("Genero da musica nao pode ser nulo ou vazio.");
		}
		else{ 
			this.genero = genero;
		}
	}
	
	/**
	 * hashcode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	/**
	 * equals, return true if a.equals(b)
	 */
	public boolean equals(Object outraMusica){
		
		if (outraMusica instanceof Musica){
			Musica novaMusica = (Musica) outraMusica;
			if (novaMusica.getTitulo().equals(this.titulo) && novaMusica.getDuracao() == this.duracao){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
	}

	/**
	 * String representation of class 
	 */
	public String toString(){
		return String.format("%s (%s - %d minutos)", this.titulo,this.genero, this.duracao);
		
	}
}