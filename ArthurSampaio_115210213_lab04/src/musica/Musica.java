package musica;

public class Musica {
	
	private String titulo; 
	private int duracao;
	private String genero;
	
	public Musica (String musTitulo, int musDuracao, String musGenero){
		this.titulo = musTitulo;
		this.duracao = musDuracao;
		this.genero = musGenero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
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



	public boolean equals(Object outra){
		
		if (outra instanceof Musica){
			Musica other = (Musica) outra;
			if (outra.getTitulo().equals(this.titulo)
		}
		
	} 
