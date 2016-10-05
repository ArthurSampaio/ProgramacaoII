package usuario;
import jogo.*;

public interface TipoDeUsuario {
	double compraJogo(Jogo jogo)throws Exception;
	int punir(Jogo nomeJogo, int scoreObtido, boolean zerou) throws Exception;
	int recompensar(Jogo nomeJogo, int scoreObtido, boolean zerou) throws Exception;
	int getXP2(Jogo jogo);

}
