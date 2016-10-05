package game;
import java.util.HashSet;

import gameplay.GamePlay;

/**
 * Class for objects of type Game
 * 
 * @author Arthur Sampaio Perico Correia
 * @version 1.0
 * 
 * 2016, Federal University of Campina Grande, Brazil
 *  
 */

public abstract class Game {
	private String name;
	private double price;
	private int bestScore;
	private int qntMatches;
	private int qntReset;
	private HashSet<GamePlay> styleGame;
	private String style; 

	
	/**
	 * 
	  * Constructor of class Game
	 * @param name
	 * 		the name of game
	 * @param price
	 * 		the price of game
	 * @throws Exception
	 * 		When:
	 * 			name is null or empty
	 * 			price its smaller that zero
	 */
	public Game(String name, double price) throws Exception{
		if(name == null || name.trim().isEmpty()){
			throw new Exception("O nome do jogo nao pode ser nulo ou vazio");
		}
		
		if(price < 0){
			throw new Exception("O preco do jogo nao pode ser inferior a 0 $");
		}
		
		this.name = name;
		this.price = price;
		this.bestScore = 0;
		this.qntMatches = 0;
		this.qntReset = 0;
		this.styleGame = new HashSet<GamePlay>();
		this.style = " ";
	}
	
	/**
	 * Register a new move in the game. Receives a int indicating newScore, if newScore it's bigger than bestScore
	 * bestScore assumes the value of newScore.  
	 * @param score
	 * 		Score of present move
	 * @param isReset
	 * 		indicates if the game is reset. 
	 * @return the experience(x2p)
	 */
	public void registerMove(int score, boolean isReset){
		this.increaseQntMatches();
		if (isReset){
			this.zeroedGame();
		}
		if (score > this.getBestScore()){
			this.setBestScore(score);
		}
		
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
	public abstract int calcX2p(int score, boolean isReset);
	
	/**
	 * Return the HashSet that contains the styles of game
	 * @return the styles of game
	 */
	public HashSet<GamePlay> getStyleGame() {
		return styleGame;
	}
	
	/**
	 * Add a style in game
	 * @param gameplay 
	 * 		the possible style of game
	 * @return
	 */
	public boolean addStyleGame(GamePlay gameplay){
		return styleGame.add(gameplay);
		
	}


	/**
	 * get the name of game
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * change the name of game
	 * @param name 
	 * 		new name of game
	 */
	public void setName(String name) throws Exception {
		if(name == null || name.trim().isEmpty()){
			throw new Exception("O nome do jogo não pode ser nulo ou vazio");
		}
		this.name = name;
	}

	/**
	 * Return the price of game
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Change the price of game
	 * @param price 
	 * 		new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Return the bestScore of game. 
	 * @return bestScore
	 */
	public int getBestScore() {
		return bestScore;
	}

	/**
	 * Change the bestScore of game
	 * @param bestScore 
	 * 		new bestScore
	 */
	public void setBestScore(int bestScore) {
		this.bestScore = bestScore;
	}

	/**
	 * The amount of times are the game is played
	 * @return qntMatches
	 */
	public int getQntMatches() {
		return qntMatches;
	}

	/**
	 * Increase in 1, the amount of times are the game is played
	 * @param qntMatches
	 */
	public void increaseQntMatches() {
		this.qntMatches += 1;
	}

	/**
	 * Return the amount of times the game was reset
	 * @return qntReset
	 */
	public int getQntReset() {
		return qntReset;
	}

	/**
	 * Increase in 1, the amount of time the game was reset
	 *
	 */
	public void zeroedGame() {
		this.qntReset += 1;
	}

	/**
	 * HashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((styleGame == null) ? 0 : styleGame.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * Two games are equals if the name, price and styles are the same for both
	 *
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Game){
			Game newGame = (Game) obj;
			if (newGame.getName().equals(this.getName()) && newGame.getPrice() == this.getPrice()
					&& this.getStyleGame().equals(newGame.getStyleGame())){
				return true;				
			}else{
				return false;
			}
		}else{
			return false;
		}
		
	}
	
	/**
	 * Return the style of game
	 * @return
	 */
	public String getStyle(){
		return this.style;
	}
	
	/**
	 * Change the style of the game
	 */
	public void setStyle(String newStyle){
		this.style = newStyle;
	}
	
	/**
	 * String representation of the class
	 */
	@Override
	public String toString(){
		String toString =  "+ " + this.getName() + "-" + this.getStyle() ;
		toString += "==> Jogou " + this.getQntMatches() + " vez(es)\n";
		toString += "==> Zerou " + this.getQntReset() + " vez(es)\n";
		toString += "==> Maior score: " + this.getBestScore();
		return toString;
				
	}
	
	

}
