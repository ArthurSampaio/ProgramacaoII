package lab03.economizap2.produto;

/**
 * Classe Produto,
 * 
 * @author Arthur Sampaio
 * @version 1.0
 * <br> 
 * 2016, Universidade Federal de Campina Grande
 *
 */
public class Produto {
	private String nome;
	private String categoria;
	private double preco;
	private int quantidade; 
	
	/**
	 * Cria um produto a partir do nome, categoria, preço e quantidade do produto
	 * 
	 * @param nome 
	 * 				o nome do produto
	 * @param categoria
	 * 				a categoria do produto
	 * @param preco
	 * 				o preco unitário do produto
	 * @param qtd
	 * 				a quantidade disponível do produto
	 * 
	 */
	
	public Produto(String nome, String categoria, double preco, int qtd){
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
		this.quantidade = qtd;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome(){
		return nome; 
	}
	
	/**
	 * Recebe uma quantidade "qtd" de produtos a vender e realiza a operação de retirar qtd do estoque
	 * @param qtd
	 * @return True se a operação for bem-sucedida, False caso contrário. 
	 */
	public boolean retiraQuantidadeProduto(int qtd){
		if (quantidade >= qtd){
			quantidade -= qtd;
			return true;
		}
		return false;
	}
	
	/**
	 * Adiciona mais unidade a um Produto
	 * @param qtd
	 * 			Quantidade a ser adicionada
	 * @return Sucesso da operação
	 */
	public boolean adicionaProduto(int qtd){
		if (qtd > 0){
			quantidade += qtd;
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna a representação em string do produto;
	 */
	public String toString(){
		return getNome() + "(" + getCategoria() + "). R$" + getPreco() + " Restante: " + getQuantidade();
	}
	
}
