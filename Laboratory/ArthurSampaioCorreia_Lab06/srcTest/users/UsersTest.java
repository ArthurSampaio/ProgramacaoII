package users;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import game.*;


public class UsersTest {


	private Users tiago;
	private Users neto;
	private Users arthur;

	@Before
	public void setUp() throws Exception {
		this.tiago = new Noob("Tiago Pereira","tiagolp");
		this.neto = new Veteran("Francisco Neto", "fgoneto");
		this.arthur = new Veteran("Arthur Sampaio", "arthurspc");
	}
 
	@Test
	public void usersTest() throws Exception{
		try{
			arthur = new Veteran("Arthur Sampaio", "arthurspc");
			neto = new Veteran("Francisco Neto", "fgoneto");
		}catch (Exception e){
			fail(); //shouldnt throw exception here
		}
	}
	
	@Test
	public void addMoney() {
 
		try {
			tiago.addMoney(1000.0);
			assertEquals(1000.0, tiago.getMoney(), 0.05);
			tiago.addMoney(50);
			assertEquals(1050, tiago.getMoney(), 0.05);
		} catch (Exception e) {
			fail(); //shouldnt throw exception here
 
		}
	}
 
 
	@Test
	public void constructorTest(){
 
		// for names
		
		try {
			Users user = new Noob("  ", "tiagolp");
 
		} catch (Exception e) {
			Assert.assertEquals("O nome do usuario nao pode ser nulo ou vazio.", e.getMessage());
		}
 
		try {
			Users user = new Noob(null, "tiagolp");
 
		} catch (Exception e) {
			Assert.assertEquals("O nome do usuario nao pode ser nulo ou vazio.", e.getMessage());
		}
		
		try {
			Users user2 = new Veteran(" ", "fgoneto");
		} catch(Exception e) {
			Assert.assertEquals("O nome do usuario nao pode ser nulo ou vazio.", e.getMessage());
		}
		
		try {
			Users user2 = new Veteran(null, "fgoneto");
		} catch(Exception e){
			Assert.assertEquals("O nome do usuario nao pode ser nulo ou vazio.", e.getMessage());
		}
 
 
		// logins
		
		try {
			Users user = new Noob("Tiago Pereira", " ");
 
		} catch (Exception e) {
			Assert.assertEquals("O login do usuario nao pode ser nulo ou vazio.", e.getMessage());
		}
 
		try {
			Users user = new Noob("Tiago Pereira", null);
 
		} catch (Exception e) {
			Assert.assertEquals("O login do usuario nao pode ser nulo ou vazio.", e.getMessage());
		}
 
 
		try {
			Users user = new Veteran("Neto", " ");
 
		} catch (Exception e) {
			Assert.assertEquals("O login do usuario nao pode ser nulo ou vazio.", e.getMessage());
		}
 
		try {
			Users user = new Veteran("Neto", null);
 
		} catch (Exception e) {
			Assert.assertEquals("O login do usuario nao pode ser nulo ou vazio.", e.getMessage());
		}
 
	}
 

	@Test
	public void addMoneyException() throws Exception{
		try{
			neto.addMoney(-20);
 
		}catch (Exception e){
			Assert.assertEquals("O valor que deseja adicionar ao saldo nao pode ser negativo.", e.getMessage());
		}
	}
 
	@Test
	public void buyGamesException() throws Exception{
 
		Game mario = new GamePlatform("Super Mario", 20);
 
		try{	
 
			tiago.addMoney(1000.0);
			tiago.buyGames(mario);
			assertEquals(1,tiago.getGame().size());
			assertEquals(982.0, tiago.getMoney(), 0.05);
 
		}catch(Exception e){
			Assert.fail(); //shouldnt throw exception here
		}
 
		try{
			neto.addMoney(1000);
			neto.buyGames(mario);
			assertEquals(1,neto.getGame().size());
			assertEquals(984.0, neto.getMoney(), 0.05);
		}catch(Exception e){
			Assert.fail();//shouldnt throw exception here
		}
	}
 
	@Test
	public void buyGamesTest() throws Exception{
 
		Game ff = new GameRpg("Final Fantasy VIII", 50);
		
		try{
			tiago.buyGames(ff);
			
		}catch (Exception e){
			Assert.assertEquals("Saldo insuficiente.", e.getMessage());
		}
 
 
		try{
	
			neto.addMoney(120);
			neto.buyGames(ff);
			neto.buyGames(ff); 
 
		}catch (Exception e){
			Assert.assertEquals("Usuario ja possui o jogo.", e.getMessage());
 
		}
	}
 
	@Test
	public void testEquals() throws Exception{
 
		Users wesley = new Noob("Wesley Anibal", "wesley.a");
		Users matheus = new Noob("Matheus Melo", "wesley.a");
		Users mariana = new Veteran("Mariana Mendes" ,"m4reana");
 
		assertTrue(wesley.equals(matheus));
		assertTrue(wesley.equals(wesley));
		assertFalse(mariana.equals(matheus));
		assertFalse(wesley.equals(mariana));
	}
	
	@Test
	public void registerMoveTest() throws Exception{
 
		Game kof = new GameFight("The King Of Fighters 98", 120.0);
		Game ff = new GameRpg("Final Fantasy VIII", 50.00);
		Game mario = new GamePlatform("Super Mario", 20.0);
 
		arthur.addMoney(300);
		arthur.buyGames(kof);
 
 
		tiago.addMoney(200);
		tiago.buyGames(ff);
 
		neto.addMoney(100);
		neto.buyGames(mario);
 
 
		try{
			arthur.registerMove("The King Of Fighters 98", 200, false);
			assertEquals(2800, arthur.getX2p());
 
			arthur.registerMove("The King Of Fighters 98", 2000, true);
			assertEquals(2802, arthur.getX2p());
 
			arthur.registerMove("The King Of Fighters 98", 10000, false);
			assertEquals(2812, arthur.getX2p());
 
		}catch(Exception e){
			Assert.fail();
		}
 
 
		try{
			tiago.registerMove("Final Fantasy VIII", 200, false);
			assertEquals(510, tiago.getX2p());
 
			tiago.registerMove("Final Fantasy VIII", 200, false);
			assertEquals(520, tiago.getX2p());
		
 
		}catch (Exception e){
			System.out.println(e.getMessage());
			Assert.fail("faiei");
		}
 
 
		try{
			neto.registerMove("Super Mario", 500, false);
			assertEquals(1300, neto.getX2p());
 
			neto.registerMove("Super Mario", 3000, true);
			assertEquals(1320, neto.getX2p());
 
		}catch(Exception e){
			Assert.fail();
		}
 
	}
	
	@Test
	public void registerMoveException(){
		try{
			tiago.registerMove("Tomb Raider", 5000, true);
		}catch(Exception e){
			Assert.assertEquals("O usuario nao possui esse jogo.", e.getMessage());
		}
	}
 

}

	

