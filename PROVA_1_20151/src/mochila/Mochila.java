package mochila;
import item.Item;

import java.util.ArrayList;

public class Mochila {
	private double weightMax;
	private double weightAux = 0;
	private ArrayList<Item> itens = new ArrayList<Item>();
	
	public Mochila(double weight){
		this.weightMax = weight;
		this.weightAux = 0;
	
	}
	
	public boolean adicionaItem(Item item) {
		if(this.getWeightMax() >= this.getWeightAux() + item.getWeight()){
			double valor = item.getWeight();
			this.refreshWeightAux(valor);
			return this.itens.add(item);
			
			
		}else{
			return false;
		}
	}
	
	public int calcEffectTotal(String type){
		int sumEffect = 0;
		for (Item item : this.itens){
			if (item.getType().equalsIgnoreCase(type)){
				sumEffect += item.getDamage();
			}
		}	
		return sumEffect;		

	}

	public double getWeightMax() {
		return weightMax;
	}



	public double getWeightAux(){
		return this.weightAux;
	}
	
	public void refreshWeightAux(double valor){
		this.weightAux += valor;
		
	}
	


}
