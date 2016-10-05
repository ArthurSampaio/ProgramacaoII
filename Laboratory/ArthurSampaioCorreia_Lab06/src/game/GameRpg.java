package game;

public class GameRpg extends Game {
	
	private final static int EXPERIENCE = 10;
	
	/**
	 * @author Arthur Sampaio Perico Correia
	 * @version 1.0
	 * 
	 * 2016, Federal University of Campina Grande, Brazil
	 * 
	 * 
	 * Constructor of class GameRpg
	 * @param name
	 * 		the name of game
	 * @param price
	 * 		the price of game
	 * @throws Exception
	 * 		When:
	 * 			name is null or empty
	 * 			price its smaller that zero
	 */
	public GameRpg(String name, double price)throws Exception{
		super(name, price);
		this.setStyle("RPG");
		//concluir, presta atenção criatura nas coisa
		
	}
	
	/**
	 * Calcs the x2p for any type of user
	 * @param score
	 * 		the score in math
	 * @param isReset
	 * 		if reset, true, otherwise, false. 
	 * @return
	 * 		the value of experience in x2p
	 */
	@Override
	public int calcX2p(int score, boolean reset){
		return EXPERIENCE;
	}
	

	

}
