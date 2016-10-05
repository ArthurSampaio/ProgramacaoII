package game;

public class GameFight extends Game{
	
	
	/**
	 * 
	 * @author Arthur Sampaio Perico Correia
	 * @version 1.0
	 * 
	 * 2016, Federal University of Campina Grande, Brazil
	 *  
	 * Constructor of class GameFight
	 * @param name
	 * 		the name of game
	 * @param price
	 * 		the price of game
	 * @throws Exception
	 * 		When:
	 * 			name is null or empty
	 * 			price its smaller that zero
	 */
	public GameFight(String name, double price)throws Exception{
		super(name, price);
		this.setStyle("Fight");
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
	public int calcX2p(int score, boolean isReset){	
			//if the bestscore value is greater than 100000
			if(this.getBestScore() > 100000){
				this.setBestScore(100000);
			}
			return this.getBestScore()/1000;
		
	}

}
