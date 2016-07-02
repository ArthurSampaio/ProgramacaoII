/*Aluno: Arthur Sampaio*/
package lab02.lojaop2;
import java.util.Scanner;

public class CompraLojaoP2 {
	
	public static double PRECO = 1.99;
	
	public  void compras(String[] args){
		int produtosDiferentes;
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite a quantidade de produtos diferentes que será comprada:");
		produtosDiferentes = sc.nextInt();

		String[] produto = new String[produtosDiferentes];
		int[] quantidade = new int[produtosDiferentes];
		int total = 0;
		int porcentagem = 0;

		for (int i = 1 ;i < produtosDiferentes+1; i++){
			System.out.print("Nome do Produto " + i + ":");
			produto[i-1] = sc.next();
			
			System.out.print("Quantidade de " + produto[i-1] + ": ");
			quantidade[i-1] = sc.nextInt();
			total = total + quantidade[i-1];
			sc.nextLine();
							
		}
		
		System.out.println("--Cadastro Concluido--\nA sua compra foi:");
		for (int j = 0; j < produto.length; j++){
			porcentagem = ((quantidade[j] *100)/ total);
			System.out.println(quantidade[j] + " " + produto[j] + " (" + (porcentagem) + "%)");
			porcentagem = 0;
		}

		System.out.println("Total de produtos: " + total );
		System.out.println("Total gasto: R$ " + total*PRECO);
		System.out.println("--- Fim da Execução ---");
		sc.nextLine();
	}
}