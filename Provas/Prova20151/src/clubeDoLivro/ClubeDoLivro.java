package clubeDoLivro;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import excessoes.ClubeDoLivroException;
import excessoes.LivroNotFoundException;
import livro.Livro;

public class ClubeDoLivro {
	
	private HashMap<String, Livro> livrosCadastrados;

	public ClubeDoLivro() {
		this.livrosCadastrados = new HashMap<String, Livro>();
	}
	
	public void adicionaLivro(String titulo, String autor, int ano, String isbn) throws Exception{	
		if(this.testaString(titulo)){
			throw new IllegalArgumentException("Titulo nao pode ser nulo ou vazio.");
		}
		
		if(this.testaString(autor)){
			throw new IllegalArgumentException("Autor nao pode ser nulo ou vazio.");
		}
		
		if(this.testaString(isbn)){
			throw new IllegalArgumentException("ISBN nao pode ser nulo ou vazio.");
		}
		
		if(this.livrosCadastrados.containsKey(isbn)){
			this.livrosCadastrados.put(isbn, new Livro(titulo, autor, ano, isbn));
		}else{
			throw new ClubeDoLivroException("Livro ja pertence ao acervo.");
		}
	}
	
	public void importaLivros(String filename) throws IOException{
		String file = "C:\\Users\\sampaio\\workspace\\ProgramacaoII\\Provas\\Prova20151\\src\\clubeDoLivro\\resources_p2.csv";
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		while(br.ready()){
			String linha = br.readLine().trim();
			//retira os espacos aqui acima	
			if(!"".equals(linha)){
				String[] parametros = linha.split(",");
				int ano = Integer.parseInt(parametros[2].trim());
				Livro livro = new Livro(parametros[0], parametros[1],
						ano, parametros[3]);
				this.livrosCadastrados.put(livro.getISBN(), livro);
			}
		}
		
		
		
	}

	public Livro buscaLivro(String isbn) throws ClubeDoLivroException {
		if(this.testaString(isbn)){
			throw new LivroNotFoundException();
		}
		if(this.livrosCadastrados.containsKey(isbn)){
			return this.livrosCadastrados.get(isbn);
		}else{
			throw new ClubeDoLivroException("O livro nao esta no nosso acervo.");
			
		}
		
	}

	public void adicionaOpiniao(String isbn, int nota, String autor, String comentario) throws Exception {
		Livro buscado = this.buscaLivro(isbn);
		buscado.addOpiniao(nota, autor, comentario);
			
	}

	public double getNotaGeral(String isbn) throws Exception {
		Livro buscado = this.buscaLivro(isbn);
		return buscado.getAvaliacao();
	}
	
	public void listaOpinioes(String isbn) throws Exception{
		Livro buscado = this.buscaLivro(isbn);
		System.out.println(buscado.toString());
	}
	
	public void ranking(int n) throws Exception{
		
		if (n > this.livrosCadastrados.size()){
			throw new ClubeDoLivroException("Nao ha livros suficientes no acervo.");
		}
		
		String valor = "";
		String quebraLinha = System.getProperty("line.separator");
		List raking = new ArrayList<Livro>();
		for(String key : this.livrosCadastrados.keySet()){
			raking.add(this.livrosCadastrados.get(key));
			
		}
		
		for(int i = 0; i < raking.size(); i ++){
			valor += raking.get(i).toString();
			valor += quebraLinha;
		}
		
		System.out.println(valor);
		
	}
	
	private boolean testaString(String m){
		if(m == null || m.trim().isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	
}