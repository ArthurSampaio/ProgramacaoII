package discount;

/**
 * Enum Class, Discount for any users
 * @author arthurspc
 *
 */
public enum Discount {
	
	/**
	 * Discount for a normal user
	 */
	DISCOUNT(0), 
	/**
	 * Discount for a noob user
	 */
	DISCOUNT_NOOB(0.1), 
	/**
	 * Discount for a Veteran
	 */
	DISCOUNT_VET(0.2);
	private double value;

	private Discount(double discount){
		this.value = discount;
	}
	
	public double getDiscount(){
		return this.value;
	}
	
}
