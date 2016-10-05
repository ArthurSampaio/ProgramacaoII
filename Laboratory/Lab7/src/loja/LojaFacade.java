package loja;

import java.util.Set;

import easyaccept.EasyAccept;
import jogo.*;
import usuario.*;
import loja.LojaController;

public class LojaFacade {
	private final static int FALSE = 0;
	private LojaController loja;
	
	public LojaFacade(){
		this.loja = new LojaController();
	}  

	

	public void criaUsuario(String nome, String login, String tipoUsuario) throws Exception {
		try{ 
			loja.criaUsuario(nome, login, tipoUsuario);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}



	public void vendeJogo(String jogoNome, double preco, String jogabilidades, String estiloJogo, String loginUser)
			throws Exception {
		try{ 
			loja.vendeJogo(jogoNome, preco, jogabilidades, estiloJogo, loginUser);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}



	public Jogo criaJogo(String nome, double preco, String type, String jogabilidades) throws Exception {
		try{ 
			return loja.criaJogo(nome, preco, type, jogabilidades);
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}



	public void adicionaCredito(String login, double credito) throws Exception {
		try{ 
			loja.adicionaCredito(login, credito);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}



	public Usuario buscaUsuario(String login) {
		try{ 
			return loja.buscaUsuario(login);
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}



	public void upgrade(String login) throws Exception {
		try{ 
			loja.upgrade(login);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}



	public double confereCredito(String login) throws Exception {
		try{ 
			return loja.confereCredito(login);
		}catch(Exception e){
			System.out.println(e.getMessage());
			return 0;
		}
	}



	public String toString() {
		return loja.toString();
	}



	public int getX2p(String login) throws Exception {
		try{ 
			return loja.getX2p(login);
		}catch(Exception e){
			System.out.println(e.getMessage());
			return 0;
		}
	}



	public void punir(String login, String nomeJogo, int score, boolean zerou) throws Exception {
		try{ 
			loja.punir(login, nomeJogo, score, zerou);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}



	public void recompensar(String login, String nomeJogo, int score, boolean venceu) throws Exception {
		try{ 
			loja.recompensar(login, nomeJogo, score, venceu);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}



	public static void main(String[] args) {
		args = new String[] { "loja.LojaFacade", "acceptance_test/us1.txt", "acceptance_test/us2.txt",  "acceptance_test/us3.txt" };
		EasyAccept.main(args);

	}
	
}
