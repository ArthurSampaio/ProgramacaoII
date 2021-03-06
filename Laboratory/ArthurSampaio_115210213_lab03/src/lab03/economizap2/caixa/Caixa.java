package lab03.economizap2.caixa;
import lab03.economizap2.produto.Produto;
import lab03.economizap2.leitor.Input;
import lab03.economizap2.estoque.Estoque;	

/**
 * Classe Caixa (Principal do Laboratório 03)
 * 
 * @author Arthur Sampaio
 * @version 1.0
 * 
 * 2016, Universidade Federal de Campina Grande
 * 
 */
public class Caixa {
	private static double saidaTotal = 0.0; 	
	private static Estoque estoque = new Estoque();
	public static Input input = new Input();
	
	public static final int CADASTRAR = 1;
	public static final int VENDER = 2;
	public static final int IMPRIMIR = 3;
	public static final int SAIR = 4;
	
	//O numero mágico "FALSE" serve para comparar quando o retorno de um método int com comando condicional
	//for mal sucessido
	public static final int FALSE = -1; 
	
	
	public void menuCaixa(){
		while (true) {
			menu();
			int entrada = input.inteiro("Opção: ");
			
				switch(entrada){
				
				case CADASTRAR:
					cadastraProduto();
					break;
				
				case VENDER:
					vendeProduto();
					break;
					
				case IMPRIMIR:
					imprimeBalanco();
					break;
					
				case SAIR:
					System.exit(0);
					
				default:
					System.out.println("Esta opcao nao é valida.");
				}
		}
				
	}
		
	/**
	 * Imprime o menu inicial
	 */
	public void menu(){
	
		System.out.println("====Bem-vindo(a) ao EconomizaP2====");
		System.out.println("Digite a opção desejada:");
		System.out.println("1-Cadastrar um Produto");
		System.out.println("2-Vender um Produto");
		System.out.println("3-Imprimir Balanço");
		System.out.println("4-Sair");
		System.out.println();
	}
	
	/**
	 * Recebe os atributos do tipo Produto e instancia um objeto, em seguida este objeto é adicionado ao estoque
	 */
	public void cadastraProduto(){
		String opcao = "Nao";
		do{
			String nome = input.string("Digite o nome do produto: ");
			if (estoque.verificaEstoque(nome) == true){
				System.out.println("Produto já Cadastrado. ");
			}
			else{ 	
				double preco = input.real("Digite o preço unitário do produto: ");
				String categoria = input.string("Digite o tipo do produto: ");
				int quantidade = input.inteiro("Digite a quantidade no estoque: ");
				Produto produto = new Produto(nome,categoria, preco, quantidade);
				estoque.insereProduto(produto);
				System.out.println(quantidade + "''"+ nome + "''" + " cadastrado(s) com sucesso.");
			}	
			System.out.println();
			opcao = input.string("Deseja cadastrar outro produto? ");
			System.out.println();
						
		}while(opcao.equals("Sim"));
	}
	
	/**
	 * Realiza a venda de produtos
	 */
	public void vendeProduto(){
		String opcao = "Nao";
		System.out.println("= = = = Venda de Produtos = = = = ");
		do{
			String nomeProduto = input.string("Digite o nome do Produto: ");
			//Se estiver o nomeProduto estiver no estoque
			if (estoque.verificaEstoque(nomeProduto)){
				double precoUnitario = estoque.getPrecoProduto(nomeProduto);
				System.out.println("===> " + "(" + nomeProduto + "). R$" + precoUnitario);
				System.out.println();
				int quantidadeVendida = input.inteiro("Digite a quantidade que deseja vender: ");
				if (estoque.retiraProduto(nomeProduto, quantidadeVendida)){
					//calcular a preço da saida
					System.out.println("===> Total arrecadado: R$ " + calculaValorDaVenda(nomeProduto, quantidadeVendida));
					System.out.println();
				}
				else{
					System.out.println("Não é possível vender pois não há " + nomeProduto + " suficiente");
				}
			}
			
			else{
				System.out.println(nomeProduto + "nao cadastrada no sistema.");
			}
			opcao = input.string("Deseja vender outro produto? ");
			
		}while(opcao.equals("Sim"));
		
	}
	
	
	
	public void imprimeBalanco(){
		System.out.println("= = = = Impressao de Balanco = = =");
		System.out.println("Produtos cadastrados: ");
		estoque.imprimeTodosProdutos();	
		System.out.println();
		System.out.println("Total arrecadado em vendas: R$ " + getSaidaTotal());
		System.out.println("Total que pode ser arrecadado: R$ " + estoque.quantoPodeGanhar());
		input.line("");
				
	}
	
	/**
	 * Calcula o valor da operacao de venda
	 * @param nomeProduto
	 * 			Nome do produto que está sendo vendido
	 * @param quantidadeVendida
	 * 			Quantidade do produto vendida
	 * @return
	 */
	public double calculaValorDaVenda(String nomeProduto, int quantidadeVendida){
		double precoUnitario = estoque.getPrecoProduto(nomeProduto);
		double valorOperacao = precoUnitario * quantidadeVendida;
		saidaTotal += valorOperacao;
		return valorOperacao;
	}
	
	

	/**
	 * Recupera o valor do total arrecadado em vendas	
	 * @return saidaTotal
	 */
	public double getSaidaTotal() {
		return saidaTotal;
	}

	
	
	
	
	
}	
	

