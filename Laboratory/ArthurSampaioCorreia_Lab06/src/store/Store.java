package store;
import java.util.HashSet;

import exception.P2CG2Exception;
import game.*;
import users.*;
import factory.*;


public class Store {
	
	private final static String VETERAN = "Veteran";
	
	private HashSet<Users> allUsers;
	private GameFactory factoryGame;
	private UsersFactory factoryUsers;
	private HashSet<Game> allGames;
	
	public Store(){
		this.allUsers = new HashSet<>();
		this.allGames = new HashSet<>();
		this.factoryGame = new GameFactory();
		this.factoryUsers = new UsersFactory();
	}
	
	/**
	 * Create and add a new User in allUsers
	 * @param name
	 * 		the name of new Users
	 * @param login
	 * 		the Login of users
	 * @param type
	 * 		define the type of users
	 * @return
	 * 		the success of operation
	 *
	 */
	public boolean addUser(String name, String login, String type){
		try{
			return this.allUsers.add(this.factoryUsers.createUsers(name, login, type));
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Create and add a nem Game in allGame`s Store
	 * @param name
	 * 		The name of game
	 * @param price
	 * 		the price of game
	 * @param type
	 * 		define the type of game
	 * @return
	 * 		return the sucess of operation
	 * @throws Exception
	 * 		When the type is invalid.
	 */
	public boolean addGame(String name, double price, String type)throws P2CG2Exception{
		try{
			this.stringException(name);
			this.stringException(type);
			return this.allGames.add(this.factoryGame.createGame(name, price, type));
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Add money in an account of a User
	 * @param login
	 * 		The login of user
	 * @param money
	 * 		the money that will be added
	 * @return
	 * 		the success of operation
	 * 
	 */
	public boolean addMoneyInUser(String login, double money){
		try{ 
			this.stringException(login);
			for(Users user : this.allUsers){
				if(user.getLogin().equals(login)){
					return user.addMoney(money);
				}
			}return false;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
			
	}
	
	
	/**
	 * Sells a game to a custmer
	 * @param nameGame
	 * 		The name of game
	 * @param login
	 * 		The login of user
	 * @return
	 * 		the success of operation
	 * @throws Exception
	 * 		When the game and/or the user are not in Store
	 */
	public boolean sellsGame(String nameGame, String login)throws P2CG2Exception{
		try{
			this.stringException(nameGame);
			this.stringException(login);
			
			if(this.containsGame(nameGame) && this.containsUsers(login)){
		
				Users user = this.returnUser(login);
				Game game = this.returnGame(nameGame);
				return user.buyGames(game);
			}else{
				return false;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	
	/**
	 * Remove a specific user in Store
	 * @param login
	 * 		The login of user
	 * @return
	 * 		The success of operation
	 * @throws Exception
	 * 		When the user not exist in Store
	 */
	public boolean removeUser(String login)throws Exception{
		this.stringException(login);
		if(!this.containsUsers(login)){
			throw new Exception("O usuario nao existe na loja");
		}else{
			return this.allUsers.remove(this.returnUser(login));

		}
	}
	
	
	/**
	 * Remove a specific game in Store
	 * @param name
	 * 		The name of game will be deleted
	 * @return	
	 * 		The success of operation
	 * @throws Exception
	 * 		When the game not exist in store
	 */
	public boolean removeGame(String name)throws Exception{
		this.stringException(name);
		if(!this.containsGame(name)){
			throw new Exception("O jogo nao existe na loja.");
		}else{
			return this.allGames.remove(this.returnGame(name));
		}
	}
	
	
	/**
	 * Get a specific game
	 * @param name
	 * 		The name of game
	 * @return
	 * 		An object of type game
	 */
	public Game returnGame(String name)throws Exception{
		this.stringException(name);
		for(Game game : this.allGames){
			if(game.getName().equals(name)){
				return game;
			}
		}return null;
	}
	
	/**
	 * Get a specific user
	 * @param login
	 * 		The login of user
	 * @return
	 * 		An object of type Users
	 */
	public Users returnUser(String login)throws Exception{
		this.stringException(login);
		for(Users user : this.allUsers){
			if(user.getLogin().equals(login)){
				return user;
			}
		}return null;
	}
	
	/**
	 * Checks if the store have a specific user
	 * @param login
	 * 		the login of users
	 * @return
	 * 		return the success the operation
	 * @throws Exception
	 *		When login is null or empty 
	 * 
	 */	
	public boolean containsUsers(String login)throws Exception{
		this.stringException(login);
		for(Users user : this.allUsers){
			if(user.getLogin().equals(login)){
				return true;
			}
		}return false;
	}
	
	/**
	 * Checks if the store have a specific game
	 * @param name
	 * 		the name of game
	 * @return
	 * @throws Exception
	 */
	public boolean containsGame(String name)throws Exception{
		this.stringException(name);
		for(Game game : this.allGames){
			if(game.getName().equals(name)){
				return true;
			}
		}return false;
	}
	
	
	/**
	 * User Noob makes the upgrade to User Veteran
	 * @param login
	 * 		the login of user
	 * @return
	 * 		the success of operation
	 * @throws Exception
	 * 		When:
	 * 			Store not contains the user
	 * 			X2p is smaller that 1000
	 * 			The user is veteran
	 */
	public boolean upgradeUser(String login)throws Exception{
		if(!this.containsUsers(login)){
			throw new Exception("Usuario inexistente na loja.");
		}
		
		Users user = this.returnUser(login);
		
		if(!this.factoryUsers.checkUserNoob(user)){
			throw new Exception("O usuario ja e veterano.");
		}
		
		if(user.getX2p() < 1000){
			throw new Exception("O usuario nao possui x2p suficiente");
		}
		
		String name = user.getName();
		String loginN = user.getLogin();
		HashSet<Game> games = user.getGame();
		int x2p = user.getX2p();
		Double money = user.getMoney();
		
		this.allUsers.remove(user);
		
		user = this.factoryUsers.createUsers(name, loginN, VETERAN);
						
		user.setGame(games);
		user.setX2p(x2p);
		user.addMoney(money);
				
		return this.allUsers.add(user);
	}
		

	
	
	public HashSet<Users> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(HashSet<Users> allUsers) {
		this.allUsers = allUsers;
	}

	public HashSet<Game> getAllGames() {
		return allGames;
	}

	public void setAllGames(HashSet<Game> allGames) {
		this.allGames = allGames;
	}

	/**
	 * Checks the exception in any string
	 * @param string
	 * @throws Exception
	 * 		When the string passed by parameter is null or empty
	 */
	public void stringException(String string)throws P2CG2Exception{
		if(string == null || string.trim().isEmpty()){
			throw new P2CG2Exception(string + " is invalid");
		}
	}

	/**
	 * Hashcode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allGames == null) ? 0 : allGames.hashCode());
		result = prime * result + ((allUsers == null) ? 0 : allUsers.hashCode());
		return result;
	}

	/**
	 * Two Stores are equal if both have the same users. 
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Store){
			Store store = (Store) obj;
			if(store.getAllUsers().equals(this.getAllUsers())){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	
	/**
	 * String representation of class;
	 */
	public String toString(){
		String toString;
		toString = "=== Central P2-CG ===\n";
		for(Users user : this.allUsers){
			toString += user.toString();
			toString += "\n";
			
		}
		toString += "----------------------------";
		return toString;
	}
	
	
	
	
}
