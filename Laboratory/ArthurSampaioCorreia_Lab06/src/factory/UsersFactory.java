package factory;
import users.*;

/**
 * @author Arthur Sampaio Perico Correia
 * @version 1.0
 * 
 * 2016, Federal University of Campina Grande, Brazil
 *
 * Factory for superclass Users
 * 
 */
public class UsersFactory {
	
	public UsersFactory(){}
	
	/**
	 * Instance a object of type users. This method "choose" the type of users
	 * (noob, veteran) starting the string type.
	 * @param name
	 * 		The name of user
	 * @param login
	 * 		The login
	 * @param type
	 * 		Define the type (style) of the user.
	 * @return
	 * 		A object of type Users
	 * @throws Exception
	 * 		When the String type is invalid.
	 */
	public Users createUsers(String name, String login, String type)throws Exception{
		if(type == null || type.trim().isEmpty() 
				|| !(type.equalsIgnoreCase("Veteran") || 
						type.equalsIgnoreCase("Noob"))){
			throw new Exception("O tipo do usuario e invalido.");
		}
		
		return null;
	}
	
	/**
	 * Checks if a Game is a Noob
	 * @param user
	 * 		A object users
	 * @return
	 * 		The success of operation
	 */
	public boolean checkUserNoob(Users user){
		if(user instanceof Noob){
			return true;
		}else{
			return false;
		}
		
	}

}
