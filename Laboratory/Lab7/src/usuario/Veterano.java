package usuario;


import excecoes.JogoInvalidoException;
import excecoes.StringInvalidaException;
import jogo.Jogabilidade;
import jogo.Jogo;

public class Veterano implements TipoDeUsuario {
	public static final double DESCONTO_VETERANO = 0.8;
	public static final int CONSTANTE_COMPRA = 15;
	public static final String TIPO_USUARIO = "Jogador Veterano";

	
	

	public Veterano(String nome, String login) throws StringInvalidaException {
	}

	@Override
	public double compraJogo(Jogo jogo) throws Exception {
		if (jogo == null){
			throw new JogoInvalidoException( );
		}
		double custo = jogo.getPreco() * DESCONTO_VETERANO;
		return custo;
	}
	
	public int punir(Jogo jogado, int score, boolean venceu) throws Exception{
		if(jogado == null){
			throw new JogoInvalidoException();
		}else{
			int punicao = 0;
			for(Jogabilidade jogabilidade : jogado.getJogalidade()){
				if(jogabilidade ==  Jogabilidade.COMPETITIVO){
					punicao -= 20;
				}else if(jogabilidade == Jogabilidade.OFFLINE){
					punicao -= 20;
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
				if(jogabilidade == Jogabilidade.ONLINE){
					recompensa += 10;
				}else if(jogabilidade == Jogabilidade.COOPERATIVO){
					recompensa += 20;
				}
			}
			return (recompensa + jogado.registraJogada(score, venceu));
		}
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
