public abstract class Item {
	private String itemName;
	private double itemPrice;
    //private double taxRate=0;

	public abstract double getTaxRate() ;

   
    // default constructor
	Item() {};

	// constructor with data field values
	Item(String itemName,  double itemPrice) {
		this.itemName= itemName;
		this.itemPrice = itemPrice;
		
	}

	// getters and setters for each data field
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
    }

	// Abastract method to calculate price with tax
	public abstract double calculatePriceWithTax();
}
