public class Cart extends TaxCalculator {
	private double totalPrice;
	private int itemsCount;
	
	Item[] itemsInCart = new Item[100];
	
	Cart() { 
		totalPrice = 0; 
		itemsCount = 0;
	}

	// getters and settors for data fields
	public int getItemsCount() {
		return itemsCount;
	}
	public void setItemsCount(int itemsCount) {
		this.itemsCount = itemsCount;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	// method for adding item
	public void addItems(Item item) {
		itemsInCart[itemsCount] = item;
		itemsCount++;
	}

	// method for calculating total price
	public double calculateTotalPrice() {
		totalPrice = 0;
		for (int i=0; i < itemsCount; i++) {
			totalPrice += itemsInCart[i].getItemPrice();
		}
		return totalPrice;
	}

	// method for calculating total price with tax
	public double calculateTotalwithTax() {
		return calculateTotalPrice() + calculateTax(this.itemsInCart, itemsCount);
	}
}
