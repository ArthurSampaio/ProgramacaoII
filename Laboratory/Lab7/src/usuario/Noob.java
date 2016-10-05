package usuario;


import excecoes.JogoInvalidoException;
import excecoes.StringInvalidaException;
import jogo.Jogabilidade;
import jogo.Jogo;

public class Noob implements TipoDeUsuario {
	
	public static final double DESCONTO_NOOB = 0.9;
	public static final String TIPO_USUARIO = "Jogador Noob";
	public static final int CONSTANTE_COMPRA = 10;

	
	public Noob(String nome, String login) throws StringInvalidaException {
	}
	
	public int punir(Jogo jogado, int score, boolean venceu) throws Exception{
		if(jogado == null){
			throw new JogoInvalidoException();
		}else{
			int punicao = 0;
			for(Jogabilidade jogabilidade : jogado.getJogalidade()){
				if(jogabilidade ==  Jogabilidade.ONLINE){
					punicao -= 10;
				}else if(jogabilidade == Jogabilidade.COMPETITIVO){
					punicao -= 20;
				}else if(jogabilidade == Jogabilidade.COOPERATIVO){
					punicao -= 50;
				}
			}return (punicao + jogado.registraJogada(score, venceu));
		}
	
	}
	
	public int recompensar(Jogo jogado, int score, boolean venceu) throws Exception{
		if(jogado == null){
			throw new JogoInvalidoException();
		}else{
			int recompensa = 0;
			for(Jogabilidade jogabilidade : jogado.getJogalidade()){
				if(jogabilidade == Jogabilidade.OFFLINE){
					recompensa += 30;
				}else if(jogabilidade == Jogabilidade.MULTIPLAYER){
					recompensa += 10;
				}
			}
			return (recompensa + jogado.registraJogada(score, venceu));
		}
	}

	@Override
	public double compraJogo(Jogo jogo) throws Exception {
		if (jogo == null){
			throw new JogoInvalidoException( );
		}
		double custo = jogo.getPreco() * DESCONTO_NOOB;
		return custo;
	}
	
	public int getXP2(Jogo jogo){
		Double preco = jogo.getPreco();
		return preco.intValue() * CONSTANTE_COMPRA;
	}

	@Override
	public String toString() {
		return TIPO_USUARIO;
	}

}