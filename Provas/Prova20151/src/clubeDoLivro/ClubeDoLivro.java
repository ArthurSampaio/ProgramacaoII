package clubeDoLivro;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

import livro.Livro;

public class ClubeDoLivro {
	
	private HashMap<String, Livro> livrosCadastrados;

	public ClubeDoLivro() {
		this.livrosCadastrados = new HashMap<String, Livro>();
	}
	
	public void adicionaLivro(String titulo, String autor, int ano, String isbn) throws Exception{		
	}
	
	public void importaLivros(String filename) throws Exception{
		FileReader fr = new FileReader("resources_p2.csv");
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()){
			String linha = br.readLine().trim();
			if(!"".equals(linha)){
				String[] parametros = linha.split(",");
				int ano = Integer.parseInt(parametros[2]);
				Livro livro = new Livro(parametros[0], parametros[1],
						ano, parametros[3]);
			//	if (! livrosCadastrados.put(livro.getISBN(), livro)){
					
				//}
			}
		}
		
		
		
	}

	public Livro buscaLivro(String isbn) throws Exception {
		return null;
	}

	public void adicionaOpiniao(String isbn, int nota, String autor, String comentario) throws Exception {
	}

	public double getNotaGeral(String isbn) throws Exception {
		return 0.0;
	}
	
	public void listaOpinioes(String isbn) throws Exception{
	}
	
	public void ranking(int n) throws Exception{
	}
	
}