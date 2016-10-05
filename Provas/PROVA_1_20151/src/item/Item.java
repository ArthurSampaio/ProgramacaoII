package item;

public class Item {
	private String name;
	private double weight;
	private String type;
	private int damage;
	
	public Item(String name, double bag,int effect, String type){
		if (type.equalsIgnoreCase("Pocao")){
			this.name = name;
			this.type = type;
			this.weight = bag; 
			this.damage = effect;
		}else{
			this.name = name;
			this.type = type;
			this.weight = bag; 
			this.damage = effect * -1; //quando for arma o damage é negativo, pois tira life do personagem
		}
		
	}
	



	public double getWeight() {
		return this.weight;
	}



	public String getType() {
		return type;
	}



	public int getDamage() {
		return damage;
	}


	
		
	
}