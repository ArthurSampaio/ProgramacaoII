package musica;

public class Musica {
	
	private String titulo; 
	private int duracao;
	private String genero;
	
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws Exception {
		if (titulo == null || titulo.trim().isEmpty()){
			throw new Exception("Titulo da musica nao pode ser nulo ou vazio.");
		}else{
			this.titulo = titulo;
		}
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) throws Exception {
		if (duracao <= 0){
			throw new Exception("Duracao da musica nao pode ser negativa.");
		}else{ 
		this.duracao = duracao;
		}
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) throws Exception {
		if (genero == null || genero.trim().isEmpty()){
			throw new Exception("Genero da musica nao pode ser nulo ou vazio.");
		}
		else{ 
			this.genero = genero;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

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
	
	public String toString(){
		return String.format("Música: %s - %d minutos", this.titulo, this.duracao);
		
	}
}