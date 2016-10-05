package users;
import game.*;
import discount.Discount;


/**
 * Class for veteren users, inheterance of Users type. 
 * @author Arthur Sampaio
 * @version 1.0
 * 
 * 2016, Federal University of Campina Grande, Brazil
 */
public class Veteran extends Users {
	
	public final static int CONST_X2P = 15;
	
	/**
	 * Constructor of class
	 * @param name
	 * 		Name of User
	 * @param login
	 * 		Login for user
	 */
	public Veteran (String name, String login)throws Exception{
		super(name,login);
		this.changeX2p(1000);
	}
	
	/**
	 * Buy the game for Veteran Users, if you have money, and add the games in hashset (games)
	 * @param newGame
	 * 		game to be buy
	 * @return
	 * 		the success of operation
	 */
	@Override
	public boolean buyGames(Game newGame){
		//if no have no money
		if (newGame.getPrice() <= this.getMoney()){
			//if the game not add
			if (this.addGame(newGame)){
				this.moneyDown(newGame.getPrice()*(1 - Discount.DISCOUNT_VET.getDiscount()));
				this.addX2p(this.x2pByPurchasing(newGame.getPrice()));
				return true;
			}else{
				return false;
			}
						
		}else{
			return false;
		}
	}
	
	
	//Abstract
	public int x2pByPurchasing(double price) {
		Double newprice = price;
		
		return CONST_X2P*newprice.intValue();
		
	}
	
	/**
	 * String representation of class
	 */
	@Override
	public String toString(){
		Double allPrice = 0.0;
		String toString = this.getLogin() + "\n" + this.getName() + "-" + this.getLogin() + "\n";
		toString += "Lista de Jogos:\n";
		for (Game game : this.getGame()){
			toString += game.toString();
			allPrice += game.getPrice();
		}
		toString += "\n";
		toString += String.format("Total de preços dos jogos: R$ %.2f ", allPrice);
		return toString;
		
	}

}
