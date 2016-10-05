package usuario;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import excecoes.*;
import jogo.Jogo;
import usuario.Noob;
import usuario.Veterano;

public class Usuario {

	public static final String FIM_DE_LINHA = System.lineSeparator();
	public static final int XP2_LIMIAR = 1000;

	private String nome;
	private String login;
	private Set<Jogo> meusJogos;
	private double credito;
	private int xp2;
	private TipoDeUsuario statusUsuario;

	public Usuario(String nome, String login) throws StringInvalidaException {

		if (nome == null || nome.trim().isEmpty()) {
			throw new StringInvalidaException("Nome nao pode ser nulo ou vazio.");
		}
		if (login == null || login.trim().isEmpty()) {
			throw new StringInvalidaException("Login nao pode ser nulo ou vazio.");
		}

		this.nome = nome;
		this.login = login;
		meusJogos = new HashSet<Jogo>();
		this.credito = 0;
		this.statusUsuario = new Noob(nome, login);
		this.xp2 = 0;
	}


	public TipoDeUsuario getStatus(){
		return this.statusUsuario;
	}
	
	public void setStatus(TipoDeUsuario sts){
		this.statusUsuario = sts;
	}
	
	
	public void addCredito(double cred)throws Exception{
		if(cred < 0){
			throw new ValorInvalidoException("Nao é possivel adicionar credito negativo");
		}else{
			this.credito += cred;
		}
	}
	
		
	public void addXp2(int value){
		this.xp2 += value;
	}

	public void compraJogo(Jogo jogo)throws Exception{
		this.retiraCredito(this.statusUsuario.compraJogo(jogo));
		this.meusJogos.add(jogo);
		this.addXp2(this.statusUsuario.getXP2(jogo));
	}

	public void retiraCredito(double value)throws Exception{
		if(value > this.getCredito()){
			throw new ValorInvalidoException("O saldo nao pode ficar negativo.");
		}else{
			this.credito -= value;
		}
	}
	
	public void upgrade()throws UpgradeInvalidoException, StringInvalidaException{
		if(this.getXp2() < XP2_LIMIAR){
			throw new UpgradeInvalidoException();
		}else{
			this.statusUsuario = new Veterano(this.nome,this.login);
		}
	}
	
	public void downgrade() throws StringInvalidaException{
		if(this.getXp2() < 1000){
			this.statusUsuario = new Noob(this.nome, this.login);
		}
	}
	
	public int getXp2() {
		return this.xp2;
	}

	public void cadastraJogo(Jogo jogo) {
		this.meusJogos.add(jogo);
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setCredito(double novoValor) {
		this.credito = novoValor;
	}

	public double getCredito() {
		return this.credito;
	}
	
	
	public void punir(String nomeJogo, int score, boolean venceu)throws Exception{
		Jogo jogado = this.buscaJogo(nomeJogo);
		if(jogado == null){
			throw new JogoInvalidoException();
		}else{
			jogado.registraJogada(score, venceu);
			this.addXp2(this.statusUsuario.punir(jogado, score, venceu));
		}
	}
	
	
	public void recompensar(String nomeJogo, int score, boolean venceu)throws Exception{
		Jogo jogado = this.buscaJogo(nomeJogo);
		if(jogado == null){
			throw new JogoInvalidoException();
		}else{
			jogado.registraJogada(score, venceu);
			this.addXp2(this.statusUsuario.recompensar(jogado, score, venceu));
			
		}
	}

	
	public Jogo buscaJogo(String nomeJogo) {
		Jogo buscado = null;
		Iterator<Jogo> itr = meusJogos.iterator();
		while (itr.hasNext()) {
			Jogo achado = (Jogo) itr.next();
			if (achado.getNome().equals(nomeJogo)) {
				buscado = achado;
			}
		}
		return buscado;
	}

	public void addJogos(Set<Jogo> jogos){
		for(Jogo jogo : jogos){
			this.meusJogos.add(jogo);
		}
	}
	
	public Set<Jogo> getMeusJogos() {
		return meusJogos;
	}

	public void setMeusJogos(Set<Jogo> meusJogos) {
		this.meusJogos = meusJogos;
	}

	public double calculaPrecoTotal() {
		double total = 0;
		Iterator<Jogo> itr = meusJogos.iterator();
		while (itr.hasNext()) {
			Jogo achado = (Jogo) itr.next();
			total += achado.getPreco();
		}
		return total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	/**
	 * Two users are equals if have the same login
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario temp = (Usuario) obj;
			return this.getLogin().equals(temp.getLogin());
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
	String myString = this.getLogin() + FIM_DE_LINHA;
	myString += this.getNome() + this.statusUsuario.toString() + FIM_DE_LINHA;
	myString += "Lista de Jogos:" + FIM_DE_LINHA;
	Iterator<Jogo> itr = getMeusJogos().iterator();
	while (itr.hasNext()) {
		Jogo j = (Jogo) itr.next();
		myString += j.toString();
	}
	myString += FIM_DE_LINHA;
	myString += "Total de pre�o dos jogos: R$ " + this.calculaPrecoTotal() + FIM_DE_LINHA;
	myString += "--------------------------------------------";
	return myString;
	}

	


}
