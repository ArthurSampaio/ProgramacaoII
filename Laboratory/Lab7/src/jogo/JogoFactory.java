package jogo;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;

import excecoes.JogoInvalidoException;
import excecoes.UpgradeInvalidoException;

/**
 * @author Arthur Sampaio Perico Correia
 * @version 1.0
 * 
 * 2016, Federal University of Campina Grande, Brazil
 *
 * Factory for superclass Game
 * 
 */
public class JogoFactory {
	private HashMap<String, Jogabilidade> mapJogabildades;
	
	public JogoFactory(){
		this.initializeMap();
	}
	public Jogo criaJogo(String jogoNome, double preco, String tiposJogabilidades, String estiloJogo)
			throws Exception {
		String estilo = estiloJogo.toLowerCase();
		if (estilo.equals("rpg")) {
			return criaRPG(jogoNome, preco, tiposJogabilidades);
		} else if (estilo.equals("plataforma")) {
			return criaPlataforma(jogoNome, preco, tiposJogabilidades);
		} else if (estilo.equals("luta")) {
			return criaLuta(jogoNome, preco, tiposJogabilidades);
		} else {
			throw new JogoInvalidoException();
		}
	}
	public Set<Jogabilidade> createJogabilidades(String names1) {
		Set<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();

		String[] listofNames = names1.split(" ");

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
	private Jogo criaRPG(String nome, double preco,String tiposJogabilidade)
			throws Exception {
		
		Jogo jogo = new Rpg(nome,preco,createJogabilidades(tiposJogabilidade));
		return jogo;

	}

	private Jogo criaPlataforma(String nome, double preco, String tiposJogabilidade)
			throws Exception {
		Jogo jogo = new Plataforma(nome,preco,createJogabilidades(tiposJogabilidade));
		return jogo;
		
	}

	private Jogo criaLuta(String nome, double preco, String tiposJogabilidade)
			throws Exception {
		Jogo jogo = new Luta(nome,preco,createJogabilidades(tiposJogabilidade));
		return jogo;
	
	}


}