/*Aluno: Arthur Sampaio*/
package lab02.lojaop2;
import java.util.Scanner;

public class MenuPrincipal {
	
	
	public static void main(String[] args){
		Scanner nc = new Scanner(System.in);
	
		while (true) {
			System.out.println("Bem vindo ao LojaoP2!");
			System.out.println("Menu Inicial: Digite uma das opções abaixo:\n");
			System.out.println("1 - Realizar Compra");
			System.out.println("2 - Mudar preço base de produtos");
			System.out.println("3 - Sair");
			System.out.println("Opção: ");
			int opcao = nc.nextInt(); 
			
			if (opcao == 1){
				CompraLojaoP2 compra = new CompraLojaoP2();
				compra.compras(args);
			}
			
			else if (opcao == 2){
				System.out.println("Digite o novo valor de preço: ");
				double preco = nc.nextDouble();
				CompraLojaoP2 compra = new CompraLojaoP2();
				compra.PRECO = preco;
			}
			
			else{
				System.out.println("Até mais");
				break;
			}
		}
		
		
	}

}
