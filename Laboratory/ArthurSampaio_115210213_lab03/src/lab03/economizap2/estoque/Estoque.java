package lab03.economizap2.estoque;
import lab03.economizap2.produto.Produto;

/**
 * Classe Estoque
 * 		Controla o estoque de um supermercado que utiliza Produtos 
 * @author Arthur Sampaio
 * 
 * @version 1.0
 * 
 * <br>
 */


public class Estoque {
	
	private int indice = 0;
	private int tamanho = 1;
	private Produto[] estoque = new Produto[tamanho];
	public String quebraLinha = System.getProperty("line.separator");
	public static final int FALSE = -1; 
	//O numero mágico "FALSE" serve para retornar -1 quando a busca por um elemento no 
	//Array estoque for mal-sucedida;


	//Os dois próximos métodos são para deixar o array estoque dinâmico
	/**
	 * Verifica a Quantidade de produtos, se estiver perto de preencher o array ele chama o método aumentaQuantidadeProdutos
	 */
	public void verificaQuantidadeProdutos(){
		if (estoque.length ==  indice + 1){
			aumentaQuantidadeProdutos();
		}
	}
		
	/**
	 * Aumenta o tamanho do array estoque caso esteja próximo de ser preenchido totalmente
	 */
	public void aumentaQuantidadeProdutos(){
		Produto[] novoEstoque = new Produto[tamanho * 2];
		for(int i = 0; i < indice; i++){
			novoEstoque[i] = estoque[i];
		}
		setTamanho(tamanho * 2);
		estoque = novoEstoque;
	}

	/**
	 * Adiciona novos produtos ao estoque
	 * @param novoProduto
	 * @return sucesso da operacao 
	 */
	public void insereProduto(Produto novoProduto){
		verificaQuantidadeProdutos();
		estoque[indice] = novoProduto;
		setIndice(indice + 1);
	}
	
	/**
	 * Verifica se o produto está no estoque
	 * @param nomeProduto
	 * @return True se estiver, false caso contrário
	 */
	public boolean verificaEstoque (String nomeProduto){
		for (int i = 0; i < indice; i++){
			if (estoque[i].getNome().equals(nomeProduto)){
			return true;	
			}
		}return false;
	}
	
	/**
	 * Retira uma quantidade (qtd) de um produto do array estoque
	 * Retorna true se a operação for concluida, c.c. retorna false
	 * 
	 * @param nomeProduto
	 * 			Nome do produto que será retirado
	 * @param qtd
	 * 			Quantidade do produto que será retirado 
	 * @return o sucesso da operação
	 *  
	 */
	public boolean retiraProduto (String nomeProduto, int qtd){
		int indice = pesquisaPorNome(nomeProduto);
		if (indice != FALSE){
			if (estoque[indice].retiraQuantidadeProduto(qtd)){
				return true;
			}
			else{
				return false;
			}	
		}
		else {
			return false;
		}
	}	
	
	/**
	 * Pesquisa o produto no estoque e retorna o indice. Caso não encontre retorna -1 (VARIAVEL FALSE)
	 * 
	 * @param nomeProduto
	 * 			Nome do produto que está sendo pesquisado
	 * @return o indice do produto ou FALSE 
	 */
	public int pesquisaPorNome(String nomeProduto){
		for (int i = 0; i < indice; i++){
			if (estoque[i].getNome().equals(nomeProduto)){
				return i;
			}
		}		
		return FALSE;  //Isso ainda é uma gambiarra 
	} 
	
	/**
	 * Retorna a quantidade de um produto de nomeProduto dentro do estoque
	 * @param nomeProduto
	 * @return quantidade de um nomeProduto
	 */
	public int getQuantidadeProduto(String nomeProduto){
		int indice = pesquisaPorNome(nomeProduto);
		return estoque[indice].getQuantidade
				();
	}
	
	/**
	 * Retorna o preço de nomeProduto dentro do estoque
	 * @param nomeProduto
	 * 			Nome do produto
	 * @return preço unitário do produto pesquisado
	 */
	public double getPrecoProduto(String nomeProduto){
		int indice = pesquisaPorNome(nomeProduto);
		return estoque[indice].getPreco();
	}
	
	/**
	 * Recupera o valor do Indice
	 * @return indice
	 */
	public int getIndice() {
		return indice;
	}


	/**
	 * Altera o valor do indice
	 * @param indice
	 */
	public void setIndice(int indice) {
		this.indice = indice;
	}

	
	/**
	 * Recupera o valor do tamanho
	 * @return tamanho
	 */
	public int getTamanho() {
		return tamanho;
	}

	
	/**
	 * Altera o valor do tamanho;
	 * @param tamanho
	 */
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	/**
	 * Imprime a representação em string do estoque
	 */
	public String toString (){
		return "O estoque tem " + estoque.length + "produtos. ";
	}

	
	/**
	 * Lista todos os produtos cadastrados com nome, categoria, preço e quantidade;
	 */
	public void imprimeTodosProdutos(){
		for (int i = 0; i < indice; i++){
			System.out.printf("\t %d) %s", (i+1),estoque[i].toString());	
			System.out.println();
		}
	}
	
	/**
	 * Calcular o valor que ainda pode ser arrecado por cada produto e retorna o valor da arrecadação total
	 * @return podeGanhar;
	 * 			Valor que ainda é esperado arrecadar com as vendas
	 */
	public double quantoPodeGanhar(){
		double podeGanhar = 0;
		for (int i = 0; i < indice; i++){
			podeGanhar += estoque[i].getPreco() * estoque[i].getQuantidade();
		}
		return podeGanhar;
	}

}
