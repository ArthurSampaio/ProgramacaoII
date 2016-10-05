package factory;
import game.*;

/**
 * @author Arthur Sampaio Perico Correia
 * @version 1.0
 * 
 * 2016, Federal University of Campina Grande, Brazil
 *
 * Factory for superclass Game
 * 
 */
public class GameFactory {
	
	public GameFactory(){};

	/**
	 * Instance a object of type game. This method "choose" the type of game
	 * (rpg,platform,fight) starting the string type.
	 * @param name
	 * 		The name of game
	 * @param price
	 * 		The price
	 * @param type
	 * 		Define the type (style) of the game.
	 * @return
	 * 		A object of type Game
	 * @throws Exception
	 * 		When the String type is invalid.
	 */
	public Game createGame(String name, Double price, String type)throws Exception{
		if(type == null || type.trim().isEmpty() || !(type.equalsIgnoreCase("RPG") || 
				type.equalsIgnoreCase("Fight") || type.equalsIgnoreCase("Platform"))){
			throw new Exception("Tipo de jogo invalido.");
		}
		if(type.equalsIgnoreCase("Fight")){
			return new GameFight(name,price);
		}
		else if(type.equalsIgnoreCase("Platform")){
			return new GamePlatform(name,price);
		}
		else{
			return new GameRpg(name,price);
		}
	}
}
