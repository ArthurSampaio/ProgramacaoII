package lab03.economizap2.leitor;
import java.util.Scanner;

/**
 * Classe Input,
 * Para ler dados e imprimir a mensagem de inteiros, real, strings e linhas
 * 
 * @author Arthur Sampaio
 * @version 1.0
 * 
 * 2016, Universidade Federal de Campina Grande
 * 
 */

public class Input {
	
	public static Scanner sc = new Scanner(System.in);
	
	/**
	 * Os métodos abaixo retornam respectivamente
	 * 
	 * @return int
	 * @return double
	 * @return String
	 */
	
	public  int inteiro(String mensagem){
		System.out.print(mensagem);
		int qualquer = sc.nextInt();
		sc.nextLine();
		return qualquer;
	}
	
	public  double real (String mensagem){
		System.out.print(mensagem);
		double qualquer = sc.nextDouble();
		sc.nextLine();
		return qualquer;
	}
	
	public  String string (String mensagem){
		System.out.print(mensagem);
		String qualquer = sc.next();
		sc.nextLine();	
		return qualquer;
	}
	
	public String line (String mensagem){
		System.out.print(mensagem);
		String qualquer = sc.nextLine();
		sc.nextLine();
		return qualquer;
	}
	
}
