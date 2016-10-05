package game;
import game.*;

import gameplay.GamePlay;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
	
	private Game kingFight;
	private Game mario;
	private Game gow;
	
	
	@Before
	public void setUp() throws Exception {
		
		kingFight = new GameFight("The King Of Figthers", 12.00);
		mario = new GamePlatform("Sonic The Hedgehog", 15.00);
		gow = new GameRpg("God of War", 23.00);
	}
	
	@Test
	public void constructor(){
		try {
			Game castlevania = new GamePlatform("Castlevania Symphony of the Night", 12.00);
			Game kingdonHearts = new GameRpg("Kingdon Hearts", 15.00);
			Game StreetsOfRage  = new GameRpg("Streets of Rage", 23.00);
		} catch (Exception e) {
			Assert.fail(); // shouldnt throw exception here
		}
	}
	
	
	@Test
	public void conException(){
		try{
			Game example  = new GameRpg(" ", 250);

		}catch (Exception e){
			Assert.assertEquals("O nome do jogo nao pode ser nulo ou vazio" , e.getMessage());
		}
 
 
		try{
			Game example  = new GameRpg(null, 250);

		}catch (Exception e){
			Assert.assertEquals("O nome do jogo nao pode ser nulo ou vazio" , e.getMessage());
		}
 
 
		try{
			Game example  = new GameRpg("bomberman", -250);

		}catch (Exception e){
			Assert.assertEquals("O preco do jogo nao pode ser inferior a 0 $" , e.getMessage());
		}
	}

	@Test
	public void registerMove(){
		Assert.assertEquals(0, mario.getBestScore());
		Assert.assertEquals(0, mario.getQntMatches());
		Assert.assertEquals(0, mario.getQntReset());
		
		mario.registerMove(5000, true);
		
		Assert.assertEquals(5000, mario.getBestScore());
		Assert.assertEquals(1, mario.getQntMatches());
		Assert.assertEquals(1, mario.getQntReset());
	}
	

	@Test
	public void addStyle(){
		
		Assert.assertTrue(gow.addStyleGame(GamePlay.OFFLINE));
		Assert.assertTrue(mario.addStyleGame(GamePlay.MULTIPLAYER));
		Assert.assertTrue(kingFight.addStyleGame(GamePlay.COMPETITIVE));
		
		
	}
}


