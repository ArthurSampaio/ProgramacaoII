package users;
import game.*;
import discount.Discount;


/**
 * Class for users noob, inheterance of Users type. 
 * @author arthurspc
 * @version 1.0
 * 
 * 2016, Federal University of Campina Grande, Brazil
 */
public class Noob extends Users {
	public final static int CONST_X2P = 10;

	
	/**
	 * Constructor of clas
	 * @param name
	 * 		Name of User
	 * @param login
	 * 		Login for user
	 */
	public Noob (String name, String login)throws Exception{
		super(name,login);
	}
	
	/**
	 * Buy the game for Noob Users, if you have money, and add the games in hashset (games)
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
				this.moneyDown(newGame.getPrice()*(1 - Discount.DISCOUNT_NOOB.getDiscount()));
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
	public String toString (){
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
