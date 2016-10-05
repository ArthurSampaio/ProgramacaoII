package users;
import game.*;
import discount.Discount;

import java.util.HashSet;


/**
 * Abstract class for objects of type Users
 * 
 * @author Arthur Sampaio Perico Correia
 * @version 1.0
 * 
 * 2016, Federal University of Campina Grande, Brazil
 *  
 */
public abstract class Users {
	private String name;
	private String login;
	private HashSet<Game> games;
	private double money;
	private int x2p; 
	
		
	/**
	 * Constructor of clas
	 * @param name
	 * 		Name of User
	 * @param login
	 * 		Login for user
	 */
	public Users(String name, String login)throws Exception{
		
		if(name == null || name.trim().isEmpty()){
			throw new Exception("O nome do usuario nao pode ser nulo ou vazio.");
		}


		if(login == null || login.trim().isEmpty()){
			throw new Exception("O login do usuario nao pode ser nulo ou vazio.");
		}

		this.name = name;
		this.login = login;
		this.games = new HashSet<Game>();
		this.money = 0;
		this.x2p = 0; 
	}
	
	/**
	 * Register a new move in the game. Find the game from your name in hashset games.
	 *  Receives a int indicating newScore, if newScore it's bigger than bestScore
	 * bestScore assumes the value of newScore.  
	 * @param score
	 * 		Score of present move
	 * @param isReset
	 * 		indicates if the game is reset. 
	 */
	public void registerMove(String nameGame, int score, boolean reset)throws Exception{
		
		if(this.hasGame(nameGame)){
			Game game = this.searchGame(nameGame);
			if(game == null){
				throw new Exception("O usuario nao possui esse jogo.");
			}
			
			else{
				game.registerMove(score, reset);
				
				//add x2p in user
				this.addX2p(game.calcX2p(score, reset));
			}
		}else{
			throw new Exception("O usuario nao possui esse jogo.");
		}
			
	}
	

	/**
	 * Find a game in hashset(games) with the name "name"
	 * @param name
	 * 		the name of game
	 * @return
	 * 		if true, the game
	 * 		otherwise, null.
	 * @throws
	 * 		if the name is empty or null
	 */
	public Game searchGame(String name)throws Exception{
		for(Game game : this.games){
			if(game.getName().equals(name)){
				return game;
			}
		}return null;
	}
	
	/**
	 * This method answer the question: Has in games a game with name "name"?
	 * @param name
	 * 		the name of game
	 * @return
	 * 		the answer
	 * @throws Exception
	 * 		if the name is empty or null
	 */
	public boolean hasGame(String name)throws Exception{
		for(Game game : this.games){
			if(game.getName().equals(name)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Buy the game, if you have money, and add the games in hashset (games)
	 * @param newGame
	 * 		game to be buy
	 * @return
	 * 		the success of operation
	 */
	public boolean buyGames(Game newGame)throws Exception{
		//if no have no money
		if (newGame.getPrice() <= this.getMoney()){
			//if the game not add
			if (this.games.add(newGame)){
				this.moneyDown(newGame.getPrice()*(1 - Discount.DISCOUNT.getDiscount()));
				return true;
			}else{
				throw new Exception("Usuario ja possui o jogo.");
			}
						
		}else{
			throw new Exception("Saldo insuficiente.");
		}
	}
	
	/**
	 * Calcs x2p by purchased game
	 * @param preco
	 * @return
	 */
	public abstract int x2pByPurchasing(double preco);
	
	/**
	 * Deducts user money
	 * @param expenses
	 * 		the value of the deducts
	 */
	public void moneyDown(double expenses){
		this.money -= expenses;
	}
	
	/**
	 * Return the real name of user;
	 * @return 
	 * 		name of user
	 */
	public String getName() {
		return name;
	}

	/**
	 * Add more x2p in user
	 * @param value
	 * 		the value who will increment in x2p
	 */
	public void addX2p(int value){
		this.x2p += value;
	}
	
	/**
	 * Change the name of user
	 * @param name
	 * 		new name of user
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Return the login of user
	 * @return
	 * 		the login
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Change the list of games
	 * @param games
	 * 		new games
	 */
	public void setGame(HashSet<Game> games){
		this.games = games;
	}

	/**
	 * Return the arraylist with the games
	 * @return
	 * 		a arraylist of type Games
	 */
	public HashSet<Game> getGame(){
		return this.games;
	}
	
	/**
	 * Change the x2p of user
	 * @param x2p
	 * 		new x2p
	 */
	public void setX2p(int x2p){
		this.x2p = x2p;
	}
	
	/**
	 * Return the money that the user has
	 * @return
	 * 		money of user
	 */
	public double getMoney() {
		return money;
	}

	/**
	 * Add money in the user profile
	 * @param newmoney
	 * 		amount to be deposited
	 * @return the success of operation
	 * 
	 * @throws	
	 * 		When:
	 * 			the newmoney its smaller that zero	
	 */
	public boolean addMoney(double newmoney)throws Exception{
		if (newmoney < 0){
			throw new Exception("O valor que deseja adicionar ao saldo nao pode ser negativo.");
		}
		this.money += newmoney;
		return true; 
	}

	/**
	 * Return the experience of user profile
	 * @return
	 * 		the experience (x2p)
	 */
	public int getX2p() {
		return x2p;
	}
	
	


	/**
	 * Change the initial value of x2p. 
	 * @param value
	 * 		new value for experience. 
	 */
	protected void changeX2p(int value){
		this.x2p = value;
	}

	/**
	 * HashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	/**
	 * Two users are equal if they have same login
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Users){
			Users user = (Users) obj;
			if (user.getLogin().equals(this.getLogin())){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	/**
	 * String representation of class Users
	 */
	@Override
	public String toString(){
		Double allPrice = 0.0;
		String toString = this.getLogin() + "\n" + this.getName() + "\n";
		toString += "Lista de Jogos:\n";
		for (Game game : this.games){
			toString += game.toString();
			allPrice += game.getPrice();
		}
		toString += "\n";
		toString += String.format("Total de preços dos jogos: R$ %.2f ", allPrice);
		return toString;
		
	}
	
	public boolean addGame(Game game){
		return this.games.add(game);
	}
	
}
