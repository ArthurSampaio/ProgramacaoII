package heroi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TesteHeroi {
	
	private Heroi kratos;
	private Heroi samusAran;
	private Heroi sylvanas;
	private Heroi mario;

	@Before
	public void setUp() throws Exception{
		mario = new Heroi("Mario", 40.0);
		kratos = new Heroi("Kratos", 100.0);
		samusAran = new Heroi("Samus", 90.0);
		sylvanas = new Heroi("Sylvanas",50);
		
		//Mario causa:
		//   dano total de: 30
		//   cura total de: 10
		Assert.assertTrue(mario.criaItem("Pocao Cogumelo", 10.0, 20, "Pocao")); 
		Assert.assertTrue(mario.criaItem("Sapato", 30.0, 30, "Arma"));
		Assert.assertFalse(mario.criaItem("Espada", 50.0, 15, "Arma"));
		
		//Kratos causa:
		//   dano total de: 90
		//   cura total de: 10
		Assert.assertTrue(kratos.criaItem("Corrente", 40.0, 50, "Arma"));
		Assert.assertTrue(kratos.criaItem("Espada", 50.0, 40, "Arma"));
		Assert.assertTrue(kratos.criaItem("Pocao dos Deuses", 10.0, 25, "Pocao"));
		
		//Sylvanas causa: 
		//   dano total de: 30 + 5 Sylvanas ainda tem 10 de vida.
		//   cura total de: 20
		Assert.assertTrue(sylvanas.criaItem("Arco e Flecha", 30.0, 40, "Arma"));
		Assert.assertTrue(sylvanas.criaItem("Pocao Venenosa", 5.0, 10, "Arma"));
		Assert.assertTrue(sylvanas.criaItem("Pocao Milagrosa", 5.0, 100, "Pocao"));
		
		//Samus causa:
		//   dano total: 50 + 30 = 80
		//   cura total: 40
		Assert.assertTrue(samusAran.criaItem("Canhao de Plasma", 50.0, 30, "Arma"));
		Assert.assertFalse(samusAran.criaItem("Missil Nuclear", 100.0, 900, "Arma"));
		Assert.assertTrue(samusAran.criaItem("Missil de Gelo", 30.0, 50, "Arma"));
		Assert.assertTrue(samusAran.criaItem("Vacina", 10.0, 40, "Pocao"));

	}
	
	@Test
	public void testValoresBatalha() throws Exception{
		kratos.ataca(mario);//mario = 10
		mario.ataca(kratos);//kratos = 70
		 
		Assert.assertEquals(10, mario.getHP());
		Assert.assertEquals(70, kratos.getHP());
		
		kratos.cura();//kratos = 95;
		Assert.assertEquals(95, kratos.getHP());
		
		kratos.ataca(mario); //mario = -80; "Mario desmaiou sem chances de voltar com pocao."
		Assert.assertEquals(95, kratos.getHP());
		Assert.assertEquals(-80, mario.getHP());
		
		Assert.assertFalse(mario.cura()); //mario = -80
		
		kratos.ataca(sylvanas);//sylvanas = 10;
		Assert.assertEquals(10, sylvanas.getHP());
		
		Assert.assertTrue(sylvanas.cura()); // sylavas = 100;
		Assert.assertEquals(100, sylvanas.getHP());
		
		sylvanas.ataca(kratos);//kratos = 45;
		sylvanas.ataca(kratos);//kratos = 0; "Kratos desmaiou, mas ainda pode ser curado"
		Assert.assertEquals(-5, kratos.getHP());
		
		Assert.assertTrue(kratos.cura()); //kratos = 20
		Assert.assertEquals(20, kratos.getHP());
		Assert.assertEquals(20, kratos.getHP());
		kratos.ataca(sylvanas); //sylvanas = 10;
		Assert.assertEquals(10, sylvanas.getHP());
		
		samusAran.ataca(sylvanas); //sylvanas = -70;
		Assert.assertEquals(-70, sylvanas.getHP());
		samusAran.ataca(kratos); //kratos = -60
		Assert.assertEquals(-60, kratos.getHP());
		Assert.assertFalse(kratos.cura());

	}	
	
	@Test
	public void testMensagemBatalha(){		
		//kratos.ataca(mario);//mario = 10
		//mario.ataca(kratos);//kratos = 70
		
		Assert.assertEquals("Mario ainda tem 10 de vida.", kratos.ataca(mario));
		Assert.assertEquals("Kratos ainda tem 70 de vida.", mario.ataca(kratos));
		
		kratos.cura();//kratos = 95;
		Assert.assertEquals(95, kratos.getHP());
		
		Assert.assertEquals("Mario desmaiou sem chances de voltar com pocao.", kratos.ataca(mario)); //mario = -80		
		Assert.assertFalse(mario.cura()); 
		
		Assert.assertEquals("Sylvanas ainda tem 10 de vida.",kratos.ataca(sylvanas));//sylvanas = 10;
		Assert.assertTrue(sylvanas.cura()); // sylavas = 100;
		Assert.assertEquals(100, sylvanas.getHP());
		
		Assert.assertEquals("Kratos ainda tem 45 de vida.", sylvanas.ataca(kratos));//kratos = 45;
		Assert.assertEquals("Kratos desmaiou, mas ainda pode ser curado.", sylvanas.ataca(kratos));//kratos = -5; "Kratos desmaiou, mas ainda pode ser curado"
		Assert.assertTrue(kratos.cura()); //kratos = 20
		Assert.assertEquals(20, kratos.getHP());
		Assert.assertEquals("Sylvanas ainda tem 10 de vida.", kratos.ataca(sylvanas)); //sylvanas = 10;
		
		Assert.assertEquals("Sylvanas desmaiou sem chances de voltar com pocao.", samusAran.ataca(sylvanas)); //sylvanas = -70;
		Assert.assertEquals("Kratos desmaiou sem chances de voltar com pocao.", samusAran.ataca(kratos)); //kratos = -60
	}
	
}