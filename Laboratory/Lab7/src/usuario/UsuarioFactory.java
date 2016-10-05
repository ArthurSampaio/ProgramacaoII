package usuario;

import excecoes.UpgradeInvalidoException;
import excecoes.UsuarioInvalidoException;

/**
 * @author Arthur Sampaio Perico Correia
 * @version 1.0
 * 
 * 2016, Federal University of Campina Grande, Brazil
 *
 * Factory for superclass Users
 * 
 */
public class UsuarioFactory {
	
	public UsuarioFactory(){};
	
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
	public Usuario criaUsuario(String name, String login, String tipoUsuario)throws Exception{
		if(tipoUsuario == null || tipoUsuario.trim().isEmpty() || !(tipoUsuario.equalsIgnoreCase("Veterano") || 
						tipoUsuario.equalsIgnoreCase("Noob"))){
			throw new UsuarioInvalidoException("O tipo do usuario e invalido.");
		}else{
			Usuario user = new Usuario(name, login);
			return user;
		}
	}
}
