package livro;

public class Livro {
	private String titulo;
	private String autor;
	private String ISBN;
	private int ano;
	
	public Livro(String titulo,String autor, int ano, String isbn) throws RuntimeException{
		if(this.testaString(titulo)){
			throw new IllegalArgumentException("Titulo do livro nao pode ser nulo ou vazio");
		}if(this.testaString(autor)){
			throw new IllegalArgumentException("Autor do livro nao pode ser nulo ou vazio");
		}if(this.testaString(isbn)){
			throw new IllegalArgumentException("O ISBN nao pode ser nulo ou vazio");
		}
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = isbn;
		this.ano = ano;
	}

	public boolean testaString(String m){
		if(m == null || m.trim().isEmpty()){
			return false;
		}else{
			return true;
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getISBN(){
		return this.ISBN;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Livro){
			Livro livro = (Livro)obj;
			if(livro.getISBN().equals(this.getISBN())){
				return true;
			}else{
				return false;
			}
		}
		return true;
	}
	
	
	
}
