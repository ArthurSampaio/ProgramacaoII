package loja;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import jogo.*;
import usuario.*;
import excecoes.*;

public class LojaController {
	public static final String FIM_DE_LINHA = System.lineSeparator();
	private Set<Usuario> meusUsuarios;
	private HashMap<String, Jogabilidade> mapJogabildades;
	private JogoFactory factoryJogo;
	private UsuarioFactory factoryUsuario;
	

	public LojaController() {
		this.meusUsuarios = new HashSet<Usuario>();
		this.initializeMap();
		factoryUsuario = new UsuarioFactory();
		factoryJogo = new JogoFactory();
	}

	
	/**
	 * Create an user of a certain type and add in database. The characteristics of user are passed by parameter
	 * @param nome
	 * 		The name of user
	 * @param login
	 * 		The login of user
	 * @param type
	 * 		Define the type of user
	 * @return
	 * 		The user
	 * @throws Exception
	 * 		When the user is null
	 */
	public void criaUsuario(String nome, String login, String tipoUsuario)throws Exception{
		Usuario user = this.factoryUsuario.criaUsuario(nome, login, tipoUsuario);
		if(user == null){
			throw new Exception("Usuário inválido");
		}else{
			this.meusUsuarios.add(user);
		}
	}
	
	

	public void vendeJogo(String jogoNome, double preco, String jogabilidades, String estiloJogo, String loginUser)throws Exception {
	
		Usuario buscado = this.buscaUsuario(loginUser);
		
		buscado.compraJogo(this.factoryJogo.criaJogo(jogoNome, preco, estiloJogo, jogabilidades));
		

	}
	
	public Jogo criaJogo(String nome, double preco, String type,String jogabilidades)throws Exception{
		return this.factoryJogo.criaJogo(nome, preco, type, jogabilidades);
		
	}



	public void adicionaCredito(String login, double credito) throws Exception {
		Usuario user = this.buscaUsuario(login);
		if(user == null){
			throw new UsuarioInvalidoException("Usuario nao cadastrado");
		}else{
			user.addCredito(credito);
		}
	}	
	
	public Usuario buscaUsuario(String login) {
		Usuario buscado = null;

		for(Usuario user : this.meusUsuarios){
			if(user.getLogin().equals(login)){
				return user;
			}
		}
		return buscado;

	}

	public void upgrade(String login) throws Exception {
		
		Usuario user = this.buscaUsuario(login);
		if(user == null){
			throw new UsuarioInvalidoException();
		}else{
			if(user.getStatus() instanceof Veterano){
				throw new UpgradeInvalidoException();
			}else{
				user.upgrade();
			}
		}
		
	}

	public double confereCredito(String login) throws Exception {
		Usuario user = this.buscaUsuario(login);
		if(user == null){
			throw new UsuarioInvalidoException("Usuario nao cadastrado");
		}else{
			return user.getCredito();
		}
	}

	public String toString() {
		String myString = "=== Central P2-CG ===" + FIM_DE_LINHA + FIM_DE_LINHA;
		
		for(Usuario user : this.meusUsuarios){
			myString += user.toString() + FIM_DE_LINHA;
		}
		return myString;
	}

	public int getX2p(String login) throws Exception{
		Usuario buscado = this.buscaUsuario(login);
		if (buscado == null){
			throw new UsuarioInvalidoException("Usuario nao cadastrado");
		}else{ 
			return buscado.getXp2();
		}
	}

	

	private Set<Jogabilidade> createJogabilidades(String names1) {
		Set<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();

		String[] listofNames = names1.split(",");

		for (int i = 0; i < listofNames.length; i++) {
			String element = listofNames[i].toUpperCase();
			if (element != null) {
				Jogabilidade tipojogabilidade = mapJogabildades.get(element);
				jogabilidades.add(tipojogabilidade);
			}
		}

		return jogabilidades;

	}
	
	private void initializeMap() {
		this.mapJogabildades = new HashMap<String, Jogabilidade>();
		mapJogabildades.put("ONLINE", Jogabilidade.ONLINE);
		mapJogabildades.put("OFFLINE", Jogabilidade.OFFLINE);
		mapJogabildades.put("COMPETITIVO", Jogabilidade.COMPETITIVO);
		mapJogabildades.put("COOPERATIVO", Jogabilidade.COOPERATIVO);
		mapJogabildades.put("MULTIPLAYER", Jogabilidade.MULTIPLAYER);

	}
	
	private Set getMeusUsuarios(){
		return this.meusUsuarios;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((meusUsuarios == null) ? 0 : meusUsuarios.hashCode());
		return result;
	}


	/**
	 * Two stores are equals if have the same users in your databases
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LojaController) {
			LojaController temp = (LojaController) obj;
			return this.getMeusUsuarios().equals(temp.getMeusUsuarios());
		} else {
			return false;
		}
	}
	
	public void punir(String login, String nomeJogo, int score, boolean zerou)throws Exception{
		Usuario user = this.buscaUsuario(login);
		if(user == null){
			throw new UsuarioInvalidoException();
		}else{
			user.punir(nomeJogo, score, zerou);
		}
	}
	
	public void recompensar(String login, String nomeJogo, int score, boolean venceu)throws Exception{
		Usuario user = this.buscaUsuario(login);
		if(user == null){
			throw new UsuarioInvalidoException();
		}else{
			user.recompensar(nomeJogo, score, venceu);
		}
	}
	

	
	
	
}
