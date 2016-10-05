package heroi;
import item.Item;
import mochila.Mochila;



public class Heroi {
	
	private String name;
	private int life = 100;
	private double weightBag;
	private Mochila mochila;
	
	public Heroi(String name, double bag){
		this.name = name;
		this.weightBag = bag;
		this.mochila = new Mochila(bag);
	}
	
	public boolean criaItem(String name, double bag,int effect, String type){
		Item newItem = new Item(name, bag, effect,type);
		return mochila.adicionaItem(newItem);
	}


	
	public String ataca (Heroi otherHeroi){
		int dammage = 0;
		//o dano total é calculado com valor negativo, já que a arma "tira" life
		dammage = this.mochila.calcEffectTotal("Arma");
		return otherHeroi.calcHP(dammage);
	}
	
	
	
	public String calcHP(int dammage){ 
		
		this.setLife(this.getLife() + dammage);
 
		if (this.getLife() > 0){
			return( this.getName()+ " ainda tem " + this.life + " de vida.");
		}
		else if(this.getLife() > -10){
			return (this.getName()+ " desmaiou, mas ainda pode ser curado.");
			
		}else{
			return (this.getName() + " desmaiou sem chances de voltar com pocao.");
		}
	}
	
	public boolean cura(){
		int effect= 0;
		effect = this.mochila.calcEffectTotal("Pocao");
		if (this.getHP() < -10 ){
			return false;
		}
		
		if (this.getHP() + effect >= 100){
			this.setLife(100);
			return true;
		}
		
		else{
			this.setLife(effect + this.getHP());
			return true;
		}
	}

	public String getName() {
		return name;
	}



	public int getLife() {
		return life;
	}
	
	public int getHP(){
		return this.life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
}
